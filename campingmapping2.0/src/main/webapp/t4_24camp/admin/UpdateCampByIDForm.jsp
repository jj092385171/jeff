<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>EEIT56_露營</title>
		</head>

		<body>
			<div>
				<a href="<c:url value='/IndexShowCampsServlet' />"><strong>營地_營區位管理</strong></a>
			</div>

			<hr>

			<h2>修改營地</h2>
			<form name="UpdateCampByIDForm" action="<c:url value='/T4_24/UpdateCampByIDServlet' />" method="POST"
				enctype="multipart/form-data">
				營地編號: <input type="text" name='campID' readonly="readonly" value='${ camp.campID }'><br>
				營地: <input type="text" name='campName' value='${ camp.campName }'>
				<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.campName}</div>
				<br>
				縣市編號: <input type="text" name='city.cityID' readonly="readonly" value='${ camp.city.cityID }'><br>
				縣市名: <input type="text" name='city.cityName' readonly="readonly" value='${ camp.city.cityName }'><br>
				縣市XXX:<c:forEach var='city' items='${cityList}'>
					<input type="radio" name="cityIDXXX" checked value="${city.cityID}" />${city.cityName}
				</c:forEach><br>
				縣市:<c:forEach var='city' items='${cityList}'>
					<input type="radio" name="cityID" value="${city.cityID}" />${city.cityName}
				</c:forEach>
				<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.cityID}</div>
				<br>
				地址: <input type="text" name='location' value='${ camp.location }'>
				<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.location}</div>
				<br>
				圖片: <input type="file" name="campPictures" id='campPictures'>
				<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.campPictures}</div>
				<br>
				簡介: <input type="text" name='description' value='${ camp.description }'><br>


				標籤XXX: <c:forEach var='tag' items='${camp.tags}'>
					<input id='${tag.tagID}' type="checkbox" name="tagIDXXX" checked
						value="${tag.tagID}" />${tag.tagName}
				</c:forEach><br>

				標籤: <c:forEach var='tag' items='${tagList}'>
					<input type="checkbox" name="tagID" value="${tag.tagID}" />${tag.tagName}
				</c:forEach>
				<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.tagIDs}</div>



				<br>
				<input type="submit" value="修改">

			</form>
			<hr>

			<div>
				<a href="<c:url value='/t4_24camp/admin/QueryPageForm.jsp' />">&emsp;查詢&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='/t4_24camp/admin/InsertCampForm.jsp' />">&emsp;新增&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='/IndexShowCampsServlet' />">回首頁</a>
			</div>

		</body>

		</html>