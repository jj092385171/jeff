<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
}
</style>
</head>
<body>
	<form action="<c:url value='/T4_09/JobServletAdd'/>" method="POST"
		enctype="multipart/form-data">
		<div class="c1">

			<p>
				會員id <input type="text" name="id" required>>
			</p>
			<hr>
			<p>
				刊登編號 <input class="cl" type="text" name="rackID" required></p>
				<div style="color:#FF0000; font-size:60%; display: inline">${ErrorMsg.rackID}</div>
			
			<hr>
			<p>職缺
			<select name="job">
			<option value="廚師">廚師</option>
			<option value="廚助">廚助</option>
			<option value="房務員">房務員</option>
			<option value="會計">會計</option>
			<option value="櫃台">櫃台</option>
			<option value="假日工讀生">假日工讀生</option>
			<option value="行政管理人員">行政管理人員</option>
			<option value="其他">其他</option>
			</select>
			</p>
			<hr>
			<p>
				薪資 <input type="text" name="salary" required>>
			</p>
			<hr>

			<p>
				人數 <input type="text" name="quantity" required>>
			</p>
			<hr>

			<p>
				地點 <input type="text" name="place" required>>
			</p>
			<hr>

			<p>
				可上班時段 <input type="text" name="time" required>>
			</p>
			<hr>

			<p>
				可上班日期 <input type="text" name="date" required>>
			</p>
			<hr>

			<p>
				上架日期 <input type="date" name="rackUp" required>>
			</p>
			<hr>

			<p>
				下架日期 <input type="date" name="rackDown" required>>
			</p>
			<hr>

			<p>
				照片上傳 <input type="file" name="img" required>>
			</p>
			<hr>

			<p>
				備註
				<textarea name="remark" cols="20" rows="5"></textarea>
			</p>

			<input type="submit" value="送出"> <input type="reset"
				value="取消">
		</div>
	</form>
	<form action="<c:url value='/T4_09/job/jobIndex.jsp' />">
		<button>回首頁</button>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.6.1.js">
	
		$('input').attr('required',true)},	
	
	</script>
	
	
</body>
</html>