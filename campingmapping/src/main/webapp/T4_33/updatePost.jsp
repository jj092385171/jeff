<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show Post</title>
</head>
<body onload="show()">

	<header>
		<h3>修改貼文</h3>
	</header>
	<form action="<c:url value='/T4_33/servlet/updatePostServlet' />" method="POST">
		<div>
			<label>標題</label>
			<input type="text" name="title" maxlength="30" size="80" required="required" value="${title}">
		</div>
		<div>
			<label>內容</label>
			<textarea name="content" id="" cols="66" rows="10" required="required">${content}</textarea>
		</div>
		<div>
			<label>修改照片</label>
			<input type="file" name="picture" value="">${picture}
		</div>
		<div>
			<label>露營人數</label>
			<select name="people" id="people"></select>
		</div>
		<div>
			<label>露營費用</label>
			<input type="number" name="price" id="price">
		</div>
		<div>
			<label>露營城市</label>
			<input type="hidden" name="" id="countyId" value="${county}">
			<select name="county" id="county"></select>${county}
		</div>
		<div>
			<label>開始露營日期</label>
			<input type="date" name="startDate" value="${startDate}">
		</div>
		<div>
			<label>結束露營日期</label>
			<input type="date" name="endDate" value="${endDate}">
		</div>
		<div>
			<label>評分</label>
			<select name="score" id="score"></select>
		</div>
		<div>
			<input type="hidden" name="postId" value="${postId}">
			<input type="submit" value="修改完成">
		</div>
	</form>
	<script>
		function show(){
			showPeople();
			showPrice();
			showCounty();
			showStartDate();
			showEndDate();
			showScore();
		}
				
		function showPeople() {
			var peopleMax = 5;
			if(${people} == 0){
				var option = document.createElement("option");
				option.value = "";
				option.innerHTML = "請選擇";
				document.getElementById("people").appendChild(option);
			}
			for (let i = 1; i <= peopleMax; i++) {
				var option = document.createElement("option");
				option.value = i;
				option.innerHTML = i;
				if(i == ${people}){
					option.selected = "selected";
				}
				document.getElementById("people").appendChild(option);
			}
		}
		
		function showPrice(){
			if(${price} == 0){
				document.getElementById("price").innerHTML = "";
			}else{
				document.getElementById("price").value = ${price};
			}
		}
			
		function showCounty(){
			var countyId = document.getElementById("countyId").value;			
			if(countyId == ""){
				var option = document.createElement("option");
				option.innerHTML = "請選擇";
				document.getElementById("county").appendChild(option);
			}
			var countyInner = ["台北市", "新北市", "基隆市", "桃園市", "新竹縣", "新竹市", "苗栗縣", "台中市", "彰化縣", "南投縣", 
				"雲林縣", "嘉義縣", "嘉義市", "台南市", "高雄市", "屏東縣", "宜蘭縣", "花蓮縣", "台東縣", "澎湖縣", "金門縣", "連江縣"];
			var countyValue = ["TPE", "TPH", "KLU", "TYC", "HSH", "HSC", "MAL", "TXG", "CWH", "NTO", "YLH", "CHY",
				"CYI", "TNN", "KHH", "IUH", "ILN", "HWA", "TTT", "PEH", "KMN", "LNN"];
			
			for(let i = 0; i < countyValue.length; i++){
				var option = document.createElement("option");
				option.value = countyValue[i];
				option.innerHTML = countyInner[i];
				
				if(countyValue[i] == countyId){
					option.selected = "selected";
				}  
				document.getElementById("county").appendChild(option);
			}
		}
		
		function showStartDate(){
			
		}
		
		function showEndDate(){
			
		}
		
		function showScore(){
			var scoreMax = 5;
			if(${score} == 0){
				var option = document.createElement("option");
				option.value = "";
				option.innerHTML = "請選擇";
				document.getElementById("score").appendChild(option);
			}
			for (let i = 1; i <= scoreMax; i++) {
				var option = document.createElement("option");
				option.value = i;
				option.innerHTML = i;
				if(i == ${score}){
					option.selected = "selected";
				}
				document.getElementById("score").appendChild(option);
			}
		}
	</script>
</body>
</html>