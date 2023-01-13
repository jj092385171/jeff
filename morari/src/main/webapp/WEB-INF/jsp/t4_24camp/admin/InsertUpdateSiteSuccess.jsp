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

			<div>
				<h2>結果:&emsp;${site.siteID} 的資料 ${what} 成功</h2>
				<table>
					<thead>
						<tr>
							<th>營位區編號</th>
							<th>營位區名</th>
							<th>營區位圖片</th>
							<th>總營位</th>
							<th>營位金額</th>
							<th>營地編號</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${ site.siteID }</td>
							<td>${ site.siteName }</td>
							<td>
								<img width="80" height="100" src="/getSitePicture/${site.siteID}" />
							</td>
							<td>${ site.totalSites }</td>
							<td>${ site.siteMoney }</td>
							<td>${ site.camp.campID }</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div>
				<a href="/campingmapping3.0/queryPage.controller">&emsp;查詢&emsp;營地_營區位</a>
				<br>
				<a href="/campingmapping3.0/insertPage.controller">&emsp;新增&emsp;營地_營區位</a>
				<br>
				<a href="/campingmapping3.0/indexShowAllCamp.controller">回首頁</a>
			</div>

		</body>

		</html>