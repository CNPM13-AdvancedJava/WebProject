<%-- 
    Document   : insertKeyFail
    Created on : Jun 1, 2016, 1:43:03 PM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    String name = "Thêm key không thành công, key phải có dạng XXXX-XXXX-XXXX-XXXX";
    session.setAttribute("Message",name);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <s:action name="insertKeyFail" executeResult="true"/>
    </body>
</html>
