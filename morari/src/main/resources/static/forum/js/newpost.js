// 載入 你的.html
fetch("/morari/forum/html/newpost.html")
    .then(response => response.text())
    .then(html => {
        // 將載入的 HTML 放入 .footer 元素中
        document.querySelector(".newpost").innerHTML = html;
    });

	$(document).ready(function () {
		// 顯示畫面
		showPeople();
 		showCounty();
 		showScore();
 		
 		// 新增貼文
 		$("#sub").click(function(){		
			console.log("test");
			var params = {
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
				type:"post",
				url:"/morari/insertpost.controller",
				dataType:"JSON",
				contentType:"application/json",
				data:JSON.stringify(params),
				success: function(data){
					alert("新增成功")
					window.location = data.url;
				}
			});	
		});
	});


	function showPeople() {
		var peopleMax = 10;
		for (let i = 1; i <= peopleMax; i++) {
			var option = document.createElement("option");
			option.value = i;
			option.innerHTML = i;
			document.getElementById("people").appendChild(option);
		}
	}

	function showCounty() {
		var countyInner = ["台北市", "新北市", "基隆市", "桃園市", "新竹縣", "新竹市", "苗栗縣", "台中市", "彰化縣", "南投縣",
			"雲林縣", "嘉義縣", "嘉義市", "台南市", "高雄市", "屏東縣", "宜蘭縣", "花蓮縣", "台東縣", "澎湖縣", "金門縣", "連江縣"];
		var countyValue = ["TPE", "TPH", "KLU", "TYC", "HSH", "HSC", "MAL", "TXG", "CWH", "NTO", "YLH", "CHY", "CYI",
			"TNN", "KHH", "IUH", "ILN", "HWA", "TTT", "PEH", "KMN", "LNN"];
		for (let i = 0; i < countyInner.length; i++) {
			var option = document.createElement("option");
			option.value = countyValue[i];
			option.innerHTML = countyInner[i];
			document.getElementById("county").appendChild(option);
		}
	}

	function showScore() {
		var scoreMax = 5;
		for (let i = 1; i <= scoreMax; i++) {
			var option = document.createElement("option");
			option.value = i;
			option.innerHTML = i;
			document.getElementById("score").appendChild(option);
		}
	}