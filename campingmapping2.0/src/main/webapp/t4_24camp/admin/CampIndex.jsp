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
						<th>營地編號</th>
						<th>營地</th>
						<th>縣市編號</th>
						<th>縣市名</th>
						<th>營地地址</th>
						<th>營地圖片</th>
						<th>營地簡介</th>
						<th>營地標籤</th>
						<th>更新</th>
						<th>刪除</th>
						<th>新增營區位</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var='camp' items='${allCamps}'>
						<tr>
							<td>${ camp.campID }</td>
							<td><a href="<c:url value='/SitesOfCampServlet.do?campID=${ camp.campID }' />">${
									camp.campName }</a></td>
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
							<td>
								<form action="<c:url value='/UpadteCampByIDPageServlet.do?campID=${camp.campID }'/>"
									method="POST">
									<button onclick="check()">更新</button>
								</form>

							</td>
							<td>
								<form action="<c:url value='/DeleteSiteByIDServlet.do?campID=${camp.campID }'/>"
									method="POST">
									<button onclick="check()">刪除</button>
								</form>
							</td>
							<td>
								<form action="<c:url value='/InsertSiteGetCampIDServlet?campID=${camp.campID }'/>"
									method="POST">
									<button>新增營區位</button>
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

			<script>
				function check() {
					if (confirm('確定執行?') == true) {
						action = "<c:url value='/UpadteCampByIDPageServlet.do?campID=${camp.campID }'/>"
						method = "POST"
						return true;
					} else {
						return false;
					}
				}
			</script>
		</body>

		</html>