<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新營地表單</title>
<style>
form {
	margin: 0 auto;
	width: 35%;
	border: 1px solid black;
	padding: 20px;
}
</style>
</head>
<body>
<h2>修改營地</h2>
	<form name="UpdateCampByIDForm" action="<c:url value='/T4_24/UpdateCampByIDServlet' />" method="POST" enctype="multipart/form-data">
		營地編號: <input type="text" name='campID' readonly="readonly" value='${ csctBean.campID }'><br>
		營地: <input type="text" name='campName' value='${ csctBean.campName }'>
			 <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.campName}</div>
			 <br>
		縣市編號: <input type="text" name='cityID'  value='${ csctBean.cityID }'><br>
		縣市名: <input type="text" name='cityName'  value='${ csctBean.cityName }'><br>
		縣市XXX:<c:forEach var='city' items='${cityList}'>
			   		<input type="radio" name="cityIDXXX" checked value="${city.cityID}" />${city.cityName}
				</c:forEach><br>
		縣市:<c:forEach var='city' items='${cityList}'>
			   		<input type="radio" name="cityID" value="${city.cityID}" />${city.cityName}
			  </c:forEach>
			  <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.cityID}</div>
			  <br>
		地址: <input type="text" name='location'  value='${ csctBean.location }'>
		     <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.location}</div>
			 <br>
	    圖片: <input type="file" name="campPictures" id='campPictures'>
	         <div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.campPictures}</div>
	         <br>
		簡介: <input type="text" name='discription' value='${ csctBean.discription }'><br>
		標籤XXX: <c:forEach var='tag' items='${csctBean.tagList}'>
				<input id='${tag.tagID}' type="checkbox" name="tagIDXXX" checked value="${tag.tagID}" />${tag.tagName}
			 </c:forEach><br>
		標籤: <c:forEach var='tag' items='${tagList}'>
					<input type="checkbox" name="tagID" value="${tag.tagID}" />${tag.tagName}
			 	</c:forEach>
				<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.tagIDs}</div>
				
		<br>
		<input type="submit" value="修改">

	</form>
<a href="<c:url value='IndexShowAllPageServlet' />" >回首頁</a>
<script src='https://code.jquery.com/jquery-3.6.1.min.js'></script>
<script>
	$(function(){
		
	})
</script>
</body>
</html>