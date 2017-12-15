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
                    <h3 style="font-weight: bold">Quản lý nhà sản xuất</h3>
                    <section class="mainmenu">
                        <a href="AddMenufacturer" type="button" class="btn btn-primary addnew"><span class="glyphicon glyphicon-plus"></span> Thêm nhà sản xuất</a>                     
                    </section>
                    <section>
                        <table style="width: 1000px;">
                            <thead>
                                <tr>
                                    <th class="col-1">##</th>
                                    <th class="col-1">Hình ảnh</th>
                                    <th class="col-2"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="manufacturers">
                                    <tr>
                                        <td><s:property value="manufacturerId"/></td>
                                        <td><s:property value="manufacturerName"/></td>
                                        <td><a href="AddProductKey?productId=<s:property value="productId"/>"><span class="glyphicon glyphicon-plus"></span></a>
                                            <a href="ProductDetail?productId=<s:property value="productId"/>"><span class="glyphicon glyphicon-pencil"></span></a>
                                            <a href="DeleteProduct?productId=<s:property value="productId"/>" onclick="deleteProduct()"><span class="glyphicon glyphicon-trash"></span></a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>

                        </table>

                    </section>
                </div>  
            </div>
        </div>
    </body>
</html>

