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
        <title>Quản trị</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/sb-admin.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="headerAdmin.jsp" %>
        <div id="wrapper">
            <div id="page-wrapper">     
                <div class="container-fluid">
                    <section class="mainmenu">
                        <a href="addProductIn" type="button" class="btn btn-primary addnew"><span class="glyphicon glyphicon-plus"></span> Thêm sản phẩm</a>                     
                    </section>
                    <%if (session.getAttribute("Message") != null) {%>
                        <span class="ErrorLogin"><%=session.getAttribute("Message")%></span>
                        <%} else { %>
                        <span></span>
                        <%}%>
                    <table class="rwd-table">
                        <thead>
                            <tr>
                                <th class="col-1">#</th>
                                <th class="col-2">Hình ảnh</th>
                                <th class="col-2">Tên sản phẩm</th>
                                <th class="col-15">Thể loại</th>
                                <th class="col-15">Giá</th>
                                <th class="col-15">Giảm giá</th>
                                <th class="col-15"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <s:iterator value="listProduct">
                                <tr>
                                    <td><s:property value="productId"/></td>
                                    <td><img src="<s:property value="images"/>" height="90px" width="70px"></td>
                                    <td><s:property value="productName"/></td>
                                    <td><s:property value="gametype.gametypeName"/></td>
                                    <td><s:property value="prince"/></td>
                                    <td><s:property value="saled.sale"/>%</td>
                                    <td><a href="addkey?productId=<s:property value="productId"/>"><span class="glyphicon glyphicon-plus"></span></a>
                                        <a href="getKeyByID?productId=<s:property value="productId"/>"><span class="glyphicon glyphicon-eye-open"></span></a>
                                        <a href="initProduct?productId=<s:property value="productId"/>"><span class="glyphicon glyphicon-pencil"></span></a>
                                        <a href="delete?productId=<s:property value="productId"/>" onclick="deleteProduct()"><span class="glyphicon glyphicon-trash"></span></a></td>
                                </tr>
                            </s:iterator>
                        </tbody>

                    </table>


                </div>           
            </div>
        </div>
        <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript">
            function deleteProduct() {
                var string;
                string = "Bạn có chắc chắn muốn xóa sản phẩm này không?";
                if (!confirm(string)) {
                    window.location.href="#";
                    window.history.back(1);
                }
            }
        </script>


    </body>
</html>
