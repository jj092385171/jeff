<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>刪除營地</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>
<body>
	<form name="DeleteCampByIDForm" action="<c:url value='' />" method="POST" enctype="multipart/form-data">
		<table border="1">
			<thead>
				<tr bgcolor='lightblue'>
					<th height="60" colspan="2" align="center" ><h2>刪除營地資料</h2></th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='lightgreen'>
					<td width="120" height="40">請輸入營地 ID:</td>
					<td width="600" height="40" align="left">
						<c:forEach var='camp' items='${campList}'>
							營地編號: ${ camp.getCampID() }<br>
							營地: ${ camp.getCampName() }<br>
							縣市: ${ camp.getCityID() }<br>
							地址: ${ camp.getLocation() }<br>
<!-- 							圖片: <br> -->
							簡介: ${ camp.getDiscription() }<br>
						</c:forEach>
					</td>
				<tr bgcolor='lightblue'>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="送出"></td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>