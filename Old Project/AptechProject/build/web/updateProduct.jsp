<%-- 
    Document   : addProduct
    Created on : May 21, 2016, 1:22:54 PM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manager</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/sb-admin.css" rel="stylesheet">
    </head>
    <body>
    <%@include file="headerAdmin.jsp" %>
    <div id="wrapper">
        <div id="page-wrapper">     
            <div class="container-fluid">
            <div class="row">
                <s:iterator value="initProduct">
                    <form action="updateProduct">
                        <div class="form-group">
                        <label>Mã Sản Phẩm<span>*</span></label>
                        <input class="form-control" name="product.productId" readonly="true" value="<s:property value="productId"/>">
                    </div>
                    <div class="form-group">
                        <label>Tên Sản Phẩm<span>*</span></label>
                        <input class="form-control" name="product.productName" required="required" value="<s:property value="productName"/>">
                    </div> 
                    <div class="form-group">
                        <label>Thể loại</label>
                        <input class="form-control" name="aa" value="<s:property value="gametype.gametypeName"/>">
                        
                    </div>
                    <div class="form-group">
                        <label>Ngày ra mắt</label>
                        <input class="form-control" name="timeRelease"  value="<s:property value="timeRelease"/>" readonly="true">
                        <input class="form-control" name="product.timeRelease" type="date">
                    </div>
                    <div class="form-group">
                        <label>Nhà sản xuất</label>
                        <input class="form-control" name="product.manufacturer" value="<s:property value="manufacturer"/>">
                    </div>
                    <div class="form-group">
                        <label>Mô tả</label>
                        <textarea class="form-control" name="product.context" rows="15"><s:property value="context"/></textarea>
                    </div>
                    <div class="form-group">
                        <label>Tiêu đề</label>
                        <input class="form-control" name="product.typetext" value="<s:property value="typetext"/>">
                    </div>
                    <div class="form-group">
                        <label>Nội dung</label>
                        <input class="form-control" name="product.headcontext" value="<s:property value="headcontext"/>">
                    </div>
                    <div class="form-group">
                        <label>Ngôn ngữ</label>
                        <input class="form-control" name="product.language" value="<s:property value="language"/>">
                    </div>
                    <div class="form-group">
                        <label>Chế độ</label>
                        <input class="form-control" name="product.regime" value="<s:property value="regime"/>">
                    </div>
                    <div class="form-group">
                        <label>Khu vực</label>
                        <input class="form-control" name="product.region" value="<s:property value="region"/>">
                    </div>
                    <div class="form-group">
                        <label>Giảm giá</label>
                        <input class="form-control" name="product.saled.sale" value="<s:property value="saled.sale"/>">
                    </div>
                    <div class="form-group">
                        <label>Giá<span>*</span></label>
                        <input class="form-control" name="product.prince" required="required" value="<s:property value="prince"/>">
                    </div>
                    <button class="btn btn-primary addnew">Sửa</button>
                    </form>
                </s:iterator>
                </div>

            </div>           
        </div>
    </div>
    <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
