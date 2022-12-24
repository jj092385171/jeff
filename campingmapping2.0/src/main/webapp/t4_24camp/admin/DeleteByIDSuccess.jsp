<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE HTML>

		<html>

		<head>
			<meta charset="utf-8" />
			<title>EEIT56_露營</title>
		</head>

		<body>
			<div>
				<a href="<c:url value='/IndexShowAllPageServlet' />"><strong>營地_營區位管理</strong></a>
			</div>

			<hr>

			<h2>刪除營地結果</h2>
			<div>
				${ ID }
			</div>

			<hr>

			<div>
				<a href="<c:url value='/t4_24camp/admin/QueryPageForm.jsp' />">&emsp;查詢&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='/t4_24camp/admin/InsertCampForm.jsp' />">&emsp;新增&emsp;營地_營位區</a>
				<br>
				<a href="<c:url value='/t4_24camp/admin/UpdatePage.jsp' />">&emsp;修改&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='/t4_24camp/admin/deletePage.jsp' />">&emsp;刪除&emsp;營地_營區位</a>
				<br>
				<a href="<c:url value='IndexShowAllPageServlet' />">回首頁</a>
			</div>

		</body>

		</html>