<%-- 
    Document   : insertKeySuccess
    Created on : Jun 1, 2016, 1:42:44 PM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    String name = "Thêm key thành công";
    session.setAttribute("Message",name);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <s:action name="insertKeySuccess" executeResult="true"/>
    </body>
</html>
