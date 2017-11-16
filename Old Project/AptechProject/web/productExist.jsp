<%-- 
    Document   : productExist
    Created on : May 30, 2016, 8:21:03 PM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    String name = "Sản phẩm này đã tồn tại";
    session.setAttribute("ErrorInsert",name);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <s:action name="insertFail" executeResult="true"/>
    </body>
</html>
