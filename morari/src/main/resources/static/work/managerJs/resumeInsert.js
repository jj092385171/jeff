// 載入 你的.html
$(document).ready(function() {
	// let uid;
	//	fetch("/morari/utils/getuid")
	//		.then(response => response.text())
	//		.then(data => {
	//		})

	var url = window.location.href;
	var uuid = url.split("/").pop();
	$('#uid').val(uuid);

	// 一鍵輸入 
	$("#fastinput").click(function() {
		fastinport();
	});

	$("#send").click(function() {
		function getFormData($form) {
			var unindexed_array = $form.serializeArray();
			var indexed_array = {};

			$.map(unindexed_array, function(n, i) {
				indexed_array[n['name']] = n['value'];
			});
			return indexed_array;
		}

		$.ajax({
			type: 'POST',
			url: '/morari/admin/resume/resumeInsert.controller/' + uuid,
			contentType: 'application/json',
			data: JSON.stringify(getFormData($("#insert"))),
			success: function(response) {
				$('#showInsert').empty("");
				$('#su').empty("");
				$('#booking').remove();
				if (response == null) {
					$('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
				} else {
					var h3 = $('#su');
					h3.prepend('成功送出');
					var table = $('#showInsert');
					table.append("<tr align='center'><th>會員編號</th><th>姓名</th><th>年次</th><th>性別</th><th>email</th><th>電話</th><th>學歷</th><th>專業技能</th></tr>");

					var tr = "<tr align='center'>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.userprofiles.uid + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.name + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.age + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.gender + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.mail + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.phone + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.educational + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.skill + "</td></tr>";
					table.append(tr);
				}
			}
		});
	});
});
function fastinport() {
	$("#name").val("黃凱莉");
	$("#age").val("84");
	$("#mail").val("hcc8462@gmail.com");
	$("#phone").val("0955815651");
	$("#gender").attr('checked', true);
	$("#educational").val("屏東科技大學餐飲管理學系");
	$("#skill").val("多益700分，日文n3");

}