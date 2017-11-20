<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>  
    <body>
        <div class="title-topgame">
            <span>Top Game Bán Chạy Nhất</span>
        </div>
        <div class="content-topgame">
            <ul class="list-group">
                <s:iterator value="lstProduct">
                <li>
                    <a href="GetProduct?productId=<s:property value="productId"/>">
                        <div class="select-topgame">
                            <div class="images-topgame">
                                <img class="topgame-image" src="<s:property value="thumbnailUrl"/>" alt="">
                            </div>
                            <div class="context-topgame">
                                <span><s:property value="productName"/> </span>
                            </div>
                        </div>
                    </a>
                </li>
                </s:iterator>
            </ul>
        </div>
    </body>
</html>
