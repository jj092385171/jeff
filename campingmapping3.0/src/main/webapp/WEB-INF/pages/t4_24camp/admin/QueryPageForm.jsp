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
				<a href="/campingmapping3.0/indexShowAllCamp.controller"><strong>營地_營區位管理</strong></a>
			</div>

			<hr>

			<form name="QueryCampByCityNameForm" action="queryCampsByCityIDs.controller"
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
								<div style="color:#FF0000; font-size:60%; display: inline">${errors.cityIDs}</div>
							</td>
						<tr>
							<td><input type="submit" value="送出"></td>
						</tr>
					</tbody>
				</table>
			</form>

			<hr>

			<form name="QueryCampByCampIDForm" action="queryCampsByCampIDs.controller" method="POST">
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
								<div style="color:#FF0000; font-size:60%; display: inline">${errors.campID}</div>
							</td>
						<tr>
							<td><input type="submit" value="送出"></td>
						</tr>
					</tbody>
				</table>
			</form>

			<div>
				<a href="/campingmapping3.0/queryPage.controller">&emsp;查詢&emsp;營地_營區位</a>
				<br>
				<a href="/campingmapping3.0/insertPage.controller">&emsp;新增&emsp;營地_營區位</a>
				<br>
				<a href="/campingmapping3.0/indexShowAllCamp.controller">回首頁</a>
			</div>

		</body>

		</html>