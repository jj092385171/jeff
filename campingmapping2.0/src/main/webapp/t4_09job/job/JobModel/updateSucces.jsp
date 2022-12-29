<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Update Succes</title>
<style>
.c1 {
	text-align: center
}

.b {
	text-align: center;
}

.c1 {
	width: 588px;
	left: 500px;
	color: blue;
	justify-content: center;
	align-items: center;
	margin: auto
}

.t1 {
	border: 2px black solid;
	border-color: black;
	background-color: lightblue;
}

.t2 {
	border: 2px solid;
	border-color: black;
	background-color: lightgreen;
}

.t3 {
	border: 2px solid;
}

.b {
	text-align: center;
}
</style>
</head>
<body>
	<h3 class="b">修改成功！</h3>
	<div class="c1">
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
			<tbody class="t2">

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
				</tr>
			</tbody>
		</table>
	</div>
	<form action="<c:url value='/t4_09job/job/JobModel/jobCRUD.jsp' />"
		method="POST" enctype="multipart/form-data">
		<div class="b">
			<button>回首頁</button>
		</div>
	</form>
</body>
</html>