<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html> 
    <body>
        <%session.removeAttribute("userNameAdmin");%>
        <s:action name="logOutAdmin" executeResult="true"/>
    </body>
</html>
