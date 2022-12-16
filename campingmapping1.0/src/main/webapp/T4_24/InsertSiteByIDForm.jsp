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

			<form name="InsertSiteByIDForm" action="<c:url value='/T4_24/InsertSiteByIDServlet' />" method="POST"
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
								<input name="campID" readonly="readonly" value='${ cctBean.campID }' type="text">
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
				<form name="InsertSiteByIDForm">
					營地編號: <input type="text" name='campID' readonly="readonly" value='${ cctBean.campID }'><br>
					營地: <input type="text" name='campName' readonly="readonly" value='${ cctBean.campName }'><br>
					縣市編號: <input type="text" name='cityID' readonly="readonly" value='${ cctBean.cityID }'><br>
					縣市名: <input type="text" name='cityName' readonly="readonly" value='${ cctBean.cityName }'><br>
					縣市XXX:<c:forEach var='city' items='${cityList}'>
						<input type="radio" name="cityIDXXX" readonly="readonly" checked
							value="${city.cityID}" />${city.cityName}
					</c:forEach><br>
					縣市:<c:forEach var='city' items='${cityList}'>
						<input type="radio" name="cityID" readonly="readonly" value="${city.cityID}" />${city.cityName}
					</c:forEach><br>
					地址: <input type="text" name='location' readonly="readonly" value='${ cctBean.location }'><br>
					圖片: <img width="80" height="100"
						src="<c:url value='/T4_24/GetCampImage?id=${cctBean.campID}'/>" /><br>
					簡介: <input type="text" name='discription' readonly="readonly" value='${ cctBean.discription }'><br>
					標籤XXX: <c:forEach var='tag' items='${cctBean.tagList}'>
						<input type="checkbox" name="tagIDXXX" readonly="readonly" checked
							value="${tag.tagID}" />${tag.tagName}
					</c:forEach><br>
					標籤: <c:forEach var='tag' items='${tagList}'>
						<input type="checkbox" name="tagID" readonly="readonly" value="${tag.tagID}" />${tag.tagName}
					</c:forEach>
				</form>
			</div>

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