﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
<h1>CityID搜結結果</h1>
<c:forEach var='camp' items='${campList}'>
		營地編號: ${ camp.campID }<br>
<%-- 		營地: ${ camp.campName }<br> --%>
		縣市: ${ camp.cityID }<br>
		地址: ${ camp.location }<br>
	<!-- 	圖片: <br> -->
		簡介: ${ camp.discription }<br>
</c:forEach>

<p>
<a href="<c:url value='/T4_24/CampIndex.jsp' />" >回首頁</a>
</body>
</html>