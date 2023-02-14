// 顯示畫面
$(function(){
	// postid
	let url = window.location.href;
	let arr = url.split('/');
	let postid = arr[arr.length - 1];
	$('#postcomment').DataTable({
		"ajax":{
			url:"/morari/showpostcommentbypostid.controller/" + postid,
			dataSrc:""
		},
		lengthMenu: [5, 10, 15, 20],
		language: {
			"lengthMenu": "顯示 _MENU_ 筆資料",
			"info": "顯示第 _START_ 至 _END_ 筆資料，共 _TOTAL_ 筆",
			"search": "搜尋：",
			"paginate": {
				"next": "下一頁",
				"previous": "上一頁",
				"first": "首頁",
				"last": "末頁",
			}
		},
		"columns":[
			{data:"postcommentid", title:"留言編號"},
			{data:"uid", title:"會員編號"},
			{data:"postcomment", title:"留言內容"},
			{data:"postcommentreport", title:"是否檢舉留言",
				render: function(data,type,row) {
					if (row.postcommentreport == 0) {
							return "否";
						}else{
							return "是";
						}
				}
			},
			{data:"postcommenthide", title:"是否隱藏留言", 
				render: function(data,type,row) {
					if (row.postcommenthide == 0) {
							return "否";
						}else{
							return "是";
						}
				}
			},
  			{
			    title: "隱藏/取消隱藏留言",
			    render: function(data,type,row) {
			      	if(row.postcommenthide == 0){
			      		return '<button class="my-button datatable_hide_button" onclick="hidepostcomment('+ row.postcommentid +')"><i class=\"fas fa-eye-slash\"></i></button>';
			      	}else{
						return '<button class="my-button datatable_hide_button" onclick="cancelhidepostcomment('+ row.postcommentid +')"><i class=\"fas fa-eye\"></i></button>';
					}
			    }
  			},
  			{
			    title: "取消檢舉留言",
			    render: function(data,type,row) {
			    	if(row.postcommentreport == 1){
						return '<button class="my-button datatable_report_button" onclick="cancelreportpostcomment('+ row.postcommentid +')"><i class=\"fas fa-bell-slash\"></i></button>';
					}
					return null;
			    }
  			}
			]
	
	});
	
});

function hidepostcomment(id){
	if (confirm("是否確定隱藏留言?")) {
		$.ajax({
			type:"put",
			url:"/morari/hidepostcomment.controller/" + id,
			dataType:"JSON",
			contentType:"application/json",
			success: function(data){
				if(data == true){
					alert("隱藏留言成功");
					location.reload();
				}
			}
		});
	}
}
	
function cancelhidepostcomment(id){
	if (confirm("是否確定取消隱藏留言?")) {
		$.ajax({
			type:"put",
			url:"/morari/cancelhidepostcomment.controller/" + id,
			dataType:"JSON",
			contentType:"application/json",
			success: function(data){
				if(data == true){
					alert("取消隱藏留言成功");
					location.reload();
				}
			}
		});
	}
}

function cancelreportpostcomment(id){
	if (confirm("是否確定取消檢舉留言?")) {
		$.ajax({
			type:"put",
			url:"/morari/cancelreportpostcomment.controller/" + id,
			dataType:"JSON",
			contentType:"application/json",
			success: function(data){
				if(data == true){
					alert("取消檢舉留言成功");
					location.reload();
				}
			}
		});
	}
}