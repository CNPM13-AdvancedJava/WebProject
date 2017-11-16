<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    String name = "Email hoặc mật khẩu không chính xác";
    session.setAttribute("ErrorLogin",name);
%>
<html>   
    <body>
        <s:action name="loginFail" executeResult="true"/>
    </body>
</html>

