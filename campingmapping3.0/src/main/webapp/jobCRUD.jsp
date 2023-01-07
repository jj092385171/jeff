<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>職缺(後台)</title>
</head>
<body>
	<div>
		<h2>職缺(後台)</h2>
		<a href="insert.controller">新增職缺</a>
		<%-- 		<form action="<c:url value='insert.controller'/>" method="post" --%>
		<%-- 			enctype="multipart/form-data"> --%>
		<!-- 			<button>新增職缺</button> -->
		<%-- 		</form> --%>
		<form action="<c:url value='/t4_09job/job/JobModel/select.jsp'/>"
			method="POST" enctype="multipart/form-data">
			<button>查詢</button>
		</form>
		<a href="showAll.controller">全部資料</a>
		<%-- 		<form action="<c:url value='/JobServletShowAll' />" method="POST" --%>
		<%-- 			enctype="multipart/form-data"> --%>
		<!-- 			<button>全部資料</button> -->
		<%-- 		</form> --%>


	</div>
</body>
</html>