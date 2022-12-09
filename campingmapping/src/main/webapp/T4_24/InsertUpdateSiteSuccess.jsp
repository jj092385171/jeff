<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增營區位結果</title>
</head>
<body>
<%-- 營區位編號: ${siteBean.siteID} 的資料 ${what} 成功<br> --%>

<%-- 圖片: <img height='200' width='200' src="<c:url value='/T4_24/GetCampImage?id=${campID}' />"/><br> --%>
<%-- 圖片: <img height='200' width='200' src="${pageContext.servletContext.contextPath}/T4_24/GetCampImage?id=${campID}"/><br> --%>
<%-- 圖片: <img height='200' width='200' src="data:image/png;base64,${CampBean.getBase64String()} }"/><br> --%>
營區位名: ${ siteBean.siteName } <br>
總營位: ${ siteBean.totalSites } <br>
營位金額: ${ siteBean.siteMoney }<br>
營地編號: ${ campID }<br>



<p>
<a href="<c:url value='/T4_24/CampIndex.jsp' />" >回首頁</a>
</body>
</html>