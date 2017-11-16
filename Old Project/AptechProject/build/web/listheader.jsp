<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>  
    <body>   
        <s:iterator value="lstSup">
        <li>
            <a href="support?supId=<s:property value="supportId"/>"><s:property value="supportHeader"/></a>                                            
        </li>
    </s:iterator>
</body>
</html>
