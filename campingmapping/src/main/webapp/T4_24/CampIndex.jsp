<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>camp</title>
</head>
<body>
<h1>營地管理</h1>
<a href="<c:url value='/T4_24/InsertCampPageServlet' />">新增營地</a><p/>
<a href="<c:url value='/T4_24/QueryCampPageServlet' />">查詢營地</a><p/>
<a href="<c:url value='/T4_24/ShowAllCampsPageServlet' />">刪除營地</a><p/>
<a href="<c:url value='/T4_24/ShowAllCampsPageServlet' />">修改營地</a><p/>
<hr>


</body>
</html>