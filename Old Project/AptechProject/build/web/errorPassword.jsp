<%-- 
    Document   : productExist
    Created on : May 30, 2016, 8:21:03 PM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    String message = "Mật khẩu không trùng khớp, mật khẩu phải có nhiều hơn 8 ký tự";
    session.setAttribute("ErrorRegister",message);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <s:action name="errorPassword" executeResult="true"/>
    </body>
</html>
