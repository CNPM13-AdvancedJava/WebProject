<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html> 
    <body>
        <%session.removeAttribute("ErrorLoginAdmin");%>
        <s:action name="loginAdminIn" executeResult="true"/>
    </body>
</html>