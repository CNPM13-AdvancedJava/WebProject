<%-- 
    Document   : ListProduct
    Created on : Dec 2, 2017, 2:10:53 PM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Product Managerment</title>
        <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="../vendor/metisMenu/metisMenu.min.css" rel="stylesheet">
        <link href="../dist/css/sb-admin-2.css" rel="stylesheet">
        <link href="../vendor/morrisjs/morris.css" rel="stylesheet">
        <link href="../vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    </head>
    <%@include file="Header.jsp" %>
    <body>
        <div id="wrapper">
            <div id="page-wrapper">     
                <div class="container-fluid">
                    <div class="row">
                        <h2>Thêm mã kích hoạt</h2><br>
                        <span style="color: red"><s:property value="MESSAGE"/></span>
                        <br>
                        <form action="InsertProductKey" method="Post">
                            <div class="form-group">
                                <label>Mã sản phẩm</label>
                                <input class="form-control" name="productId" type="text" value="<s:property value="product.productId"/>" readonly="true">
                            </div>
                            <div class="form-group">
                                <label>Tên sản phẩm</label>
                                <input class="form-control" name="productName" type="text" value="<s:property value="product.productName"/>" readonly="true">
                            </div>
                            <div class="form-group">
                                <label>Mã kích hoạt</label>
                                <input class="form-control" name="productKey" type="text">
                            </div>
                            <s:submit value="Thêm"/>
                        </form>
                    </div>

                </div>           
            </div>
        </div>
        
    </body>
</html>
