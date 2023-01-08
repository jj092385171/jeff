<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Update</title>

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
	<form action="<c:url value='update.controller'/>" method="POST"
		enctype="multipart/form-data">
		<div class="c1">

			<p>
				刊登編號 <input type="text" name="rackID"
					value="${JobBean.rackID}${param.rackID} " readonly>
			</p>
			<hr>
			
			<p>
				會員id <input type="text" name="uid"
					value="${JobBean.uID}${param.uid}" required>
			</p>
			<div style="color: #FF0000; font-size: 60%; display: inline">${errors.id}</div>
			<hr>

			<p>
				職缺 <input type="hidden" id="ii" value="${JobBean.job}${param.ii}">
				<select name="job">
					<option class="1" value="廚師">廚師</option>
					<option class="2" value="廚助">廚助</option>
					<option class="3" value="房務員">房務員</option>
					<option class="4" value="會計">會計</option>
					<option class="5" value="櫃台">櫃台</option>
					<option class="6" value="假日工讀生">假日工讀生</option>
					<option class="7" value="行政管理人員">行政管理人員</option>
					<option class="8" value="夜班保全">夜班保全</option>
					<option class="9" value="其他">其他</option>
				</select>
			</p>
			<hr>

			<p>
				薪資 <input type="text" name="salary"
					value="${JobBean.salary}${param.salary}" required>
			</p>
			<hr>

			<p>
				人數 <input type="text" name="quantity"
					value="${JobBean.quantity}${param.quantity}" required>
			</p>
			<div style="color: #FF0000; font-size: 60%; display: inline">${errors.quantity}</div>
			<hr>


			<p>
				地點 <input type="text" name="place"
					value="${JobBean.place}${param.place}" required>
			</p>
			<hr>

			<p>
				可上班時段 <input type="text" name="time"
					value="${JobBean.date}${param.time}" required>
			</p>
			<hr>

			<p>
				可上班日期 <input type="text" name="date"
					value="${JobBean.time}${param.date}" required>
			</p>
			<hr>

			<p>
				上架日期 <input type="date" name="rackUp"
					value="${JobBean.rackUp}${param.rackUp}" required>
			</p>
			<hr>

			<p>
				下架日期 <input type="date" name="rackDown"
					value="${JobBean.rackDown}${param.rackDown}" required>
			</p>
			<hr>

			<p>
				照片更新 <input type="file" name="img"><img width="80"
					height="100"
					src="<c:url value='img.controller?id=${JobBean.rackID}${param.img}'/>" />
			</p>
			<hr>
			<p>
				備註
				<textarea name="remark" cols="20" rows="5">${JobBean.remark}${param.remark}</textarea>
			</p>

			<input type="submit" value="儲存"> <input type="reset"
				value="取消">
		</div>
	</form>
	<form action="<c:url value='jobCRUD.controller' />" method="POST"
		enctype="multipart/form-data">
		<div class="b">
			<button>回首頁</button>
		</div>
	</form>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.6.1.js"></script>
	<script>
		var v = $('#ii').val();
		console.log(v)
		switch (v) {
		case '廚師':
			$(".1").attr('selected', true)
			break;
		case '廚助':
			$(".2").attr('selected', true)
			break;
		case '房務員':
			$(".3").attr('selected', true)
			break;
		case '會計':
			$(".4").attr('selected', true);
			break;
		case '櫃台':
			$(".5").attr('selected', true)
			break;
		case '假日工讀生':
			$(".6").attr('selected', true)
			break;
		case '行政管理人員':
			$(".7").attr('selected', true)
			break;
		case '夜班保全':
			$(".8").attr('selected', true)
			break;
		case '其他':
			$(".9").attr('selected', true)
			break;
		}
	</script>


</body>

</html>