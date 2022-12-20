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
				<a href="<c:url value='IndexShowAllPageServlet' />"><strong>營地_營區位管理</strong></a>
			</div>

			<hr>

			<h2>修改&emsp;營地_營區位</h2>
			<form name="UpdateCampSitePage" action="<c:url value='/T4_24/UpadteCampByIDPageServlet' />" method="POST">
				<table>
					<thead>
						<tr>
							<th>
								<h2>修改營地資料</h2>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>請輸入營地 ID:</td>
							<td>
								<input name="campID" value="${param.campID}" type="text">
								<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.campID}</div>
							</td>
						<tr>
							<td>
								<input type="submit" value="送出">
							</td>
						</tr>
					</tbody>
				</table>
			</form>


			<hr>

			<form name="UpdateCampSitePage" action="<c:url value='/T4_24/UpadteSiteByIDPageServlet' />" method="POST">
				<table>
					<thead>
						<tr>
							<th>
								<h2>修改營區位資料</h2>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>請輸入營地 ID:</td>
							<td>
								<input name="campIDSite" value="${param.campIDSite}" type="text">
								<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.campIDSite}
								</div>
							</td>
						<tr>
							<td>
								<input type="submit" value="送出">
							</td>
						</tr>
					</tbody>
				</table>
			</form>

			<hr>

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
					<c:forEach var='all' items='${showALL}'>
						<tr>
							<td>${ all.campID }</td>
							<td>${ all.campName }</td>
							<td>${ all.cityID }</td>
							<td>${ all.cityName }</td>
							<td>${ all.location }</td>
							<td>
								<img width="80" height="100"
									src="<c:url value='/T4_24/GetCampImage?id=${all.campID}'/>" />
							</td>
							<td>${ all.discription }</td>
							<td>
								<c:forEach var='tag' items='${all.tagList}'>
									${tag.tagName}&nbsp; / &nbsp;
								</c:forEach>
							</td>
						</tr>
						<c:forEach var='site' items='${all.siteList}'>
							<tr>
								<td>&emsp;&emsp;${ site.siteID }</td>
								<td>&emsp;${ site.siteName }</td>
								<td>&emsp;
									<img width="80" height="100"
										src="<c:url value='/T4_24/GetSiteImage?id=${site.siteID}'/>" />
								</td>
								<td>&emsp;${ site.totalSites }</td>
								<td>&emsp;${ site.siteMoney }</td>
							</tr>
						</c:forEach>
					</c:forEach>
				</tbody>
			</table>

			<hr>

			<div>
				<a href="<c:url value='/T4_24/QueryPageServlet' />">&emsp;查詢&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='/T4_24/InsertPageServlet' />">&emsp;新增&emsp;營地_營位區</a>
				<br>
				<a href="<c:url value='/T4_24/UpdatePage.jsp' />">&emsp;修改&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='/T4_24/deletePage.jsp' />">&emsp;刪除&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='IndexShowAllPageServlet' />">回首頁</a>
			</div>

		</body>

		</html>