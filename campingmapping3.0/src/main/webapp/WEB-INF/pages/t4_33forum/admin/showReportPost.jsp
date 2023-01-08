<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show ReportPost</title>
<style>
	body{
		background-color: mistyrose;
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
	<h3 class="titleh3">被檢舉的貼文</h3>
	<form action="showAllPostAdmin">
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
        	<c:forEach var="postReportList" items="${postReportList}">
        		<tr>
        			<td>${postReportList.postId}</td>
        			<td>${postReportList.userId}</td>
        			<td>${postReportList.title}</td>
        			<td>${postReportList.content}</td>
        			<td>${postReportList.people}</td>
        			<td>${postReportList.price}</td>
        			<td>${postReportList.county}</td>
        			<td>${postReportList.startDate}</td>
        			<td>${postReportList.endDate}</td>
        			<td>${postReportList.score}</td>
        			<td>${postReportList.releaseDate}</td>
        			<td>${postReportList.userLike}</td>
        			<td>${postReportList.userUnlike}</td>
        			<td>${postReportList.postReport}</td>
        			<td>${postReportList.postHide}</td>
        			<td>
        				<form method="POST">
        				<input type="hidden" name="postId" value="${postReportList.postId}">
        				<input type="submit" formaction="hidePost" value="隱藏貼文" onclick="return confirm('是否確定隱藏貼文?');">
        				<input type="submit" formaction="cancelReportPost" value="取消檢舉貼文" onclick="return confirm('是否確定取消檢舉貼文?');">
        				</form>
        			</td>
        		</tr>
        	</c:forEach>
        	</tbody>
        </table>
    
</body>
</html>