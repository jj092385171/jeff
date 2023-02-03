// 載入 你的.html
//fetch("/morari/work/html/jobCrud.html")
//	.then(response => response.text())
//	.then(html => {
//		// 將載入的 HTML 放入 .footer 元素中
//		document.querySelector(".crud").innerHTML = html;
//	});

$(document).ready(function () {

	let uid;
	fetch("/morari/utils/getuid")
		.then(response => response.text())
		.then(data => {
			// console.log(data)
			uid = data;
		}).then(() => {
			
			//找全部
			$.ajax({
				type: 'POST',
				url: '/morari/admin/work/jobShowAll.controller',
				contentType: 'application/json',
				//data: JSON.stringify(getFormData($("#insert"))),
				success: function (data) {
					$('#showInsert').empty("");

					if (data == null) {
						$('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
					} else {
						//var h3 = $('#su');
						//h3.prepend('新增成功');
						var table = $('#showInsert');
						table.append("<tr><th>會員編號</th><th>刊登編號</th><th>刊登時間</th><th>職缺</th><th>薪資</th><th>人數</th><th>地點</th><th>可上班日期</th><th>可上班時段</th><th>備註</th><th>照片</th><th></th></tr>");


						$.each(data, function (i, n) {
							var tr = "<tr align='center'>" +
								"<td>" + n.userprofiles.uid + "</td>" +
								"<td>" + n.rackid + "</td>" +
								"<td>" + n.rackup + "</td>" +
								"<td>" + n.job + "</td>" +
								"<td>" + n.salary + "</td>" +
								"<td>" + n.quantity + "</td>" +
								"<td>" + n.camp.city + n.camp.location + "</td>" +
								"<td>" + n.date + "</td>" +
								"<td>" + n.time + "</td>" +
								"<td>" + n.remark + "</td>" +
								"<td>" + n.camp.campPicturesPath + "</td>" +
								"<td><form action='update.controller/" + n.rackid + "' method='POST'><input type='submit' value='修改'></form></td>" +
								"<td><button id='delete' onclick='jobDelete(" + n.rackid + ")'>刪除</button></td>" + "</tr>";
							table.append(tr);
						});
					}
				}
			});

			
		});

});
function jobDelete(rackid) {
	if (confirm("確定刪除該筆資料(刊登編號:" + rackid + ")?")) {
		$.ajax({
			type: 'delete',
			url: '/morari/admin/work/jobDelete.controller/' + rackid,
			dataType: 'TEXT',
			success: function (data) {
				alert(data);
				location.reload();
			}
		});
	} else {
	}
};



