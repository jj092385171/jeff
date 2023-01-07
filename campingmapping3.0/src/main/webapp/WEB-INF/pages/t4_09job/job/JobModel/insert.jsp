<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>

<style>
.c1 {
	width: 500px;
	border: 2px solid black;
	left: 500px;
	background-color: lightgray;
	color: blue;
	justify-content: center;
	align-items: center;
	margin: auto
}

.b {
	text-align: center;
}
</style>
</head>
<body>
	<form action="jobServletAdd.controller" method="POST"
		enctype="multipart/form-data">
		<div class="c1">

			<p>
				會員id <input type="text" name="uid" value='${param.uid}' required>
			</p>
			<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.id}</div>


			<hr>
			<p>
				職缺 <input type="hidden" id="ii" value="${param.ii}"> <select
					name="job">
					<option value="廚師">廚師</option>
					<option value="廚助">廚助</option>
					<option value="房務員">房務員</option>
					<option value="會計">會計</option>
					<option value="櫃台">櫃台</option>
					<option value="假日工讀生">假日工讀生</option>
					<option value="行政管理人員">行政管理人員</option>
					<option value="夜班保全">夜班保全</option>
					<option value="其他">其他</option>
				</select>
			</p>
			<hr>
			<p>
				薪資 <input type="text" name="salary" value='${param.salary}' required>
			</p>
			<hr>

			<p>
				人數 <input type="text" name="quantity" value='${param.quantity}'
					required>
			</p>
			<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.quantity}</div>
			<hr>

			<p>
				地點 <input type="text" name="place" value='${param.place}' required>
			</p>
			<hr>

			<p>
				可上班時段 <input type="text" name="time" value='${param.time}' required>
			</p>
			<hr>

			<p>
				可上班日期 <input type="text" name="date" value='${param.date}' required>
			</p>
			<hr>

			<p>
				上架日期 <input type="date" name="rackUp" value='${param.rackUp}'
					required>
			</p>
			<hr>

			<p>
				下架日期 <input type="date" name="rackDown" value='${param.rackDown}'
					required>
			</p>
			<hr>

			<p>
				照片上傳 <input type="file" name="img" value='${param.img}'>
			</p>
			<hr>

			<p>
				備註
				<textarea name="remark" cols="20" rows="5">${param.remark}</textarea>
			</p>

			<input type="submit" value="送出"> <input type="reset"
				value="取消">
		</div>
	</form>

	<form action="<c:url value='/t4_09job/job/JobModel/jobCRUD.jsp' />"
		method="POST" enctype="multipart/form-data">

		<div class="b">
			<button>回首頁</button>
		</div>
	</form>

	<script src="https://code.jquery.com/jquery-3.6.1.js">
		
	</script>


</body>
</html>