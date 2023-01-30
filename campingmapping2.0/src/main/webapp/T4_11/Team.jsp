<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE HTML>

		<html>

			<head>
				<title>揪團管理</title>
				<meta charset="utf-8" />
				<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
				<style>
 					hr { 
 						margin: 10px; 
 						border-color: transparent; 
 					} 

				</style>
			</head>

			<body class="is-preload">


					<div id="main">
						<div class="inner">

							<!-- Header -->
								<a href="index.html" class="logo"><strong>揪團</strong> 管理者</a>
							

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
												<td class="nineteendigits">${bean.postdate}</td>
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
												<td><a href="/campingmapping2.0/T4_11/insert.jsp" class="button big">新增</a></td>
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
												<td class="nineteendigits">${bean.postdate}</td>
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

						</div>
					</div>

					
							
				<!-- Scripts -->
				<script src="../jquery-3.6.1.js"></script>
				<script>
				var el = document.querySelectorAll('.pair');
				for(var i = 0; i<el.length ; i++) {
					if(el[i].innerText == 0){
						el[i].innerText = "可配對";
					}else{
						el[i].innerText = "不可配對";
					}
				}
				var date = document.querySelectorAll('.tendigits');
				for(var j = 0; j < date.length; j++){
					var tendigitsdate = date[j].innerText.substr(0,10);
					date[j].innerText = tendigitsdate;
				}
				var time = document.querySelectorAll('.nineteendigits');
				for(var k = 0; k < time.length; k++){
					var nineteendigits = time[k].innerText.substr(0,19);
					time[k].innerText = nineteendigits;
				}
				</script>
			</body>

		</html>