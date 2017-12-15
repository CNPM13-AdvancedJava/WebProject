<%-- 
    Document   : UpdateCatalog
    Created on : Dec 16, 2017, 6:14:55 AM
    Author     : Bumble Bee
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

        <title>Catalog</title>
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
                        <h2>Cập nhật catalog</h2><br>
                        <span style="color: red"><s:property value="error"/></span>
                        <br>
                        <form action="UpdateCatalog" method="Post">
                            <div class="form-group">
                                <label>Mã catalog</label>
                                <input class="form-control" name="catalogId"
                                       type="text"
                                       value="<s:property value="catalogId"/>"
                                       readonly="true">
                            </div>
                            <div class="form-group">
                                <label>Tên catalog</label>
                                <input class="form-control" name="catalogName"
                                       type="text"
                                       value="<s:property value="catalogName"/>"
                                       required="true">
                            </div>
                            <s:submit value="Lưu"/>
                        </form>
                    </div>

                </div>           
            </div>
        </div>
    </body>
</html>
