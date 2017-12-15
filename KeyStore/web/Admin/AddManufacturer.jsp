<%-- 
    Document   : AddManufacturer
    Created on : Dec 15, 2017, 9:18:51 PM
    Author     : Bumble Bee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Thêm nhà sản xuất</title>
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
                        <h2>Thêm nhà sản xuất</h2><br>
                        <span style="color: red"><s:property value="error"/></span>
                        <br>
                        <form action="AddNewManufacturer" method="Post">
                            <div class="form-group">
                                <label>Tên nhà sản xuất</label>
                                <input class="form-control" name="manufacturerName" type="text">
                            </div>
                            <s:submit value="Thêm"/>
                        </form>
                    </div>

                </div>           
            </div>
        </div>
        
    </body>
</html>

