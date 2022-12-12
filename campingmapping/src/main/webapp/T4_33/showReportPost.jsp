<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show ReportPost</title>
<style>
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
	}
	.contenth3{
		margin: 5px 0px;
	}
</style>
</head>

<body>
	<h3 class="titleh3">被檢舉的貼文</h3>
	<form action="<c:url value='/T4_33/showDiscussionServlet' />" method="POST" id="postForm">
        <input type="submit" value="回討論區">
        
        <table>
        	<c:forEach var="postReportList" items="${postReportList}">
        	<tbody>
        		<tr>
        			<td>
        				<h3 class="contenth3">${postReportList.title}</h3>
        				<input type="submit" formaction="<c:url value='/T4_33/showPostServlet?postId=${postReportList.postId}' />" value="查看貼文">
        			</td>
        		</tr>
        	</tbody>
        	</c:forEach>
        </table>
    </form>
</body>
</html>