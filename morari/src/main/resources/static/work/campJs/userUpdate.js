// 載入 你的.html
$(document).ready(function() {

//	let uid;
//	fetch("/morari/utils/getuid")
//		.then(response => response.text())
//		.then(data => {
//			// console.log(data)
//			uid = data;
//		})

	var url = window.location.href;
	var id = url.split("/").pop();
	console.log(id);

	$.ajax({
		type: 'POST',
		url: '/morari/admin/user/work/userSelectRackId.controller/' + id,
		dataType: 'json',
		success: function(data) {
			$('#1').val(data.userprofiles.uid);
			$('#2').val(data.campname);
			$('#3').val(data.place);
			$('#4').val(data.salary);
			$('#5').val(data.quantity);
			$('#6').val(data.date);
			$('#7').val(data.time);
			$('#8').val(data.remark);
			$('#9').val(data.img);
			console.log(data.job);

			switch (data.job) {
				case '廚師':
					$("#10").attr('selected', true)
					break;
				case '廚助':
					$("#11").attr('selected', true)
					break;
				case '櫃台':
					$("#12").attr('selected', true)
					break;
				case '房務員':
					$("#13").attr('selected', true)
					break;
				case '清潔員':
					$("#14").attr('selected', true);
					break;
				case '假日工讀生':
					$("#15").attr('selected', true)
					break;
				case '夜間值班員':
					$("#16").attr('selected', true)
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
			url: '/morari/admin/user/work/userUpdate.controller/' + id,
			contentType: 'application/json',
			data: JSON.stringify(getFormData($("#update"))),
			success: function(response) {
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
					table.append("<tr><th>會員編號</th><th>刊登編號</th><th>營區</th><th>地點</th><th>職缺</th><th>薪資</th><th>人數</th><th>上班日期</th><th>上班時段</th><th>刊登時間</th><th>備註</th><th>照片</th></tr>");

					console.log("response:" + response);
					var tr = "<tr align='center'>" +
						"<td>" + response.userprofiles.uid + "</td>" +
						"<td>" + response.rackid + "</td>" +
						"<td>" + response.campname + "</td>" +
						"<td>" + response.place + "</td>" +
						"<td>" + response.job + "</td>" +
						"<td>" + response.salary + "</td>" +
						"<td>" + response.quantity + "</td>" +
						"<td>" + response.date + "</td>" +
						"<td>" + response.time + "</td>" +
						"<td>" + response.rackup + "</td>" +
						"<td>" + response.remark + "</td>" +
						"<td><img width='80' height='80' src='/morari/src/main/resources/static/images/'" + response.img + "></td>" + "</tr>";
					table.append(tr);
					//});
				}
			}
		});
	});
});