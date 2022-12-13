<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE HTML>

		<html>
		<% String path=request.getContextPath(); String basePath=request.getScheme() + "://" + request.getServerName()
			+ ":" + request.getServerPort() + path + "/T4_11/background/assets/css/main.css" ; %>

			<head>
				<title>揪團管理</title>
				<meta charset="utf-8" />
				<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
				<!-- 	<link rel="stylesheet" href="../T4_11/background/assets/css/main.css" /> -->
				<link rel="stylesheet" href="<%=basePath%>" />
				<style>
 					hr { 
 						margin: 10px; 
 						border-color: transparent; 
 					} 

				</style>
			</head>

			<body class="is-preload">

				<!-- Wrapper -->
				<div id="wrapper">

					<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
							<header id="header">
								<a href="index.html" class="logo"><strong>揪團</strong> 管理者</a>
								<ul class="icons">
									<li><a href="#" class="icon brands fa-twitter"><span
												class="label">Twitter</span></a></li>
									<li><a href="#" class="icon brands fa-facebook-f"><span
												class="label">Facebook</span></a></li>
									<li><a href="#" class="icon brands fa-snapchat-ghost"><span
												class="label">Snapchat</span></a>
									</li>
									<li><a href="#" class="icon brands fa-instagram"><span
												class="label">Instagram</span></a></li>
									<li><a href="#" class="icon brands fa-medium-m"><span
												class="label">Medium</span></a></li>
								</ul>
							</header>

							<!-- Banner -->
							
							<section id="banner">
								<div class="content">
									<header>
										<h1>一起來
											露營吧</h1>
										<p>請選擇您想執行的選項</p>
									</header>
									<p>因為很想要體驗露營、交交新朋友可是自己工作關係生活圈沒那麼廣，想問有人知道有哪些社團還是社群會開放揪露營，然後大家認識認識一起玩
										我是認真想認識新朋友體驗露營，也可以後續買裝備大家多多一起出門露營⛺️</p>
									<form action="<c:url value='/select'/>" method="POST">
									<ul class="actions">
									
										<li><input type="submit" value="查詢"></li>
										<li>起始日期: <input type="date" id="startdate" name="startdate"></li>
										<li>結束日期: <input type="date" id="enddate" name="enddate"></li>
										<li><select name="initiatingnum">
										<option value="0">請選擇揪團號碼</option>
										<c:forEach var="bean" items="${view}">
										<option value="${bean.initiatingnum}">${bean.initiatingnum}</option>
										</c:forEach>
										</select></li>
										<li><select name="postmember">
										<option value="0">請選擇發文會員</option>
										<c:forEach var="bean" items="${postmember}">
										<option value="${bean.postmember}">${bean.postmember}</option>										
										</c:forEach>
										</select></li>
										<li><select name="camparea">
										<option value="0">請選擇露營地點</option>
										<c:forEach var="bean" items="${camparea}">
										<option value="${bean.camparea}">${bean.camparea}</option>
										</c:forEach>
										</select></li>
									</ul>
									</form>
								</div>
								
							</section>

							<!-- Section -->
							<div class="image object">
									<table>
										<thead>
											<tr>
												<td width="88px">揪團號碼</td>
												<td width="88px">發文會員</td>
												<td>發文日期</td>
												<td>起始日期</td>
												<td>結束日期</td>
												<td width="88px">已有人數</td>
												<td width="88px">接受人數</td>
												<td width="88px">露營地點</td>
												<td width="88px">配對狀態</td>
											</tr>
										</thead>
										<c:forEach var="bean" items="${view2}">
											<tr>
												<td>${bean.initiatingnum}</td>
												<td>${bean.postmember}</td>
												<td class="tendigits">${bean.postdate}</td>
												<td class="tendigits">${bean.startdate}</td>
												<td class="tendigits">${bean.enddate}</td>
												<td>${bean.currentnum}</td>
												<td>${bean.acceptablenum}</td>
												<td>${bean.camparea}</td>
												<td class="pair">${bean.pair}</td>
											</tr>
										</c:forEach>
									</table>
								</div>
								<div class="image object">
									<table id="table">
										<thead>
											<tr>
												<td><a href="/campingmapping/T4_11/insert.jsp" class="button big">新增</a></td>
												<td width="88px">揪團號碼</td>
												<td width="88px">發文會員</td>
												<td>發文日期</td>
												<td>起始日期</td>
												<td>結束日期</td>
												<td width="88px">已有人數</td>
												<td width="88px">接受人數</td>
												<td width="88px">露營地點</td>
												<td width="88px">配對狀態</td>
											</tr>
										</thead>
										<c:forEach var="bean" items="${view}">

											<tr>
												<td>
													<form action="<c:url value='/delete'/>" method="POST"><input
															type="hidden" name="delete" value="${bean.initiatingnum}">
														<hr><input type="submit" value="刪除">
													</form>
													<form action="<c:url value='/alter'/>" method="POST"><input
															type="hidden" name="alter" value="${bean.initiatingnum}">
														<hr><input type="submit" value="修改">
													</form>
												</td>
												<td>${bean.initiatingnum}</td>
												<td>${bean.postmember}</td>
												<td class="tendigits">${bean.postdate}</td>
												<td class="tendigits">${bean.startdate}</td>
												<td class="tendigits">${bean.enddate}</td>
												<td>${bean.currentnum}</td>
												<td>${bean.acceptablenum}</td>
												<td>${bean.camparea}</td>
												<td class="pair">${bean.pair}</td>
											</tr>
										</c:forEach>
									</table>
								</div>
								

							<!-- Section -->
							

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
									<h2>主選單</h2>
								</header>
								<ul>
									<li><a href="/campingmapping/index.jsp"">首頁</a></li>
									<li><a href="generic.html">露友專區</a></li>
									<li><a href="elements.html">徵才專區</a></li>
									<li>
										<span class="opener">營區預定</span>
										<ul>
											<li><a href="#">裝備交流</a></li>
											<li><a href="<c:url value='/view'/>">我要揪團</a></li>
											<li><a href="#">論壇社群</a></li>
											<li><a href="#">關於我們</a></li>
										</ul>
									</li>
									<li><a href="#">裝備交流</a></li>
									<li><a href="#">論壇社群</a></li>
									<li>
										<span class="opener">關於我們</span>
										<ul>
											<li><a href="#">Ipsum Adipiscing</a></li>
											<li><a href="#">Tempus Magna</a></li>
											<li><a href="#">Feugiat Veroeros</a></li>
										</ul>
									</li>
									<li><a href="<c:url value='/view'/>">我要揪團</a></li>
								</ul>
							</nav>

							<!-- Section -->
							<section>
								<header class="major">
									<h2>CampingMapping</h2>
								</header>
								<div class="mini-posts">
									<article>
										<a href="#" class="image"><img src="images/pic07.jpg" alt="" /></a>
										<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.
										</p>
									</article>
									<article>
										<a href="#" class="image"><img src="images/pic08.jpg" alt="" /></a>
										<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.
										</p>
									</article>
									<article>
										<a href="#" class="image"><img src="images/pic09.jpg" alt="" /></a>
										<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore aliquam.
										</p>
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
								<p>Sed varius enim lorem ullamcorper dolore aliquam aenean ornare velit lacus, ac varius
									enim lorem
									ullamcorper dolore. Proin sed aliquam facilisis ante interdum. Sed nulla amet lorem
									feugiat
									tempus aliquam.</p>
								<ul class="contact">
									<li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a></li>
									<li class="icon solid fa-phone">(0800) 761-761</li>
									<li class="icon solid fa-home">1234 Somewhere Road #8254<br />
										Nashville, TN 00000-0000</li>
								</ul>
							</section>

							<!-- Footer -->
							<footer id="footer">
								<p class="copyright">&copy; Untitled. All rights reserved. Demo Images: <a
										href="https://unsplash.com">Unsplash</a>. Design: <a
										href="https://html5up.net">HTML5
										UP</a>.</p>
							</footer>

						</div>
					</div>

				</div>

				<!-- Scripts -->
				<script src="../jquery-3.6.1.js"></script>
				<% String basePath2=request.getScheme() + "://" + request.getServerName() + ":" +
					request.getServerPort() + path + "assets/js/jquery.min.js" ; %>
					<% String basePath3=request.getScheme() + "://" + request.getServerName() + ":" +
						request.getServerPort() + path + "assets/js/browser.min.js" ; %>
						<% String basePath4=request.getScheme() + "://" + request.getServerName() + ":" +
							request.getServerPort() + path + "assets/js/breakpoints.min.js" ; %>
							<% String basePath5=request.getScheme() + "://" + request.getServerName() + ":" +
								request.getServerPort() + path + "assets/js/util.js" ; %>
								<% String basePath6=request.getScheme() + "://" + request.getServerName() + ":" +
									request.getServerPort() + path + "assets/js/main.js" ; %>
									<script src="<%=basePath2%>"></script>
									<script src="<%=basePath3%>"></script>
									<script src="<%=basePath4%>"></script>
									<script src="<%=basePath5%>"></script>
									<script src="<%=basePath6%>"></script>
				<script>
				var el = document.querySelectorAll('.pair');
				console.log(el.length);
				for(var i = 0; i<el.length ; i++) {
					console.log(el[i].innerText);
					if(el[i].innerText == 0){
						el[i].innerText = "可配對";
					}else{
						el[i].innerText = "不可配對";
					}
				}
				var date = document.querySelectorAll('.tendigits');
				console.log(date.length);
				for(var j = 0; j < date.length; j++){
					var tendigitsdate = date[j].innerText.substr(0,10);
					date[j].innerText = tendigitsdate;
				}
				</script>
			</body>

		</html>