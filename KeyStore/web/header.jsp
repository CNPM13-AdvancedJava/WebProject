<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>  
    <body>
        <div class="header">
            <div class="container">
                <div class="row">				
                    <div class="col-md-12 col-sm-12 col-xs-12 header-content">
                        <nav class="navbar navbar-default" role="navigation">
                            <div class="container-fluid">						
                                <div class="navbar-header">
                                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                                        <span class="sr-only">Toggle navigation</span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                        <span class="icon-bar"></span>
                                    </button>
                                    <a class="navbar-brand selected" href="home.jsp">Trang Chủ</a>
                                </div>				
                                <div class="collapse navbar-collapse navbar-ex1-collapse">
                                    <ul class="nav navbar-nav">
                                        <li><a href="introduction.jsp">Giới Thiệu</a></li>	
                                        <li><a href="provision.jsp">Điều khoản và dịch vụ</a></li>	
                                        <li><a href="tutorial.jsp">Hướng dẫn thanh toán</a></li>	
                                        <li><a href="#">Hỗ trợ</a></li>	
                                    </ul>								
                                    <ul class="nav navbar-nav navbar-right">
                                        <form action="findProduct" method="POST" class="navbar-form navbar-left" role="search">
                                            <div class="form-group">										
                                                <input type="search" name="txt-searchValue" class="form-control" placeholder="Tìm kiếm">	
                                                <button type="submit" class="btn btn-default form-control"><span class="glyphicon glyphicon-search"></span></button>
                                            </div>
                                        </form>
                                        <% if((session.getAttribute("userName"))!=null){ %>                             
                                        <li role="presentation" class="dropdown" id="name-header-content">
                                            <span class="span-header-login">Xin Chào</span>
                                            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                                <span><%= session.getAttribute("userName")%></span>
                                            </a>
                                            <ul class="dropdown-menu">
                                                <li>
                                                    <a href="getGiohang?userNameGH=<%=session.getAttribute("userName")%>">
                                                        Giỏ Hàng
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="getListUser?userNameList=<%=session.getAttribute("userName")%>">
                                                        Quản lí thông tin
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="getLogOut">
                                                        Đăng Xuất
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <% } else {%>
                                        <li><a class="selected" href="loginIn.jsp">Đăng Nhập</a></li>
                                        <%}%>
                                    </ul>
                                </div>
                            </div>
                        </nav>
                    </div> 
                </div>		
            </div>
        </div>       
    </body>
</html>
