
const fetch1 = fetch("/morari/forum/html/showpost.html").then(response => response.text());
const fetch2 = fetch("/morari/forum/html/showpostcomment.html").then(response => response.text());

Promise.all([fetch1, fetch2]).then(results => {
	const [html1, html2] = results;
	document.querySelector(".showpost").innerHTML = html1;
	document.querySelector(".showpostcomment").innerHTML = html2;
	// 執行您的 JS
	$(document).ready(function () {
		let url = window.location.href;
		let arr = url.split('/');
		let postid = arr[arr.length - 1];

		// 顯示貼文
		$.ajax({
			url: "/morari/showpostbyid.controller/" + postid,
			dataType: "JSON",
			contentType: "application/json",
			success: function (data) {
				$("#title").val(data.title);

				$("#content").val(data.content);

				if (data.people > 0) {
					$("#people").val(data.people);
				}

				if (data.price > 0) {
					$("#price").val(data.price);
				}

				var countyInner = ["台北市", "新北市", "基隆市", "桃園市", "新竹縣", "新竹市", "苗栗縣", "台中市", "彰化縣", "南投縣",
					"雲林縣", "嘉義縣", "嘉義市", "台南市", "高雄市", "屏東縣", "宜蘭縣", "花蓮縣", "台東縣", "澎湖縣", "金門縣", "連江縣"];
				var countyValue = ["TPE", "TPH", "KLU", "TYC", "HSH", "HSC", "MAL", "TXG", "CWH", "NTO", "YLH", "CHY",
					"CYI", "TNN", "KHH", "IUH", "ILN", "HWA", "TTT", "PEH", "KMN", "LNN"];
				for (let i = 0; i < countyValue.length; i++) {
					if (countyValue[i] == data.county) {
						$("#county").val(countyInner[i]);
					}
				}

				if (data.startdate != "" && data.startdate != null) {
					$("#startDate").val(data.startdate);
				}

				if (data.enddate != "" && data.enddate != null) {
					$("#endDate").val(data.enddate);
				}

				if (data.score > 0) {
					$("#score").val(data.score);
				}

				$("#releaseDate").val(data.releasedate);

				$("#userLike").val(data.userlike);
				$("#userUnlike").val(data.userunlike);
			}
		});

		// 顯示留言
		$.ajax({
			url: "/morari/showpostcommentbypostid.controller/" + postid,
			dataType: "JSON",
			contentType: "application/json",
			success: function (data) {
				var table = $("#showpostcomment");
				$.each(data, function (i, n) {
					// i=index 第幾個 n=element 元素
					var tr = "<tr>" + "<td>會員ID:" + n.uid + "<br>留言:" + n.postcomment + "<br>" + "</td>" + "</tr>";
					table.append(tr);
				});
			}
		});

		// 檢舉貼文
		$("#sub").click(function () {
			if (confirm("是否確定檢舉?")) {
				$.ajax({
					type: "put",
					url: "/morari/reportpost.controller/" + postid,
					dataType: "JSON",
					contentType: "application/json",
					success: function (data) {
						if (data == true) {
							alert("檢舉成功");
						}
					}
				});
			}
		});

		// 喜歡貼文
		$("#like").click(function () {
			$.ajax({
				type: "put",
				url: "/morari/likepost.controller/" + postid,
				dataType: "JSON",
				contentType: "application/json",
				success: function (data) {
					if (data == false) {
						alert("已喜歡過此貼文");
					}
					location.reload();
				}
			});
		});

		// 不喜歡貼文
		$("#unlike").click(function () {
			$.ajax({
				type: "put",
				url: "/morari/unlikepost.controller/" + postid,
				dataType: "JSON",
				contentType: "application/json",
				success: function (data) {
					if (data == false) {
						alert("已不喜歡過此貼文");
					}
					location.reload();
				}
			});
		});

		// 新增留言
		$("#sendcomment").click(function () {
			if ($.trim($("#postcomment").val()) == "") {
				alert("請輸入留言內容");
				return;
			}
			var comment = {
				"postcomment": $("#postcomment").val()
			};
			$.ajax({
				type: "post",
				url: "/morari/insertpostcomment.controller/" + postid,
				dataType: "JSON",
				contentType: "application/json",
				data: JSON.stringify(comment),
				success: function () {
					location.reload();
				}
			});
		});

	});

	});














