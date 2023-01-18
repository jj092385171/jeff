// 載入 你的.html
fetch("/morari/forum/html/updatepost.html")
    .then(response => response.text())
    .then(html => {
        // 將載入的 HTML 放入 .footer 元素中
        document.querySelector(".updatepost").innerHTML = html;
    });

// postid
postid = window.location.href.substring(57);

$(document).ready(function(){
	// 顯示畫面
	$.ajax({
		url:"/morari/showpostbyid.controller/" + postid,
		dataType:"JSON",
		contentType:"application/json",
		success: function(data){
			$("#title").val(data.title);
			
			$("#content").val(data.content);
			
			var peopleMax = 10;
			var option = document.createElement("option");
			option.value = "0";
			option.innerHTML = "請選擇";
			$("#people").append(option);
			for (let i = 1; i <= peopleMax; i++) {
				option = document.createElement("option");
				option.value = i;
				option.innerHTML = i;
				if(i == data.people){
					option.selected = "selected";
				}
				$("#people").append(option);
			}
			
			if(data.price > 0){
				$("#price").val(data.price);
			}
			
			var option = document.createElement("option");
			option.value="";
			option.innerHTML = "請選擇";
			$("#county").append(option);
			var countyInner = ["台北市", "新北市", "基隆市", "桃園市", "新竹縣", "新竹市", "苗栗縣", "台中市", "彰化縣", "南投縣", 
				"雲林縣", "嘉義縣", "嘉義市", "台南市", "高雄市", "屏東縣", "宜蘭縣", "花蓮縣", "台東縣", "澎湖縣", "金門縣", "連江縣"];
			var countyValue = ["TPE", "TPH", "KLU", "TYC", "HSH", "HSC", "MAL", "TXG", "CWH", "NTO", "YLH", "CHY",
				"CYI", "TNN", "KHH", "IUH", "ILN", "HWA", "TTT", "PEH", "KMN", "LNN"];
			
			for(let i = 0; i < countyValue.length; i++){
				option = document.createElement("option");
				option.value = countyValue[i];
				option.innerHTML = countyInner[i];
				if(countyValue[i] == data.county){
					option.selected = "selected";
				}  
				$("#county").append(option);
			}
			
			if(data.startdate != "" && data.startdate != null){
				var date = moment(Date.parse(data.startdate)).format('YYYY-MM-DD');
				$("#startDate").val(date);
				console.log($("#startDate").val());
			}
			
			if(data.enddate != "" && data.enddate != null){
				var date = moment(Date.parse(data.enddate)).format('YYYY-MM-DD');
				$("#endDate").val(date);
			}
			
			var scoreMax = 5;
			var option = document.createElement("option");
			option.value = "0";
			option.innerHTML = "請選擇";
			$("#score").append(option);
			for (let i = 1; i <= scoreMax; i++) {
				option = document.createElement("option");
				option.value = i;
				option.innerHTML = i;
				if(i == data.score){
					option.selected = "selected";
				}
				$("#score").append(option);
			}
			
//			var hid = "<a href='/morari/forum/showpost.controller/" + postid + "' id='sub'>修改完成</a>"
//			$("#hid").append(hid);
		}	
	});
	
	// 修改完成
	$("#sub").click(function(){		
		if(confirm("是否確定修改?")){
			var params = {
				"postid":postid,
				"title":$("#title").val(),
				"content":$("#content").val(),
				"people":$("#people").val(),
				"price":$("#price").val(),
				"county":$("#county").val(),
				"startDate":$("#startDate").val(),
				"endDate":$("#endDate").val(),
				"score":$("#score").val()
			}
			
			
			$.ajax({
				type:"put",
				url:"/morari/updatepost.controller",
				dataType:"JSON",
				contentType:"application/json",
				data:JSON.stringify(params),
				success: function(data){
					alert("更新成功")
					window.location = data.url;
				}
			});
		}
		
	});
	
});