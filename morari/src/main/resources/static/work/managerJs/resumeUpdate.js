// 載入 你的.html
//fetch("/morari/work/html/resumeUpdate.html")
//    .then(response => response.text())
//    .then(html => {
//        // 將載入的 HTML 放入 .footer 元素中
//        document.querySelector(".resumeUpdate").innerHTML = html;
//    });

$(document).ready(function() {
	var url = window.location.href;
	var id = url.split("/").pop();
	console.log(id);

	$.ajax({
		type: 'POST',
		url: '/morari/admin/resume/selectNumber.controller/' + id,
		dataType: 'json',
		success: function(data) {
			$('#1').val(data.job.rackid);
			//$('#2').val(data.uid);
			$('#3').val(data.work);
			$('#4').val(data.name);
			$('#5').val(data.age);
			//			$('#6').val(data.gender);
			$('#7').val(data.mail);
			$('#8').val(data.phone);
			$('#9').val(data.educational);
			$('#10').val(data.experience);
			$('11').val(data.ptime);

			switch (data.gender) {
				case '男':
					$("#12").attr('checked', true)
					break;
				case '女':
					$("#13").attr('checked', true)
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
				$('#update').empty("");
				$('#img').empty("");
				if (response == null) {
					$('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
				} else {
					var h3 = $('#su');
					h3.prepend('修改成功');
					var table = $('#showInsert');
					table.append("<tr><th>刊登編號</th><th>履歷編號</th><th>會員編號</th><th>應徵職缺</th><th>姓名</th><th>年次</th><th>性別</th><th>email</th><th>電話</th><th>學歷</th><th>經歷</th><th>填寫時間</th></tr>");


					var tr = "<tr align='center'>" +
						"<td>" + response.job.rackid + "</td>" +
						"<td>" + response.number + "</td>" +
						"<td>" + response.userprofiles.uid + "</td>" +
						"<td>" + response.work + "</td>" +
						"<td>" + response.name + "</td>" +
						"<td>" + response.age + "</td>" +
						"<td>" + response.gender + "</td>" +
						"<td>" + response.mail + "</td>" +
						"<td>" + response.phone + "</td>" +
						"<td>" + response.educational + "</td>" +
						"<td>" + response.experience + "</td>" +
						"<td>" + response.ptime + "</td>" + "</tr>";
					table.append(tr);
				}
			}
		});
	});
});
