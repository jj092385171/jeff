<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager First</title>
<style>
	body{
		background-color: blanchedalmond;;
	}
	h2{
		color: brown;
	}
	form{
		margin: 10px 5px;
	}
	table{
		margin: 10px 0px;
	}
	td{
		padding: 0px 10px 10px 10px;
		border: 1px solid black;
		border-radius: 3%;
		box-shadow: 3px 3px 5px 5px slategray;
		background-color: white;
	}
</style>
</head>

<body>
	<h2>討論區管理者首頁</h2>
	<form action="<c:url value='/T4_33/newPost.jsp' />" method="POST" id="postForm">
        <input type="submit" value="新增貼文">
        <input type="submit" formaction="<c:url value='/T4_33/showHidePostServlet' />" value="查詢隱藏貼文">
        <input type="submit" formaction="<c:url value='/T4_33/showReportPostServlet' />" value="查詢被檢舉的貼文">
        <input type="submit" formaction="<c:url value='/T4_33/showdiscussionServlet' />" value="回討論區首頁">
        <table>
        	<thead>
        		<tr>
        			<th>編號</th>
        			<th>標題</th>
        			<th>內容</th>
        			<th>最後更新日期</th>
        			<th></th>
        		</tr>
        	</thead>
        	<tbody>
        	<c:forEach var="post" items="${postList}">
        		<tr>
        		<td>${post.postId}</td>
        		<td>${post.title}</td>
        		<td>${post.content}</td>
        		<td>${post.releaseDate}</td>
        		<td><input type="submit" formaction="<c:url value='/T4_33/showPostServlet?postId=${post.postId}' />" value="查看貼文"></td>
        		</tr>
        	</c:forEach>
        	</tbody>
        </table>
    </form>
</body>
</html>