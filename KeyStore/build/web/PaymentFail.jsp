<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thất Bại</title>       
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
                    <div class="col-lg-12 col-md-12 col-xs-12 thanhtoanFail">
                        <h1 class="color-h">Thanh Toán Thất bại</h1>
                        <br>
                        <h2 class="color-h">Tài khoản của quý khách không đủ để thực hiện giao dịch</h2>
                        <h2 class="color-h">Vui lòng nạp thêm tiền vào tài khoản </h2>
                        <h2 class="color-h">hoặc xóa bớt số lượng sản phầm trong giỏ hàng</h2>
                        <br>
                        <div id="pay-quavi" style="display:block;">                                                        
                            <a style="color: white" href="Home.jsp" type="button" class="btn btn-danger">Quay về trang chủ</a>
                            <a style="color: white" href="MyCart" type="button" class="btn btn-danger">Giỏ hàng</a>
                        </div>                        
                    </div>
                </div>
            </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
