<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html> 
    <body>
        <%session.removeAttribute("ErrorLogin");%>
        <s:action name="loginIn" executeResult="true"/>
    </body>
</html>
