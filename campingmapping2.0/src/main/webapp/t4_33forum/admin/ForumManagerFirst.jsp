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
	<form method="POST" id="postForm">
<!--         <input type="submit" value="新增貼文"> -->
        <input type="submit" formaction="<c:url value='/T4_33/showHidePostServlet' />" value="查詢隱藏貼文">
        <input type="submit" formaction="<c:url value='/T4_33/showReportPostServlet' />" value="查詢被檢舉的貼文">
        <input type="submit" formaction="<c:url value='/T4_33/showDiscussionServlet' />" value="回討論區首頁">
        <table>
        	<thead>
        		<tr>
        			<th>貼文編號</th>
        			<th>會員編號</th>
        			<th>標題</th>
        			<th>內容</th>
        			<th>露營人數</th>
        			<th>露營費用</th>
        			<th>露營城市</th>
        			<th>開始露營日期</th>
        			<th>結束露營日期</th>
        			<th>評分</th>
        			<th>最後更新日期</th>
        			<th>喜歡本貼文人數</th>
        			<th>不喜歡本貼文人數</th>
        			<th>是否被檢舉</th>
        			<th>是否被隱藏</th>
        		</tr>
        	</thead>
        	<tbody>
        	<c:forEach var="post" items="${postList}">
        		<tr>
        		<td>${post.postId}</td>
        		<td>${post.userId}</td>
        		<td>${post.title}</td>
        		<td>${post.content}</td>
        		<td>${post.people}</td>
        		<td>${post.price}</td>
        		<td>${post.county}</td>
        		<td>${post.startDate}</td>
        		<td>${post.endDate}</td>
        		<td>${post.score}</td>
        		<td>${post.releaseDate}</td>
        		<td>${post.userLike}</td>
        		<td>${post.userUnlike}</td>
        		<td>${post.postReport}</td>
        		<td>${post.postHide}</td>
        		<td><input type="submit" formaction="<c:url value='/T4_33/hidePostServlet' />" value="隱藏貼文"></td>
        		</tr>
        	</c:forEach>
        	</tbody>
        </table>
    </form>
</body>
</html>