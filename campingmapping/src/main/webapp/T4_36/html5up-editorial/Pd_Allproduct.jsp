<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>

<head>
<title>camp 商城首頁</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="http://localhost:8080/campingmapping/T4_36/html5up-editorial/assets/css/main.css" />
</head>

<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<section></section>
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="#" class="logo"><strong>商城維護</strong> by team4</a>
					<ul class="icons">

						<li><a href="#" class="icon brands fa-twitter"><span
								class="label">Twitter</span></a></li>
						<li><a href="#" class="icon brands fa-facebook-f"><span
								class="label">Facebook</span></a></li>
						<li><a href="#" class="icon brands fa-snapchat-ghost"><span
								class="label">Snapchat</span></a></li>
						<li><a href="#" class="icon brands fa-instagram"><span
								class="label">Instagram</span></a></li>
						<li><a href="#" class="icon brands fa-medium-m"><span
								class="label">Medium</span></a></li>
					</ul>
				</header>
				<div class="container">

					<!-- Page Heading -->
					<!-- 					<h1 class="h3 mb-4 text-gray-800">商城維護</h1> -->
					<div>
						<form
							action="<c:url value='http://localhost:8080/campingmapping/T4_36/html5up-editorial/Pd_insert.jsp'/>"
							method="POST">
							<input type="submit" value="新增產品"
								style="width: 105px; height: 50px;">
						</form>
						<%-- <form action="<c:url value='#'/>" --%>
						<!-- 							method="POST"> -->
						<!-- 							<input type="submit" value="購物車測試"  style="width:100px;height:45px;"> -->
						<!-- 						</form> -->
					</div>
					<form id="form1" name="form1" method="post"
						action="SelectAllServlet.do" enctype="multipart/form-data">

						<table id="productlist" style="width: 1050px;">
							<thead>
								<tr>
									<th>產品編號</th>
									<th>會員ID</th>
									<th>產品名稱</th>
									<th>品牌</th>
									<th>規格</th>
									<th>類型</th>
									<th>照片</th>
									<th>價格</th>
									<th>庫存數量</th>
									<th>商品發售日期</th>
									<th>商品修改日期</th>
									<th>修改產品</th>
									<th>刪除產品</th>

								</tr>
							</thead>
							<tbody>
								<c:forEach var='Category' items='${AllList}' varStatus="statusX">
									<tr>

										<td>${Category.pdid}</td>
										<td>${Category.userID}</td>
										<td>${Category.pdname}</td>
										<td>${Category.pdtitle}</td>
										<td>${Category.pdcontent}</td>
										<td>${Category.pdtype}</td>
										<td>${Category.pdpicture}</td>
										<td>${Category.pdprice}</td>
										<td>${Category.pdinventory}</td>
										<td>${Category.pddate}</td>
										<td>${Category.pdlastupdate}</td>

										<td><input name="ProductId" type="hidden"
											id="${Category.pdid}" value="${Category.pdid}" /> <input
											type="button" style="border-radius: 60%" name="delete"
											value="修改" onclick="updateProduct(${Category.pdid})" /></td>
										<td><input name="ProductId" type="hidden"
											id="${Category.pdid}" value="${Category.pdid}" /> <input
											type="button" style="border-radius: 60%" name="delete"
											value="刪除" onclick="confirmDelete(${Category.pdid})" /></td>


									</tr>
								</c:forEach>
							</tbody>
						</table>
					</form>
				</div>

				<!-- Banner -->

				<!-- Begin Page Content 內容 -->

				<!-- /.container-fluid -->

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
						<li><a
							href="http://localhost:8080/campingmapping/T4_36/html5up-editorial/Pd_index.jsp">首頁</a>
						</li>
						<li><a href="<c:url value='/SelectAllServlet.do'/>">商城維護</a>
						</li>
						<li><span class="opener">商品分類</span>
							<ul>
								<li><a href="#">睡袋</a></li>
								<li><a href="#">燈具</a></li>
								<li><a href="#">桌椅</a></li>
								<li><a href="#">火爐/炊具</a></li>
								<li><a href="#">保冷箱</a></li>
								<li><a href="#">登山包</a></li>
								<li><a href="#">戶外服裝</a></li>
								<li><a href="#">登山鞋</a></li>
							</ul></li>
						<li><a href="#">訂單管理</a></li>
						<li><a href="#">登入</a></li>
					</ul>
				</nav>


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
	<script src="https://kit.fontawesome.com/cb6b6ec1ab.js"
		crossorigin="anonymous"></script>
	<script
		src="http://localhost:8080/campingmapping/T4_36/html5up-editoria/js/jquery.min.js"></script>
	<script
		src="http://localhost:8080/campingmapping/T4_36/html5up-editoria/js/browser.min.js"></script>
	<script
		src="http://localhost:8080/campingmapping/T4_36/html5up-editoria/js/breakpoints.min.js"></script>
	<script
		src="http://localhost:8080/campingmapping/T4_36/html5up-editoria/js/util.js"></script>
	<script
		src="http://localhost:8080/campingmapping/T4_36/html5up-editoria/js/main.js"></script>
	<script type="text/javascript">
				function confirmDelete(id) {
					if (confirm("確定刪除此項產品資料(編號:" + id + ")?")) {
							
						document.forms[0].action="http://localhost:8080/campingmapping/CategoryDeleteServlet.do?ProductId="+id;
						document.forms[0].method="POST";
						document.forms[0].submit();
// 						window.location.replace("http://localhost:8080/campingmapping/T4_36/html5up-editorial/Pd_delet.jsp");
					} else {
					}
				}
				function updateProduct(id) {
					if (confirm("確定修改此項產品資料(編號:" + id + ")?")) {
						document.forms[0].action="http://localhost:8080/campingmapping/CategorySelectByPdidServlet.do?querybyproductno="+id;
						document.forms[0].method="POST";
						document.forms[0].submit();
						
// 						window.location.replace("http://localhost:8080/campingmapping/T4_36/html5up-editorial/Pd_update.jsp");
					} else {
					}
				}
// 	value='http://localhost:8080/campingmapping/T4_36/html5up-editorial/Pd_update.jsp'
			</script>
</body>

</html>