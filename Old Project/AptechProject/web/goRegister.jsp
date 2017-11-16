<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html> 
    <body>
        <%session.removeAttribute("ErrorRegister");%>
        <s:action name="gotoRegister" executeResult="true"/>
    </body>
</html>
