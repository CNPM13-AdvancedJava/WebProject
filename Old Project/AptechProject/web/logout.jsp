<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html> 
    <body>
        <%session.removeAttribute("userName");%>
        <s:action name="logOut" executeResult="true"/>
    </body>
</html>
