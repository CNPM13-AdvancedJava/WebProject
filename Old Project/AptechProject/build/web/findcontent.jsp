<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang Chủ</title>       
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
        <div class="bgbody" >
            <%@include file="header.jsp" %>
            <div class="content">
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
                            <div class="row">
                                <div class="product-menu">
                                    <s:action name="getAllCatalog" executeResult="true"/> 
                                </div>
                            </div>
                            <div class="row">
                                <div class="list-product">                                    
                                    <div class="product-list">                                  
                                        <ul>
                                            <s:iterator value="lstProduct">
                                                <li>
                                                    <div class="col-xs-12 col-md-2 col-sm-4">
                                                        <a href="getPro?productId=<s:property value="productId"/>" class="thumbnail">
                                                            <img class="images-product" src="<s:property value="images"/>" alt="...">
                                                            <div class="caption">
                                                                <h5><s:property value="productName"/></h5>
                                                                <p class="prince-product"><s:property value="prince"/> đ</p>						      
                                                            </div>
                                                        </a>
                                                    </div>
                                                </li>
                                            </s:iterator>
                                        </ul>                                   
                                    </div>                                                
                                </div>
                            </div>                          
                        </div>
                    </div>                    
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
