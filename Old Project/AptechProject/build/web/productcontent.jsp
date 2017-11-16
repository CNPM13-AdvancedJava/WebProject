<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sản Phẩm</title>       
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
        <div id="fb-root"></div>
        <script>
            window.fbAsyncInit = function () {
                FB.init({
                    appId: '1512941462313621',
                    xfbml: true,
                    version: 'v2.6'
                });
            };

            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id)) {
                    return;
                }
                js = d.createElement(s);
                js.id = id;
                js.src = "//connect.facebook.net/vi_VN/sdk.js";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));
        </script>         
        <div class="bgbody">
            <%@include file="header.jsp" %>
            <%if (session.getAttribute("userName") != null) {%>
            <div class="content">
                <div class="container">			
                    <div class="row">
                        <div class="col-md-5 col-sm-6 col-xs-12 images-content">
                            <img class="content-images" src="<s:property value="productbyId.images"/>" alt="">
                        </div>			
                        <div class="col-md-7 col-sm-6 col-xs-12 context-content">
                            <div class="content-title">
                                <h2><s:property value="productbyId.productName"/></h2>						
                            </div>
                            <div class="content-context">
                                <span class="label-context">Mã hàng : </span>
                                <span class="context-field"><s:property value="productbyId.productName"/></span></br>
                                <span class="label-context">Thời gian nhận key : </span>
                                <span class="context-field">Instant</span></br>
                                <span class="label-context">Trạng thái : </span>
                                <span class="context-field">Còn hàng</span></br>
                                <span class="label-context">Giảm giá : </span>
                                <span class="context-field">0 %</span>
                            </div>
                            <div class="prince">
                                <div class="number-prince">
                                    <span >Giá : <s:property value="productbyId.prince"/>đ </span>
                                    <input type="text" id="price" value="<s:property value="productbyId.prince"/>" style="display:none;"/>
                                </div>											
                            </div>            
                            <div class="pay-content">
                                <div class="table-pay">
                                    <form action="goGioHang?productId=<s:property value="productbyId.productId"/>&userNameDH=<%=session.getAttribute("userName")%>" method="POST" class="form-group">                                            
                                        <span class="label-context">Số lượng :</span>                                     
                                        <input id="number" class="form-control" type="text" onkeyup="getNum()" name="number-pay" value="1">   
                                        </br>
                                        <button class="btn btn-danger form-control" onclick="checkText()" name="btn-pay">Đặt Vào Giỏ Hàng</button>
                                        </br>
                                    </form>
                                    <div class="buynow">
                                        <form action="goThanhToanoneChamp?giaSponeChamp=<s:property value="productbyId.prince"/>&productThanhtoanId=<s:property value="productbyId.productId"/>" method="POST">
                                            <input type="text" name="text-number-son" id="son-number" value="1" style="display:none;"/>
                                            <button class="btn btn-danger form-control" name="btn-pay" onclick="checkText()">Mua ngay</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="status">
                                <span class="label-context">
                                    <s:property value="productbyId.productStatus"/>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="involve">
                            <div class="title-involve">
                                <span>Sản Phẩm Liên Quan</span>
                            </div>                           
                            <ul>
                                <s:iterator value="listProductref">
                                    <li>
                                        <div class="col-xs-12 col-sm-6 col-lg-2 col-md-4">
                                            <a href="getPro?productId=<s:property value="productId"/>" class="thumbnail">
                                                <img class="images-involve" src="<s:property value="images"/>" alt="...">
                                                <div class="caption">
                                                    <h5><s:property value="productName"/></h5>
                                                    <p class="prince-product"> <s:property value="prince"/> đ</p>						      
                                                </div>
                                            </a>
                                        </div>
                                    </li>
                                </s:iterator>    
                            </ul>
                        </div>
                    </div>
                    <div class="row">
                        <div class="describe-comment">
                            <ul class="nav nav-tabs" role="tablist">
                                <li role="presentation" class="active"><a href="#describe" aria-controls="describe" role="tab" data-toggle="tab">Mô tả</a></li>
                                <li role="presentation"><a href="#comment" aria-controls="comment" role="tab" data-toggle="tab">Nhận xét</a></li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="describe">
                                <span class="Warring">
                                    - THỜI GIAN NHẬN KEY GAME : 5 ĐẾN 15 PHÚT. 
                                    </br>
                                    - KEY GAME ĐƯỢC CHUYỂN ĐẾN ĐỊA CHỈ EMAIL CỦA BẠN.      
                                </span>
                                <div class="table-key">
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>Thông tin chi  tiết CD- Key game</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Ngày phát hành</td>
                                                <td><s:property value="productbyId.timeRelease"/></td>
                                            </tr>
                                            <tr>
                                                <td>Ngôn ngữ</td>
                                                <td><s:property value="productbyId.language"/></td>
                                            </tr>
                                            <tr>
                                                <td>Chế độ</td>
                                                <td><s:property value="productbyId.regime"/></td>
                                            </tr>
                                            <tr>
                                                <td>Region</td>
                                                <td><s:property value="productbyId.region"/></td>
                                            </tr>
                                            <tr>
                                                <td>Activate và download</td>
                                                <td><a href="#"><s:property value="productbyId.ative"/></a></td>
                                            </tr>
                                            <tr>
                                                <td>Hãng sản xuất</td>
                                                <td><s:property value="productbyId.manufacturer"/></td>
                                            </tr>
                                            <tr>
                                                <td>Thể loại</td>
                                                <td><s:property value="productbyId.typetext"/></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <span class="Detailed-description">
                                    <h4><s:property value="productbyId.headcontext"/></h4>
                                    <s:property value="productbyId.context"/>
                                </span>
                                <div class="describe-video">

                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane" id="comment">
                                <div class="fb-comments" data-href="https://developers.facebook.com/docs/plugins/comments#configurator" data-width="100%" data-numposts="3"></div>
                            </div>
                        </div>
                    </div>							
                </div>
            </div>
            <%} else {%>
            <div class="content">
                <div class="container">			
                    <div class="row">
                        <div class="col-md-5 col-sm-6 col-xs-12 images-content">
                            <img class="content-images" src="<s:property value="productbyId.images"/>" alt="">
                        </div>			
                        <div class="col-md-7 col-sm-6 col-xs-12 context-content">
                            <div class="content-title">
                                <h2><s:property value="productbyId.productName"/></h2>						
                            </div>
                            <div class="content-context">
                                <span class="label-context">Mã hàng : </span>
                                <span class="context-field"><s:property value="productbyId.productName"/></span></br>
                                <span class="label-context">Thời gian nhận key : </span>
                                <span class="context-field">Instant</span></br>
                                <span class="label-context">Trạng thái : </span>
                                <span class="context-field">Còn hàng</span></br>
                                <span class="label-context">Giảm giá : </span>
                                <span class="context-field">0 %</span>
                            </div>
                            <div class="prince">
                                <div class="number-prince">
                                    <span >Giá : <s:property value="productbyId.prince"/>đ </span>
                                </div>											
                            </div>        
                            <div class="pay-content">
                                <div class="table-pay">
                                    <div class="form-group">                                       
                                        <span class="label-context">Số lượng :</span>                                     
                                        <input class="form-control" type="text" name="number-pay" value="1">   
                                        </br>
                                        <a href="loginIn.jsp" class="btn btn-danger form-control" type="submit" name="btn-pay">Đặt Vào Giỏ Hàng</a>
                                        </br>
                                        <div class="buynow">
                                            <a href="loginIn.jsp" class="btn btn-danger form-control" type="submit" name="btn-pay">Mua ngay</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="status">
                                <span class="label-context">
                                    <s:property value="productbyId.productStatus"/>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="involve">
                            <div class="title-involve">
                                <span>Sản Phẩm Liên Quan</span>
                            </div>
                            <s:iterator value="listProductref">
                                <ul>
                                    <li>
                                        <div class="col-xs-12 col-sm-6 col-lg-2 col-md-4">
                                            <a href="getPro?productId=<s:property value="productId"/>" class="thumbnail">
                                                <img class="images-involve" src="<s:property value="images"/>" alt="...">
                                                <div class="caption">
                                                    <h5><s:property value="productName"/></h5>
                                                    <p class="prince-product"> <s:property value="prince"/> đ</p>						      
                                                </div>
                                            </a>
                                        </div>
                                    </li>
                                </s:iterator>    
                            </ul>
                        </div>
                    </div>
                    <div class="row">
                        <div class="describe-comment">
                            <ul class="nav nav-tabs" role="tablist">
                                <li role="presentation" class="active"><a href="#describe" aria-controls="describe" role="tab" data-toggle="tab">Mô tả</a></li>
                                <li role="presentation"><a href="#comment" aria-controls="comment" role="tab" data-toggle="tab">Nhận xét</a></li>
                            </ul>
                        </div>
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="describe">
                                <span class="Warring">
                                    - THỜI GIAN NHẬN KEY GAME : 5 ĐẾN 15 PHÚT. 
                                    </br>
                                    - KEY GAME ĐƯỢC CHUYỂN ĐẾN ĐỊA CHỈ EMAIL CỦA BẠN.      
                                </span>
                                <div class="table-key">
                                    <table class="table table-hover">
                                        <thead>
                                            <tr>
                                                <th></th>
                                                <th>Thông tin chi  tiết CD- Key game</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>Ngày phát hành</td>
                                                <td><s:property value="productbyId.timeRelease"/></td>
                                            </tr>
                                            <tr>
                                                <td>Ngôn ngữ</td>
                                                <td><s:property value="productbyId.language"/></td>
                                            </tr>
                                            <tr>
                                                <td>Chế độ</td>
                                                <td><s:property value="productbyId.regime"/></td>
                                            </tr>
                                            <tr>
                                                <td>Region</td>
                                                <td><s:property value="productbyId.region"/></td>
                                            </tr>
                                            <tr>
                                                <td>Activate và download</td>
                                                <td><a href="#"><s:property value="productbyId.ative"/></a></td>
                                            </tr>
                                            <tr>
                                                <td>Hãng sản xuất</td>
                                                <td><s:property value="productbyId.manufacturer"/></td>
                                            </tr>
                                            <tr>
                                                <td>Thể loại</td>
                                                <td><s:property value="productbyId.typetext"/></td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <span class="Detailed-description">
                                    <h4><s:property value="productbyId.headcontext"/></h4>
                                    <s:property value="productbyId.context"/>
                                </span>
                                <div class="describe-video">

                                </div>
                            </div>
                            <div role="tabpanel" class="tab-pane" id="comment">
                                <div class="fb-comments" data-href="https://developers.facebook.com/docs/plugins/comments#configurator" data-width="100%" data-numposts="3"></div>
                            </div>
                        </div>
                    </div>							
                </div>
            </div>    
            <%}%>
            <%@include file="footer.jsp" %>
        </div>
        <script type="text/javascript">
            function getNum() {
                var x1 = document.getElementById('number');
                var x2 = document.getElementById('son-number');
                x2.value = x1.value;
            }
            function checkText() {
                var x2 = document.getElementById('number');
                if (x2.value == null || x2.value == "")
                {
                    alert("Bạn cần nhập số lượng hàng hoá");
                    window.location.href = "#";
                    window.history.back(1);
                }
            }
        </script>
    </body>
</html>
