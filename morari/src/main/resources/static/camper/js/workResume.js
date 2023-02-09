// 載入 你的.html
var uid;
$(document).ready(function() {

	fetch("/morari/utils/getuid")
		.then(response => response.text())
		.then(data => {
			// console.log(data)
			uid = data;
		})


	$("#resume").click(function() {
		$('#items').empty("");

		$.ajax({
			type: 'GET',
			url: '/morari/guest/work/guestSelectResume.controller/' + uid,
			contentType: 'application/json',
			success: function(data) {
				console.log(data);
				if (data == null || data.length==0) {
					var table = $('#items');
					var tr = "<tr align='center'>" +
						"<td colspan='2'>暫無資料</td>" +
						"<td>" + "<form action='/morari/guest/work/startResumeInsert.controller'><input type = 'submit' value = '新增簡歷' ></form> " + "</td>" +
						"</tr>"
					table.append(tr);
				} else {
					var table = $('#items');

					table.append("<tr><th>會員編號</th><th>姓名</th><th>年次</th><th>性別</th><th>email</th><th>電話</th><th>學歷</th><th>專業技能</th></tr>");

					console.log("data:" + data);
					var tr = "<tr align='center'>" +
						"<td>" + data.uid + "</td>" +
						"<td>" + data.name + "</td>" +
						"<td>" + data.age + "</td>" +
						"<td>" + data.gender + "</td>" +
						"<td>" + data.mail + "</td>" +
						"<td>" + data.phone + "</td>" +
						"<td>" + data.educational + "</td>" +
						"<td>" + data.skill + "</td>" +
						"<td>" + "<button onclick='selectResume()'>修改簡歷</button>" + "</td></tr>";
					table.append(tr);
				}
			}
		})
	});
	//	var table = $('#items');
	//	var tr = "<tr align='center'>" +
	//		"<td>" + "<form action='/morari/guest/work/startResumeInsert.controller'><input type = 'submit' value = '新增簡歷' ></form> " + "</td>" +
	//		"<td>" + "<button onclick='selectResume()'>修改簡歷</button>" + "</td>" +
	//		"</tr>"
	//	table.append(tr);

});

function selectResume() {
	window.location.href = '/morari/guest/work/update.controller'
};