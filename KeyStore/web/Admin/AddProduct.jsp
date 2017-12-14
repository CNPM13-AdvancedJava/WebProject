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
                        <h2>Thêm sản phẩm</h2>
                        <br><br>
                        <s:form action="InsertProduct" enctype="multipart/form-data" method="Post">
                            <div class="form-group">
                                <label>Tên Sản Phẩm<span>*</span></label>
                                <input class="form-control" name="productName" required="required">
                            </div> 
                            <label>Dòng máy : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                            <select id="catalogBox" class="form-group" name="catalogId" onchange="loadGameType()">
                                <option>----- Chọn Dòng Game -----</option>
                                <s:iterator value="lstCatalog">                                   
                                    <option value="<s:property value="catalogId"/>"><s:property value="catalogName"/></option>                                    
                                </s:iterator>
                            </select>
                            <div class="form-group">
                                <label>Thể loại Game : </label>
                                <select id="gameTypeBox" class="boxGametype" name="typeId">
                                    <option>----- Chọn Thể Loại -----</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Nhà sản xuất : &nbsp;</label>
                                <select id="catalogBox" class="form-group" name="manufacturerId" onchange="loadGameType()">
                                    <option>----- Chọn Nhà Sản Xuất -----</option>
                                    <s:iterator value="lstManufacturer">                                   
                                        <option value="<s:property value="manufacturerId"/>"><s:property value="manufacturerName"/></option>                                    
                                    </s:iterator>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Ngày ra mắt</label>
                                <input class="form-control" name="releaseTime" type="date">
                            </div>
                            <div class="form-group">
                                <label>Ngôn ngữ</label>
                                <input class="form-control" name="language">
                            </div>
                            <div class="form-group">
                                <label>Khu vực</label>
                                <input class="form-control" name="region">
                            </div>
                            <div class="form-group">
                                <label>Giá<span>*</span></label>
                                <input class="form-control" name="product.prince" required="required" type="number">
                            </div>
                            <div class="form-group">
                                <label>Mô tả<span>*</span></label>
                                <textarea class="form-control" name="description"></textarea>
                            </div>
                            <div class="form-group">
                                <label>Giới thiệu<span>*</span></label>
                                <textarea class="form-control" name="introduction" rows="10" required="required"></textarea>
                            </div>
                            <div class="form-group">
                                <label>Thêm ảnh</label>
                                <input type="file" name="productImage">
                            </div>
                            <div>
                                <button type="submit" class="btn btn-primary addnew"><span class="glyphicon glyphicon-plus"></span> Thêm sản phẩm</button>                     
                            </div>
                        </s:form>
                    </div>

                </div>           
            </div>
        </div>
        <script type="text/javascript">
            function loadGameType() {
                var e = document.getElementById("catalogBox");
                var catalogId = e.options[e.selectedIndex].value;
                var box = document.getElementById("gameTypeBox");
                box.options.length = 0;
                var initOpt = document.createElement('option');
                initOpt.innerHTML = "----- Chọn Thể loại -----";
                box.appendChild(initOpt);
            <s:iterator value="lstType">
                var itemId = <s:property value="catalog.catalogId"/>;
                if (parseInt(catalogId) === parseInt(itemId)) {
                    var typeid = <s:property value="typeId"/>;
                    var typename = '<s:property value="typeName"/>';
                    var opt = document.createElement('option');
                    opt.value = typeid;
                    opt.innerHTML = typename;
                    box.appendChild(opt);
                }
            </s:iterator>
            }
        </script>
    </body>
</html>
