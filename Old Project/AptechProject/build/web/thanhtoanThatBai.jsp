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
            <%@include file="header.jsp" %>
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-xs-12 thanhtoanFail">
                        <h1 class="color-h">Thanh Toán Thất bại</h1>
                        <h2 class="color-h">Tài khoản của quý khách không đủ để thực hiện giao dịch</h2>
                        <h3 class="color-h">Nhấp vào <a href="main.jsp">đây</a> để quay về Trang Chủ</h3>                        
                    </div>
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
