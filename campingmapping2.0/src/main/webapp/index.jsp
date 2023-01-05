<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE HTML>
		<html lang="zh">

		<head>

			<title>CampingMapping</title>
			<meta charset="utf-8" />
			<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
			<link rel="stylesheet" href="assets/css/main.css" />
			<noscript>
				<link rel="stylesheet" href="assets/css/noscript.css" />
			</noscript>
			<script src="https://kit.fontawesome.com/c5dcdb1f13.js" crossorigin="anonymous"></script>


		</head>

		<body class="is-preload">
			<div>
				<nav style="z-index:9999;position: relative;margin-top: 1%	;margin-left: 1% ;float: right;">
					<input type="button" value="登入" id="sign">
					<input type="button" value="登出" id="out">
				</nav>
			</div>
			<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
				<header id="header">
					<div class="logo">
						<span class="fa-solid fa-tent fa-2xl"></span>
					</div>
					<div class="content">
						<div class="inner">
							<h1>CampingMapping</h1>
							<p></p>
						</div>
					</div>
							<form method="POST">
					<nav>
						<ul class="header-nav1">
							<li class="nav1-li"><a href="#about">About</a></li>
							<li class="nav1-li"><a href="<c:url value='/T4_11/TeamUser.jsp'/>">Team</a></li>
							<li class="nav1-li"><a href="<c:url value='/T4_24/campUser/CampUser.jsp'/>">Camp</a></li>
							<input type="submit" formaction="<c:url value='/T4_33/showDiscussionServlet' />" value="Forum">
							<li class="nav1-li"><a href="<c:url value='/T4_33/showDiscussionServlet'/>">Forum</a></li>
							<li class="nav1-li"><a href="<c:url value='/T4_36/shopUser/ShopUser.jsp'/>">Shop</a></li>
							<li class="nav1-li"><a href="<c:url value='/t4_09job/jobUser/JobUser.jsp'/>">Job</a></li>
							<li class="nav1-li"><a href="<c:url value='/T4_01/userMember/userMamber.html'/>">Member</a>
							</li>
							<!--<li><a href="#elements">Elements</a></li>-->
						</ul>
					</nav>
							</form>
				</header>



				<!-- Footer -->
				<footer id="footer">
					<p class="copyright">footer</p>
				</footer>

			</div>

			<!-- BG -->
			<div id="bg"></div>

			<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

		</body>

		</html>