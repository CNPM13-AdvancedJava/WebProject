<%-- 
    Document   : ListProduct
    Created on : Dec 2, 2017, 2:10:53 PM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Order Managerment</title>
        <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
        <link href="../dist/css/sb-admin-2.css" rel="stylesheet">
        <link href="../vendor/morrisjs/morris.css" rel="stylesheet">
        <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    </head>
    <%@include file="Header.jsp" %>
    <body>
        <div id="wrapper">
            <div id="page-wrapper">
                <div class="container-fluid">
                    <h3 style="font-weight: bold">Chi tiết đơn hàng</h3><br/>   
                    <br/><br/>
                    <section>
                        <div class="form-group">
                            <label>Mã người dùng</label>
                            <input class="form-control" value="<s:property value="order.user.userId"/>" readonly="true">
                        </div> 
                        <div class="form-group">
                            <label>E-mail</label>
                            <input class="form-control" value="<s:property value="order.user.email"/>" readonly="true">
                        </div> 
                        <div class="form-group">
                            <label>Tên người dùng</label>
                            <input class="form-control" value="<s:property value="order.user.userName"/>" readonly="true">
                        </div> 
                        <br><br>
                        <div class="form-group">
                            <label>Mã đơn hàng</label>
                            <input class="form-control" value="<s:property value="order.orderId"/>" readonly="true">
                        </div> 
                        <div class="form-group">
                            <label>Phương thức thanh toán</label>
                            <input class="form-control" value="<s:property value="order.paymentMethod.methodName"/>" readonly="true">
                        </div> 
                        <div class="form-group">
                            <label>Tình trạng</label>
                            <input class="form-control" value="<s:property value="order.stt"/>" readonly="true">
                        </div> 
                        <div class="form-group">
                            <label>Ngày đặt hàng</label>
                            <input class="form-control" value="<s:property value="order.orderTime"/>" readonly="true">
                        </div> 
                        <div class="form-group">
                            <label>Tổng tiền</label>
                            <input class="form-control" value="<s:property value="order.totalPrice"/>" readonly="true">
                        </div> 
                        <br>
                        <h4 style="font-weight: bold">Chi tiết sản phẩm đã đặt</h4><br/>  
                        <section>
                            <table style="width: 1000px;">
                                <thead>
                                    <tr style="height: 30px;">
                                        <th class="col-1">Tên sản phẩm</th>
                                        <th class="col-1">Mã kích hoạt</th>
                                        <th class="col-3">Trạng thái</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <s:iterator value="lstOrderDetail">
                                        <tr style="height: 30px;">
                                            <td><s:property value="productKey.productDetail.productName"/></td>
                                            <td><s:property value="productKey.keyId"/></td>
                                            <td><s:property value="productKey.status"/></td>
                                        </tr>
                                    </s:iterator>
                                </tbody>

                            </table>
                            <br><br><br><br><br><br><br><br>
                        </section>
                    </section>

                </div>  
            </div>
        </div>

        <script type="text/javascript">
            function deleteProduct(id) {
                console.log(id);
                var string;
                string = "Bạn có chắc chắn muốn xóa sản phẩm này không?";
                if (confirm(string)) {
                    window.location.href = "DeleteProduct?productId=" + id;
                }
            }
        </script>
    </body>
</html>
