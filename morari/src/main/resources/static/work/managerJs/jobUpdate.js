// 載入 你的.html
$(document).ready(function () {
			var url = window.location.href;
			var id = url.split("/").pop();
			console.log(id);
			
			$.ajax({
				type: 'POST',
				url: '/morari/admin/work/selectRackId.controller/'+id,
				dataType: 'json',			
				success: function (data) {
					console.log(data.userprofiles.uid)
					$('#1').val(data.userprofiles.uid);
					$('#2').val(data.job);
					$('#3').val(data.salary);
					$('#4').val(data.quantity);
					$('#5').val(data.place);
					$('#6').val(data.date);
					$('#7').val(data.time);
					$('#8').val(data.remark);
					
				}
			});
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
				$.ajax({
					type: 'Put',
					url: '/morari/admin/work/jobUpdate.controller/'+id,
					contentType: 'application/json',
					data: JSON.stringify(getFormData($("#update"))),
					success: function (response) {
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
							table.append("<tr><th>會員編號</th><th>刊登編號</th><th>刊登時間</th><th>職缺</th><th>薪資</th><th>人數</th><th>地點</th><th>可上班日期</th><th>可上班時段</th><th>備註</th><th>照片</th></tr>");
//							var date = new Date(response.rackup);
//							var formattedDate = date.toLocaleDateString("yyyy-MM-dd");
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