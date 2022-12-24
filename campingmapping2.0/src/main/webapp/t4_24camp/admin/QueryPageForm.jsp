<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>EEIT56_露營</title>
		</head>

		<body>
			<div>
				<a href="<c:url value='/IndexShowAllPageServlet' />"><strong>營地_營區位管理</strong></a>
			</div>

			<hr>

			<form name="QueryCampByCityNameForm" action="<c:url value='/T4_24/QueryCampsByCityIDsServlet' />"
				method="POST">
				<table>
					<thead>
						<tr>
							<th>
								<h2>縣市查詢營地資料</h2>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>縣市:</td>
							<td>
								<c:forEach var='city' items='${cityList}'>
									<input type="checkbox" name="cityID" value="${city.cityID}" />${city.cityName}
								</c:forEach>
								<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.cityIDs}</div>
							</td>
						<tr>
							<td><input type="submit" value="送出"></td>
						</tr>
					</tbody>
				</table>
			</form>

			<hr>

			<form name="QueryCampByCampIDForm" action="<c:url value='/T4_24/QueryCampByCampIDServlet' />" method="POST">
				<table>
					<thead>
						<tr>
							<th>
								<h2>ID查詢營地資料</h2>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>營地ID:</td>
							<td><input name="campID" value="" type="text">
								<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.campID}</div>
							</td>
						<tr>
							<td><input type="submit" value="送出"></td>
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