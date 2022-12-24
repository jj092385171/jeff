<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<title>EEIT56_露營</title>
			<meta charset="UTF-8">
		</head>

		<body>
			<<div>
				<a href="<c:url value='/IndexShowCampsServlet' />"><strong>營地_營區位管理</strong></a>
			</div>

			<hr>

			<h2>cityIDs 搜尋營地結果</h2>
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
					<c:forEach var='cb' items='${camps}'>
						<tr>
							<td>${ cb.campID }</td>
							<td>${ cb.campName }</td>
							<td>${ cb.city.cityID }</td>
							<td>${ cb.city.cityName }</td>
							<td>${ cb.location }</td>
							<td>
								<!-- <td>
								<img width="80" height="100"
									src="<c:url value='/T4_24/GetCampImage?id=${cb.campID}'/>" />
							</td> -->
							<td>${ cb.description }</td>
							<td>
								<c:forEach var='tag' items='${cb.tags}'>
									${tag.tagName}&nbsp; / &nbsp;
								</c:forEach>
							</td>
						</tr>
						<c:forEach var='site' items='${cb.sites}'>
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
					</c:forEach>
				</tbody>
			</table>

			<div>
				<a href="<c:url value='/t4_24camp/admin/QueryPageForm.jsp' />">&emsp;查詢&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='/t4_24camp/admin/InsertCampForm.jsp' />">&emsp;新增&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='/IndexShowCampsServlet' />">回首頁</a>
			</div>

		</body>

		</html>