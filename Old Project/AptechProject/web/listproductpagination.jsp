<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
    <body>
        <div class="row">
            <div class="list-product">                                    
                <div class="product-list">                                  
                    <ul>
                        <s:iterator value="lstProduct">
                            <li>
                                <div class="col-xs-12 col-lg-2 col-md-4 col-sm-6">
                                    <a href="getPro?productId=<s:property value="productId"/>" class="thumbnail">
                                        <img class="images-product" src="<s:property value="images"/>" alt="...">
                                        <div class="caption">
                                            <h5 class=""><s:property value="productName"/></h5>
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
        <div class="row">
            <div class="paging">
                <nav>
                    <ul class="pagination">
                        <li>
                            <s:iterator value="listPag">                       
                                <a href="shoppage?page=<s:property value="number"/>"><s:property value="number"/></a>                                            
                            </s:iterator>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>    
    </body>
</html>
