$(function(){
	$.ajax({
		url:"/morari/shownonhidepost.controller",
		dataType:"JSON",
		contentType:"application/json",
		success: function(data){
			var table = $("#allpost");
			$.each(data, function(i,n){
				// i=index 第幾個 n=element 元素
				var tr = "<tr align='center'>" + "<td>" + n.title + "<br>" + n.content + "<br>" + "<a href='/morari/forum/showpost.controller/" + n.postid + "'>查看貼文</a><br><br>" + "</td>" + "</tr>";
				table.append(tr);
				console.log(n.postid);
			});
		}
	});
});