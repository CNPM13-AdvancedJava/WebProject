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
                            <th class="col-2">Khách hàng</th>
                            <th class="col-2">Sản phẩm</th>
                            <th class="col-1">Giá</th>
                            <th class="col-2">Hình thức</th>
                            <th class="col-1">Tình trạng</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="listOrder">
                            <tr>
                                <td><s:property value="orderId"/></td>
                                <td><s:property value="userkey.userName"/></td>
                                <td><s:property value="product.productName"/></td>
                                <td><s:property value="product.prince"/></td>
                                <td><s:property value="method.methodName"/></td>
                                <td><s:property value="orderPstatus"/></td>
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
