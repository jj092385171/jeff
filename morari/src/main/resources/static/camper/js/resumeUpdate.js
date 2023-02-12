// 載入 你的.html
let uid;
$(document).ready(function() {

	fetch("/morari/utils/getuid")
		.then(response => response.text())
		.then(data => {
			// console.log(data)
			uid = data;
		}).then(() => {

			$.ajax({
				type: 'GET',
				url: '/morari/guest/work/guestSelectResume.controller/' + uid,
				contentType: 'application/json',
				success: function(data) {
					console.log(data);
					console.log(data.unmber);
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
			url: '/morari/admin/resume/resumeUpdate.controller/' + data.number,
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
					table.append("<tr><th>會員編號</th><th>姓名</th><th>年次</th><th>性別</th><th>email</th><th>電話</th><th>學歷</th><th>專業技能</th></tr>");


					console.log("response:" + response);
					var tr = "<tr align='center'>" +
						"<td>" + response.userprofiles.uid + "</td>" +
						"<td>" + response.name + "</td>" +
						"<td>" + response.age + "</td>" +
						"<td>" + response.gender + "</td>" +
						"<td>" + response.mail + "</td>" +
						"<td>" + response.phone + "</td>" +
						"<td>" + response.educational + "</td>" +
						"<td>" + response.skill + "</td></tr>";
					table.append(tr);
				}
			}
		});
	});
				}
			})
		})
		

})