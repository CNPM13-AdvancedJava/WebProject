<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
    String name = request.getParameter("txt-user");
    session.setAttribute("userName",name);
%>
<html>   
    <body>       
        <s:action name="headerGoMain" executeResult="true"/>
    </body>
</html>