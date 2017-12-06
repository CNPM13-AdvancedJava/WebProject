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
                        <%if (session.getAttribute("ErrorInsert") != null) {%>
                        <span class="ErrorLogin"><%=session.getAttribute("ErrorInsert")%></span>
                        <%} else { %>
                        <span></span>
                        <%}%>
                        <s:form action="addProduct" enctype="multipart/form-data" method="Post">
                            <div class="form-group">
                                <label>Tên Sản Phẩm<span>*</span></label>
                                <input class="form-control" name="product.productName" required="required">
                            </div> 
                            <label>Dòng máy : </label>
                            <select id="box1" class="form-group" name="catalog">
                                <option>----- Chọn Dòng Máy -----</option>
                                <s:iterator value="listCatalog">                                   
                                    <option value="<s:property value="catalogId"/>"><s:property value="catalogName"/></option>                                    
                                </s:iterator>
                            </select>
                            <div class="form-group">
                            <label>Thể loại Game : </label>
                            <select id="box2" class="boxGametype" style="display:none;" name="product.gametype.gametypeId">
                                <option value="1">Battlefield (series)</option> 
                                <option value="3">Call of Duty (series)</option> 
                                <option value="4">GUILD WARS (series)</option> 
                                <option value="5">STARCARFT (series)</option> 
                                <option value="6">Action/Adventure</option> 
                                <option value="7">Sports</option> 
                                <option value="8">Shooter</option> 
                                <option value="9">Racing</option> 
                                <option value="10">MMO GAMES</option> 
                                <option value="11">Strategy</option> 
                                <option value="12">EA-ORIGIN GAMES</option> 
                                <option value="13">Steam Games</option> 
                                <option value="14">Ubisoft - Uplay games</option> 
                                <option value="15">Kaspesky CD Key</option> 
                                <option value="16">Blizzard Game</option> 
                                <option value="17">PRE-ORDER</option> 
                            </select>
                            <select id="box3" class="boxGametype" style="display:none;" name="product.Gametype.gametypeId">
                                <option value="19">Chery Credits Cards</option> 
                                <option value="21">Go Cashs</option> 
                                <option value="22">Steam Wallet Card</option> 
                                <option value="23">Code giảm ping</option> 
                                <option value="24">Rixty Cards</option> 
                            </select>
                            <select id="box4" class="boxGametype" style="display:none;" name="product.Gametype.gametypeId">
                                <option value="25">Play Station Network US Card</option> 
                                <option value="26">Play Station Network UK Card</option>
                            </select>
                            <select id="box5" class="boxGametype" style="display:none;" name="product.Gametype.gametypeId">
                                <option value="27">XBOX LIVE Cards</option> 
                            </select>
                            <select id="box6" class="boxGametype" style="display:none;" name="product.Gametype.gametypeId">
                                <option value="28">Itunes USA Cards</option> 
                                <option value="29">Google Play USA Cards</option>
                            </select>
                            </div>
                            <div class="form-group">
                                <label>Ngày ra mắt</label>
                                <input class="form-control" name="timeRelease" type="date">
                            </div>
                            <div class="form-group">
                                <label>Nhà sản xuất</label>
                                <input class="form-control" name="product.manufacturer">
                            </div>
                            <div class="form-group">
                                <label>Mô tả</label>
                                <textarea class="form-control" name="product.context" rows="15" required="required"></textarea>
                            </div>
                            <div class="form-group">
                                <label>Tiêu đề</label>
                                <input class="form-control" name="product.typetext">
                            </div>
                            <div class="form-group">
                                <label>Nội dung</label>
                                <textarea class="form-control" name="product.headcontext"></textarea>
                            </div>
                            <div class="form-group">
                                <label>Ngôn ngữ</label>
                                <input class="form-control" name="product.language">
                            </div>
                            <div class="form-group">
                                <label>Chế độ</label>
                                <input class="form-control" name="product.regime">
                            </div>
                            <div class="form-group">
                                <label>Khu vực</label>
                                <input class="form-control" name="product.region">
                            </div>
                            <div class="form-group">
                                <label>Giá<span>*</span></label>
                                <input class="form-control" name="product.prince" required="required" type="number">
                            </div>
                            <label>Giảm giá : </label>
                            <select name="product.saled.salesId">
                                <s:iterator value="listSale">
                                    <label>Giảm Giá</label>
                                    <option value="<s:property value="salesId"/>"><s:property value="sale"/></option>
                                </s:iterator>
                            </select>
                            <div class="form-group">
                                <label>Thêm ảnh</label>
                                <s:file name="productImage"/>
                            </div>
                            <s:submit value="Thêm"/>
                        </s:form>
                    </div>

                </div>           
            </div>
        </div>
    </body>
</html>
