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
        <title>Manager</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/sb-admin.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="headerAdmin.jsp" %>
        <div id="page-wrapper">     
            <div class="container-fluid">
                <div class="row">
                    <s:iterator value="user">
                        <section class="image">
                            <img class="images-detail" src="<s:property value="userImages"/>">
                        </section>
                        <div class="info">
                        <h4>Địa chỉ Email: <s:property value="userName"/></h4>
                        <h4>Số điện thoại: <s:property value="userPhonenum"/></h4>
                        <h4>Giới tính: <s:property value="userGender"/></h4>
                        <h4>Ngày sinh: <s:property value="userDateofbirth"/></h4>
                        <h4>Địa chỉ: <s:property value="userAddress"/></h4>
                        <h4>Ví: <s:property value="money"/> VNĐ</h4>
                        </div>
                    </s:iterator>
                </div>
            </div>           
        </div>
    </div>
    <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
