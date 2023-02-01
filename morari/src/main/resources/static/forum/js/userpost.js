$(function () {
	let uid;
	fetch("/morari/utils/getuid")
		.then(response => response.text())
		.then(data => {
			uid = "/morari/showpostbyuserid.controller/" + data
		}).then(() => {
			$.ajax({
				url:  uid,
				dataType: "JSON",
				contentType: "application/json",
				success: function (data) {
					var table = $("#userpost");
					$.each(data, function (i, n) {
						// i=index 第幾個 n=element 元素
						var tr = "<tr border='1'><td><h4>" + n.title + "</h4><br>" + n.content + "<br>" +
						"<button onclick='window.location.href = \"/morari/forum/showpost.controller/" + n.postid + "\"'>查看貼文</button>" +

						"<button onclick='window.location.href = \"/morari/forum/showupdate.controller/" + n.postid + "\"'>修改貼文</button>" +
							// "<button formaction='/morari/forum/showupdate.controller/" + n.postid + "'>修改貼文</button></form>" +
							"<br>" + "</td>" + "</tr>";
						table.append(tr);
					});
				}
			});
		})


});