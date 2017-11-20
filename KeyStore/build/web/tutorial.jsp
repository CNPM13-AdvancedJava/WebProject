<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hướng dẫn mua hàng</title>       
        <meta name="viewport" content="width=device-width, initial-scale=1">	
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" href="css/mystyle.css" type="text/css">
        <link href="css/content.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="bgbody">
            <%@include file="Header.jsp" %>
            <div class="content-gioithieu">   
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12 col-lg-12 banner">
                            <div class="col-md-8 col-sm-7 col-xs-12 col-lg-9 banner-content">
                                <s:action name="GetBanner" executeResult="true"/>
                            </div>
                            <div class="col-md-4 col-sm-5 col-xs-12 col-lg-3 top-game">
                                <s:action name="GetTop5" executeResult="true"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="product-content">
                            <div class="product-menu">
                                <s:action name="GetAllCatalog" executeResult="true"/> 
                            </div>
                            <div class="wrapper">
                                <h3 class="label">Hướng dẫn mua hàng</h3>
                                <p class="efgh">QUY TRÌNH THỰC HIỆN MUA  CD- KEY GAMES  TRỰC TUYẾN TẠI WW.KEYWORLD.VN</p>
                                <h4 class="step">Bước 1: </h4><p>Truy cập website <a href="#">www.store.com.vn</a></p>
                                <h4 class="step">Bước 2: </h4><p>Đăng ký thành viên tại <a href="#">www.store.com.vn</a></p>
                                <h4 class="step">Bước 3: </h4><p>Chọn game cần mua .</p>
                                <h4 class="step">Bước 4: </h4><p> Thanh toán, có các hình thức thanh toán sau: </p>
                                <p>-Thanh toán qua chuyển khoản qua ngân hàng VIETCOMBANK và DONG A BANK  bao gồm chuyển khoản tiền mặt tại ngân hàng và chuyển khoản trực tuyến  internet banking . ( Chú ý : khi thanh toán cần điền mã đơn hàng vào nội dung thanh toán ). Những quý khách hàng nào chưa có tài khoản ngân hàng có thể  đến ngân hàng Vietcombank hoặc Đông á bank chuyển tiền mặt trực tiếp vào số tài khoản của KEYWORLD.VN với nội dung " mã đơn hàng " của quý khách </p>
                                <p>-Thanh toán trực tuyến qua ví điện tử</p>
                                <h4 class="step">Bước 5: </h4><p>Nhận key qua Gmail hoặc SMS</p>
                                <h4 class="step">Bước 6: </h4><p>Kết thúc giao dịch</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
