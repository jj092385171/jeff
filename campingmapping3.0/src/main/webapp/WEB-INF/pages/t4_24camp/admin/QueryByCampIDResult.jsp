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

			<h2>campID&emsp;搜尋營地_營區位結果</h2>
			<table>
				<thead>
					<tr>
						<th>營地編號</th>
						<th>營地</th>
						<th>縣市編號</th>
						<th>縣市名</th>
						<th>地址</th>
						<th>圖片</th>
						<th>簡介</th>
						<th>標籤</th>
					</tr>
					<tr>
						<th>&emsp;&emsp;營位區編號</th>
						<th>&emsp;營位區名</th>
						<th>&emsp;營區位圖片</th>
						<th>&emsp;總營位</th>
						<th>&emsp;營位金額</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${ camp.campID }</td>
						<td>${ camp.campName }</td>
						<td>${ camp.city.cityID }</td>
						<td>${ camp.city.cityName }</td>
						<td>${ camp.location }</td>
						<!-- <td>
							<img width="80" height="100"
								src="<c:url value='/T4_24/GetCampImage?id=${camp.campID}'/>" />
						</td> -->
						<td>${ camp.description }</td>
						<td>
							<c:forEach var='tag' items='${camp.tags}'>
								${tag.tagName} &nbsp; / &nbsp;
							</c:forEach>
						</td>
					</tr>
					<c:forEach var='site' items='${camp.sites}'>
						<tr>
							<td>&emsp;&emsp;${ site.siteID }</td>
							<td>&emsp;${ site.siteName }</td>
							<!-- <td>&emsp;
								<img width="80" height="100"
									src="<c:url value='/T4_24/GetSiteImage?id=${site.siteID}'/>" />
							</td> -->
							<td>&emsp;${ site.totalSites }</td>
							<td>&emsp;${ site.siteMoney }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<div>
				<a href="/campingmapping3.0/queryPage.controller">&emsp;查詢&emsp;營地_營區位</a>
				<br>
				<a href="/campingmapping3.0/insertPage.controller">&emsp;新增&emsp;營地_營區位</a>
				<br>
				<a href="/campingmapping3.0/indexShowAllCamp.controller">回首頁</a>
			</div>

		</body>

		</html>