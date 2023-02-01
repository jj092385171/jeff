// 載入 你的.html
$(document).ready(function () {
			$.ajax({
				type: 'POST',
				url: '/morari/admin/work/jobShowAll.controller',
				contentType: 'application/json',
				success: function (data) {
					$('#showInsert').empty("");

					if (data == null) {
						$('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
					} else {
 				
						var table = $('#showInsert');
						table.append("<tr><th>職缺</th><th>刊登時間</th><th>薪資</th><th>人數</th><th>地點</th><th>可上班日期</th><th>可上班時段</th><th>備註</th><th>照片</th><th></th></tr>");

						$.each(data, function (i, n) {
							var tr = "<tr align='center'>" + 
							"<td>" + n.job + "</td>" + 
							"<td>" + n.rackup + "</td>" + 
							"<td>" + n.salary + "</td>" + 
							"<td>" + n.quantity + "</td>" + 
							"<td>" + n.place + "</td>" + 
							"<td>" + n.date + "</td>" + 
							"<td>" + n.time + "</td>" + 
							"<td>" + n.remark + "</td>" + 
							"<td>" + n.img + "</td>" + 
							"<td><form action='startResumeInsert.controller/"+ n.rackid +"' method='POST'><input type='submit' value='我要應徵'></form></td></tr>";					
							table.append(tr);
						});
					}
				}
			});
		});
		function selectJob(job) {
		$.ajax({
			type:'POST',
			url: '/morari/guest/work/guestSelectLike.controller/'+job,
			dataType:'json',
			success: function (data) {
				$('#showInsert').empty("");
				$('#su').empty("");
				
					console.log(data);
				if (data.length == 0||data== null) {
					$('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
				} else {
					var h3 = $('#su');
					h3.prepend('查詢結果');
					var table = $('#showInsert');
					table.append("<tr><th>職缺</th><th>刊登時間</th><th>薪資</th><th>人數</th><th>地點</th><th>可上班日期</th><th>可上班時段</th><th>備註</th><th>照片</th><th></th></tr>");

					$.each(data, function (i, n) {
						console.log("data:" + data);
						var tr = "<tr align='center'>" + 
						"<td>" + n.job + "</td>" + 
						"<td>" + n.rackup + "</td>" + 
						"<td>" + n.salary + "</td>" + 
						"<td>" + n.quantity + "</td>" + 
						"<td>" + n.place + "</td>" + 
						"<td>" + n.date + "</td>" + 
						"<td>" + n.time + "</td>" + 
						"<td>" + n.remark + "</td>" + 
						"<td>" + n.img + "</td>" + 
						"<td><form action='startResumeInsert.controller/"+ n.rackid +"' method='POST'><input type='submit' value='我要應徵'></form></td></tr>";					
						table.append(tr);
					});
				}
			}
		});
	};