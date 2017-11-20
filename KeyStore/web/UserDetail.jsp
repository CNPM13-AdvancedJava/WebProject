<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin tài khoản</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">	
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" href="css/mystyle.css" type="text/css">
        <link href="css/content.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/popup.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="bgbody">
            <%@include file="Header.jsp" %>
            <div class="content-thongtintaikhoan">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-5 col-md-5 col-xs-12 images-tttk">
                            <img class="image-tttk" src="images/user/default_ava.jpg" alt="">
                        </div>
                        <div class="col-lg-7 col-md-7 col-xs-12 content-tttk">
                            <h2>Thông tin tài khoản</h2>
                            <h4>Tên tài khoản : </h4><span><s:property value="detail.userName"/></span></br></br>
                            <h4>Email : </h4><span><s:property value="detail.email"/></span></br></br>
                            <h4>Giới tính : </h4><span><s:property value="detail.gender"/></span></br></br>
                            <h4>Ngày sinh : </h4><span><s:property value="detail.dateOfBirth"/></span></br></br>
                            <h4>Số điện thoại : </h4><span><s:property value="detail.phoneNumber"/></span></br></br>
                            <h4>Địa chỉ : </h4><span><s:property value="detail.address"/></span></br></br>
                            <h4>Số dư tài khoản : </h4><span><s:property value="detail.money"/> VNĐ</span></br></br>
                            <span style="color: red"><s:property value="user.errorMessage"/></span>
                            <span style="color: greenyellow"><s:property value="user.successMessage"/></span></br></br>
                            <h4><a href="UserDetail?id=<%=session.getAttribute("userId")%>&isChange=1" type="button" class="btn btn-danger">Sửa thông tin</a>&nbsp;&nbsp;</h4>						
                            <h4><a href="javascript:void(0)" onclick="cardChargingPopup()" type="button" class="btn btn-danger">Nạp tiền</a>&nbsp;&nbsp;</h4>
                            <h4><a href = "javascript:void(0)" onclick="popup()" type="button" class="btn btn-danger">Đổi mật khẩu</a></h4>
                        </div>
                        <div id="light" class="white_content">
                            <div class="doimk">
                                <form action="ChangePassword?id=<%= session.getAttribute("userId")%>" method="POST">
                                    <table class="table table-default">
                                        <tr>
                                            <td class="label-changePass">Mật khẩu hiện tại : </td>
                                            <td><input type="password" class="form-control" name="curPass" value="" placeholder=""></td>
                                        </tr>
                                        <tr>
                                            <td class="label-changePass">Mật khẩu : </td>
                                            <td><input type="password" class="form-control" name="newPass" value="" placeholder=""></td>
                                        </tr>
                                        <tr>
                                            <td class="label-changePass">Nhập lại Mật khẩu : </td>
                                            <td><input type="password" class="form-control" name="cfmPass" value="" placeholder=""></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <button type="submit" class="btn btn-danger form-control">Xác nhận</button>																						
                                            </td>
                                            <td><a href="#" class="btn btn-danger form-control" onclick = "endpopup()">Huỷ bỏ</a> </td>
                                        </tr>
                                    </table>
                                </form>
                            </div>
                        </div>
                                    
                        <div id="charging" class="white_content">
                            <div class="doimk">
                                <form action="CardCharging?id=<%= session.getAttribute("userId")%>" method="POST">
                                    <table class="table table-default">
                                        <tr>
                                            <td class="label-changePass">Loại thẻ cào : </td>
                                            <td>
                                                <select name="cardType" class="form-control" required>
                                                    <option value="VT">Viettel</option> 
                                                    <option value="MBP">Mobiphone</option> 
                                                    <option value="VNP">Vinaphone</option> 
                                                    <option value="VNM">VietnamMobile</option> 
                                                </select>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="label-changePass">Serial : </td>
                                            <td><input type="text" class="form-control" name="serial" value="" placeholder="" required></td>
                                        </tr>
                                        <tr>
                                            <td class="label-changePass">PIN : </td>
                                            <td><input type="text" class="form-control" name="pin" value="" placeholder="" required></td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <button type="submit" class="btn btn-danger form-control">Nạp</button>																						
                                            </td>
                                            <td><a href="#" class="btn btn-danger form-control" onclick = "closeCardChargingPopup()">Huỷ bỏ</a> </td>
                                        </tr>
                                    </table>
                                </form>
                            </div>
                        </div>
                        <div id="fade" class="black_overlay"></div>
                    </div>	
                </div>
            </div>
            <%@include file="Footer.jsp" %>
        </div>       
    </body>
</html>
