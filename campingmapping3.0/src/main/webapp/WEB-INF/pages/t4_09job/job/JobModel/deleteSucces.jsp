<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.c1 {
	text-align: center
}

.b {
	text-align: center;
}
</style>
</head>

<body>
	<h2 class="c1">刪除成功</h2>
	<!-- 	<div class="b"> -->
	<!-- 		<a href="insert.controller">回上一頁</a> -->
	<!-- 	</div> -->
	<form action="<c:url value='insert.controller' />" method="POST"
		enctype="multipart/form-data">
		<div class="b">
			<button>回上一頁</button>
		</div>
	</form>

	<form action="<c:url value='jobCRUD.controller' />" method="POST"
		enctype="multipart/form-data">
		<div class="b">
			<button>回首頁</button>
		</div>
	</form>

</body>

</html>