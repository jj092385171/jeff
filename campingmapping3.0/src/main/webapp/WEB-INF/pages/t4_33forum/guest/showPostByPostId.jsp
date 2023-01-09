<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showPost</title>
<style>
	h3{
		color: brown;	
	}
	div{
		padding: 5px 5px;
		margin: 5px 5px;
	}
	h4{
		color: brown;
	}
	td{
		padding: 3px;
	}
</style>
</head>
<body onload="show()">
<form action="showAllPost">
	<h3>貼文</h3>
	<input type="hidden" name="postId" value="${resultPost.postId}">
	<input type="submit" value="回討論區">
<!-- 	<input type="submit" formaction="showUpdatePostByPostId" value="修改貼文"> -->
</form>
<form method="post">
	<input type="hidden" name="postId" value="${resultPost.postId}">
	<div>
		<label>標題:</label>
		<input type="text" name="title" value="${resultPost.title}" size="80" disabled>
	</div>
	<div>
		<label>內容:</label>
		<textarea name="content" id="" cols="66" rows="10" disabled>${resultPost.content}</textarea>
	</div>
	<div>
		<label>露營人數:</label>
		<input type="hidden" id="peopleId" value="${resultPost.people}">
		<input type="text" name="people" id="people" size="30" disabled>
	</div>
	<div>
		<label>露營費用:</label>
		<input type="hidden" id="priceId" value="${resultPost.price}">
		<input type="text" name="price" id="price" size="30" disabled>
	</div>
	<div>
		<label>露營城市:</label>
		<input type="hidden" id="countyId" value="${resultPost.county}">
		<input type="text" name="county" id="county" size="30" disabled>
	</div>
	<div>
		<label>開始露營日期:</label>
		<input type="hidden" id="startDateId" value="${resultPost.startDate}">
		<input type="text" name="startDate" id="startDate" size="30" disabled>
	</div>
	<div>
		<label>結束露營日期:</label>
		<input type="hidden" id="endDateId" value="${resultPost.endDate}">
		<input type="text" name="endDate" id="endDate" size="30" disabled>
	</div>
	<div>
		<label>評分:</label>
		<input type="hidden" id="scoreId" value="${resultPost.score}">
		<input type="text" name="score" id="score" size="30" disabled>
	</div>
	<div>
		<label>最後更新日期:</label>
		<input type="hidden" id="releaseDateId" value="${resultPost.releaseDate}">
		<input type="text" name="releaseDate" id="releaseDate" size="30" disabled>
	</div>
	<div>
		<label>喜歡本貼文人數:</label>
		<input type="text" name="userLike" value="${resultPost.userLike}" size="30" disabled>
		<input type="submit" formaction="" value="喜歡">
	</div>
	<div>	
		<label>不喜歡本貼文人數:</label>
		<input type="text" name="userUnlike" value="${resultPost.userUnlike}" size="30" disabled>
		<input type="submit" formaction="" value="不喜歡">
	</div>
	<input type="submit" formaction="reportPost" value="檢舉貼文" onclick="return confirm('是否確定檢舉貼文?');">
</form>

	
<hr>
<form action="insertPostComment" method="post">
	<h3>留言</h3>
	<input type="hidden" name="postId" value="${resultPost.postId}">
	<label>新增留言:</label>
    <input type="text" name="comment" maxlength="100" size="100" required="required">
    <input type="submit" value="送出留言"><br>
</form>
	<table>
		<c:forEach var="postComment" items="${resultpostComment}">
        	<tr>
        		<td>
        			留言者ID：${postComment.userId}<br>
        			留言內容：${postComment.postComment}
<!--         			<input type="submit" formaction="" value="隱藏留言"> -->
        		</td>
        	</tr>
        </c:forEach>		
	</table>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script type="text/javascript">
	function show(){
		showPeople();
		showPrice();
		showCounty();
		showStartDate();
		showEndDate();
		showScore();
		showReleaseDate();
	}
	
	function showPeople(){
		var peopleId = document.getElementById("peopleId").value;
		if(peopleId > 0){
			document.getElementById("people").value = peopleId;
		}
	}
	
	function showPrice(){
		var priceId = document.getElementById("priceId").value;
		if(priceId > 0){
			document.getElementById("price").value = priceId;
		}
	}
	
	function showCounty(){
		var countyId = document.getElementById("countyId").value;
		var countyInner = ["台北市", "新北市", "基隆市", "桃園市", "新竹縣", "新竹市", "苗栗縣", "台中市", "彰化縣", "南投縣", 
			"雲林縣", "嘉義縣", "嘉義市", "台南市", "高雄市", "屏東縣", "宜蘭縣", "花蓮縣", "台東縣", "澎湖縣", "金門縣", "連江縣"];
		var countyValue = ["TPE", "TPH", "KLU", "TYC", "HSH", "HSC", "MAL", "TXG", "CWH", "NTO", "YLH", "CHY",
			"CYI", "TNN", "KHH", "IUH", "ILN", "HWA", "TTT", "PEH", "KMN", "LNN"];
		
		for(let i = 0; i < countyValue.length; i++){
			if(countyValue[i] == countyId){
				document.getElementById("county").value = countyInner[i];
			}  
		}
	}
	
	function showStartDate() {
		if(document.getElementById("startDateId").value != ""){
			let date = moment(Date.parse(document.getElementById("startDateId").value)).format('YYYY-MM-DD');
			document.getElementById("startDate").value = date;
		}
	}
	
	function showEndDate() {
		if(document.getElementById("endDateId").value != ""){
			let date = moment(Date.parse(document.getElementById("endDateId").value)).format('YYYY-MM-DD');
			document.getElementById("endDate").value = date;
		}
	}
	
	function showScore(){
		var scoreId = document.getElementById("scoreId").value;
		if(scoreId > 0){
			document.getElementById("score").value = scoreId;
		}
	}
	
	function showReleaseDate() {
		let date = moment(Date.parse(document.getElementById("releaseDateId").value)).format('YYYY-MM-DD HH:mm:ss');
		document.getElementById("releaseDate").value = date;
	}
</script>

</body>
</html>