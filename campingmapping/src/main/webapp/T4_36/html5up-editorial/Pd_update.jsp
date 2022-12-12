<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>

<head>
	<title>修改商品細項</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="http://localhost:8080/campingmapping/T4_36/html5up-editorial/assets/css/main.css" />
</head>

<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="#" class="logo"><strong>修改商品細項</strong> by team4</a>
					<ul class="icons">
						<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="#" class="icon brands fa-facebook-f"><span class="label">Facebook</span></a></li>
						<li><a href="#" class="icon brands fa-snapchat-ghost"><span class="label">Snapchat</span></a>
						</li>
						<li><a href="#" class="icon brands fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a></li>
					</ul>
				</header>

<form action="<c:url value='/CategoryUpdateServlet.do'/>" method="POST"
		enctype="multipart/form-data">
		產品編號(pk)<br> 
		<input type="text" value='${Category.pdid}' name="Pdid"  />會員ID<br> 
		<input type="text" value='${Category.userID}' name="userID">產品名稱<br> 
		<input type="text" value='${Category.pdname}' name="Pdname">品牌名稱<br> 
		<input type="text" value='${Category.pdtitle}' name="Pdtitle">產品規格<br> 
		<input type="text" value='${Category.pdcontent}' name="Pdcontent">產品類型<br>
		<input type="text" value='${Category.pdtype}' name="Pdtype">照片<br>
		<input type="text" value='${Category.pdpicture}' name="Pdpicture" readonly="readonly" />價位<br> 
		<input type="text" value='${Category.pdprice}' name="Pdprice">庫存數量<br> 
		<input type="text" value='${Category.pdinventory}' name="Pdinventory">上架日期<br> 
		<input type="text" value='${Category.pddate}' name="Pddate" readonly="readonly" />商品更新日期<br>
		<input type="text" value="2020-12-23 15:40:45" name="Pdlastupdate">
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
						<li><a href="http://localhost:8080/campingmapping/T4_36/html5up-editorial/Pd_index.jsp">首頁</a></li>
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
				<footer id="footer">
					<p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a
							href="https://unsplash.com">Unsplash</a>. Design: <a href="https://html5up.net">HTML5
							UP</a>.</p>
				</footer>

			</div>
		</div>

	</div>

	<!-- Scripts -->
	<script src="http://localhost:8080/campingmapping/T4_36/html5up-editoria/js/jquery.min.js"></script>
	<script src="http://localhost:8080/campingmapping/T4_36/html5up-editoria/js/browser.min.js"></script>
	<script src="http://localhost:8080/campingmapping/T4_36/html5up-editoria/js/breakpoints.min.js"></script>
	<script src="http://localhost:8080/campingmapping/T4_36/html5up-editoria/js/util.js"></script>
	<script src="http://localhost:8080/campingmapping/T4_36/html5up-editoria/js/main.js"></script>

</body>

</html>