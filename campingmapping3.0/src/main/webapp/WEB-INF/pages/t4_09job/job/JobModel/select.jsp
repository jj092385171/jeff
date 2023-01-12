<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Select</title>
<style>
.c1 {
	width: 500px;
	border: 2px solid black;
	left: 500px;
	background-color: lightgray;
	color: blue;
	justify-content: center;
	align-items: center;
	margin: auto
}

.b {
	text-align: center;
}
</style>
</head>

<body>
	<div class="c1">

		<form action="<c:url value='/selectLike.controller'/>" method="POST"
			enctype="multipart/form-data">

			<h3>查詢</h3>
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
			<div style="color: #FF0000; font-size: 60%; display: inline">${errors.job}</div>
		</form>
		<hr>

		<form action="<c:url value='/selectUid.controller'/>" method="POST"
			enctype="multipart/form-data">

			會員ID:<input type="text" name="uID" required> <input
				type="submit" value="查詢">
			<div style="color: #FF0000; font-size: 60%; display: inline">${errors.uID}</div>
		</form>

	</div>
	<hr>

	<form action="<c:url value='jobCRUD.controller' />" method="POST"
		enctype="multipart/form-data">
		<div class="b">
			<button>回首頁</button>
		</div>
	</form>

	<script src="https://code.jquery.com/jquery-3.6.1.js">
		$('input').attr('required', true),
	</script>
</body>

</html>