<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sửa thông tin tài khoản</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">	
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
        <link href="css/content.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="bgbody">
            <%@include file="header.jsp" %>
            <div class="content-updatetttk">
                <div class="container">
                    <div class="row">					
                        <div>
                            <div class="col-lg-5 col-md-5 col-xs-12 images-tttk">
                                <img class="image-tttk" src="<s:property value="userById.userImages"/>" alt="">							
                            </div>
                            <div class="col-lg-7 col-md-7 col-xs-12 conten-tttk">
                                <h2>Sửa thông tin tài khoản</h2>
                                <form action="userUpdatebyId?userUpdateId=<s:property value="userById.userId"/>" method="POST">
                                    <table class="table table-default">
                                        <tr>
                                            <td><h4>Tên tài khoản : </h4></td>
                                            <td><input readonly="true" type="text" name="txt-user" class="form-control" value="<s:property value="userById.userName"/>"></td>
                                        </tr>
                                        <tr>
                                            <td><h4>Ngày sinh : </h4></td>
                                            <td><input type="date" class="form-control" name="birtdate" value="<s:property value="birtdate"/>"></td>
                                        </tr>
                                        <tr>
                                            <td><h4>Giới tính : </h4></td>
                                            <td>
                                                <select name="gender" class="form-control">
                                                    <option value="1">Nam</option>
                                                    <option value="2">Nữ</option>
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><h4>Số điện thoại : </h4></td>
                                            <td><input type="text" class="form-control" name="txt-phone" value="<s:property value="userById.userPhonenum"/>"></td>
                                        </tr>
                                        <tr>
                                            <td><h4>Địa chỉ : </h4></td>
                                            <td><input type="text" class="form-control" name="txt-address" value="<s:property value="userById.userAddress"/>"></td>
                                        </tr>
                                        <tr>
                                            <td><h4>Ảnh đại diện : </h4></td>
                                            <td><input type="file" class="form-control" name="userImage" value="" placeholder=""></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <button class="btn btn-danger">Xác nhận</button>&nbsp;&nbsp;
                                                <a href="getListUser?userNameList=<s:property value="userById.userName"/>" type="button" class="btn btn-danger">Huỷ bỏ</a>
                                            </td>
                                            <td>
                                                &nbsp;
                                            </td>
                                        </tr>								
                                    </table>
                                </form>
                            </div>
                        </div>
                    </div>	
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>       
    </body>
</html>
