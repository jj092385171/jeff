<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>discussion First</title>

</head>

<body>
	<h2>討論區首頁</h2>
	<form action="<c:url value='/T4_33/newPost.jsp' />" method="POST" id="postForm">
        <input type="submit" value="新增貼文">
        <input type="submit" formaction="<c:url value='/T4_33/showHidePostServlet' />" value="查詢隱藏貼文">
        <table>
        	<tbody>
        	<c:forEach var="post" items="${postList}">
        		<tr>
        			<td>
        				${post.title} <br>
        				<input type="submit" formaction="<c:url value='/T4_33/showPostServlet?postId=${post.postId}' />" value="查看貼文"><hr>
        			</td>
        		</tr>
        	</c:forEach>
        	</tbody>
        </table>
    </form>
</body>
</html>