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
				<a href="/campingmapping3.0/indexShowAllCamp.controller"><strong>營地_營區位管理</strong></a>
			</div>

			<hr>

			<form name="InsertSiteForm" action="insertSite.controller" method="POST"
				enctype="multipart/form-data">
				<table>
					<thead>
						<tr>
							<th>
								<h2>新增營區位資料</h2>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>營區位名:</td>
							<td>
								<input name="siteName" value="${site.siteName}" type="text">
								<div style="color:#FF0000; font-size:60%; display: inline">${errors.siteName}</div>
							</td>
						</tr>
						<tr>
							<td>選擇營區位圖片:</td>
							<td>
								<input name="sitePicturesPath" type="file">
								<div style="color:#FF0000; font-size:60%; display: inline">${errors.sitePictures}
								</div>
							</td>
						</tr>
						<tr>
							<td>總營位:</td>
							<td>
								<input name="totalSites" value="${site.totalSites}" type="text">
								<div style="color:#FF0000; font-size:60%; display: inline">${errors.totalSites}</div>
							</td>
						</tr>
						<tr>
							<td>營位金額:</td>
							<td>
								<input name="siteMoney" value="${site.siteMoney}" type="text">
								<div style="color:#FF0000; font-size:60%; display: inline">${errors.siteMoney}</div>
							</td>
						</tr>
						<tr>
							<td>營地編號:</td>
							<td>
								<input name="campID" readonly="readonly" value='${ campID }' type="text">
							</td>
						</tr>
						<tr>
							<td><input type="submit" value="送出"></td>
						</tr>
					</tbody>
				</table>
			</form>

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