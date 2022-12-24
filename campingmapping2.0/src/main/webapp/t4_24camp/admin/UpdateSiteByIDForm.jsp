<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE HTML>

		<html>

		<head>
			<meta charset="utf-8" />
			<title>EEIT56_露營</title>
		</head>

		<body>
			<div>
				<a href="<c:url value='/IndexShowAllPageServlet' />"><strong>營地_營區位管理</strong></a>
			</div>

			<hr>

			<h2>修改營區位</h2>
			<div>
				<c:forEach var='site' items='${siteList}'>
					<br>
					<form name="UpdateSiteCampByIDForm" action="<c:url value='/T4_24/UpdateSiteByIDServlet' />"
						method="POST" enctype="multipart/form-data">
						營區位編號: <input type="text" name='siteID' readonly="readonly" value='${ site.siteID }'><br>
						營區位名: <input type="text" name='siteName' value='${ site.siteName }'>
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.siteName}</div>
						<br>
						圖片: <input type="file" name="sitePictures">
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.sitePictures}</div>
						<br>
						總營位: <input type="text" name='totalSites' value='${ site.totalSites }'>
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.totalSites}</div>
						<br>
						營位金額: <input type="text" name='siteMoney' value='${ site.siteMoney }'>
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.siteMoney}</div>
						<br>
						營地編號: <input type="text" name='campID' readonly="readonly" value='${ site.camp.campID }'><br>
						<input type="submit" value="修改">
					</form>
					<hr>
				</c:forEach>
			</div>

			<hr>

			<div>
				<a href="<c:url value='/t4_24camp/admin/QueryPageForm.jsp' />">&emsp;查詢&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='/t4_24camp/admin/InsertCampForm.jsp' />">&emsp;新增&emsp;營地_營位區</a>
				<br>
				<a href="<c:url value='/t4_24camp/admin/UpdatePage.jsp' />">&emsp;修改&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='/t4_24camp/admin/deletePage.jsp' />">&emsp;刪除&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='/IndexShowAllPageServlet' />">回首頁</a>
			</div>

		</body>

		</html>