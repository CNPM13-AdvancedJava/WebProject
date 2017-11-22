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
                                    <a class="navbar-brand selected" href="Home.jsp">Trang Chủ</a>
                                </div>				
                                <div class="collapse navbar-collapse navbar-ex1-collapse">
                                    <ul class="nav navbar-nav">
                                        <li><a href="Introduction.jsp">Giới Thiệu</a></li>	
                                        <li><a href="Provision.jsp">Điều khoản và dịch vụ</a></li>	
                                        <li><a href="Tutorial.jsp">Hướng dẫn thanh toán</a></li>	
                                        <li><a href="#">Hỗ trợ</a></li>	
                                    </ul>
                                    <%
                                        Integer amount = (Integer) session.getAttribute("amount");
                                        if (amount == null){
                                            amount = 0;
                                        }
                                    %>
                                    <ul class="nav navbar-nav navbar-right">
                                        <li><a href="MyCart">Giỏ hàng của bạn (<%=amount%> sản phẩm)</a></li>
                                        <% if((session.getAttribute("userName"))!=null){ %>                             
                                        <li role="presentation" class="dropdown" id="name-header-content">
                                            <span class="span-header-login">Xin Chào</span>
                                            <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                                <span><%= session.getAttribute("userName")%></span>
                                            </a>
                                            <ul class="dropdown-menu">
                                                <li>
                                                    <a href="UserDetail?id=<%=session.getAttribute("userId")%>">
                                                        Quản lí thông tin
                                                    </a>
                                                </li>
                                                <li>
                                                    <a href="Logout">
                                                        Đăng Xuất
                                                    </a>
                                                </li>
                                            </ul>
                                        </li>
                                        <% } else {%>
                                        <li><a class="selected" href="Login.jsp">Đăng Nhập</a></li>
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
