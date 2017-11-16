<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang Chủ</title>       
        <meta name="viewport" content="width=device-width, initial-scale=1">	
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" href="css/mystyle.css" type="text/css">
        <link href="css/content.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="bgbody" >
            <%@include file="header.jsp" %>
            <div class="container">
                <div class="row">
                    <div class="errorDH">
                        <div class="list-product">                                    
                            <h3>Mặt hàng hiện tại đã hết hàng <a href="main.jsp">Nhấp vào đây</a> để quay lại</h3>
                        </div>
                    </div>                            
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
