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
								<form action="<c:url value='/PageUpadteSiteByIDServlet'/>" method="POST">
									<button onclick="return check()" type="submit" name="siteID"
										value="${site.siteID }">更新</button>
								</form>
							</td>
							<td>
								<form action="<c:url value='/DeleteCampByIDServlet.do'/>" method="POST">
									<button id="a" onclick="return check()" type="submit" name="siteID"
										value="${site.siteID }">刪除</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<hr>

			<div>
				<a href="/campingmapping3.0/queryPage.controller">&emsp;查詢&emsp;營地_營區位</a>
				<br>
				<a href="/campingmapping3.0/insertPage.controller">&emsp;新增&emsp;營地_營區位</a>
				<br>
				<a href="/campingmapping3.0/indexShowAllCamp.controller">回首頁</a>
			</div>


			<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
			<script>
				function check() {
					var conf = confirm("確定執行?");
					if (conf == true) {
						alert("執行!!");
						return true;
					}
					else {
						alert("取消執行!");
						// return false here
						return false;
					}
				}
			</script>
		</body>

		</html>