<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>職缺(後台)</title>
</head>
<body>
	<div>
		<h2>職缺(後台)</h2>

		<form action="<c:url value='/insert.controller'/>" method="post"
			enctype="multipart/form-data">
			<button>新增職缺</button>
		</form>
		
		<form action="<c:url value='/select.controller'/>"
			method="POST" enctype="multipart/form-data">
			<button>查詢</button>
		</form>
		
		<form action="<c:url value='/showAll.controller' />" method="POST"
			enctype="multipart/form-data">
			<button>全部資料</button>
		</form>


	</div>
</body>
</html>