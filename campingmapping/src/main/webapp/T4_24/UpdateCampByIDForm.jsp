<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>刪除營地</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>
<body>
	<form name="UpdateCampByIDForm" action="<c:url value='/T4_24/UpdateCampByIDServlet' />" method="POST" enctype="multipart/form-data">
		營地編號: <input type="text" color='red' name='campID' readonly="readonly" value='${ cpcBean.campID }'><br>
		營地: <input type="text" name='campName' value='${ cpcBean.campName }'><br>
		縣市編號: <input type="text" name='cityID' readonly="readonly" value='${ cpcBean.cityID }'><br>
		縣市名: <input type="text" name='cityName' readonly="readonly" value='${ cpcBean.cityName }'><br>
		地址: <input type="text" name='location' readonly="readonly" value='${ cpcBean.location }'><br>
	    圖片: <input type="file" name="campPictures"><br>
		簡介: <input type="text" name='discription' value='${ cpcBean.discription }'><br>
		標籤: <c:forEach var='tag' items='${tagList}'>
				<input type="checkbox" name="tagID" value="${tag.tagID}" />${tag.tagName}
			 </c:forEach>
		
		<br>
		<input type="submit" value="修改">

	</form>

</body>
</html>