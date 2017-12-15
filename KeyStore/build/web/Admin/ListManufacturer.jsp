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

        <title>Product Management</title>
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
                        <a href="ShowAddManufacturerForm" type="button" class="btn btn-primary addnew">
                            <span class="glyphicon glyphicon-plus"></span>
                            Thêm nhà sản xuất
                        </a>                     
                    </section>
                    <section>
                        <table style="width: 1000px;">
                            <thead>
                                <tr>
                                    <th class="col-1">Mã NSX</th>
                                    <th class="col-1">Tên NSX</th>
                                    <th class="col-2"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="manufacturers">
                                    <tr>
                                        <td><s:property value="manufacturerId"/></td>
                                        <td><s:property value="manufacturerName"/></td>
                                        <td>
                                            <a href="ShowUpdateManufacturerForm?manufacturerId=<s:property value="manufacturerId"/>&manufacturerName=<s:property value="manufacturerName"/>"
                                                <span class="glyphicon glyphicon-pencil"></span>
                                            </a>
                                            <a href="#"
                                               onclick="deleteManufacturer(<s:property value="manufacturerId"/>)">
                                                <span class="glyphicon glyphicon-trash"></span>
                                            </a>
                                        </td>
                                    </tr>
                                </s:iterator>
                            </tbody>

                        </table>

                    </section>
                </div>  
            </div>
        </div>

        <script type="text/javascript">
            function deleteManufacturer(id) {
                console.log(id);
                var string;
                string = "Bạn có chắc chắn muốn NSX này không?";
                if (confirm(string)) {
                    window.location.href = "DeleteManufacturer?manufacturerId=" + id;
                }
            }
        </script>
    </body>
</html>

