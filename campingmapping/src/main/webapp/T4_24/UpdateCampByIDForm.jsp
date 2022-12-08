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
		營地編號: <input type="text" name='campID' readonly="readonly" value='${ cctBean.campID }'><br>
		營地: <input type="text" name='campName' value='${ cctBean.campName }'><br>
		縣市編號: <input type="text" name='cityID'  value='${ cctBean.cityID }'><br>
		縣市名: <input type="text" name='cityName'  value='${ cctBean.cityName }'><br>
		縣市:<c:forEach var='city' items='${cityList}'>
			   	<input type="radio" name="cityID" checked value="${city.cityID}" />${city.cityName}
			</c:forEach><br>
		縣市XXX:<c:forEach var='city' items='${cityList}'>
			   		<input type="radio" name="cityID" value="${city.cityID}" />${city.cityName}
			   </c:forEach><br>
		地址: <input type="text" name='location'  value='${ cctBean.location }'><br>
	    圖片: <input type="file" name="campPictures"><br>
		簡介: <input type="text" name='discription' value='${ cctBean.discription }'><br>
		標籤: <c:forEach var='tag' items='${cctBean.tagList}'>
				<input type="checkbox" name="tagID" checked value="${tag.tagID}" />${tag.tagName}
			 </c:forEach><br>
		標籤XXX: <c:forEach var='tag' items='${tagList}'>
					<input type="checkbox" name="tagID" value="${tag.tagID}" />${tag.tagName}
			 	</c:forEach>
		
		<br>
		<input type="submit" value="修改">

	</form>

</body>
</html>