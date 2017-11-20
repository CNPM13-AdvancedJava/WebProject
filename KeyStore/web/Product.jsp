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
            <%@include file="Header.jsp" %>
            <div class="content">
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
                            <div class="row">
                                <div class="product-menu">
                                    <s:action name="GetMenu" executeResult="true"/> 
                                </div>
                            </div>
                            <div class="row">
                                <div class="list-product">                                    
                                    <div class="product-list">                                  
                                        <ul>
                                            <s:iterator value="lstProduct">
                                                <li>
                                                    <div class="col-xs-12 col-lg-2 col-md-4 col-sm-6 my-thumnail">
                                                        <a href="GetProduct?productId=<s:property value="productId"/>" class="thumbnail">
                                                            <img class="images-product" src="<s:property value="thumbnailUrl"/>" alt="...">
                                                            <div class="caption">
                                                                <h5 class=""><s:property value="productName"/></h5>
                                                                <p class="prince-product"><s:property value="price"/> đ</p>						      
                                                            </div>
                                                        </a>
                                                    </div>
                                                </li>
                                            </s:iterator>
                                        </ul>              
                                    </div>                                                
                                </div>
                            </div>
                            <div class="row">
                                <div class="paging">
                                    <nav>
                                        <ul class="pagination">
                                            <li>
                                                <s:iterator value="lstPage">                       
                                                    <a href="GetProductPagination?page=<s:property value="pageNumber"/>"><s:property value="pageNumber"/></a>                                            
                                                </s:iterator>
                                            </li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>                                 
                        </div>
                    </div>                    
                </div>
            </div>
            <%@include file="Footer.jsp" %>
        </div>
    </body>
</html>
