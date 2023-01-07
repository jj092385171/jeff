<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<meta charset="UTF-8">
<title>addSuccess</title>
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

	<h2 class="c1">新增成功</h2>
<!-- 	<div class="b"> -->
<!-- 		<a href="jobCRUD.controller">回首頁</a> -->
<!-- 	</div> -->
	<form action="<c:url value='jobCRUD.controller' />"
		method="POST" enctype="multipart/form-data">
		<div class="b">
			<button>回首頁</button>
		</div>
	</form>
	<!-- 	<div class="b"> -->
	<!-- 		<a href="insert.controller">回上一頁</a> -->
	<!-- 	</div> -->
	<form action="<c:url value='insert.controller' />" method="POST"
		enctype="multipart/form-data">
		<div class="b">
			<button>回上一頁</button>
		</div>
	</form>
</body>

</html>