<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<title>Elements - Editorial by HTML5 UP</title>
			<meta charset="utf-8" />
			<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
			<link rel="stylesheet" href="background/assets/css/main.css" />
			<style>
				#model {
					width: 500px;
					height: 300px;
				}
			</style>
		</head>

		<body class="is-preload">
			<div id="model">

				<div id="wrapper">

					<div id="main">
						<div class="inner">



								<header class="main">
									<h1>新增</h1>
								</header>

								<hr class="major" />

								<div class="col-6 col-12-medium">

									<form action="<c:url value='/controller'/>" method="POST">
										發文會員:<input type="text" id="postmember" name="postmember" onkeyup="value=value.replace(/[^\d]/g,'') " 
										required placeholder="請輸入會員編號,僅限數字"><br>
										起始日期:<input type="date" id="startdate" name="startdate" required><br>
										結束日期:<input type="date" id="enddate" name="enddate" required><br>
										現有人數:<input type="text" id="currentnum" name="currentnum" onkeyup="value=value.replace(/[^\d]/g,'') " 
										required placeholder="請輸入現有人數,僅限數字"><br>
										接受人數:<input type="text" id="acceptnum" name="acceptnum" onkeyup="value=value.replace(/[^\d]/g,'') " 
										required placeholder="請輸入接受人數,僅限數字"><br>
										露營地點:<input type="text" id="camparea" name="camparea"  required placeholder="請輸入露營地點"><br>
										配對狀態:<input type="hidden" id="pair" name="pair" value="0" required><br> 
										<input type="submit" id="test"	value="送出">
									</form>


								</div>
						</div>


					</div>
				</div>
			</div>




		</body>

		</html>