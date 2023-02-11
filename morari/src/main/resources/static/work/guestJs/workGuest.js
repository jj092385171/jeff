// 載入 你的.html
var uid;

$(document).ready(function() {

	fetch("/morari/utils/getuid")
		.then(response => response.text())
		.then(data => {
			// console.log(data)
			uid = data;
		})


	$.ajax({
		type: 'POST',
		url: '/morari/admin/work/jobShowAll.controller',
		contentType: 'application/json',
		success: function(data) {
			var banners = document.getElementById("banners");
					$.each(data, function(i, n) {
						//创建一个div
						var div = document.createElement("div");


						//设置div的id
						div.id = "abc";
						//设置div的class
						div.className = "col-md-3 col-sm-6";
						//设置style
						//div.style.display="block";
						div.click = "selectbyid()";
						//设置子div的其他属性，直接通过字符串连接的方式连接即可。动态值放在引号外面就行
						div.innerHTML = '<div id="' + n.rackid + '" class="item" style="cursor: pointer;">' +
							'<img  src="' +  n.img  + '" style="max-height: 130px;" alt="img">' +
							'<div class="homepage-slider-caption">' +
							'<h3>' + n.job + '</h3>' +
							'<h4>月薪$' +n.salary + '起</h4>' +
							'</div>' +
							'</div> ';

						banners.appendChild(div);
						(function (i) {
							var elementId = n.rackid;
							document.getElementById(elementId).addEventListener("click", function () {
								// 觸發控制器的代碼
								$.ajax({
									success: function () {
										window.location.href = "/morari/guest/work/workDetail.controller/" + elementId;
									}
								});
							});
						})(i);

					})
		}
	});
});

function selectJob(job) {
	$.ajax({
		type: 'POST',
		url: '/morari/guest/work/guestSelectLike.controller/' + job,
		dataType: 'json',
		success: function(data) {
			$('#showInsert').empty("");
			$('#su').empty("");

			console.log(data);
			if (data.length == 0 || data == null) {
				$('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
			} else {
				var h3 = $('#su');
				h3.prepend('查詢結果');
				var table = $('#showInsert');
				table.append("<tr><th>職缺</th><th>刊登時間</th><th>薪資</th><th>人數</th><th>地點</th><th>上班日期</th><th>上班時段</th><th>備註</th><th>照片</th><th></th></tr>");

				$.each(data, function(i, n) {
					console.log("data:" + data);
					var tr = "<tr align='center'>" +
						"<td>" + n.job + "</td>" +
						"<td>" + n.rackup + "</td>" +
						"<td>" + n.salary + "</td>" +
						"<td>" + n.quantity + "</td>" +
						"<td>" + n.place + "</td>" +
						"<td>" + n.date + "</td>" +
						"<td>" + n.time + "</td>" +
						"<td>" + n.remark + "</td>" +
						"<td><img width='80' height='80' src='" + n.img + "'></td>" +
						"<td><button id='mailResume' onclick='mailResume(" + n.rackid + " )'></button></td></tr>";
					"<td><button id='mailResume' onclick='mailResume(" + n.rackid + " )'>我要應徵</button></td></tr>";
					table.append(tr);
				});
			}
		}
	});
};


