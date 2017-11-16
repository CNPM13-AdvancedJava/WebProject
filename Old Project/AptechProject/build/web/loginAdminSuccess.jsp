<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    String name = request.getParameter("txt-user-admin");
    session.setAttribute("userNameAdmin",name);
%>
<html>   
    <body>
        <s:action name="loginAdminSuccess" executeResult="true"/>
    </body>
</html>