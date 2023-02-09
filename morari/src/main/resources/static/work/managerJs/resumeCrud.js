// 載入 你的.html

$(document).ready(function() {

	let uid;
	fetch("/morari/utils/getuid")
		.then(response => response.text())
		.then(data => {
			// console.log(data)
			uid = data;
		}).then(() => {

			$.ajax({
				type: 'POST',
				url: '/morari/admin/resume/resumeShowAll.controller',
				contentType: 'application/json',
				success: function(response) {
					$('#showResume').empty("");
					$('#showResume').DataTable({
						"data": response,
						"columns":
							[

								{
									data: 'number',
									title: "履歷編號",
									width: "80px",
								},
								{
									data: 'userprofiles.uid',
									title: "會員編號",
									width: "80px"
								},

								{
									data: 'name',
									title: "姓名",
									width: "100px",
								},

								{
									data: 'age',
									title: "年次",
									width: "80px"
								},

								{
									data: 'gender',
									title: "性別",
									width: "70px"
								},

								{
									data: 'mail',
									title: "email",
									width: "100px"
								},

								{
									data: 'phone',
									title: "電話",
									width: "100px"
								},

								{
									data: 'educational',
									title: "學歷",
									width: "120px"
								},

								{
									data: 'skill',
									title: "專業技能",
									width: "130px"
								},

								{
									title: "修改",
									width: "80px",
									render: function(data, type, row) {
										return '<button style="border:none;background-color:transparent" id="delete"  onclick="resumeUpdate(' + row.number + ')"><a href="#" class="btn btn-warning btn-circle"><i class="fas fa-user-edit"></i></a></button>';

									}
								},
								{
									title: "刪除",
									width: "80px",
									render: function(data, type, row) {
										return '<button style="border:none;background-color:transparent" id="delete"  onclick="resumeDelete(' + row.number + ')"><a href="#" class="btn btn-danger btn-circle"><i class="fas fa-trash-alt"></i></a></button>';
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
});

function resumeDelete(number) {
	if (confirm("確定刪除該筆資料(履歷編號:" + number + ")?")) {
		$.ajax({
			type: 'delete',
			url: '/morari/admin/resume/resumeDelete.controller/' + number,
			dataType: 'TEXT',
			success: function(data) {
				alert(data);
				location.reload();
			}
		});
	} else {
	}
};

function resumeUpdate(number) {
	window.location.href = '/morari/admin/resume/update.controller/' + number

};





