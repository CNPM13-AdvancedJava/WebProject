<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>    
    <body>
        <div class="menu-product">
            <ul class="nav nav-pills">
                <s:iterator value="lstCatalog">
                    <li role="presentation" class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                            <s:property value="catalogName"/> <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <s:iterator value="types">
                                <li>
                                    <a href="Product?type=<s:property value="typeId"/>"><s:property value="typeName"/></a>
                                </li>
                            </s:iterator>
                        </ul>
                    </li>	
                </s:iterator>
                <form action="FindProduct" method="POST" class="navbar-form navbar-left searchBar" role="search">
                    <div class="form-group">										
                        <input type="search" name="name" class="form-control" placeholder="Tìm kiếm">	
                        <button type="submit" class="btn btn-default form-control"><span class="glyphicon glyphicon-search"></span></button>
                    </div>
                </form>
            </ul>

        </div>
    </body>
</html>
