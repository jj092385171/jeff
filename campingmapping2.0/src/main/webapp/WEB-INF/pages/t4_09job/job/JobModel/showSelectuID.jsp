<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Select uID</title>
</head>
<body>
<table class="t1">
		<thead>
			<tr>
				<th>uID</th>
				<th>刊登編號</th>
				<th>職缺</th>
				<th>薪水</th>
				<th>人數</th>
				<th>地點</th>
				<th>上班時段</th>
				<th>上班日期</th>
				<th>照片</th>
				<th>備註</th>
				<th>上架日期</th>
				<th>下架日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="JobBean" items="${jobBean}">
				<tr>

					<td>${JobBean.uID}</td>
					<td>${JobBean.rackID}</td>
					<td>${JobBean.job}</td>
					<td>${JobBean.salary}</td>
					<td>${JobBean.quantity}</td>
					<td>${JobBean.place}</td>
					<td>${JobBean.date}</td>
					<td>${JobBean.time}</td>
					<td><img width="80" height="100"
						src="<c:url value='/JobServletImg?id=${JobBean.rackID}'/>" /></td>
					<td>${JobBean.remark}</td>
					<td>${JobBean.rackUp}</td>
					<td>${JobBean.rackDown}</td>
					<td>
						<form
							action="<c:url value='/JobServletDelete?de=${JobBean.rackID}'/>"
							method="POST" enctype="multipart/form-data">
							<button>刪除</button>
						</form>
						<form
							action="<c:url value='/JobServletFindBean?up=${JobBean.rackID}'/>"
							method="POST" enctype="multipart/form-data">
							<button>修改</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<form action="<c:url value='/t4_09job/job/JobModel/jobCRUD.jsp' />">
		<button>回首頁</button>
	</form>
</body>
</html>