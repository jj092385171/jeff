<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
							<h1>徵才區</h1>
							<h2>夥伴你好~</h2>
						</header>
						<p></p>
						<form action="<c:url value='/T4_09/job/CRUD/insert.jsp'/>">
							<button>新增職缺</button>
						</form>
						<form action="<c:url value='/T4_09/job/CRUD/select.jsp'/>">
							<button>查詢</button>
						</form>
						<form action="<c:url value='/JobServletShowAll' />">
							<button>全部</button>
						</form>
<!-- 						<ul class="actions"> -->
<!-- 							<li><a href="#" class="button big">Learn More</a></li> -->
<!-- 						</ul> -->
					</div>
					<span class="image object"> <img src="images/pic10.jpg"
						alt="" />
					</span>
				</section>

				<!-- Section -->
				<section>
					<header class="major">
						<h2>Erat lacinia</h2>
					</header>
					<div class="features">
						<article>
							<span class="icon fa-gem"></span>
							<div class="content">
								<h3>Portitor ullamcorper</h3>
								<p>Aenean ornare velit lacus, ac varius enim lorem
									ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
									nulla amet lorem feugiat tempus aliquam.</p>
							</div>
						</article>
						<article>
							<span class="icon solid fa-paper-plane"></span>
							<div class="content">
								<h3>Sapien veroeros</h3>
								<p>Aenean ornare velit lacus, ac varius enim lorem
									ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
									nulla amet lorem feugiat tempus aliquam.</p>
							</div>
						</article>
						<article>
							<span class="icon solid fa-rocket"></span>
							<div class="content">
								<h3>Quam lorem ipsum</h3>
								<p>Aenean ornare velit lacus, ac varius enim lorem
									ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
									nulla amet lorem feugiat tempus aliquam.</p>
							</div>
						</article>
						<article>
							<span class="icon solid fa-signal"></span>
							<div class="content">
								<h3>Sed magna finibus</h3>
								<p>Aenean ornare velit lacus, ac varius enim lorem
									ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
									nulla amet lorem feugiat tempus aliquam.</p>
							</div>
						</article>
					</div>
				</section>

				<!-- Section -->
				<section>
					<header class="major">
						<h2>Ipsum sed dolor</h2>
					</header>
					<div class="posts">
						<article>
							<a href="#" class="image"><img src="images/pic01.jpg" alt="" /></a>
							<h3>Interdum aenean</h3>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
								nulla amet lorem feugiat tempus aliquam.</p>
							<ul class="actions">
								<li><a href="#" class="button">More</a></li>
							</ul>
						</article>
						<article>
							<a href="#" class="image"><img src="images/pic02.jpg" alt="" /></a>
							<h3>Nulla amet dolore</h3>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
								nulla amet lorem feugiat tempus aliquam.</p>
							<ul class="actions">
								<li><a href="#" class="button">More</a></li>
							</ul>
						</article>
						<article>
							<a href="#" class="image"><img src="images/pic03.jpg" alt="" /></a>
							<h3>Tempus ullamcorper</h3>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
								nulla amet lorem feugiat tempus aliquam.</p>
							<ul class="actions">
								<li><a href="#" class="button">More</a></li>
							</ul>
						</article>
						<article>
							<a href="#" class="image"><img src="images/pic04.jpg" alt="" /></a>
							<h3>Sed etiam facilis</h3>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
								nulla amet lorem feugiat tempus aliquam.</p>
							<ul class="actions">
								<li><a href="#" class="button">More</a></li>
							</ul>
						</article>
						<article>
							<a href="#" class="image"><img src="images/pic05.jpg" alt="" /></a>
							<h3>Feugiat lorem aenean</h3>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
								nulla amet lorem feugiat tempus aliquam.</p>
							<ul class="actions">
								<li><a href="#" class="button">More</a></li>
							</ul>
						</article>
						<article>
							<a href="#" class="image"><img src="images/pic06.jpg" alt="" /></a>
							<h3>Amet varius aliquam</h3>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
								nulla amet lorem feugiat tempus aliquam.</p>
							<ul class="actions">
								<li><a href="#" class="button">More</a></li>
							</ul>
						</article>
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
						<!-- 						<li><a href="index.html">Homepage</a></li> -->
						<li><a href="">徵才區</a></li>
						<li><a href="elements.html">Elements</a></li>
						<li><span class="opener">Submenu</span>
							<ul>
								<li><a href="#">Lorem Dolor</a></li>
								<li><a href="#">Ipsum Adipiscing</a></li>
								<li><a href="#">Tempus Magna</a></li>
								<li><a href="#">Feugiat Veroeros</a></li>
							</ul></li>
						<li><a href="#">Etiam Dolore</a></li>
						<li><a href="#">Adipiscing</a></li>
						<li><span class="opener">Another Submenu</span>
							<ul>
								<li><a href="#">Lorem Dolor</a></li>
								<li><a href="#">Ipsum Adipiscing</a></li>
								<li><a href="#">Tempus Magna</a></li>
								<li><a href="#">Feugiat Veroeros</a></li>
							</ul></li>
						<li><a href="#">Maximus Erat</a></li>
						<li><a href="#">Sapien Mauris</a></li>
						<li><a href="#">Amet Lacinia</a></li>
					</ul>
				</nav>

				<!-- Section -->
				<section>
					<header class="major">
						<h2>Ante interdum</h2>
					</header>
					<div class="mini-posts">
						<article>
							<a href="#" class="image"><img src="images/pic07.jpg" alt="" /></a>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore aliquam.</p>
						</article>
						<article>
							<a href="#" class="image"><img src="images/pic08.jpg" alt="" /></a>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore aliquam.</p>
						</article>
						<article>
							<a href="#" class="image"><img src="images/pic09.jpg" alt="" /></a>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore aliquam.</p>
						</article>
					</div>
					<ul class="actions">
						<li><a href="#" class="button">More</a></li>
					</ul>
				</section>

				<!-- Section -->
				<section>
					<header class="major">
						<h2>Get in touch</h2>
					</header>
					<p>Sed varius enim lorem ullamcorper dolore aliquam aenean
						ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin
						sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat
						tempus aliquam.</p>
					<ul class="contact">
						<li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a></li>
						<li class="icon solid fa-phone">(000) 000-0000</li>
						<li class="icon solid fa-home">1234 Somewhere Road #8254<br />
							Nashville, TN 00000-0000
						</li>
					</ul>
				</section>

				<!-- Footer -->
				<footer id="footer">
					<p class="copyright">
						&copy; Untitled. All rights reserved. Demo Images: <a
							href="https://unsplash.com">Unsplash</a>. Design: <a
							href="https://html5up.net">HTML5 UP</a>.
					</p>
				</footer>

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