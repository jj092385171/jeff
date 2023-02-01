// 載入 你的.html
fetch("/morari/forum/html/newpost.html")
    .then(response => response.text())
    .then(html => {
        // 將載入的 HTML 放入 .footer 元素中
        document.querySelector(".newpost").innerHTML = html;

		$(document).ready(function () { 		
			// 新增貼文
			$("#sub").click(function(){					
				console.log($("#price").val());
				if($.trim($("#title").val()) == ""){
					alert("請輸入標題");
					return;
				}
				if($.trim($("#postcontent").val()) == ""){
					alert("請輸入內容");
					return;
				}
				if($("#price").val() <= 0){
					alert("輸入金額需大於0");
					return;
				}
				if($("#endDate").val() < $("#startDate").val()){
					alert("結束露營日期早於開始露營日期");
					return;
				}
				
				var params = {
					"title":$("#title").val(),
					"content":$("#postcontent").val(),
					"people":$("#people").val(),
					"price":$("#price").val(),
					"county":$("#county").val(),
					"startdate":$("#startDate").val(),
					"enddate":$("#endDate").val(),
					"score":$("#score").val()
					}
					
				$.ajax({
					type:"post",
					url:"/morari/insertpost.controller",
					dataType:"JSON",
					contentType:"application/json",
					data:JSON.stringify(params),
					success: function(data){
						if(data == true){
							alert("新增成功");
							window.location.href = "/morari/admin/forum/forumadminindex";
						}
					}
				});	
			});
				
			// 顯示畫面
			var peopleMax = 10;
			for (let i = 1; i <= peopleMax; i++) {
				var option = document.createElement("option");
				option.value = i;
				option.innerHTML = i;
				$("#people").append(option);
			}
			
			var countyInner = ["台北市", "新北市", "基隆市", "桃園市", "新竹縣", "新竹市", "苗栗縣", "台中市", "彰化縣", "南投縣",
				"雲林縣", "嘉義縣", "嘉義市", "台南市", "高雄市", "屏東縣", "宜蘭縣", "花蓮縣", "台東縣", "澎湖縣", "金門縣", "連江縣"];
			var countyValue = ["TPE", "TPH", "KLU", "TYC", "HSH", "HSC", "MAL", "TXG", "CWH", "NTO", "YLH", "CHY", "CYI",
				"TNN", "KHH", "IUH", "ILN", "HWA", "TTT", "PEH", "KMN", "LNN"];
			for (let i = 0; i < countyInner.length; i++) {
				var option = document.createElement("option");
				option.value = countyValue[i];
				option.innerHTML = countyInner[i];
				$("#county").append(option);
			}
			
			var scoreMax = 5;
			for (let i = 1; i <= scoreMax; i++) {
				var option = document.createElement("option");
				option.value = i;
				option.innerHTML = i;
				$("#score").append(option);
			}
		});


    });














// 載入 你的.html
// fetch("/morari/forum/html/newpost.html")
//     .then(response => response.text())
//     .then(html => {
//         // 將載入的 HTML 放入 .footer 元素中
//         document.querySelector(".newpost").innerHTML = html;
//     });

// 	$(document).ready(function () {
//  		// 新增貼文
//  		$("#sub").click(function(){		
// 			if($.trim($("#title").val()) == ""){
// 				alert("請輸入標題");
// 				return;
// 			}
// 			if($.trim($("#postcontent").val()) == ""){
// 				alert("請輸入內容");
// 				return;
// 			}
// 			if($("#price").val() <= 0){
// 				alert("輸入金額需大於0");
// 				return;
// 			}
// 			if($("#endDate").val() < $("#startDate").val()){
// 				alert("結束露營日期早於開始露營日期");
// 				return;
// 			}
			
// 			var params = {
// 				"title":$("#title").val(),
// 				"content":$("#postcontent").val(),
// 				"people":$("#people").val(),
// 				"price":$("#price").val(),
// 				"county":$("#county").val(),
// 				"startdate":$("#startDate").val(),
// 				"enddate":$("#endDate").val(),
// 				"score":$("#score").val()
// 				}
				
// 			$.ajax({
// 				type:"post",
// 				url:"/morari/insertpost.controller",
// 				dataType:"JSON",
// 				contentType:"application/json",
// 				data:JSON.stringify(params),
// 				success: function(data){
// 					if(data == true){
// 						alert("新增成功");
// 						window.location.href = "/morari/admin/forum/forumadminindex";
// 					}
// 				}
// 			});	
// 		});
		
// 		// 顯示畫面
// 		var peopleMax = 10;
// 		for (let i = 1; i <= peopleMax; i++) {
// 			var option = document.createElement("option");
// 			option.value = i;
// 			option.innerHTML = i;
// 			$("#people").append(option);
// 		}
		
// 		var countyInner = ["台北市", "新北市", "基隆市", "桃園市", "新竹縣", "新竹市", "苗栗縣", "台中市", "彰化縣", "南投縣",
// 			"雲林縣", "嘉義縣", "嘉義市", "台南市", "高雄市", "屏東縣", "宜蘭縣", "花蓮縣", "台東縣", "澎湖縣", "金門縣", "連江縣"];
// 		var countyValue = ["TPE", "TPH", "KLU", "TYC", "HSH", "HSC", "MAL", "TXG", "CWH", "NTO", "YLH", "CHY", "CYI",
// 			"TNN", "KHH", "IUH", "ILN", "HWA", "TTT", "PEH", "KMN", "LNN"];
// 		for (let i = 0; i < countyInner.length; i++) {
// 			var option = document.createElement("option");
// 			option.value = countyValue[i];
// 			option.innerHTML = countyInner[i];
// 			$("#county").append(option);
// 		}
		
// 		var scoreMax = 5;
// 		for (let i = 1; i <= scoreMax; i++) {
// 			var option = document.createElement("option");
// 			option.value = i;
// 			option.innerHTML = i;
// 			$("#score").append(option);
// 		}
// 	});