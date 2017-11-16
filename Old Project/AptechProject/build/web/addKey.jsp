<%-- 
    Document   : addProduct
    Created on : May 21, 2016, 1:22:54 PM
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
                    <div class="row">
                        
                        <form action="add" method="Post">
                            <h3>Tên sản phẩm: <s:property value="initProduct.productName"/></h3> 
                            <div class="form-group">
                                <input class="form-control" name="productKey.product.productId" value="<s:property value="initProduct.productId"/>" readonly="true">
                                <label>Nhập key:</label>
                                <textarea class="form-control" name="productKey.productkeyKey"></textarea>
                            </div>
                            <s:submit value="Thêm"/>
                        </form>
                    </div>

                </div>           
            </div>
        </div>
        <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
