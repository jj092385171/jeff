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
				<a href="<c:url value='/IndexShowCampsServlet' />"><strong>營地_營區位管理</strong></a>
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
							<td>${ camp.campID }</td>
							<td>${ camp.campName }</td>
							<td>${ camp.city.cityID }</td>
							<td>${ camp.city.cityName }</td>
							<td>${ camp.location }</td>
							<!-- <td>
								<img width="80" height="100" src="<c:url value='/T4_24/GetCampImage?id=${camp.campID}'/>" />
							</td> -->
							<td>${ camp.description }</td>
							<td>
								<c:forEach var='tag' items='${camp.tags}'>
									${tag.tagName} &nbsp; / &nbsp;
								</c:forEach>
							</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div>
				<a href="<c:url value='/t4_24camp/admin/QueryPageForm.jsp' />">&emsp;查詢&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='/t4_24camp/admin/InsertCampForm.jsp' />">&emsp;新增&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='/IndexShowCampsServlet' />">回首頁</a>
			</div>

		</body>

		</html>