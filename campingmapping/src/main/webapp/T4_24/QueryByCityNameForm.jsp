<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>搜尋營地</title>
<style>
form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>
<body>
	<form name="QueryCampByCityNameForm" action="<c:url value='/T4_24/QueryCampServlet' />" method="POST">
		<table border="1">
			<thead>
				<tr bgcolor='lightblue'>
					<th height="60" colspan="2" align="center" ><h2>查詢營地資料</h2></th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='lightgreen'>
					<td width="120" height="40">縣市:</td>
					<td width="600" height="40" align="left">
						<c:forEach var='city' items='${cityList}'>
							<input type="checkbox" name="cityID" value="${city.getCityID()}" />${city.getCityName()}
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