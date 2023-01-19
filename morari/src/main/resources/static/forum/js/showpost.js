// 載入 你的.html
fetch("/morari/forum/html/showpost.html")
    .then(response => response.text())
    .then(html => {
        // 將載入的 HTML 放入 .footer 元素中
        document.querySelector(".showpost").innerHTML = html;
    });
    
// 顯示畫面
$(document).ready(function () {
	var postid = window.location.href.substring(55);
	$.ajax({
		url:"/morari/showpostbyid.controller/" + postid,
		dataType:"JSON",
		contentType:"application/json",
		success: function(data){
			$("#title").val(data.title);
			
			$("#content").val(data.content);
			
			if(data.people > 0){
				$("#people").val(data.people);
			}
			
			if(data.price > 0){
				$("#price").val(data.price);
			}
			
			var countyInner = ["台北市", "新北市", "基隆市", "桃園市", "新竹縣", "新竹市", "苗栗縣", "台中市", "彰化縣", "南投縣", 
			"雲林縣", "嘉義縣", "嘉義市", "台南市", "高雄市", "屏東縣", "宜蘭縣", "花蓮縣", "台東縣", "澎湖縣", "金門縣", "連江縣"];
			var countyValue = ["TPE", "TPH", "KLU", "TYC", "HSH", "HSC", "MAL", "TXG", "CWH", "NTO", "YLH", "CHY",
			"CYI", "TNN", "KHH", "IUH", "ILN", "HWA", "TTT", "PEH", "KMN", "LNN"];
			for(let i = 0; i < countyValue.length; i++){
				if(countyValue[i] == data.county){
					$("#county").val(countyInner[i]);
				}  
			}
			
			if(data.startdate != "" && data.startdate != null){
				var date = moment(Date.parse(data.startdate)).format('YYYY-MM-DD');
				$("#startDate").val(date);
			}
			
			if(data.enddate != "" && data.enddate != null){
				var date = moment(Date.parse(data.enddate)).format('YYYY-MM-DD');
				$("#endDate").val(date);
			}
			
			if(data.score > 0){
				$("#score").val(data.score);
			}
			
			var date = moment(Date.parse(data.releasedate)).format('YYYY-MM-DD HH:mm:ss');
			$("#releaseDate").val(date);
		}
	});
});