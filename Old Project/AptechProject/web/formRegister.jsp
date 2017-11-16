<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>     
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/login.css"/>
        <script src="js/jquery-2.2.3.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>            
    <body>
        <div class="bg-login">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <div id="register-box">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <div class="panel-title">Register</div>
                                    <div class="fg-pass">
                                        <a href="loginIn.jsp">Login</a>
                                    </div>
                                </div>
                                <div class="panel-body" style="padding-top:30px;">
                                    <form action="checkUserName"  id="form-register" method="Post">
                                        <%if (session.getAttribute("ErrorRegister") != null) {%>
                                        <span class="ErrorLogin"><%=session.getAttribute("ErrorRegister")%></span>
                                        <%}%>
                                        <div class="form-group">
                                            <input class="form-control" type="email" name="user.userName" placeholder="Email Andress"/>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="password" name="password" placeholder="Password"/>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="password" name="confirmPass" placeholder="Confirm Password"/>
                                        </div>                                    
                                        <select name="gender" class="form-control" id="gender">
                                            <option value="1">Nam</option> 
                                            <option value="0">Nữ</option> 
                                        </select>
                                        </br>
                                        <div class="form-group">
                                            <input class="form-control" type="date" name="birthdate" placeholder="Date Of Birth"/>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="tel" name="user.userPhonenum" placeholder="Phone Number"/>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="text" name="user.userAddress" placeholder="Address"/>
                                        </div>
                                        <button class="btn btn-danger">Đăng Kí</button>
                                        <a href="loginIn.jsp" type="button" class="btn btn-danger">Huỷ bỏ</a>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
