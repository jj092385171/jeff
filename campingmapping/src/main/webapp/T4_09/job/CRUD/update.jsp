<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
}
</style>
</head>
<body>
	<form action="<c:url value='/JobServletUpdate'/>" method="POST"
		enctype="multipart/form-data">
		<div class="c1">


			<p>
				會員id <input type="text" name="id" value="${JobBean.uID}">
			</p>

			<p>
				刊登編號 <input type="text" name="rackID" value="${JobBean.rackID}" readonly>
			</p>
			
			<hr>

			<p>職缺
				<%-- 				職缺 <input type="text" name="job" value="${JobBean.job}"> --%>
			<select name="job" value="${JobBean.job}">
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
				薪資 <input type="text" name="salary" value="${JobBean.salary}">
			</p>
			<hr>


			<p>
				人數 <input type="text" name="quantity" value="${JobBean.quantity}">
			</p>
			<hr>


			<p>
				地點 <input type="text" name="place" value="${JobBean.place}">
			</p>
			<hr>


			<p>
				可上班時段 <input type="text" name="time" value="${JobBean.date}">
			</p>
			<hr>


			<p>
				可上班日期 <input type="text" name="date" value="${JobBean.time}">
			</p>
			<hr>


			<p>
				上架日期 <input type="date" name="rackUp" value="${JobBean.rackUp}">
			</p>
			<hr>


			<p>
				下架日期 <input type="date" name="rackDown" value="${JobBean.rackDown}">
			</p>
			<hr>

			<p>
				照片上傳 <input type="file" name="img">
			</p>
			<hr>
			<p>
				備註
				<textarea value="${JobBean.img}" name="remark" cols="20" rows="5" ></textarea>
			</p>

			<input type="submit" value="儲存"> 
			<input type="reset"value="取消">

		</div>

	</form>
	<form action="<c:url value='/T4_09/job/jobIndex.jsp' />">
		<button>回首頁</button>
	</form>
</body>
</html>