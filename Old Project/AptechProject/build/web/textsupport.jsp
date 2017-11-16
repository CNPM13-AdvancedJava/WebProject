<%-- 
    Document   : textsupport
    Created on : May 25, 2016, 1:49:12 PM
    Author     : Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <meta name="viewport" content="width=device-width, initial-scale=1">	
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" href="css/mystyle.css" type="text/css">
        <link href="css/content.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/login.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="bgbody">
            <%@include file="header.jsp" %>
            <div class="container">
                <div class="row">
                    <div class="content-support">
                        <div class="header-support">
                            <span><s:property value="support.supportHeader"/></span>
                        </div>
                        <div class="context-top-support">
                            <span><s:property value="support.supportContexttop"/></span>
                        </div>
                        <div class="images-top-support">
                            <img src="<s:property value="support.supportImages"/>" alt="">
                        </div>
                        <div class="context-center-support">
                            <s:property value="support.supportCentertext"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp"%>
    </div>
</body>
</html>
