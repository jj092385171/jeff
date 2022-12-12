<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cityIDs 搜尋營地結果</title>
<style>
	th{
		width : 150px;
		height : 45px;
	}
	td{
		width : 150px;
		height : 55px;
	}
	.class1{
		width : 250px;
		height : 55px;
	}
	
</style>
</head>
<body>
<div align='center'>

<h2>cityIDs 搜尋營地結果</h2>
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
		</thead>
		<tbody>
			<c:forEach var='cct' items='${cctAllList}'>
				<tr>
					<td>${ cct.campID }</td>
					<td>${ cct.campName }</td>
					<td>${ cct.cityID }</td>
					<td>${ cct.cityName }</td>
					<td>${ cct.location }</td>
					<td>圖片: </td>
					<td>${ cct.discription }</td>
					<td class='class1'>
						<c:forEach var='tag' items='${cct.tagList}'>
							${tag.tagName}&nbsp; / &nbsp;
						</c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<br><br><br>
	
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

<!-- <ul> -->
<%-- 	<li><a href="<c:url value='/T4_24/QueryPageServlet' />">&emsp;查詢&emsp;營地_營區位</a></li> --%>
<%-- 	<li><a href="<c:url value='/T4_24/InsertPageServlet' />">&emsp;新增&emsp;營地_營位區</a></li> --%>
<%-- 	<li><a href="<c:url value='/T4_24/UpdatePage.jsp' />">&emsp;修改&emsp;營地_營區位</a></li> --%>
<%-- 	<li><a href="<c:url value='/T4_24/deletePage.jsp' />">&emsp;刪除&emsp;營地_營區位</a></li> --%>
<!-- </ul> -->
</div>
</body>
</html>