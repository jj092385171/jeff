<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新營地.營區位頁面</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>
<body>
	<form name="UpdateCampSitePage" action="<c:url value='/T4_24/UpadteCampByIDPageServlet' />" method="POST">
		<table border="1">
			<thead>
				<tr bgcolor='lightblue'>
					<th height="60" colspan="2" align="center" ><h2>修改營地資料</h2></th>
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
	<form name="UpdateCampSitePage" action="<c:url value='/T4_24/UpadteSiteByIDPageServlet' />" method="POST">
		<table border="1">
			<thead>
				<tr bgcolor='lightblue'>
					<th height="60" colspan="2" align="center" ><h2>修改營區位資料</h2></th>
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
	
	<c:forEach var='all' items='${showALL}'>
		營地編號: ${ all.campID }<br>
		營地: ${ all.campName }<br>
		縣市編號: ${ all.cityID }<br>
		縣市名: ${ all.cityName }<br>
		地址: ${ all.location }<br>
<!-- 							圖片: <br> -->
		簡介: ${ all.discription }<br>
		<c:forEach var='tag' items='${all.tagList}'>
			標籤: ${tag.tagName}<br>
		</c:forEach>
	</c:forEach>

</body>
</html>