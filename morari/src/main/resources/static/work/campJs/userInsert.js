// 載入 你的.html
$(document).ready(function () {
			$("#send").click(function () {
				function getFormData($form) {
					var unindexed_array = $form.serializeArray();
					var indexed_array = {};

					$.map(unindexed_array, function (n, i) {
						indexed_array[n['name']] = n['value'];
					});
					
					return indexed_array;
				}
				$.ajax({
					type: 'POST',
					url: '/morari/admin/user/work/userInsert.controller',
					contentType: 'application/json',
					data: JSON.stringify(getFormData($("#insert"))),
					success: function (response) {
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
							 table.append("<tr><th>會員編號</th><th>刊登編號</th><th>刊登時間</th><th>職缺</th><th>薪資</th><th>人數</th><th>地點</th><th>可上班日期</th><th>可上班時段</th><th>備註</th><th>照片</th></tr>");

							//$.each(response, function (i,n) { i=index 第幾個 n=element 元素
								console.log("response:"+response);
								var tr = "<tr align='center'>" + 
								"<td>" + response.userprofiles.uid +"</td>"+
								"<td>" + response.rackid + "</td>" + 
								"<td>" + response.rackup + "</td>" + 
								"<td>" + response.job + "</td>" + 
								"<td>" + response.salary + "</td>" +
								"<td>" + response.quantity + "</td>" + 
								"<td>" + response.place + "</td>" + 
								"<td>" + response.date + "</td>" + 
								"<td>" + response.time + "</td>" + 
								"<td>" + response.remark + "</td>" + 
								"<td>" + response.img + "</td>" +"</tr>";
								table.append(tr);
							//});
						}
					}
				});
			});
		});