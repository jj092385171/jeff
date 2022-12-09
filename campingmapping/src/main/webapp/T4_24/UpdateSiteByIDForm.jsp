<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新營區位表單</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>
<body>
	<c:forEach var='siteBean' items='${siteList}'>
		<form name="UpdateSiteCampByIDForm" action="<c:url value='/T4_24/UpdateSiteByIDServlet' />" method="POST" enctype="multipart/form-data">
			營區位編號: <input type="text" name= 'siteID' readonly="readonly" value='${ siteBean.siteID }'><br>
			營區位名: <input type="text" name='siteName' value='${ siteBean.siteName }'><br>
		    圖片: <input type="file" name="sitePictures"><br>
			總營位: <input type="text" name='totalSites'  value='${ siteBean.totalSites }'><br>
			營位金額: <input type="text" name='siteMoney'  value='${ siteBean.siteMoney }'><br>
			營地編號: <input type="text" name='campID' readonly="readonly" value='${ siteBean.campID }'><br>
			<input type="submit" value="修改">
		</form>
		<br><hr><br>
	</c:forEach>
	
</body>
</html>