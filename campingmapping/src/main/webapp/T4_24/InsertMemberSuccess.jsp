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
營地編號: ${ID}<br>
營地: ${ CampBean.campName } 的資料新增成功<br>
縣市: ${ city.cityName }<br>
地址: ${ CampBean.location }<br>
圖片: <img height='200' width='200' src="<c:url value='/T4_24/GetCampImage?id=${ID}' />"/><br>
<%-- 圖片: <img height='200' width='200' src="data:image/png;base64,${CampBean.getBase64String()} }"/><br> --%>
簡介: ${ CampBean.discription }<br>
<c:forEach var='tag' items='${tagList}'>
	標籤: ${ tag.tagName }<br>
</c:forEach>


<p>
<a href="<c:url value='/T4_24/CampIndex.jsp' />" >回首頁</a>
</body>
</html>