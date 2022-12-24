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
				<a href="<c:url value='/IndexShowAllPageServlet' />" class="logo"><strong>營地管理</strong></a>
			</div>

			<hr>

			<h2>刪除&emsp;營地_營區位</h2>
			<form name="deleteCampSitePage" action="<c:url value='/T4_24/DeleteCampByIDServlet' />" method="POST">
				<table>
					<thead>
						<tr>
							<th>
								<h2>刪除營地資料</h2>
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

			<form name="deleteCampSitePage" action="<c:url value='/T4_24/DeleteSiteByIDServlet' />" method="POST">
				<table>
					<thead>
						<tr>
							<th>
								<h2>刪除營區位資料</h2>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>請輸入營區位 ID:</td>
							<td>
								<input name="siteID" value="${param.siteID}" type="text">
								<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.siteID}</div>
							</td>
						<tr>
							<td>
								<input type="submit" value="送出">
							</td>
						</tr>
					</tbody>
				</table>
			</form>

			<div>
				<a href="<c:url value='/t4_24camp/admin/QueryPageForm.jsp' />">&emsp;查詢&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='/t4_24camp/admin/InsertCampForm.jsp' />">&emsp;新增&emsp;營地_營位區</a>
				<br>
				<a href="<c:url value='/t4_24camp/admin/UpdatePage.jsp' />">&emsp;修改&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='/t4_24camp/admin/deletePage.jsp' />">&emsp;刪除&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='IndexShowAllPageServlet' />">回首頁</a>
			</div>

		</body>

		</html>