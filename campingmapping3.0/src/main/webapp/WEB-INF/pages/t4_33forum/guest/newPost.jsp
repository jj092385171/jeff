<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="UTF-8">
			<title>new Post</title>
			<style>
				h3 {
					color: brown;
				}
				.disBlock {
					padding: 5px 5px;
					margin: 5px 5px;
				}
			</style>
		</head>

		<body onload="show()">
			<header>
				<h3>新增貼文</h3>
			</header>
			<article>
				<form action="insertPost" method="POST">
					<div class="disBlock">
						<label for="">*標題</label>
						<input type="text" name="title" maxlength="30" size="80" required="required">
					</div>
					<div class="disBlock">
						<label for="">*內容</label>
						<textarea name="content" id="" cols="66" rows="10" required="required"></textarea>
					</div>
					<div class="disBlock">
						<label for="">露營人數</label>
						<select name="people" id="people">
							<option value="">請選擇</option>
						</select>
					</div>
					<div class="disBlock">
						<label for="">露營費用</label>
						<input type="number" name="price" min="1">
					</div>
					<div class="disBlock">
						<label for="">露營城市</label>
						<select name="county" id="county">
							<option value="">請選擇</option>
						</select>
					</div>
					<div class="disBlock">
						<label for="">開始露營日期</label>
						<input type="date" name="startDate">
					</div>
					<div class="disBlock">
						<label for="">結束露營日期</label>
						<input type="date" name="endDate">
					</div>
					<div class="disBlock">
						<label for="">評分</label>
						<select name="score" id="score">
							<option value="">請選擇</option>
						</select>
					</div>
					<div class="disBlock">
						<input type="submit" value="送出">
						<input type="reset" name="" id="" value="清除">
						<input type="button" value="回上一頁" onclick="history.back()">
					</div>
				</form>
			</article>
			<script>
				function show(){
					showPeople();
					showCounty();
					showScore();
				}
				
				function showPeople() {
					var peopleMax = 10;
					for (let i = 1; i <= peopleMax; i++) {
						var option = document.createElement("option");
						option.value = i;
						option.innerHTML = i;
						document.getElementById("people").appendChild(option);
					}
				}
				
				function showCounty(){
					var countyInner = ["台北市", "新北市", "基隆市", "桃園市", "新竹縣", "新竹市", "苗栗縣", "台中市", "彰化縣", "南投縣", 
						"雲林縣", "嘉義縣", "嘉義市", "台南市", "高雄市", "屏東縣", "宜蘭縣", "花蓮縣", "台東縣", "澎湖縣", "金門縣", "連江縣"];
					var countyValue = ["TPE", "TPH", "KLU", "TYC", "HSH", "HSC", "MAL", "TXG", "CWH", "NTO", "YLH", "CHY",
						"CYI", "TNN", "KHH", "IUH", "ILN", "HWA", "TTT", "PEH", "KMN", "LNN"];
					for(let i = 0; i < countyInner.length; i++){
						var option = document.createElement("option");
						option.value = countyValue[i];
						option.innerHTML = countyInner[i];
						document.getElementById("county").appendChild(option);
					}
				}
				
				function showScore(){
					var scoreMax = 5;
					for (let i = 1; i <= scoreMax; i++) {
						var option = document.createElement("option");
						option.value = i;
						option.innerHTML = i;
						document.getElementById("score").appendChild(option);
					}
				}
			</script>

		</body>

		</html>