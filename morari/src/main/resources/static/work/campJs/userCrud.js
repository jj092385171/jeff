// 載入 你的.html
$(document).ready(function() {

	let uid;
	fetch("/morari/utils/getuid")
		.then(response => response.text())
		.then(data => {
			// console.log(data)
			uid = data;
		}).then(() => {
			//找營地名稱
			$("#campId").click(function() {

				$('#campName').empty("");
				$.ajax({
					type: 'POST',
					url: '/morari/admin/user/work/selectUUid.controller/' + uid,
					contentType: 'application/json',
					success: function(data) {
						console.log(data);
						$.each(data, function(i, n) {
							var table = $('#campName');
							var tr = "<tr align='center'>" +
								"<td>" + "<a href='/morari/admin/user/work/startInsert.controller/" + n.campID + "'>" + n.campName + "</td>" +
								"</tr>"
							table.append(tr);
						});
					}
				})

			})
			$.ajax({
				type: 'POST',
				url: '/morari/admin/user/work/userSelectUid.controller/' + uid,
				contentType: 'application/json',
				success: function(response) {
					$('#showInsert').empty("");
					$('#showInsert').DataTable({
						"data": response,
						"columns": [

							{
								title: "刊登編號",
								width: "80px",
								render: function(data, type, row) {
								return "<a href='/morari/admin/user/resume/resumeStartCrud.controller/" + row.rackid + "'>" + row.rackid 
								}
							},
							{
								data: 'userprofiles.uid',
								title: "會員編號",
								width: "100px"
							},

							{
								data: 'campname',
								title: "營區",
								width: "80px"
							},

							{
								data: 'place',
								title: "地點",
								width: "100px"
							},

							{
								data: 'job',
								title: "職缺",
								width: "100px",
							},

							{
								data: 'salary',
								title: "薪資",
								width: "100px"
							},

							{
								data: 'quantity',
								title: "人數",
								width: "70px"
							},

							{
								data: 'date',
								title: "上班日期",
								width: "60px"
							},

							{
								data: 'time',
								title: "上班時段",
								width: "50px"
							},

							{
								data: 'rackup',
								title: "刊登時間",
								width: "40px"
							},

							{
								data: 'remark',
								title: "備註",
								width: "100px"
							},

							{
								data: 'img',
								title: "照片",
								width: "100px"
							},

							{
								title: "修改",
								width: "100px",
								render: function(data, type, row) {
									return '<button style="border:none;background-color:transparent" id="delete"  onclick="jobUpdate(' + row.rackid + ')"><a href="#" class="btn btn-warning btn-circle"><i class="fas fa-user-edit"></i></a></button>';
								
								}
							},
							{
								title: "刪除",
								width: "100px",
								render: function(data, type, row) {
									return '<button style="border:none;background-color:transparent" id="delete"  onclick="userDelete(' + row.rackid + ')"><a href="#" class="btn btn-danger btn-circle"><i class="fas fa-trash-alt"></i></a></button>';
								}
							},

						],
						
						lengthMenu: [5, 10, 15, 20],
						language: {
							"lengthMenu": "顯示_MENU_ 筆資料",
							"info": "第 _START_ 至 _END_ 筆資料，共 _TOTAL_ 筆",
							"search": "搜尋：",
							"paginate": {
								"previous": " 上一頁__",
								"next": "__下一頁"
							}
						}
					});
				}
			});

//			$.ajax({
//				type: 'POST',
//				url: '/morari/admin/user/work/userSelectUid.controller/' + uid,
//				contentType: 'application/json',
//				//data: JSON.stringify(getFormData($("#insert"))),
//				success: function(data) {
//					$('#showInsert').empty("");
//
//					if (data == null) {
//						$('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
//					} else {
//						var table = $('#showInsert');
//						table.append("<tr><th>會員編號</th><th>刊登編號</th><th>營區</th><th>地點</th><th>職缺</th><th>薪資</th><th>人數</th><th>上班日期</th><th>上班時段</th><th>刊登時間</th><th>備註</th><th>照片</th><th></th></tr>");
//						$.each(data, function(i, n) {
//							var tr = "<tr align='center'>" +
//								"<td>" + n.userprofiles.uid + "</td>" +
//								"<td>" + "<a href='/morari/admin/user/resume/resumeStartCrud.controller/" + n.rackid + "'>" + n.rackid + "</td>" +
//								"<td>" + n.campname + "</td>" +
//								"<td>" + n.place + "</td>" +
//								"<td>" + n.job + "</td>" +
//								"<td>" + n.salary + "</td>" +
//								"<td>" + n.quantity + "</td>" +
//								"<td>" + n.date + "</td>" +
//								"<td>" + n.time + "</td>" +
//								"<td>" + n.rackup + "</td>" +
//								"<td>" + n.remark + "</td>" +
//								"<td><img width='80' height='80' src='/morari/src/main/resources/static/images/'" + n.img + "></td>" + 
//								"<td><form action='startUpdate.controller/" + n.rackid + "' method='POST'><input type='submit' value='修改'></form></td>" +
//								"<td><button id='delete' onclick='userDelete(" + n.rackid + ")'>刪除</button></td>" + "</tr>";
//							table.append(tr);
//						});
//					}
//				}
//			});


		})

});
function userDelete(rackid) {
	if (confirm("確定刪除該筆資料(刊登編號:" + rackid + ")?")) {
		$.ajax({
			type: 'delete',
			url: '/morari/admin/user/work/userDelete.controller/' + rackid,
			dataType: 'TEXT',
			success: function(data) {
				alert(data);
				location.reload();
			}
		});
	} else {
	}
};
function jobUpdate(rackid) {
			window.location.href = '/morari/admin/user/work/startUpdate.controller/'+rackid
		
	};