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
				<h2>結果:&emsp;${camp.campID} 的資料 ${what} 成功</h2>
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
					</thead>
					<tbody>
						<tr>
							<td>${ campID }</td>
							<td>${ campName }</td>
							<td>${ city.cityID }</td>
							<td>${ city.cityName }</td>
							<td>${ location }</td>
							<td>
								<img width="80" height="100" src="/campingmapping3.0/getCampPicture/${campID}" />
							</td>
							<td>${ camp.description }</td>
							<td>
								<c:forEach var='tag' items='${tags}'>
									${tag.tagName} &nbsp; / &nbsp;
								</c:forEach>
							</td>
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