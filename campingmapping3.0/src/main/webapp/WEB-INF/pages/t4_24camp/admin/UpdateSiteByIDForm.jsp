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
				<a href="/campingmapping3.0/indexShowAllCamp.controller"><strong>營地_營區位管理</strong></a>
			</div>

			<hr>

			<h2>修改營區位</h2>
			<div>
				<form name="UpdateSiteCampByIDForm" action="sitesOfCamp.controller/updateSiteByID.controller"
					method="POST" enctype="multipart/form-data">
					營區位編號: <input type="text" name='siteID' readonly="readonly"
						value='${ site.siteID }'><br>
					營區位名: <input type="text" name='siteName' value='${ site.siteName }'>
					<div style="color:#FF0000; font-size:60%; display: inline">${errors.siteName}</div>
					<br>
					圖片: <input type="file" name="sitePicturesPath">
						<div style="color:#FF0000; font-size:60%; display: inline">${errors.sitePicturesPath}</div>
						<br> 
					總營位: <input type="text" name='totalSites' value='${ site.totalSites }'>
					<div style="color:#FF0000; font-size:60%; display: inline">${errors.totalSites}</div>
					<br>
					營位金額: <input type="text" name='siteMoney' value='${ site.siteMoney }'>
					<div style="color:#FF0000; font-size:60%; display: inline">${errors.siteMoney}</div>
					<br>
					營地編號: <input type="text" name='campID' readonly="readonly"
						value='${ site.camp.campID }'><br>
					<input type="submit" value="更新">
				</form>
			</div>

			<hr>

			<div>
				<a href="/campingmapping3.0/queryPage.controller">&emsp;查詢&emsp;營地_營區位</a>
				<br>
				<a href="/campingmapping3.0/insertPage.controller">&emsp;新增&emsp;營地_營區位</a>
				<br>
				<a href="/campingmapping3.0/indexShowAllCamp.controller">回首頁</a>
			</div>
		</body>

		</html>