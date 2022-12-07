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
營地編號: ${ cpcBean.campID }<br>
營地: ${ cpcBean.campName }<br>
縣市編號: ${ cpcBean.cityID }<br>
縣市名: ${ cpcBean.cityName }<br>
地址: ${ cpcBean.location }<br>
<!-- 	圖片: <br> -->
簡介: ${ cpcBean.discription }<br>
<c:forEach var='tag' items='${cpcBean.tagList}'>
	標籤: ${tag.tagName} <br>
</c:forEach>

<p>
<a href="<c:url value='/T4_24/CampIndex.jsp' />" >回首頁</a>
</body>
</html>