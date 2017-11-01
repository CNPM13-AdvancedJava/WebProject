<%-- 
    Document   : banner
    Created on : May 23, 2016, 4:38:04 PM
    Author     : Nguyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
    <body>
        <div id="carousel-id" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carousel-id" data-slide-to="0" class=""></li>
                <li data-target="#carousel-id" data-slide-to="1" class=""></li>
                <li data-target="#carousel-id" data-slide-to="2" class=""></li>
                <li data-target="#carousel-id" data-slide-to="3" class="active"></li>            
            </ol>
            <ul class="carousel-inner">
                <s:iterator value="lstProduct">                
                    <li class="item <s:property value="bannerStatus"/>">
                    <div class="images-item">
                        <a href="getPro?productId=<s:property value="productId"/>"><img class="item-images img-responsive" src="images/banner/banner1.jpg"/></a>
                    </div>				
                </li>
                </s:iterator>
            </ul>
            <a class="left carousel-control" href="#carousel-id" data-slide="prev"></a>
            <a class="right carousel-control" href="#carousel-id" data-slide="next"></a>
        </div>
    </body>
</html>
