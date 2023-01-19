// 載入 你的.html
//fetch("/morari/forum/html/newpost.html")
//    .then(response => response.text())
//    .then(html => {
//        // 將載入的 HTML 放入 .footer 元素中
//        document.querySelector(".newpost").innerHTML = html;
//    });

// 送資料判斷
	
    
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
				"<td>" + n.postid + "</td><td>" + n.userid + "</td><td>" + n.title + "</td><td>" + n.content +"</td><td>" + n.people + "</td><td>" + 
				n.price + "</td><td>" + n.county + "</td><td>" + n.startdate + "</td><td>" + n.enddate + "</td><td>" + n.score + "</td><td>" + 
				n.releasedate + "</td><td>" + n.userlike + "</td><td>" + n.userunlike + "</td><td>" + n.postreport + "</td><td>" + n.posthide + "</td><td><a href='/morari/forum/showupdate.controller/" + n.postid + "'>修改貼文</a></td></tr>";
				table.append(tr);
			});
		}
	});
});