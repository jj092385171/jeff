// 載入 你的.html
fetch("/morari/forum/html/newpost.html")
    .then(response => response.text())
    .then(html => {
        // 將載入的 HTML 放入 .footer 元素中
        document.querySelector(".newpost").innerHTML = html;
    });

// 送資料判斷
	
    
// 顯示畫面
	$(document).ready(function () {
		showPeople();
 		showCounty();
 		showScore();
	});

	function show() {
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