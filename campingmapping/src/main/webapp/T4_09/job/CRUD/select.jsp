<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Select</title>
</head>
<body>

	<form action="<c:url value='/JobServletSelectLike'/>" method="POST"
		enctype="multipart/form-data">

		<p>查詢</p>
		職缺:<select name="job">
			<option value="廚師">廚師</option>
			<option value="廚助">廚助</option>
			<option value="房務員">房務員</option>
			<option value="會計">會計</option>
			<option value="櫃台">櫃台</option>
			<option value="假日工讀生">假日工讀生</option>
			<option value="行政管理人員">行政管理人員</option>
			<option value="夜班保全">夜班保全</option>	
			<option value="其他">其他</option>
		</select> <input type="submit" value="查詢">
	</form>
	<hr>
	
	<form action="<c:url value='/JobServletFindBeanByuID'/>" method="POST"
		enctype="multipart/form-data">
		會員ID:<input type="text" name="uID"> <input type="submit" value="查詢">
		<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.uID}</div>
	</form>
	<hr>

	<form action="<c:url value='/T4_09/job/jobIndex.jsp' />">
		<button>回首頁</button>
	</form>

</body>
</html>