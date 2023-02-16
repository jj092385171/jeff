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
			switch (data.type) {
				case '短期工讀':
					$("#17").attr('selected', true)
					break;
				case '長期工作':
					$("#18").attr('selected', true)
					break;
				case '打工換宿':
					$("#19").attr('selected', true)
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
					table.append("<tr align='center'><th>會員編號</th><th>刊登編號</th><th>營區</th><th>地點</th><th>類型</th></th><th>職缺</th><th>薪資</th><th>人數</th><th>上班日期</th><th>上班時段</th><th>刊登時間</th><th>備註</th><th>照片</th></tr>");

					var tr = "<tr>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.userprofiles.uid + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.rackid + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.campname + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.place + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.type + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.job + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.salary + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.quantity + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.date + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.time + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.rackup + "</td>" +
						"<td style='border: 1px solid #dddbdb;padding: 8px;text-align: center;background-color:#dddbdb'>" + response.remark + "</td>" +
						"<td><img width='80' height='80' src='"+ response.img +"'></td>" + "</tr>";
					table.append(tr);
					//});
				}
			}
		});
	});
});