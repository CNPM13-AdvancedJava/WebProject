<%-- 
    Document   : ListType
    Created on : Dec 16, 2017, 6:36:08 AM
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

        <title>Type Management</title>
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
                    <h3 style="font-weight: bold">Quản lý thể loại</h3>
                    <section class="mainmenu">
                        <a href="ShowAddTypeForm" type="button" class="btn btn-primary addnew">
                            <span class="glyphicon glyphicon-plus"></span>
                            Thêm thể loại
                        </a>                     
                    </section>
                    <section>
                        <table style="width: 1000px;">
                            <thead>
                                <tr>
                                    <th class="col-1">Mã thể loại</th>
                                    <th class="col-1">Tên thể loại</th>
                                    <th class="col-2"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <s:iterator value="types">
                                    <tr>
                                        <td><s:property value="typeId"/></td>
                                        <td><s:property value="typeName"/></td>
                                        <td>
                                            <a href="ShowUpdateTypeForm?typeId=<s:property value="typeId"/>&typeName=<s:property value="typeName"/>"
                                                <span class="glyphicon glyphicon-pencil"></span>
                                            </a>
                                            <a href="#"
                                               onclick="deleteType(<s:property value="typeId"/>)">
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
            function deleteType(id) {
                console.log(id);
                var string;
                string = "Bạn có chắc chắn muốn xóa thể loại này không?";
                if (confirm(string)) {
                    window.location.href = "DeleteType?typeId=" + id;
                }
            }
        </script>
    </body>
</html>
