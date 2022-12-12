<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show Post</title>
<style>
	h3{
		color: brown;	
	}
	div{
		padding: 5px 5px;
		margin: 5px 5px;
	}
	h4{
		color: brown;
	}
	td{
		padding: 3px;
	}
</style>
</head>
<body>
	<form action="<c:url value='/T4_33/likePostServlet' />" method="POST">
		<input type="hidden" name="postId" value="${postId}">
		<h3>貼文</h3>
		<div>
			<label>標題:</label>
			<input type="text" name="title" value="${title}" size="80" disabled>
		</div>
		<div>
			<label>內容:</label>
			<textarea name="content" id="" cols="66" rows="10" disabled>${content}</textarea>
		</div>
<!-- 		<div> -->
<!-- 			<label>照片:</label> -->
<%-- 			<img src="${picture}" width="600px">${picture} --%>
<!-- 		</div> -->
		<div>
			<label>露營人數:</label>
			<input type="text" name="people" value="${people}" size="30" disabled>
		</div>
		<div>
			<label>露營費用:</label>
			<input type="text" name="price" value="${price}" size="30" disabled>
		</div>
		<div>
			<label>露營城市:</label>
			<input type="text" name="county" value="${county}" size="30" disabled>
		</div>
		<div>
			<label>開始露營日期:</label>
			<input type="text" name="startDate" value="${startDate}" size="30" disabled>
		</div>
		<div>
			<label>結束露營日期:</label>
			<input type="text" name="endDate" value="${endDate}" size="30" disabled>
		</div>
		<div>
			<label>評分:</label>
			<input type="text" name="score" value="${score}" size="30" disabled>
		</div>
		<div>
			<label>最後更新日期:</label>
			<input type="text" name="releaseDate" value="${releaseDate}" size="30" disabled>
		</div>
		<div>
			<label>喜歡本貼文人數:</label>
			<input type="text" name="userLike" value="${userLike}" size="30" disabled>
			<input type="submit" value="喜歡">
		</div>
		<div>	
			<label>不喜歡本貼文人數:</label>
			<input type="text" name="userUnlike" value="${userUnlike}" size="30" disabled>
			<input type="submit" formaction="<c:url value='/T4_33/unlikePostServlet' />" value="不喜歡">
		</div>
		<div>
			<input type="submit" formaction="<c:url value='/T4_33/showUpdatePostServlet' />" value="修改貼文">
			<input type="submit" formaction="<c:url value='/T4_33/reportPostServlet' />" value="檢舉貼文">${reportResult}
			<input type="submit" formaction="<c:url value='/T4_33/hidePostServlet' />" value="隱藏貼文">${hideResult}
			<input type="submit" formaction="<c:url value='/T4_33/deletePostServlet' />" value="刪除貼文">${deleteResult}
			<input type="submit" formaction="<c:url value='/T4_33/showDiscussionServlet' />" value="回討論區">
		</div>
	</form>
	<hr>
	<form action="<c:url value='/T4_33/newPostCommentServlet' />" method="POST">
        <h4>留言區</h4>
        <input type="hidden" name="postId" value="${postId}">
        <label>新增留言:</label>
        <input type="text" name="postComment" maxlength="100" size="100" required="required">
        <input type="submit" value="送出留言"><br>
    </form>
    <form method="POST">
		<input type="hidden" name="postId" value="${postId}">
		<table>
			<c:forEach var="postComment" items="${comList}">
        		<tr>
        			<td>
        				留言者ID：${postComment.userId}<br>
        				留言內容：${postComment.postComment}
        				<input type="submit" formaction="<c:url value='/T4_33/hidePostCommentServlet?postCommentId=${postComment.postCommentId}' />" value="隱藏留言">
        				<input type="submit" formaction="<c:url value='/T4_33/deletePostCommentServlet?postCommentId=${postComment.postCommentId}' />" value="刪除留言">
        			</td>
        		</tr>
        	</c:forEach>
		</tbody>		
		</table>
	</form>
</body>
</html>