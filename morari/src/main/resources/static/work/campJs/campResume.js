// 載入 你的.html
$(document).ready(function() {
	var url = window.location.href;
	var id = url.split("/").pop();
	console.log(id);

	$.ajax({
		type: 'Post',
		url: '/morari/admin/user/resume/userResumeRackId.controller/' + id,
		contentType: 'application/json',
		//			data: JSON.stringify(getFormData($("#update"))),
		success: function(response) {
			console.log("response:" + response);
			$('#showInsert').empty("");
			$('#re').empty("");

			if (response == null || response.length == 0) {
				$('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
			} else {
				var h3 = $('#re');
				h3.prepend('投遞履歷結果');
				var table = $('#showInsert');
				table.append("<tr><th>刊登編號</th><th>履歷編號</th><th>會員編號</th><th>應徵職缺</th><th>姓名</th><th>年次</th><th>性別</th><th>email</th><th>電話</th><th>學歷</th><th>經歷</th><th>填寫時間</th></tr>");

				$.each(response, function(i, n) {
					var tr = "<tr align='center'>" +
						"<td>" + n.job.rackid + "</td>" +
						"<td>" + n.number + "</td>" +
						"<td>" + n.userprofiles.uid + "</td>" +
						"<td>" + n.work + "</td>" +
						"<td>" + n.name + "</td>" +
						"<td>" + n.age + "</td>" +
						"<td>" + n.gender + "</td>" +
						"<td>" + n.mail + "</td>" +
						"<td>" + n.phone + "</td>" +
						"<td>" + n.educational + "</td>" +
						"<td>" + n.experience + "</td>" +
						"<td>" + n.ptime + "</td>" +
						"<td><button class='mail' data-email='" + n.mail + "'>mail通知面試</button></td>" + "</tr>";
					table.append(tr);
				});
			}
			$('.mail').on('click', function() {
				var email = $(this).data('email');
				if (confirm("確定寄出email到:" + email + "?")) {
					$.ajax({
						type: 'post',
						url: '/morari/admin/user/work/userMail.controller',
						contentType: 'application/json',
						data: JSON.stringify(email),
						success: function(response) {
							alert(response);
							location.reload();
						}
					});
				} else {
				}

			});
		}
	});
});

