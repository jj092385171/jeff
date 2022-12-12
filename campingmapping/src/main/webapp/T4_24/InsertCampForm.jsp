﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增營地表單</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>
<body>
	<form name="InsertCampForm" action="<c:url value='/T4_24/InsertCampServlet' />" method="POST" enctype="multipart/form-data">
		<table border="1">
			<thead>
				<tr bgcolor='lightblue'>
					<th height="60" colspan="2" align="center" ><h2>新增營地資料</h2></th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='lightgreen'>
					<td width="120" height="40">營地名:</td>
					<td width="600" height="40" align="left"><input id='campName'
						style="text-align: left" name="campName" value="${param.campName}" type="text" size="14">
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.campName}</div>
					</td>
				</tr>
				<tr bgcolor='lightgreen'>
					<td width="120" height="40">縣市:</td>
					<td width="600" height="40" align="left">
						<c:forEach var='city' items='${cityList}'>
							<input type="radio" name="cityID" value="${city.cityID}" />${city.cityName}
						</c:forEach>
					<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.cityID}</div>
					</td>
				</tr>
				<tr bgcolor='lightgreen'>
					<td width="120" height="40">地址:</td>
					<td width="600" height="40" align="left"><input id='location' name="location" value="${param.location}"
						type="text" size="20">
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.location}</div>
					</td>
				</tr>
				<tr bgcolor='lightgreen'>
					<td width="120" height="40">選擇營地圖片:</td>
					<td width="600" height="40" align="left"><input id='campPictures' name="campPictures" 
						type="file" size="20">
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.campPictures}</div>
					</td>
				</tr>
				<tr bgcolor='lightgreen'>
					<td width="120" height="40">簡介:</td>
					<td width="600" height="40" align="left"><input name="discription" value="${param.discription}"
						type="text" size="20">
					</td>
				</tr>
				<tr bgcolor='lightgreen'>
					<td width="120" height="40">標籤:</td>
					<td width="600" height="40" align="left">
						<c:forEach var='tag' items='${tagList}'>
							<input type="checkbox" name="tagID" value="${tag.tagID}" />${tag.tagName}
						</c:forEach>
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.tagIDs}</div>
					</td>
				</tr>
				<tr bgcolor='lightblue'>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="送出"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<form name="InsertSitePageByCaampIDForm" action="<c:url value='/T4_24/InsertSiteByCampIDPageServlet' />" method="POST">
		<table border="1">
			<thead>
				<tr bgcolor='lightblue'>
					<th height="60" colspan="2" align="center" ><h2>新增營位區</h2></th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='lightgreen'>
					<td width="120" height="40">請輸入營地 ID:</td>
						<td width="600" height="40" align="left"><input id='campID'
						style="text-align: left" name="campID" value="${param.campID}" type="text" size="14">
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.campID}</div>
					</td>
				<tr bgcolor='lightblue'>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="送出"></td>
				</tr>
			</tbody>
		</table>
	</form>
	<table border='1'>
		<thead>
			<tr>
				<th>營地編號</th>
				<th>營地</th>
				<th>縣市編號</th>
				<th>縣市名</th>
				<th>地址</th>
				<th>圖片</th>
				<th>簡介</th>
				<th class='class1'>標籤</th>
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
					<td>圖片: </td>
					<td>${ all.discription }</td>
					<td class='class1'>
						<c:forEach var='tag' items='${all.tagList}'>
							${tag.tagName}&nbsp; / &nbsp;
						</c:forEach>
					</td>
				</tr>
				<c:forEach var='site' items='${all.siteList}'>
					<tr>
						<td>&emsp;&emsp;${ site.siteID }</td>
						<td>&emsp;${ site.siteName }</td>
						<td>&emsp;圖片:</td>
						<td>&emsp;${ site.totalSites }</td>
						<td>&emsp;${ site.siteMoney }</td>
					</tr>
				</c:forEach>
			</c:forEach>
		</tbody>
	</table>
<hr>
<a href="<c:url value='IndexShowAllPageServlet' />" >回首頁</a>
</body>
	
</html>