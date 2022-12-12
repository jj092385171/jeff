<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE HTML>
		<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
		<html>

		<head>
			<title>首頁</title>
			<meta charset="utf-8" />
			<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
			<link rel="stylesheet" href="assets/css/main.css" />


		</head>

		<body class="is-preload">

			<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
				<div id="main">
					<div class="inner">

						<!-- Header -->
						<header id="header">
							<a href="<c:url value='IndexShowAllPageServlet' />"
								class="logo"><strong>營地_營區位管理</strong></a>
							<ul class="icons">
								<li><a href="#" class="icon brands fa-twitter"><span class="label">Twitter</span></a>
								</li>
								<li><a href="#" class="icon brands fa-facebook-f"><span
											class="label">Facebook</span></a></li>
								<li><a href="#" class="icon brands fa-snapchat-ghost"><span
											class="label">Snapchat</span></a>
								</li>
								<li><a href="#" class="icon brands fa-instagram"><span
											class="label">Instagram</span></a></li>
								<li><a href="#" class="icon brands fa-medium-m"><span class="label">Medium</span></a>
								</li>
							</ul>
						</header>

						<!-- Content -->
					</div>
					<!-- Section -->
					<section>
						<header class="major">
							<h2>新增&emsp;營地_營區位</h2>
						</header>
						<div class="mini-posts">

							<body>
								<!-- Form -->
								<h3>新增營區位資料:</h3>

								<form method="post" action="" enctype="multipart/form-data">
									<div class="row gtr-uniform">
										<div class="col-6 col-12-xsmall">
											<input type="text" name="siteName" id="siteName" value="${param.siteName}"
												placeholder="營區位名" />
											<div style="color:#FF0000; font-size:60%; display: inline">
												${ErrorMsg.siteName}</div>
										</div>
										<div class="col-6 col-12-xsmall">
											<input id='sitePictures' name="sitePictures" type="file">
											<div style="color:#FF0000; font-size:60%; display: inline">
												${ErrorMsg.sitePictures}</div>
										</div>
										<div class="col-6 col-12-xsmall">
											<input type="text" name="totalSites" id="totalSites"
												value="${param.totalSites}" placeholder="總營位" />
											<div style="color:#FF0000; font-size:60%; display: inline">
												${ErrorMsg.totalSites}</div>
										</div>
										<div></div>
										<div></div>
										<div class="col-6 col-12-xsmall">
											<input type="text" name="siteMoney" id="siteMoney"
												value="${param.siteMoney}" placeholder="營位金額" />
											<div style="color:#FF0000; font-size:60%; display: inline">
												${ErrorMsg.siteMoney}</div>
										</div>

										<!-- Break -->

										<div></div>

										<form name="InsertSiteByIDForm">
											<div class="col-6 col-12-xsmall">
												營地編號: <input type="text" name='campID' id="campID" readonly="readonly"
													value='${ cctBean.campID }' />
											</div>
											<div class="col-6 col-12-xsmall">
												營地名: <input type="text" name='campName' id="campName"
													readonly="readonly" value='${ cctBean.campName }' />
											</div>
											<div class="col-6 col-12-xsmall">
												縣市編號: <input type="text" name='cityID' id="cityID" readonly="readonly"
													value='${ cctBean.cityID }' />
											</div>
											<div class="col-4 col-12-small">
												<input type="radio" name="cityIDXXX" id="${city.cityID}"
													value="${city.cityID}" readonly="readonly" checked>
												<label for="${city.cityID}">${city.cityName}</label>
											</div>
											<div class="col-6 col-12-xsmall">
												地址: <input type="text" name='location' id="location" readonly="readonly"
													value='${ cctBean.location }' />
											</div>
											<div class="col-6 col-12-xsmall">
												簡介: <input type="text" name='discription' id="discription"
													readonly="readonly" value='${ cctBean.discription }' />
											</div>
											<div class="col-6 col-12-small">
												<c:forEach var='tag' items='${tagList}'>
													<input type="checkbox" id="${tag.tagName}" name="tagIDXXX"
														value="${tag.tagID}" checked readonly="readonly">
													<label for="${tag.tagName}">${tag.tagName}</label>
												</c:forEach>
											</div>
											<div></div>
											<!-- Break -->
											<div class="col-12">
												<ul class="actions">
													<li><input type="submit" value="Add" class="primary" />
													</li>
													<li><input type="reset" value="Reset" /></li>
												</ul>
											</div>
										</form>


										<!-- <c:forEach var=' city' items='${cityList}'>
											<div class="col-4 col-12-small">

												<input type="radio" name="cityID" id="${city.cityID}"
													value="${city.cityID}">
												<label for="${city.cityID}">${city.cityName}</label>

											</div>
										</c:forEach> -->


									</div>
								</form>

						</div>
					</section>


					<table>
						<thead>
							<tr>
								<th>營地編號</th>
								<th>營地</th>
								<th>縣市編號</th>
								<th>縣市名</th>
								<th>地址</th>
								<th>圖片</th>
								<th>簡介</th>
								<th>標籤</th>
							</tr>
							<tr>
								<th>&emsp;&emsp;營位區編號</th>
								<th>&emsp;營位區名</th>
								<th>&emsp;營區位圖片</th>
								<th>&emsp;總營位</th>
								<th>&emsp;營位金額</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var='all' items='${showALL}'>
								<tr>
									<td>${ all.campID }</td>
									<td>${ all.campName }</td>
									<td>${ all.cityID }</td>
									<td>${ all.cityName }</td>
									<td>${ all.location }</td>
									<td>圖片:</td>
									<td>${ all.discription }</td>
									<td>
										<c:forEach var='tag' items='${all.tagList}'>
											${tag.tagName}&nbsp; / &nbsp;
										</c:forEach>
									</td>
								</tr>
								<c:forEach var='site' items='${all.siteList}'>
									<tr>
										<td>&emsp;&emsp;${ site.siteID }</td>
										<td>&emsp;${ site.siteName }</td>
										<td>&emsp;圖片:</td>
										<td>&emsp;${ site.totalSites }</td>
										<td>&emsp;${ site.siteMoney }</td>
									</tr>
								</c:forEach>
							</c:forEach>
						</tbody>
					</table>

				</div>

				<!-- Sidebar -->
				<div id="sidebar">
					<div class="inner">

						<!-- Search
																	<section id="search" class="alt">
																		<form method="post" action="#">
																			<input type="text" name="query" id="query" placeholder="Search" />
																		</form>
																	</section> -->

						<!-- Menu -->
						<nav id="menu">
							<header class="major">
								<h2>目錄</h2>
							</header>

							<ul>
								<li><a href="<c:url value='/T4_24/QueryPageServlet' />">&emsp;查詢&emsp;營地_營區位</a>
								</li>
								<li><a href="<c:url value='/T4_24/InsertPageServlet' />">&emsp;新增&emsp;營地_營位區</a>
								</li>
								<li><a href="<c:url value='/T4_24/UpdatePage.jsp' />">&emsp;修改&emsp;營地_營區位</a></li>
								<li><a href="<c:url value='/T4_24/deletePage.jsp' />">&emsp;刪除&emsp;營地_營區位</a></li>
							</ul>
							<!-- <li>
									<span class="opener">Submenu</span>
									<ul>
										<li><a href="#">Lorem Dolor</a></li>
										<li><a href="#">Ipsum Adipiscing</a></li>
										<li><a href="#">Tempus Magna</a></li>
										<li><a href="#">Feugiat Veroeros</a></li>
									</ul>
								</li> -->
						</nav>



						<!-- Footer -->
						<footer id="footer">
							<p class="copyright">
								&copy; Untitled. All rights reserved. Demo Images: <a
									href="https://unsplash.com">Unsplash</a>.
								Design: <a href="https://html5up.net">HTML5 UP</a>.
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