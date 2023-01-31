// 載入 你的.html
$(document).ready(function () {
			$("#send").click(function () {
				function getFormData($form) {
					var unindexed_array = $form.serializeArray();
					var indexed_array = {};

					$.map(unindexed_array, function (n, i) {
						indexed_array[n['name']] = n['value'];
					});
					console.log(indexed_array);
					return indexed_array;
				}
				var url = window.location.href;
				var id = url.split("/").pop();
				console.log(id);
				$.ajax({
					type: 'POST',
					url: '/morari/guest/work/resumeInsert.controller/'+id,
					contentType: 'application/json',
					data: JSON.stringify(getFormData($("#insert"))),
					success: function (response) {
						$('#showInsert').empty("");
						$('#su').empty("");
						$('#insert').empty("");
						console.log(response);
						if (response == null) {
							$('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
						} else {
							var h3 = $('#su');
							h3.prepend('成功送出');
							var table = $('#showInsert');
							table.append("<tr><th>會員編號</th><th>應徵職缺</th><th>姓名</th><th>年次</th><th>性別</th><th>email</th><th>電話</th><th>學歷</th><th>經歷</th><th>填寫時間</th></tr>");

						
							//$.each(response, function (i,n) { i=index 第幾個 n=element 元素
								console.log("response:"+response);
								var tr = "<tr align='center'>" + 
								"<td>" + response.userprofiles.uid +"</td>"+
								"<td>" + response.work + "</td>" + 
								"<td>" + response.name + "</td>" + 
								"<td>" + response.age + "</td>" +
								"<td>" + response.gender + "</td>" +
								"<td>" + response.mail + "</td>" + 
								"<td>" + response.phone + "</td>" + 
								"<td>" + response.educational + "</td>" + 
								"<td>" + response.experience + "</td>" +
								"<td>" + response.ptime + "</td>" +"</tr>";
								table.append(tr);
							//});
						}
					}
				});
			});
		});