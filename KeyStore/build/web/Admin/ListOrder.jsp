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
                    <h3 style="font-weight: bold">Quản lý đơn hàng</h3><br/>   
                    <br/><br/>
                    <section>
                        <table style="width: 1000px;">
                            <thead>
                                <tr>
                                    <th class="col-1">Đơn hàng</th>
                                    <th class="col-1">E-mail </th>
                                    <th class="col-3">Tổng tiền</th>
                                    <th class="col-2">Phương thức TT</th>
                                    <th class="col-1">Thời gian</th>
                                    <th class="col-2">Trạng thái</th>
                                    <th class="col-1">Số SP</th>
                                    <th class="col-2"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="lstOrder">
                                    <tr style="height: 30px;">
                                        <td><s:property value="orderId"/></td>
                                        <td><s:property value="user.email"/></td>
                                        <td><s:property value="totalPrice"/></td>
                                        <td><s:property value="paymentMethod.methodName"/></td>
                                        <td><s:property value="orderTime"/></td>
                                        <td><s:property value="stt"/></td>
                                        <td><s:property value="amount"/></td>
                                        <td>
                                            <a href="OrderDetail?orderId=<s:property value="orderId"/>"  target="_blank"><span class="glyphicon glyphicon-eye-open"></span></a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>

                        </table>

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
                    window.location.href="DeleteProduct?productId="+id;
                }
            }
        </script>
    </body>
</html>
