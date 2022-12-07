<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>testinsertServlet</title>
</head>
<body>
<form action="<c:url value='/testinsertServlet.do'/>"  method="POST" enctype="multipart/form-data">
<!-- <input type="text" name="shoppingCartId"><br> -->
<input type="text" value='1' name="userID">會員ID<br>
<input type="text" value='1' name="name">產品名稱<br>
<input type="text" value='1' name="title">品牌名稱<br>
<input type="text" value='1' name="content">產品規格<br>
<input type="text" value='1' name="type">產品類型<br>
<!-- <button onclick="myFunction()">Click me</button> -->
<!-- <input type="text" value='1' name="picture">照片<br> -->
<input type="file" name="picture"/>照片<br>
<input type="text" value='1' name="price">價位<br>
<input type="text" value='1' name="inventory">庫存數量<br>
<input type="text" value='202212070000' name="Pd_date">商品建立日期<br>
<input type="text" value='202212070000' name="Pd_last_update">商品更新日期<br>
<br>
<input type="submit"  value="提交">
</form>
</body>
</html>