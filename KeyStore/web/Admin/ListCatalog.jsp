<%-- 
    Document   : ListCatalog
    Created on : Dec 16, 2017, 6:08:25 AM
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

        <title>Catalog Management</title>
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
                    <h3 style="font-weight: bold">Quản lý catalog</h3>
                    <section class="mainmenu">
                        <a href="ShowAddCatalogForm" type="button" class="btn btn-primary addnew">
                            <span class="glyphicon glyphicon-plus"></span>
                            Thêm catalog
                        </a>                     
                    </section>
                    <section>
                        <table style="width: 1000px;">
                            <thead>
                                <tr>
                                    <th class="col-1">Mã Catalog</th>
                                    <th class="col-1">Tên Catalog</th>
                                    <th class="col-2"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="catalogs">
                                    <tr>
                                        <td><s:property value="catalogId"/></td>
                                        <td><s:property value="catalogName"/></td>
                                        <td>
                                            <a href="ShowUpdateCatalogForm?catalogId=<s:property value="catalogId"/>&catalogName=<s:property value="catalogName"/>"
                                                <span class="glyphicon glyphicon-pencil"></span>
                                            </a>
                                            <a href="#"
                                               onclick="deleteCatalog(<s:property value="catalogId"/>)">
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
            function deleteCatalog(id) {
                console.log(id);
                var string;
                string = "Bạn có chắc chắn muốn xóa Catalog này không?";
                if (confirm(string)) {
                    window.location.href = "DeleteCatalog?catalogId=" + id;
                }
            }
        </script>
    </body>
</html>
