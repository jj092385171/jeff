// 載入 你的.html


$(document).ready(function() {
//    fetch("/morari/work/html/resumeCrud.html")
//	.then(response => response.text())
//	.then(html => {
//		// 將載入的 HTML 放入 .footer 元素中
//		document.querySelector(".resumeCrud").innerHTML = html;
//	});
    	$.ajax({
    		type: 'POST',
    		url: '/morari/admin/resume/resumeShowAll.controller',
    		contentType: 'application/json',
    		//data: JSON.stringify(getFormData($("#insert"))),
    		success: function(data) {
    			$('#showInsert').empty("");

    			if (data == null) {
    				$('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
    			} else {
    				var table = $('#showInsert');
    				table.append("<tr><th>刊登編號</th><th>履歷編號</th><th>會員編號</th><th>應徵職缺</th><th>姓名</th><th>年次</th><th>性別</th><th>email</th><th>電話</th><th>學歷</th><th>經歷</th><th>填寫時間</th><th></th></tr>");


    				$.each(data, function(i, n) {
    					var tr = "<tr align='center'>" + 
    					"<td>" + n.job.rackid + "</td>" +
    					"<td>" + n.number + "</td>" +
						"<td>" + n.userprofiles.uid +"</td>"+
						"<td>" + n.work + "</td>" + 
						"<td>" + n.name + "</td>" + 
						"<td>" + n.age + "</td>" +
						"<td>" + n.gender + "</td>" +
						"<td>" + n.mail + "</td>" + 
						"<td>" + n.phone + "</td>" + 
						"<td>" + n.educational + "</td>" + 
						"<td>" + n.experience + "</td>" +
						"<td>" + n.ptime + "</td>" +
    					"<td><form action='update.controller/" + n.number + "' method='POST'><input type='submit' value='修改'></form></td>" +
    					"<td><button id='delete' onclick='resumeDelete(" + n.number + ")'>刪除</button></td>" + "</tr>";
    					table.append(tr);
    				});
    			}
    		}
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


