$(document).ready(function() {

	let uid;
	fetch("/morari/utils/getuid")
		.then(response => response.text())
		.then(data => {
			// console.log(data)
			uid = data;
		}).then(() => {

			$("#campId").click(function() {

				$('#campID').empty("");
				var div = $('#campID');
				var input = "<form>請輸入會員編號<input type='text' id='uuid'><input class='btn btn-success btn-icon-split' type='button' value='查詢' onclick='submitForm()'></form>";
				div.append(input);
			})

			//找全部
			$.ajax({
				type: 'POST',
				url: '/morari/admin/work/jobShowAll.controller',
				contentType: 'application/json',
				success: function(response) {
					$('#showAll').empty("");
					$('#showAll').DataTable({
						"data": response,
						"columns": [

							{
								data: 'rackid',
								title: "刊登編號",
								responsivePriority: 1,
							},
							{
								data: 'userprofiles.uid',
								title: "會員編號",
								responsivePriority: 12,
							},

							{
								data: 'campname',
								title: "營區",
								responsivePriority: 2,
							},

							{
								data: 'place',
								title: "地點",
								responsivePriority: 8,
							},
							{
								data: 'type',
								title: "類型",
								responsivePriority: 5,
							},

							{
								data: 'job',
								title: "職缺",
								responsivePriority: 4,
							},

							{
								data: 'salary',
								title: "薪資",
								responsivePriority: 3,
							},

							{
								data: 'quantity',
								title: "人數",
								responsivePriority: 2,
							},

							{
								data: 'date',
								title: "上班日期",
								responsivePriority: 6,
							},

							{
								data: 'time',
								title: "上班時段",
								responsivePriority: 7,
							},

							{
								data: 'rackup',
								title: "刊登時間",
								responsivePriority: 10,
							},

							{
								data: 'remark',
								title: "備註",
								responsivePriority: 11,
							},

							{
								data: 'img',
								title: "照片",
								responsivePriority: 13,
								render: function(data, type, row) {
									return '<img width="300" src="' + data + '"/>';
								}
							},

							{
								data: null,
								title: "修改",
								responsivePriority: 1,
								render: function(data, type, row) {
//									return '<button style="border:none;background-color:transparent" id="delete"  onclick="jobUpdate(' + row.rackid + ')"><a href="#" class="btn btn-warning btn-circle"><i class="fas fa-user-edit"></i></a></button>';
									return '<button class=\"datatable_edit_button\" onclick=\"jobUpdate(\'' + row.rackid + '\')\"><i class=\"fas fa-sliders-h\"></i></button>'

								}
							},

							{
								data: null,
								title: "刪除",
								responsivePriority: 1,
								render: function(data, type, row) {
//									return '<button style="border:none;background-color:transparent" id="delete"  onclick="jobDelete(' + row.rackid + ')"><a href="#" class="btn btn-danger btn-circle"><i class="fas fa-trash-alt"></i></a></button>';
									return '<button class=\"datatable_del_button\"   onclick=\"jobDelete(\'' + row.rackid + '\')\"><i class=\"fas fa-trash-alt\"></i></button>'
								}
							},

						],
						"responsive": true,
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
	window.location.href = '/morari/admin/work/startUpdate.controller/' + rackid
};

// 新增 會員編號查詢秀營地
function submitForm() {
	var input1 = document.getElementById("uuid").value;
	$.ajax({
		type: 'POST',
		url: '/morari/admin/user/work/selectUUid.controller/' + input1,
		contentType: 'application/json',
		success: function(data) {
			$('#campName').empty("");
			
			if(data == null || data.length == 0){
				alert("該會員尚未新增營地資料")
			}else{
				
			$.each(data, function(i, n) {
				var table = $('#campName');
				var tr = "<tr align='center'>" +
					"<td>" + "<a style='color: 	#FF8C00' href='/morari/admin/work/insert.controller/" + n.campID + "'>" + n.campName + "</td>" +
					"</tr>"
				table.append(tr);
			});
				
			}
			
		}
	})
}


