// 載入 你的.html

$(document).ready(function() {
	var url = window.location.href;
	var id = url.split("/").pop();
	console.log(id);

	$.ajax({
		type: 'POST',
		url: '/morari/admin/resume/selectNumber.controller/' + id,
		dataType: 'json',
		success: function(data) {
			$('#1').val(data.userprofiles.uid);
			$('#2').val(data.name);
			$('#3').val(data.age);
			$('#6').val(data.mail);
			$('#7').val(data.phone);
			$('#8').val(data.educational);
			$('#9').val(data.skill);

			switch (data.gender) {
				case '男':
					$("#4").attr('checked', true)
					break;
				case '女':
					$("#5").attr('checked', true)
					break;
			}
		}
	});
	$("#send").click(function() {
		function getFormData($form) {
			var unindexed_array = $form.serializeArray();
			var indexed_array = {};

			$.map(unindexed_array, function(n, i) {
				indexed_array[n['name']] = n['value'];
			});
			console.log(indexed_array);
			return indexed_array;
		}
		$.ajax({
			type: 'Put',
			url: '/morari/admin/resume/resumeUpdate.controller/' + id,
			contentType: 'application/json',
			data: JSON.stringify(getFormData($("#update"))),
			success: function(response) {
				console.log("response:" + response);
				$('#showInsert').empty("");
				$('#su').empty("");
				$('#booking').remove();
				$('#img').empty("");
				if (response == null) {
					$('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
				} else {
					var h3 = $('#su');
					h3.prepend('修改成功');
					var table = $('#showInsert');
					table.append("<tr align='center'><th>會員編號</th><th>姓名</th><th>年次</th><th>性別</th><th>email</th><th>電話</th><th>學歷</th><th>專業技能</th></tr>");

					var tr = "<tr align='center'>" +
						"<td style='border: 1px solid #2A52BE;padding: 8px;text-align: center;background-color:#FFFF4D'>" + response.userprofiles.uid + "</td>" +
						"<td style='border: 1px solid #2A52BE;padding: 8px;text-align: center;background-color:#FFFF4D'>" + response.name + "</td>" +
						"<td style='border: 1px solid #2A52BE;padding: 8px;text-align: center;background-color:#FFFF4D'>" + response.age + "</td>" +
						"<td style='border: 1px solid #2A52BE;padding: 8px;text-align: center;background-color:#FFFF4D'>" + response.gender + "</td>" +
						"<td style='border: 1px solid #2A52BE;padding: 8px;text-align: center;background-color:#FFFF4D'>" + response.mail + "</td>" +
						"<td style='border: 1px solid #2A52BE;padding: 8px;text-align: center;background-color:#FFFF4D'>" + response.phone + "</td>" +
						"<td style='border: 1px solid #2A52BE;padding: 8px;text-align: center;background-color:#FFFF4D'>" + response.educational + "</td>" +
						"<td style='border: 1px solid #2A52BE;padding: 8px;text-align: center;background-color:#FFFF4D'>" + response.skill + "</td></tr>";
					table.append(tr);
				}
			}
		});
	});
});
