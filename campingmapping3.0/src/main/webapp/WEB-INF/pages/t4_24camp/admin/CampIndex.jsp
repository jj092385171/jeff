<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE HTML>
		<html>

		<head>
			<meta charset="utf-8" />
			<title>EEIT56_露營</title>
			<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
		</head>

		<body>
			<div>
				<a href="/campingmapping3.0/indexShowAllCamp.controller"><strong>營地_營區位管理</strong></a>
			</div>

			<hr>

			<table>
				<thead>
					<tr>
						<th>營地編號</th>
						<th>營地</th>
						<th>縣市編號</th>
						<th>縣市名</th>
						<th>營地地址</th>
						<th>營地圖片</th>
						<th>營地簡介</th>
						<th>營地標籤</th>
						<th>更新</th>
						<th>刪除</th>
						<th>新增營區位</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var='camp' items='${allCamps}'>
						<tr>
							<td>${ camp.campID }</td>
							<td><a href="/campingmapping3.0/sitesOfCamp.controller/${ camp.campID }">${
									camp.campName }</a></td>
							<td>${ camp.city.cityID }</td>
							<td>${ camp.city.cityName }</td>
							<td>${ camp.location }</td>
							<!-- <td>
								<img width="80" height="100"
								src="<c:url value='/T4_24/GetCampImage?id=${camp.campID}'/>" />
							</td> -->
							<td>${ camp.description }</td>
							<td>
								<c:forEach var='tag' items='${camp.tags}'>
									${tag.tagName} &nbsp; / &nbsp;
								</c:forEach>
							</td>
							<td>
								<form action="<c:url value='/UpadteCampByIDPageServlet.do'/>" method="POST">
									<button onclick="return check()" type="submit" name="campID"
										value="${camp.campID }">更新</button>
								</form>
							</td>
							<td>
								<!-- <form action="<c:url value='/DeleteCampByIDServlet.do'/>" method="POST">
									<button onclick="return check()" type="submit" name="campID"
										value="${camp.campID }">刪除</button>
								</form> -->
								<form>
									<button class="delete" value="${camp.campID}" name="campID"
										type="button">刪除</button>
								</form>
							</td>
							<td>
								<form action="<c:url value='/InsertSiteGetCampIDServlet?campID=${camp.campID }'/>"
									method="POST">
									<button>新增營區位</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<hr>

			<div>
				<a href="/campingmapping3.0/queryPage.controller">&emsp;查詢&emsp;營地_營區位</a>
				<br>
				<a href="/campingmapping3.0/insertPage.controller">&emsp;新增&emsp;營地_營區位</a>
				<br>
				<a href="/campingmapping3.0/indexShowAllCamp.controller">回首頁</a>
			</div>


			<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

			<script>
				$(function () {
					$('.delete').click(function () {
						let id = $(this).attr("value");
						Swal.fire({
							title: 'Are you sure?',
							text: "You won't be able to revert this!",
							icon: 'warning',
							showCancelButton: true,
							confirmButtonColor: '#3085d6',
							cancelButtonColor: '#d33',
							confirmButtonText: 'Yes, delete it!'
						}).then((result) => {
							console.log(result)
							if (result.isConfirmed) {
								$.ajax({
									url: '/campingmapping2.0/DeleteCampByIDServlet.do',
									method: "post",
									dataType: "text",
									data: { "campID": id },
								})
									.done(function () {
										console.log("del")
										// $(location).attr("href", "/campingmapping2.0/t4_24camp/admin/QueryPageForm.jsp")
									})//done
									.fail(function (error) {
										console.log(error)
									})//fail end
							}//if
						})//then

					})//click end
				});
				//function end


				function check() {
					var conf = confirm("確定執行?");
					if (conf == true) {
						alert("執行!!");
						return true;
					}
					else {
						alert("取消執行!");
						// return false here
						return false;
					}
				}
			</script>
		</body>

		</html>