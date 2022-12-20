<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

		<form action="<c:url value='/T4_09/job/JobModel/insert.jsp'/>"
			method="POST" enctype="multipart/form-data">
			<button>新增職缺</button>
		</form>
		<%-- <form action="<c:url value='/SelectAllServlet.do'/>" method="POST"> --%>
		<!-- <input type="submit" value="輸入資料庫內產品" style="width:70px;height:50px;"> -->
		<!-- </form> -->
		<form action="<c:url value='/T4_09/job/JobModel/select.jsp'/>"
			method="POST" enctype="multipart/form-data">
			<button>查詢</button>
		</form>
		<form action="<c:url value='/JobServletShowAll' />" method="POST"
			enctype="multipart/form-data">
			<button>全部資料</button>
		</form>


	</div>
</body>
</html>