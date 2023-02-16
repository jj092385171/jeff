// 載入 你的.html
$(document).ready(function() {

	//找到營地的值塞入
	var url = window.location.href;
	var campid = url.split("/").pop();

	// 一鍵輸入 
	$("#fastinput").click(function() {
		fastinport();
	});

	$.ajax({
		type: 'POST',
		url: '/morari/admin/user/work/selectCampid.controller/' + campid,
		dataType: 'json',
		success: function(data) {
			$('#uid').val(data.userprofiles.uid);
			$('#1').val(data.campName);
			$('#2').val(data.city.cityName + data.location);
			$('#3').val(data.campPicturesPath);

		}
	});

	//新增職缺
	$("#send").click(function() {

//  var uid =document.getElementById('uid')
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
			url: '/morari/admin/user/work/userInsert.controller',
			contentType: 'application/json',
			data: JSON.stringify(getFormData($("#insert"))),
			success: function(response) {
				$('#showInsert').empty("");
				$('#su').empty("");
				$('#insert').empty("");
				$('#img').empty("");
				if (response == null) {
					$('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
				} else {
					var h3 = $('#su');
					h3.prepend('新增成功');
					var table = $('#showInsert');
					table.append("<tr align='center'><th>會員編號</th><th>刊登編號</th><th>營區</th><th>地點</th><th>類型</th></th><th>職缺</th><th>薪資</th><th>人數</th><th>上班日期</th><th>上班時段</th><th>刊登時間</th><th>備註</th><th>照片</th></tr>");

					var tr = "<tr>" +
						"<td style='border: 1px solid #f2f2f2;padding: 8px;text-align: center;background-color:#dddbdb '>" + response.userprofiles.uid + "</td>" +
						"<td style='border: 1px solid #f2f2f2;padding: 8px;text-align: center;background-color:#dddbdb '>" + response.rackid + "</td>" +
						"<td style='border: 1px solid #f2f2f2;padding: 8px;text-align: center;background-color:#dddbdb '>" + response.campname + "</td>" +
						"<td style='border: 1px solid #f2f2f2;padding: 8px;text-align: center;background-color:#dddbdb '>" + response.place + "</td>" +
						"<td style='border: 1px solid #f2f2f2;padding: 8px;text-align: center;background-color:#dddbdb '>" + response.type + "</td>" +
						"<td style='border: 1px solid #f2f2f2;padding: 8px;text-align: center;background-color:#dddbdb '>" + response.job + "</td>" +
						"<td style='border: 1px solid #f2f2f2;padding: 8px;text-align: center;background-color:#dddbdb '>" + response.salary + "</td>" +
						"<td style='border: 1px solid #f2f2f2;padding: 8px;text-align: center;background-color:#dddbdb '>" + response.quantity + "</td>" +
						"<td style='border: 1px solid #f2f2f2;padding: 8px;text-align: center;background-color:#dddbdb '>" + response.date + "</td>" +
						"<td style='border: 1px solid #f2f2f2;padding: 8px;text-align: center;background-color:#dddbdb '>" + response.time + "</td>" +
						"<td style='border: 1px solid #f2f2f2;padding: 8px;text-align: center;background-color:#dddbdb '>" + response.rackup + "</td>" +
						"<td style='border: 1px solid #f2f2f2;padding: 8px;text-align: center;background-color:#dddbdb '>" + response.remark + "</td>" +
						"<td><img width='120px' height='120px' src='" + response.img + "'></td>" + "</tr>";
					table.append(tr);
				}
			}
		});
	});
});
function fastinport() {
	$("#type").val("長期工作");
	$("#job").val("房務員");
	$("#salary").val("36000");
	$("#quantity").val("1");
	$("#date").val("隨時");
	$("#time").val("10-19");
	$("#remark").val("細心、負責，交辦事項能完成");

}