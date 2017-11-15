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
                                        <a href="login.jsp">Login</a>
                                    </div>
                                </div>
                                <div class="panel-body" style="padding-top:30px;">
                                    <form action="register" id="form-register" method="Post">
                                        <span style="color: red"><s:property value="user.errorMessage"/></span>
                                        <div class="form-group">
                                            <input class="form-control" type="email" name="email" placeholder="Email Andress" maxlength="50" required/>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="text" name="userName" placeholder="Your Name" maxlength="50" required/>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="password" name="pwd" placeholder="Password" maxlength="20" minlength="8" required/>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="password" name="cfmPwd" placeholder="Confirm Password" maxlength="20" minlength="8" required/>
                                        </div>                                    
                                        <select name="gender" class="form-control" id="gender" required>
                                            <option value="1">Nam</option> 
                                            <option value="0">Nữ</option> 
                                        </select>
                                        </br>
                                        <div class="form-group">
                                            <input class="form-control" type="date" name="dateOfBirth" placeholder="Date Of Birth" required/>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="tel" name="phoneNumber" placeholder="Phone Number" maxlength="14"/>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" type="text" name="address" placeholder="Address" maxlength="100"/>
                                        </div>
                                        <button class="btn btn-danger">Đăng Kí</button>
                                        <a href="login.jsp" type="button" class="btn btn-danger">Huỷ bỏ</a>
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
