<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
<h1>CampID搜結結果</h1>
營地編號: ${ campBean.campID }<br>
營地: ${ campBean.campName }<br>
縣市: ${ cityBean.cityName }<br>
地址: ${ campBean.location }<br>
<!-- 	圖片: <br> -->
簡介: ${ campBean.discription }<br>

<p>
<a href="<c:url value='/T4_24/CampIndex.jsp' />" >回首頁</a>
</body>
</html>