<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Editorial by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>

<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">
				<!-- Banner -->
				<section id="banner">
					<div class="content">
						<header>
							<h1>後臺操作區</h1>
							<h2>謹慎操作！</h2>
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
						<h2>Menu</h2>
					</header>
					<form action="<c:url value='jobCRUD.controller'/>" method="post"
						enctype="multipart/form-data">
						<button>職缺刊登</button>
					</form>
					<form action="<c:url value=''/>" method="post"
						enctype="multipart/form-data">
						<button>人才查詢</button>
					</form>
					<form action="<c:url value=''/>" method="post"
						enctype="multipart/form-data">
						<button>刊登方案</button>
					</form>
					<form action="<c:url value=''/>" method="post"
						enctype="multipart/form-data">
						<button>職缺刊登</button>
					</form>
					<form action="<c:url value=''/>" method="post"
						enctype="multipart/form-data">
						<button>履歷</button>
					</form>
					

				</nav>

				<!-- Section -->


				<!-- Footer -->

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