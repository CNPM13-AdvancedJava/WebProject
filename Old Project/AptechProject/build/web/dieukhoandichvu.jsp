<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Điều khoản dịch vụ</title>       
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
            <%@include file="header.jsp" %>
            <div class="content-gioithieu">   
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 col-xs-12 col-lg-12 banner">
                            <div class="col-md-8 col-sm-7 col-xs-12 col-lg-9 banner-content">
                                <s:action name="getBanner" executeResult="true"/>
                            </div>
                            <div class="col-md-4 col-sm-5 col-xs-12 col-lg-3 top-game">
                                <s:action name="getTop5" executeResult="true"/>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="product-content">
                            <div class="product-menu">
                                <s:action name="getAllCatalog" executeResult="true"/> 
                            </div>
                            <div class="wrapper">
                                <h3 class="label">Điều khoản dịch vụ</h3>
                                <h4 class="step">A/ CAM KẾT DỊCH VỤ: </h4>
                                <p>- Chúng tôi cam đoan tất cả các key game , box game từ chúng tôi đều chính hàng từ các hãng game cung cấp game như EA , STEAM , ORIGIN vv ... Các loại cd key sẽ được scan key từ DVD gốc hoặc là dạng text code tất cả đều từ nhà cung cấp của chúng tôi.</p>
                                <p>- Tất cả các keygame , box game bản quyền  của chúng tôi hoàn toàn hợp pháp với pháp luật Việt Nam.</p>
                                <p>- Hỗ trợ khách hàng tối đa về mặt kỹ thuật cũng như về giá cả .</p>
                                <h4 class="step">B/ QUI ĐỊNH HÀNG HÓA : </h4>
                                <p>-Tất cả các key game , box game bản quyền của chúng tôi bán ra 100% là chính hãng từ nhà cung cấp. Không phải là những key hack , hàng hack bất hợp pháp giá rẻ trôi nổi trên thị trường.</p>
                                <p>-Tất cả các keygame , cdkey game  , Box game bản quyền của chúng tôi khi đã active đều được chơi online vĩnh viễn không bao giờ bị lock key hay banned .</p>
                                <p>-Tất cả cdkey game bản quyền được scan ảnh  từ dvd gốc hoặc dạng text code tất cả đều từ nhà cung cấp của KEYGAMEPC.COM.</p>
                                <h4 class="step">C/ QUI ĐỊNH CHUYỂN GIAO HÀNG HÓA : </h4>
                                <p>- Sau khi quý khách đặt hàng tại KEYGAMEPC.COM. Key game , cdkey game bản quyền sẽ được gửi đến địa chỉ email của quý khách. Qúy khách có thể kiểm tra trạng thái đơn hàng tại KEYGAMEPC.COM. </p>
                                <p>- Tất cả CDKEY GAME đều được đến địa chỉ email của quý khách . Chúng tôi chuyển giao cdkey  game trên toàn thế giới.</p>
                                <p>- Các loại Box game , đĩa game gốc sẽ được chuyển đến địa chỉ của quý khách qua chuyển phát nhanh tín thành , EMS các tỉnh thành toàn quốc chỉ tại Việt Nam.</p>
                                <p> - Nếu quý khách thanh toán bằng paypal chúng tôi duy nhất chỉ chuyển cdkey game đến địa chỉ email paypal.</p>
                                <h4 class="step">D/ PHƯƠNG THỨC THANH TOÁN: </h4>
                                <p>- Chúng tôi chấp nhận thanh toán quốc tế paypal ( visa , mastercard , amex ) dành cho khách hàng quốc tế khi mua game tại KEYGAMEPC.COM</p>
                                <p>- Tại việt nam chúng tôi chấp nhận thanh toán tất cả các ngân hàng trong nước , hỗ trợ thanh toán ngân lượng , bảo kim , thẻ cào điện thoại ( mobiphone và vinaphone ).</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
