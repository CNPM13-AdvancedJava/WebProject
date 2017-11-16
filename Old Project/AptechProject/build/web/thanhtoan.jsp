<%-- 
    Document   : thanhtoan
    Created on : Jun 5, 2016, 12:53:07 PM
    Author     : Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thanh Toán</title>       
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
            <%@include file="header.jsp"%>
            <div class="content-tt">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-xs-12 content-thanhtoan">
                            <div class="web-pay">
                                <div class="convert-pay">
                                    <h5>Sản phầm : <s:property value="product.productName"/> </h5>
                                    <h5>Số lượng : <s:property value="soLuongthanhToan"/> </h5>
                                    <h5>Tổng số tiền bạn phải thanh toán là : <span class="spantientt"><s:property value="soTienthanhToan"/> đ</span> </h5>
                                    <h3>Mời bạn chọn lựa hình thức thanh toán<h3>
                                    <input type="radio" onclick="checked1()" class="rdo-class" id="rdo-1" name="pay-change" checked="check" value="" placeholder="">
                                    <span class="text-rdo" for="rdo-1">Thanh toán bằng ví</span>
                                    <input type="radio" onclick="checked2()" class="rdo-class" id="rdo-2" name="pay-change" value="" placeholder="">
                                    <span class="text-rdo" for="rdo-2">Thanh toán qua ngân hàng</span>
                                </div>
                                <div id="pay-quavi" style="display:block;">                                                        
                                    <a href="thanhToanSP?tienCanThanhToan=<s:property value="soTienthanhToan"/>&userNamettSP=<%=session.getAttribute("userName")%>" type="button" class="btn btn-danger">Thanh toán</a>
                                    <a href="main.jsp" type="button" class="btn btn-danger">Huỷ bỏ</a>
                                </div>
                                <div id="pay-nganhang" style="display:none;">
                                    <form action="thanhtoanSpPay?sotienTT=<s:property value="soTienthanhToan"/>&userNamettPay=<%=session.getAttribute("userName")%>" method="POST">
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
                                        <a href="main.jsp" type="button" class="btn btn-danger">Huỷ bỏ</a>
                                    </form>
                                </div>
                            </div>
                        </div>                     
                    </div>              
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
