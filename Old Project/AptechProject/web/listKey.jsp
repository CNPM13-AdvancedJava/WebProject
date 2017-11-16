<%-- 
    Document   : listUser
    Created on : May 19, 2016, 1:12:04 PM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/sb-admin.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="headerAdmin.jsp" %>
        <div id="wrapper">
            
            <div id="page-wrapper">     
                <div class="container-fluid">
                    <h3>Danh sách Key còn lại: </h3>
                    <div class="row">
                    <table class="rwd-table">
                        <thead>
                            <tr>
                                <th class="col-1">#</th>
                                <th class="col-5">Key</th>
                                <th class="col-1"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="listKey">
                                <tr>
                                    <td><s:property value="idProductkey"/></td>
                                    <td><s:property value="productkeyKey"/></td>
                                    <td><a href="deleteKey?idProductkey=<s:property value="idProductkey"/>" onclick="deleteKey()"><span class="glyphicon glyphicon-trash"></span></a></td>
                                </tr>
                            </s:iterator>
                        </tbody>

                    </table>
                    </div>      

                </div>           
            </div>
        </div>
        <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript">
            function deleteKey() {
                var string;
                string = "Bạn có chắc chắn muốn xóa key này không?";
                if (!confirm(string)) {
                    window.location.href="#";
                    window.history.back(1);
                }
            }
        </script>
        
    </body>
</html>
