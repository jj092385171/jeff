<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>職缺(後台)</title>
</head>
<body>
<div>
<h2>職缺(後台)</h2>

<form action="<c:url value='CRUD/insert.jsp'/>">
<button>新增</button>
</form>
<form action="<c:url value='CRUD/select.jsp'/>">
<button>查詢</button>
</form>
<form action="<c:url value='/JobServletShowAll' />">
<button>全部</button>
</form>



</div>
</body>
</html>