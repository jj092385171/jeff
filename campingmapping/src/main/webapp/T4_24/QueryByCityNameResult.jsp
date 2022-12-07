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
<h1>CityID 搜結結果</h1>
<c:forEach var='cpc' items='${cpcList}'>
		營地編號: ${ cpc.campID }<br>
		營地: ${ cpc.campName }<br>
		縣市編號: ${ cpc.cityID }<br>
		縣市名: ${ cpc.cityName }<br>
		地址: ${ cpc.location }<br>
	<!-- 	圖片: <br> -->
		簡介: ${ cpc.discription }<br>
		<c:forEach var='tag' items='${cpc.tagList}'>
			標籤: ${tag.tagName} <br>
		</c:forEach>
</c:forEach>

<p>
<a href="<c:url value='/T4_24/CampIndex.jsp' />" >回首頁</a>
</body>
</html>