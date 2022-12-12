<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>Job CRUD</title>
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
							<h1>徵才區</h1>
							<h2>夥伴你好~</h2>
						</header>
						<p></p>
						<form action="<c:url value='/T4_09/job/JobModel/insert.jsp'/>">
							<button>新增職缺</button>
						</form>
						<form action="<c:url value='/T4_09/job/JobModel/select.jsp'/>">
							<button>查詢</button>
						</form>
						<form action="<c:url value='/JobServletShowAll' />">
							<button>全部資料</button>
						</form>					
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
					<ul>
						<li><a href="http://localhost:8080/campingmapping/T4_09/job/JobModel/jobCRUD.jsp">職缺刊登</a></li>
						<li><a href=" ">人才查詢</a></li>
						<li><a href=" ">刊登方案</a></li>
						<li><a href="#">證照中心</a></li>
						<li><a href="#">履歷</a></li>
					</ul>
				</nav>		
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