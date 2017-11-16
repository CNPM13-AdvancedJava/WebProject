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
                    <table class="rwd-table">
                        <thead>
                            <tr>
                                <th class="col-1">#</th>
                                <th class="col-2">Email</th>
                                <th class="col-2">Ngày sinh</th>
                                <th class="col-2">Giới tính</th>
                                <th class="col-25">Địa chỉ</th>
                                <th class="col-15">SĐT</th>
                                <th class="col-15">Ví</th>
                                <th class="col-15"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="listUser">
                                <tr>
                                    <td><s:property value="userId"/></td>
                                    <td><s:property value="userName"/></td>
                                    <td><s:property value="userDateofbirth"/></td>
                                    <td><s:property value="userGender"/></td>
                                    <td><s:property value="userAddress"/></td>
                                    <td><s:property value="userPhonenum"/></td>
                                    <td><s:property value="money"/></td>
                                    <td><a href="getUserInfo?userId=<s:property value="userId"/>"><span class="glyphicon glyphicon-search"/></a></td>
                                </tr>
                            </s:iterator>
                        </tbody>

                    </table>


                </div>           
            </div>
        </div>
        <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
