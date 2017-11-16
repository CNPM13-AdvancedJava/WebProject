<%-- 
    Document   : header
    Created on : Jun 2, 2016, 2:02:52 PM
    Author     : Linh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản trị</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/sb-admin.css" rel="stylesheet">
        <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="header">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="main.jsp">Trang Chủ</a>
                </div>
            <ul class="nav navbar-right top-nav">               
                <a class="navbar-brand action" href="userInfo.jsp"><%=session.getAttribute("userNameAdmin")%></a>
                <a class="navbar-brand action" href="logOutAdmin.jsp">Đăng xuất</a>
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li>
                            <a href="getAllProduct.jsp"><i class="fa fa-fw fa-dashboard"></i><span class="glyphicon glyphicon-th-list"></span> Sản phẩm </a>
                        </li>
                        <li>
                            <a href="getAllUser.jsp"><i class="fa fa-fw fa-table"></i><span class="glyphicon glyphicon-user"></span> Thông tin khách hàng</a>
                        </li>
                        <li>
                            <a href="getAllOrder.jsp"><i class="fa fa-fw fa-bar-chart-o"></i><span class="glyphicon glyphicon-stats"></span>Tất cả đơn hàng </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </body>
</html>
