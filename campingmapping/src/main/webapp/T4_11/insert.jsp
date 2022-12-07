<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>Insert</title>
			<style>
				form {
					margin: auto;
					width: 300px;
				}

				form input {
					margin: 20px;
					width: auto;
				}
			</style>
		</head>

		<body>
			<form action="<c:url value='/controller'/>" method="POST">
				<h2>新增</h2>
				發文會員:<input type="text" id="member" name="member"><br>
				起始日期:<input type="date" id="startdate" name="startdate"><br>
				結束日期:<input type="date" id="enddate" name="enddate"><br>
				現有人數:<input type="text" id="currentnum" name="currentnum"><br>
				接受人數:<input type="text" id="acceptnum" name="acceptnum"><br>
				露營地點:<input type="text" id="camparea" name="camparea"><br>
				配對狀態:<input type="text" id="pair"><br>
				<input type="submit" id="test" value="送出">
			</form>
			<form action="">

			</form>
			<script src="../jquery-3.6.1.js"></script>
			<script>
				$(function () {
					$('#test').on('click', function () {
						console.log($('#member').val());
						console.log($('#startdate').val());
						console.log($('#enddate').val());
						console.log($('#currentnum').val());
						console.log($('#acceptnum').val());
						console.log($('#pair').val());
					})
				});
			</script>
		</body>

		</html>