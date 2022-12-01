<%@ page language="java" contentType="text/html; charset=UTF-8"
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
	<form name="InsertCampForm" action="<c:url value='/T4_24/InsertCampServlet' />" method="POST" enctype=“multipart/form-data”>
		<table border="1">
			<thead>
				<tr bgcolor='lightblue'>
					<th height="60" colspan="2" align="center" ><h2>新增營地資料</h2></th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='lightgreen'>
					<td width="120" height="40">營地名:</td>
					<td width="600" height="40" align="left"><input id='memberId'
						style="text-align: left" name="campName" value="${param.campName}" type="text" size="14">
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.campName}</div>
					</td>
				</tr>
				<tr bgcolor='lightgreen'>
					<td width="120" height="40">縣市:</td>
					<td width="600" height="40" align="left"><input id='pswd'
						style="text-align: left" name="city" value="${param.city}" type="password" size="14">
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.city}</div>
					</td>
				</tr>
				<tr bgcolor='lightgreen'>
					<td width="120" height="40">地址:</td>
					<td width="600" height="40" align="left"><input name="location" value="${param.location}"
						type="text" size="20">
						<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.name}</div>
					</td>
				</tr>
				<tr bgcolor='lightgreen'>
					<td width="120" height="40">選擇營地圖片:</td>
					<td width="600" height="40" align="left"><input name="campPictures" 
						type="file" size="20">
					</td>
				</tr>
				<tr bgcolor='lightgreen'>
					<td width="120" height="40">簡介:</td>
					<td width="600" height="40" align="left"><input name="discription" value="${param.discription}"
						type="text" size="20">
					</td>
				</tr>
				<tr bgcolor='lightblue'>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="送出"></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>