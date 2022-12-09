<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show Post</title>
</head>
<body>
	<form action="<c:url value='/T4_33/likePostServlet' />" method="POST">
		<div>
			<label>標題:</label>${title}
		</div>
		<div>
			<label>內容:</label>${content}
		</div>
		<div>
			<label>照片:</label>${picture}
		</div>
		<div>
			<label>露營人數:</label>${people}
		</div>
		<div>
			<label>露營費用:</label>${price}
		</div>
		<div>
			<label>露營城市:</label>${county}
		</div>
		<div>
			<label>開始露營日期:</label>${startDate}
		</div>
		<div>
			<label>結束露營日期:</label>${endDate}
		</div>
		<div>
			<label>評分:</label>${score}
		</div>
		<div>
			<label>最後更新日期:</label>${releaseDate}
		</div>
		<div>
			<label>喜歡人數:</label>${userLike}
			<input type="hidden" name="postId" value="${postId}">
			<input type="submit" value="喜歡">
		</div>
		<div>	
			<label>不喜歡人數:</label>${userUnlike}
			<input type="submit" formaction="<c:url value='/T4_33/unlikePostServlet' />" value="不喜歡">
		</div>
		<div>
			<input type="submit" formaction="<c:url value='/T4_33/showUpdatePostServlet' />" value="修改">
		</div>
		<div>
			<input type="submit" formaction="<c:url value='/T4_33/showDiscussionServlet' />" value="回討論區">
		</div>
		<div>
			<input type="submit" formaction="<c:url value='/T4_33/reportPostServlet' />" value="檢舉">${reportResult}
		</div>
		<div>
			<input type="submit" formaction="<c:url value='/T4_33/hidePostServlet' />" value="隱藏">
		</div>
	</form>
	
</body>
</html>