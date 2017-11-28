<%-- 
    Document   : thanhtoanThanhCong
    Created on : Jun 6, 2016, 1:21:41 PM
    Author     : Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thành Công</title>       
        <meta name="viewport" content="width=device-width, initial-scale=1">	
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" href="css/mystyle.css" type="text/css">       
        <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/changepay.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="bgbody">
            <%@include file="Header.jsp" %>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-xs-12 thanhtoanSuccess">
                        <h1 class="color-h">Thanh Toán Thành Công</h1>
                        <br>
                        <h2 class="color-h">Quý khách đã thanh toán thành công các sản phẩm trong giỏ hàng</h2>
                        <h2 class="color-h">Mã kích hoạt của các sản phẩm sẽ được gửi tới email của bạn</h2>
                        <h2 class="color-h">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Các sản phẩm đang có sẵn hàng sẽ được gửi tới ngay lập tức</h2>
                        <h2 class="color-h">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Thời gian gửi đối với những sản phẩm hết hàng là 1-2 ngày</h2>
                        <h2 class="color-h">Nếu có bất kỳ thắc mắc hoặc sản phẩm không được gửi đếm email của bạn</h2>
                        <h2 class="color-h">vui lòng liên hệ ngay cho chúng tôi để được hỗ trợ sớm nhất</h2>
                        <h2 class="color-h">Xin cảm ơn</h2>
                        <br>
                        <div id="pay-quavi" style="display:block;">                                                        
                            <a style="color: white" href="Home.jsp" type="button" class="btn btn-danger">Quay về trang chủ</a>
                        </div>                        
                    </div>
                </div>
            </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
