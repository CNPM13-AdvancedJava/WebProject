<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>     
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/login.css"/>
        <script src="js/jquery-2.2.3.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="bg-login">
            <div class="container">
                <%if(session.getAttribute("userNameAdmin") != null){%>
                <s:action name="goAdminifnoNull" executeResult="true"/>                       
                <%}else { %>
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <div id="login-box">
                            <div class="panel panel-info">
                                <div class="panel-heading">                           
                                    <div class="panel-title"><a href="main.jsp">Trang Chủ</a></div>
                                    <div class="fg-pass">
                                        <a class="forgot-password" href="#">Forgot Password?</a>
                                    </div>
                                </div>
                                <div class="panel-body" style="padding-top:30px;">
                                    <form action="LoginUserAdmin" method="POST" class="form-horizontal" id="form-login" role="form" enctype="multipart/form-data">
                                        <%if(session.getAttribute("ErrorLoginAdmin") != null){%>
                                        <span class="ErrorLogin"><%=session.getAttribute("ErrorLoginAdmin")%></span>
                                        <%} else { %>
                                        <span></span>
                                        <%}%>
                                        <div class="input-group user-login">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-user"></i>
                                            </span>
                                            <input id="loginuser" class="form-control" type="email" name="txt-user-admin" placeholder="Địa chỉ Email" tabindex="1"/>                                           
                                        </div>
                                        <div class="input-group pass-login">
                                            <span class="input-group-addon">
                                                <i class="glyphicon glyphicon-lock"></i>
                                            </span>
                                            <input id="loginpass" class="form-control" type="password" name="txt-pass-admin" placeholder="Mật Khẩu" tabindex="2"/>
                                        </div>
                                        <div class="input-group">
                                            <input type="checkbox" name="ckb-remember-admin" tabindex="3" id="ckb-login" />
                                            <label for="ckb-login-admin">Nhớ Mật Khẩu</label>
                                        </div>
                                        <div class="input-group" style="margin-top: 5px;">
                                            <div class="row">
                                                <div class="col-sm-12">
                                                    <button  id="btn-login" tabindex="4" class="btn btn-success">Đăng Nhập</button>
                                                    <a type="button"  id="btn-fblogin" tabindex="4" class="btn btn-primary">Đăng Nhập Facebook</a>
                                                </div>
                                            </div>
                                        </div>      
                                    </form>
                                </div>
                            </div>
                        </div>                       
                    </div>
                </div
                <%}%>
            </div>
        </div>
    </body>
</html>
