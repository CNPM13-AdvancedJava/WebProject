<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Giới Thiệu</title>       
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
                                <h3 class="label">Giới Thiệu</h3>
                                <p class="efgh">Website Keyworld.vn đã được xác thực bởi BỘ CÔNG THƯƠNG VIỆT NAM.</p>
                                <p>KEYWORLD.VN là dịch vụ trung gian cung cấp key game online đáng tin cậy nhất tại Việt Nam  cũng như Quốc tế mà khách hàng có thể tin tưởng ở chúng tôi về mặt chất lượng sản phẩm cũng như giá cả.</p>
                                <p>KEYWORLD.VN được khách hàng đánh giá là UY TÍN, TẬN TÂM VÀ GIÁ CẢ PHÙ HỢP </p>
                                <p class="abcd">Về phía Sản Phẩm:</p>
                                <p> *  Tất cả các cdkeys,  mã game tại KEYGAMEPC.COM đều được cung cấp bởi các nhà phân phối chính ở nước ngoài. Chúng được chụp từ các đĩa gốc và được scan từ các hộp game . Vì vậy quý khách hãy yên tâm chúng  là 100% keygame bản quyền và chính hãng từ các hãng EA game, STEAM game, và các hãng khác như UBISOFT, SEGA, ACTIVISON , ROCKSTAR....</p>
                                <p>*  Chúng tôi sẽ luôn cập nhật các loại game mới nhất và hấp dẫn nhất để phuc vụ quý khách. Ngoài ra chúng tôi cũng giao hàng kịp thời cho các đơn đặt hàng trước của các game mới,giúp quý khách sẵn sàng có game chơi vào đúng thời điểm phát hành.</p>
                                <p class="abcd">Về Giá của sản phẩm:</p>
                                <p>Chúng tôi luôn tìm các mức giá tốt nhất cho khách hàng. Bởi vì chúng tôi mua trực tiếp từ các nhà cung cấp với số lượng lớn vì vậy mà chúng tôi được ưu đãi về giá . Đó là lý do tại sao giá game của  KEYWORLD.VN thường rẻ hơn so với giá của các hãng STEAM, EA, hay các hãng khác</p>
                                <p class="abcd">Về phía Cung Cấp Sản Phẩm và Dịch vụ:</p>
                                <p>• Chúng tôi luôn đề cao dịch vụ khách hàng là vấn đề hàng đầu và hệ thống phân phối ngay lập tức của mình. </p>
                                <p>• Quý khách  sẽ hài lòng với việc giao dịch, trao đổi,và sự lựa chọn sản phẩm của quý khách tại trang web của chúng tôi.</p>
                                <p>• Chúng tôi sẽ thông báo cho bạn về ngôn ngữ có sẵn, khu vực giới hạn và các hướng dẫn cần thiết bất cứ khi nào bạn cần.</p>
                                <p>• Chúng tôi luôn luôn cung cấp dịch vụ hỗ trợ khách hàng cho quý khách 24/7.</p>
                                <p>• Nếu quý khách hàng có bất kỳ vấn đề nào với đơn đặt hàng của mình hoặc bất kỳ câu hỏi nào về trang web của chúng tôi, chúng tôi sẽ nhiệt tình giúp bạn giải quyết vấn đề.</p>
                                <p>• Tất cả các đơn đặt hàng của bạn sẽ được chuyển giao ngay lập tức.</p>
                                <h4>Fanpage :  <a href=" http://www.facebook.com">  http://www.facebook.com</a></h4>
                                <h4>Trustpilot : <a href=" http://www.facebook.com">  http://www.facebook.com</a></h4>
                                <h4></h4>	
                                <p class="efgh">Website Keyworld.vn đã được xác thực bởi BỘ CÔNG THƯƠNG VIỆT NAM : www.moit.gov.vn</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
