<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showHidePost</title>

</head>

<body>
	<h3>隱藏貼文</h3>
	<form action="<c:url value='/T4_33/showDiscussionServlet' />" method="POST" id="postForm">
        <input type="submit" value="回討論區">
        
        <table>
        	<c:forEach var="postHideList" items="${postHideList}">
        	<tbody>
        		<tr>
        			<td>
        				${postHideList.title}<br>
        				<input type="submit" formaction="<c:url value='/T4_33/showPostServlet?postId=${postHideList.postId}' />" value="查看貼文"><hr>
        			</td>
        		</tr>
        	</tbody>
        	</c:forEach>
        </table>
    </form>
</body>
</html>