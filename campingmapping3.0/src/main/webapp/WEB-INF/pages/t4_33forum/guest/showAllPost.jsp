<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forum Front Page</title>
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
	<form>
        <input type="submit" formaction="newPost" value="新增貼文">
        <input type="submit" formaction="showPostByUserId" value="個人貼文">
        <input type="submit" formaction="showAllPostAdmin" value="管理者首頁">
        <input type="submit" formaction="" value="回首頁">
    </form>    
    <table>
        <tbody>
        <c:forEach var="post" items="${postList}">
        	<tr>
        		<td>
        			<form>
        			<input type="hidden" name="postId" value="${post.postId}">
        			<h3>${post.title}</h3>
        			${post.content}<br><br>
        			最後更新日期:${post.releaseDate}<br>
        			<input type="submit" formaction="showPostByPostId" value="查看貼文">
        			</form>
        		</td>
        	</tr>
        </c:forEach>
        </tbody>
	</table>
</body>
</html>