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
				<a href="<c:url value='/IndexShowCampsServlet' />"><strong>營地_營區位管理</strong></a>
			</div>

			<hr>

			<form name="InsertSiteByIDForm" action="<c:url value='/InsertSiteByIDServlet.do' />" method="POST"
				enctype="multipart/form-data">
				<table>
					<thead>
						<tr>
							<th>
								<h2>新增營區位資料</h2>
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>營區位名:</td>
							<td>
								<input name="siteName" value="${param.siteName}" type="text">
								<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.siteName}</div>
							</td>
						</tr>
						<tr>
							<td>選擇營區位圖片:</td>
							<td>
								<input name="sitePictures" type="file">
								<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.sitePictures}
								</div>
							</td>
						</tr>
						<tr>
							<td>總營位:</td>
							<td>
								<input name="totalSites" value="${param.totalSites}" type="text">
								<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.totalSites}</div>
							</td>
						</tr>
						<tr>
							<td>營位金額:</td>
							<td>
								<input name="siteMoney" value="${param.siteMoney}" type="text">
								<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.siteMoney}</div>
							</td>
						</tr>
						<tr>
							<td>營地編號:</td>
							<td>
								<input name="campID" readonly="readonly" value='${ campID }' type="text">
							</td>
						</tr>
						<tr>
							<td><input type="submit" value="送出"></td>
						</tr>
					</tbody>
				</table>
			</form>

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