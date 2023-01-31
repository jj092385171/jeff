// 載入 你的.html
 $(document).ready(function() {
    	$.ajax({
    		type: 'POST',
    		url: '/morari/admin/user/work/userSelectUid.controller/'+1,
    		contentType: 'application/json',
    		//data: JSON.stringify(getFormData($("#insert"))),
    		success: function(data) {
    			$('#showInsert').empty("");

    			if (data == null) {
    				$('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
    			} else {
    				var table = $('#showInsert');
    				table.append("<tr><th>會員編號</th><th>刊登編號</th><th>刊登時間</th><th>職缺</th><th>薪資</th><th>人數</th><th>地點</th><th>可上班日期</th><th>可上班時段</th><th>備註</th><th>照片</th><th></th></tr>");

    				$.each(data, function(i, n) {
    					var tr = "<tr align='center'>" +
    						"<td>" + n.userprofiles.uid + "</td>" +
    						"<td>" + "<a href='/morari/admin/user/resume/resumeStartCrud.controller/" + n.rackid + "'>" + n.rackid + "</td>" +
    						"<td>" + n.rackup + "</td>" +
    						"<td>" + n.job + "</td>" +
    						"<td>" + n.salary + "</td>" +
    						"<td>" + n.quantity + "</td>" +
    						"<td>" + n.place + "</td>" +
    						"<td>" + n.date + "</td>" +
    						"<td>" + n.time + "</td>" +
    						"<td>" + n.remark + "</td>" +
    						"<td>" + n.img + "</td>" +
    						"<td><form action='startUpdate.controller/" + n.rackid + "' method='POST'><input type='submit' value='修改'></form></td>" +
    						"<td><button id='delete' onclick='userDelete(" + n.rackid + ")'>刪除</button></td>" + "</tr>";
    					table.append(tr);
    				});
    			}
    		}
    	});

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