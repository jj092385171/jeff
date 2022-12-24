<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>discussion First</title>
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
	<h2>討論區首頁</h2>
	<form action="<c:url value='/t4_33forum/guest/newPost.jsp' />" method="POST" id="postForm">
        <input type="submit" value="新增貼文">
        <input type="submit" formaction="<c:url value='/T4_33/showForumManagerServlet' />" value="管理者首頁">
        <input type="submit" formaction="<c:url value='/index.jsp' />" value="回首頁">
        <table>
        	<tbody>
        	<c:forEach var="post" items="${postList}">
        		<tr>
        		<td>
        			<h3>${post.title}</h3>
        			${post.content}<br><br>
        			最後更新日期:${post.releaseDate}<br>
        			<input type="submit" formaction="<c:url value='/T4_33/showPostServlet?postId=${post.postId}' />" value="查看貼文">
        		</td>
        		</tr>
        	</c:forEach>
        	</tbody>
        </table>
    </form>
</body>
</html>