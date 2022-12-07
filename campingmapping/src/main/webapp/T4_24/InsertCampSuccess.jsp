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
營地編號: ${cpcBean.campID} 的資料新增成功<br>
營地: ${ cpcBean.campName } <br>
縣市編號: ${ cpcBean.cityID }<br>
縣市名: ${ cpcBean.cityName }<br>
地址: ${ cpcBean.location }<br>
<%-- 圖片: <img height='200' width='200' src="<c:url value='/T4_24/GetCampImage?id=${campID}' />"/><br> --%>
圖片: <img height='200' width='200' src="${pageContext.servletContext.contextPath}/T4_24/GetCampImage?id=${campID}"/><br>
<%-- 圖片: <img height='200' width='200' src="data:image/png;base64,${CampBean.getBase64String()} }"/><br> --%>
簡介: ${ cpcBean.discription }<br>
<c:forEach var='tag' items='${tagList}'>
	標籤: ${ tag.tagName }<br>
</c:forEach>


<p>
<a href="<c:url value='/T4_24/CampIndex.jsp' />" >回首頁</a>
</body>
</html>