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

			<table>
				<thead>
					<tr>
						<th>營位區編號</th>
						<th>營位區名</th>
						<th>營區位圖片</th>
						<th>總營位</th>
						<th>營位金額</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var='site' items='${sites}'>
						<tr>
							<td>${ site.siteID }</td>
							<td>${ site.siteName }</td>
							<!-- <td> 
								<img width="80" height="100"
									src="<c:url value='/T4_24/GetSiteImage?id=${site.siteID}'/>" />
							</td>  -->
							<td>${ site.totalSites }</td>
							<td>${ site.siteMoney }</td>
							<td>
								<form action="<c:url value='/PageUpadteSiteByIDServlet?siteID=${site.siteID }'/>" method="POST">
									<button>更新</button>
								</form>
							</td>
							<td>
								<form action="<c:url value='/DeleteCampByIDServlet.do?siteID=${site.siteID }'/>" method="POST">
									<button>刪除</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
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