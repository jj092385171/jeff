// 顯示畫面
$(function(){
	$.ajax({
		url:"/morari/showall.controller",
		dataType:"JSON",
		contentType:"application/json",
		success: function(data){
			var table = $("#allpost");
			table.append("<tr><th>貼文編號</th><th>會員編號</th><th>標題</th><th>內容</th><th>人數</th><th>價錢</th><th>縣市</th><th>起始日期</th><th>結束日期</th><th>評分</th><th>更新日期</th><th>喜歡人數</th><th>不喜歡人數</th><th>檢舉貼文</th><th>隱藏貼文</th></tr>")
			
			$.each(data, function(i,n){
				// i=index 第幾個 n=element 元素
				var tr = "<tr align='center'>" + 
				"<td>" + n.postid + "</td><td>" + n.uid + "</td><td>" + n.title + "</td><td>" + n.content +"</td><td>" + n.people + "</td><td>" + 
				n.price + "</td><td>" + n.county + "</td><td>" + n.startdate + "</td><td>" + n.enddate + "</td><td>" + n.score + "</td><td>" + 
				n.releasedate + "</td><td>" + n.userlike + "</td><td>" + n.userunlike + "</td><td>" + n.postreport + "</td><td>" + n.posthide +
				
				// "<button onclick='window.location.href = \"/morari/forum/showupdate.controller/" + n.postid + "\"'>修改貼文</button>" +
				
				"</td><td><button onclick='window.location.href = \"/morari/admin/forum/showupdateadmin.controller/" + n.postid + "\"'>修改貼文</button></td>";
				
				
				if(n.posthide == 0){
					tr += "<td><from><button onclick=hidepost(" + n.postid + ")>隱藏貼文</button></from></td>";
				}else{
					tr += "<td><from><button onclick=cancelhidepost(" + n.postid + ")>取消隱藏貼文</button></from></td>";
				}
				
				if(n.postreport == 1){
					tr += "<td><from><button onclick=cancelreportpost(" + n.postid + ")>取消檢舉貼文</button></from></td>";
				}
				
				tr += "</tr>";
				table.append(tr);
			});
		}
	
	});
	
});

function hidepost(id){
	$.ajax({
		type:"put",
		url:"/morari/hidepost.controller/" + id,
		dataType:"JSON",
		contentType:"application/json",
		success: function(data){
			if(data == true){
				alert("隱藏成功")
				location.reload();
			}
		}
	});
}
	
function cancelhidepost(id){
	$.ajax({
		type:"put",
		url:"/morari/cancelhidepost.controller/" + id,
		dataType:"JSON",
		contentType:"application/json",
		success: function(data){
			if(data == true){
				alert("取消隱藏成功")
				location.reload();
			}
		}
	});
}

function cancelreportpost(id){
	$.ajax({
		type:"put",
		url:"/morari/cancelreportpost.controller/" + id,
		dataType:"JSON",
		contentType:"application/json",
		success: function(data){
			if(data == true){
				alert("取消檢舉成功")
				location.reload();
			}
		}
	});
}