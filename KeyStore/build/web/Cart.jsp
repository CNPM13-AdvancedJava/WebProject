<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Giỏ Hàng</title>       
        <meta name="viewport" content="width=device-width, initial-scale=1">	
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" href="css/mystyle.css" type="text/css">
        <link href="css/content.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/changepay.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="bgbody">
            <%@include file="Header.jsp"%>
            <div class="content-giohang">
                <div class="container">
                    <div class="row">
                        <div class="giohang">
                            <div class="col-lg-12 col-md-12 col-xs-12 thanhtoanFail">
                                <% if (amount == null || amount == 0) { %>
                                <br>
                                <h2 class="color-h">Giỏ hàng của bạn hiện chưa có sản phẩm nào</h2>
                                <h2 class="color-h">Mời bạn quay lại trang chủ để chọn sản phẩm</h2>
                                <h2 class="color-h">Các bước để đặt 1 sản phẩn vào giỏ hàng: </h2>
                                <h2 class="color-h">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; - B1: click vào 1 sản phẩm bất kỳ trong danh mục sản phẩm</h2>
                                <h2 class="color-h">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; - B2: nhập số lượng bạn muốn mua</h2>
                                <h2 class="color-h">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; - B3: click vào nút "Đặt vào giỏ hàng"</h2>
                                <br>
                                <div id="pay-quavi" style="display:block;">                                                        
                                    <a style="color: white" href="Home.jsp" type="button" class="btn btn-danger">Quay về trang chủ</a>
                                </div>  

                                <% } else {%>
                                <span class="sotientt">Giỏ hàng của bạn : </span>
                                <table class="table table-default">
                                    <thead>
                                        <tr>
                                            <th>Ảnh sản phẩm</th>
                                            <th>Tên sản phẩm</th>
                                            <th>Giá sản phẩm</th>
                                            <th>Số lượng</th>
                                            <th>Tổng tiền</th>
                                        </tr>
                                    </thead>                           
                                    <tbody>
                                        <s:iterator value="lstProductInCart">
                                            <tr>
                                                <td>
                                                    <div class="images-giohang">
                                                        <img class="detail-images-giohang" src="<s:property value="productImage"/>" alt="">
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="context-giohang">
                                                        <div class="title-context-giohang">
                                                            <span><s:property value="productName"/></span>
                                                        </div>								
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="price-context-giohang">
                                                        <div>
                                                            <span class="price-context-detail"><s:property value="priceStr"/></span><span> đ</span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="number-product-giohang">
                                                        <div>
                                                            <span class="number-giohang-product"><s:property value="number"/></span>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="tongtien-one-giohang">
                                                        <div>
                                                            <span class="tongtien-giohang-detail"><s:property value="totalPriceStr"/></span><span> đ</span>
                                                            <input type="text" style="display:none;" value="<s:property value="totalPriceStr"/>"/>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>
                                                    <div class="div-a-delete-giohang">
                                                        <a class="a-delete-giohang" href="RemoveProductFromCart?productId=<s:property value="productId"/>" onclick="deleteProduct()"><span class="glyphicon glyphicon-trash"></span></a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </s:iterator>
                                    </tbody>
                                </table>
                                <div class="tongthanhtoan">
                                    <span class="sotientt">Tổng số tiền mà bạn phải thanh toán : </span>
                                    <span class="number-tongthanhtoan"><s:property value="totalPrice"/> đ</span> 
                                    <div class="col-lg-12 col-md-12 col-xs-12 content-thanhtoan">
                                        <div class="web-pay">
                                            <div class="convert-pay">                                       
                                                <h3>Mời bạn chọn lựa hình thức thanh toán</h3>
                                                <input type="radio" onclick="checked1()" class="rdo-class" id="rdo-1" name="pay-change" checked="check" value="" placeholder="">
                                                <span class="text-rdo" for="rdo-1">Thanh toán bằng ví</span>
                                                <input type="radio" onclick="checked2()" class="rdo-class" id="rdo-2" name="pay-change" value="" placeholder="">
                                                <span class="text-rdo" for="rdo-2">Thanh toán qua ngân hàng</span>
                                            </div>
                                            <div id="pay-quavi" style="display:block;">                                                        
                                                <a href="DirectPayment" style="color: white" type="button" onclick="checkPay()" class="btn btn-danger">Thanh toán</a>
                                                <a href="Home.jsp" style="color: white" type="button" class="btn btn-danger">Huỷ bỏ</a>
                                            </div>
                                            <div id="pay-nganhang" style="display:none;">
                                                <form action="thanhtoanPayGH?sotienTT=<s:property value="tongsotien"/>&userNamettPay=<%=session.getAttribute("userName")%>" method="POST">
                                                    <table class="table table-default" style="max-width:600px;">
                                                        <tr>
                                                            <td><span class="label-taikhoan">Tài khoản ngân hàng </span></td>
                                                            <td><input type="text" name="tentaikhoan" class="form-control txt-taikhoan"></td>
                                                        </tr>
                                                        <tr>
                                                            <td><span class="label-taikhoan">Mật khẩu</span></td>
                                                            <td><input type="password" name="matkhau" class="form-control txt-taikhoan"></td>
                                                        </tr>
                                                    </table>            
                                                    <button class="btn btn-danger">Thanh toán</button>
                                                    <a href="Home.jsp" style="color: white" type="button" class="btn btn-danger">Huỷ bỏ</a>
                                                </form>
                                            </div>
                                        </div>
                                    </div>                         
                                </div>
                                <% }%>
                            </div>
                        </div>					
                    </div>
                </div>
            </div>
            <%@include file="Footer.jsp"%>
        </div>
        <script type="text/javascript">
            function deleteProduct() {
                var string;
                string = "Bạn có chắc chắn muốn xóa sản phẩm khỏi giỏ hàng này không?";
                if (!confirm(string)) {
                    window.location.href = "#";
                    window.history.back(1);
                }
            }
            function checkPay() {
                var string;
                string = "Bạn muốn thanh toán số tiền : <s:property value="totalPrice"/> đ ?";
                if (!confirm(string)) {
                    window.location.href = "#";
                    window.history.back(1);
                }
            }
        </script>
    </body>
</html>
