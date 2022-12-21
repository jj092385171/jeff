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
				<a href="<c:url value='IndexShowAllPageServlet' />"><strong>營地_營區位管理</strong></a>
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