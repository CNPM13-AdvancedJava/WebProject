<%-- 
    Document   : productExist
    Created on : May 30, 2016, 8:21:03 PM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    String message = "Ngày sinh không hợp lệ";
    session.setAttribute("ErrorRegister",message);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <s:action name="errorDOB" executeResult="true"/>
    </body>
</html>
