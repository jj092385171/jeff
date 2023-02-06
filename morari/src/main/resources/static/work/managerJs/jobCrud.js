// 載入 你的.html
//fetch("/morari/work/html/jobCrud.html")
//	.then(response => response.text())
//	.then(html => {
//		// 將載入的 HTML 放入 .footer 元素中
//		document.querySelector(".crud").innerHTML = html;
//	});

$(document).ready(function() {

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
				success: function(response) {
					$('#showInsert').empty("");
					$('#showInsert').DataTable({
						"data": response,
						"columns": [

							{
								data: 'rackid',
								title: "刊登編號",
								width: "80px",
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
									return '<button style="border:none;background-color:transparent" id="delete"  onclick="jobDelete(' + row.rackid + ')"><a href="#" class="btn btn-danger btn-circle"><i class="fas fa-trash-alt"></i></a></button>';
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
		});
		})
	function jobDelete(rackid) {
		if (confirm("確定刪除該筆資料(刊登編號:" + rackid + ")?")) {
			$.ajax({
				type: 'delete',
				url: '/morari/admin/work/jobDelete.controller/' + rackid,
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
			window.location.href = '/morari/admin/work/startUpdate.controller/'+rackid
		
	};


