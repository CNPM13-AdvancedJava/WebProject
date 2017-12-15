<%-- 
    Document   : UpdateManufacturer
    Created on : Dec 15, 2017, 10:38:36 PM
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
                        <h2>Cập nhật NSX</h2><br>
                        <span style="color: red"><s:property value="error"/></span>
                        <br>
                        <form action="UpdateManufacturer" method="Post">
                            <div class="form-group">
                                <label>Mã NSX</label>
                                <input class="form-control" name="manufacturerId"
                                       type="text"
                                       value="<s:property value="manufacturerId"/>"
                                       readonly="true">
                            </div>
                            <div class="form-group">
                                <label>Tên NSX</label>
                                <input class="form-control" name="manufacturerName"
                                       type="text"
                                       value="<s:property value="manufacturerName"/>"
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
