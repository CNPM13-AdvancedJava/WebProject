<%-- 
    Document   : UpdateManufacturer
    Created on : Dec 15, 2017, 10:38:36 PM
    Author     : Bumble Bee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhật NSX</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="page-wrapper">     
                <div class="container-fluid">
                    <div class="row">
                        <h2>Chỉnh sửa NSX</h2>
                        <br>
                        <form action="UpdateManufacturer" method="Post">
                            <div class="form-group">
                                <label>Mã NSX</label>
                                <input class="form-control" name="manufacturerId" type="text" value="<s:property value="manufacturerId"/>" readonly="true">
                            </div>
                            <div class="form-group">
                                <label>Tên NSX</label>
                                <input class="form-control" name="manufacturerName" type="text" value="<s:property value="manufacturerName"/>">
                            </div>
                            <s:submit value="Lưu"/>
                        </form>
                    </div>

                </div>           
            </div>
        </div>

    </body>
</html>
