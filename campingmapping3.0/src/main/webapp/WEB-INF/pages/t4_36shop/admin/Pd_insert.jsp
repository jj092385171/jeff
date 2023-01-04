<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>

<head>
	<title>新增商品</title>
	<meta charset="utf-8" />
<!-- 	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" /> -->
<!-- 	<link rel="stylesheet" href="assets/css/main.css" /> -->
</head>

<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="#" class="logo"><strong>新增商品</strong></a>
<!-- 					<ul class="icons"> -->
<!-- 						<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li> -->
<!-- 						<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li> -->
<!-- 						<li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a> -->
<!-- 						</li> -->
<!-- 						<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li> -->
<!-- 						<li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a></li> -->
<!-- 					</ul> -->
				</header>

<!-- 	<form action="<c:url value='/T4_36/servler/Category/insertServlet.do'/>" method="GET"
	enctype="multipart/form-data"> -->
	<form action="<c:url value='/Pd_insertServlet.do'/>" method="POST" enctype="multipart/form-data">
		會員ID<br> 
		<input type="text" value='1' name="userID">產品名稱<br> 
		<input type="text" value='1' name="Pdname">品牌名稱<br> 
		<input type="text" value='1' name="Pdtitle">產品規格<br> 
		<input type="text" value='1' name="Pdcontent">產品類型<br>
		<select name="Pdtype">
    	<option>請選擇產品類別</option>
   	 	<option>睡袋</option>
   	 	<option>燈具</option>
   	 	<option>桌椅</option>
   		 <option>火爐/炊具</option>
   		 <option>保冷箱</option>
   		 <option>登山包</option>
  		  <option>戶外服裝</option>
  		  <option>登山鞋</option>
  		  <option>其他</option>
		</select>照片<br> 
		<input type="file" name="picture"/><br>價位<br>
		<input type="text" value='1' name="Pdprice"> 庫存數量<br> 
		<input type="text" value='1' name="Pdinventory">商品建立日期<br> 
		<input type="text" value ="2020-12-23 15:40:45" name="Pddate">商品更新日期<br>
		<input type="text" value ="2020-12-23 15:40:45" name="Pdlastupdate"> <br>
		<input type="submit" value="提交">
	</form>
				<!-- Banner -->
				<section id="banner">
					<div class="content">
						<header>
						</header>
					</div>
				</section>


			</div>
		</div>

		<!-- Sidebar -->
		<div id="sidebar">
			<div class="inner">

				<!-- Search -->
				<section id="search" class="alt">
					<form method="post" action="#">
						<input type="text" name="query" id="query" placeholder="Search" />
					</form>
				</section>

				<!-- Menu -->
				<nav id="menu">
					<header class="major">
						<h2>商城</h2>
					</header>
					<ul>
						<li><a href="/campingmapping/index.jsp">首頁</a></li>
						<li><a href="<c:url value='/SelectAllServlet.do'/>">商城維護</a></li>
						<li>
							<span class="opener">商品分類</span>
							<ul>
								<li><a href="#">睡袋</a></li>
								<li><a href="#">燈具</a></li>
								<li><a href="#">桌椅</a></li>
								<li><a href="#">火爐/炊具</a></li>
								<li><a href="#">保冷箱</a></li>
								<li><a href="#">登山包</a></li>
								<li><a href="#">戶外服裝</a></li>
								<li><a href="#">登山鞋</a></li>
							</ul>
						</li>
						<li><a href="#">訂單管理</a></li>
						<li><a href="#">登入</a></li>
					</ul>
				</nav>


				<!-- Footer -->
<!-- 				<footer id="footer"> -->
<!-- 					<p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a -->
<!-- 							href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5 -->
<!-- 							UP</a>.</p> -->
<!-- 				</footer> -->

			</div>
		</div>

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>

</html>