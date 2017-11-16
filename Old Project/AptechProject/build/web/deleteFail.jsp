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
    <%@include file="header.jsp" %>
    <div id="wrapper">
        

        <div id="page-wrapper">     
            <div class="container-fluid">
                <div class="row">
                    <h2>Xóa thất bại!!</h2>
                    <p>Nguyên nhân có thể là do sản phầm bạn muốn xóa vẫn còn một số key 
                        chưa bán. Vui lòng kiểm tra lại  sản phẩm bạn muốn xóa.</p>
                    
                    
                    <a href="getAllProduct.jsp"><button type="button" class="btn btn-default">Quay lại</button></a>
                    
                </div>

            </div>           
        </div>
    </div>
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>
</html>
