<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show HidePost</title>
<style>
	body{
		background-color: azure;
	}
	.titleh3{
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
		box-shadow: 0px 0px 3px 3px slategray;
		background-color: white;
	}
	.contenth3{
		margin: 5px 0px;
	}
</style>
</head>

<body>
	<h3 class="titleh3">隱藏貼文</h3>
	<form action="<c:url value='/T4_33/showForumManagerServlet' />" method="POST" id="postForm">
        <input type="submit" value="回管理者首頁">
    </form>    
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
        	<c:forEach var="postHideList" items="${postHideList}">
        		<tr>
        			<td>${postHideList.postId}</td>
        			<td>${postHideList.userId}</td>
        			<td>${postHideList.title}</td>
        			<td>${postHideList.content}</td>
        			<td>${postHideList.people}</td>
        			<td>${postHideList.price}</td>
        			<td>${postHideList.county}</td>
        			<td>${postHideList.startDate}</td>
        			<td>${postHideList.endDate}</td>
        			<td>${postHideList.score}</td>
        			<td>${postHideList.releaseDate}</td>
        			<td>${postHideList.userLike}</td>
        			<td>${postHideList.userUnlike}</td>
        			<td>${postHideList.postReport}</td>
        			<td>${postHideList.postHide}</td>
        			<td>
        				<form method="POST">
        				<input type="hidden" name="postId" value="${postHideList.postId}">
        				<input type="submit" formaction="<c:url value='/T4_33/cancelHidePostServlet' />" id="cancelHide" value="取消隱藏貼文" onclick="return confirm('是否確定取消隱藏?');">
        				</form>
        			</td>
        		</tr>
        	</c:forEach>
        	</tbody>
        </table>
   
</body>
</html>