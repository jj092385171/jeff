fetch('view.controller', { method: 'GET' }).then(
			function (response) {
				if (response.status != 200) {
					console.log(response.satus);
					return;
				}
				
				console.log(response);


				response.json().then(function (data) {
					
					data.forEach(function(row) {
    				if (row.pair === 1) {
      				row.pair = "不可配對";
    				} else if (row.pair === 0) {
      				row.pair = "可配對";
    				}
  				});
					
					$('#result').DataTable({
      				data: data,
      				columns: [
        				{
        			data: null,
        			render: function(data, type, row) {
          			return `
            			<form action="/delete.controller/${data.initiatingnum}" method="delete">
              			<input type="hidden" name="dnum" value="${data.initiatingnum}">
              			<button type="button" name="delete">刪除</button>
            			</form>
            			<form action="/morari/team/update.controller" method="get">
              			<input type="hidden" name="dnum" value="${data.initiatingnum}">
              			<input type="hidden" name="pman" value="${data.userprofiles.uid}">
              			<button type="submit" name="update">修改</button>
            			</form>
          `			;
        			}
      				},
      				{ data: 'initiatingnum', title: '揪團編號' },
      				{ data: 'userprofiles.uid', title: '發文會員' },
      				{ data: 'postdate', title: '發文日期', render: function (data, type, row) {
      					return data.split('T')[0];
    					} },
      				{ data: 'startdate', title: '開始日期', render: function (data, type, row) {
      					return data.split('T')[0];
    					} },
      				{ data: 'enddate', title: '結束日期', render: function (data, type, row) {
      					return data.split('T')[0];
    					} },
      				{ data: 'currentnum', title: '目前人數' },
      				{ data: 'acceptablenum', title: '接受人數' },
      				{ data: 'camparea', title: '露營地點' },
      				{ data: 'pair', title: '配對狀態' },

      							],
      				lengthMenu: [5, 10, 15, 20],
      				language: {
					"lengthMenu":     "顯示 _MENU_ 筆資料",
					"info":           "顯示第 _START_ 至 _END_ 筆資料，共 _TOTAL_ 筆",
					"search":         "搜尋：",
					"paginate": {
         				"next":       "下一頁",
         				"previous":   "上一頁"
      				}
					}
      							
    							});
							});
			});
		
		var xh = new XMLHttpRequest();
		xh.open('get', 'view.controller', true);
		xh.send();
		
		document.getElementById("result").addEventListener("click", function(event) {
			  if (event.target.name === "delete") {
				  	var name = event.target.name;
		        	console.log(name);
		            var formData = new FormData(event.target.form);
		            var value = formData.get('dnum');
		            console.log(value);
		            
		            // 發出 DELETE 請求
		            var xhr = new XMLHttpRequest();
		            if(name == "delete"){
		            	var result = confirm("確定要刪除此筆資料嗎？");
		            	
		            	if(result){
		           		xhr.open('DELETE', 'delete.controller/{' + value + "}");
		            	xhr.onload = function() {
		            	  if (xhr.status === 200) {
		            	    console.log(xhr.responseText);
		            	    location.href="/morari/team/teammanager.controller";
		            	  }
		            	  else {
		            	    console.error(xhr.responseText);
		            	  }
		            	};
		           		xhr.send();
		            	}
		            
		            }
			  }
		});
	
		xh.onload = function () {

			var data = JSON.parse(xh.responseText);
			
			document.querySelectorAll("button").forEach(function(button) {
		        button.addEventListener("click", function(event) {
		        	
		        	// 取得表單輸入
		        	var name = button.name;
		        	console.log(name);
		            var formData = new FormData(button.form);
		            var value = formData.get('dnum'); 
		           
		     	    if(name == "select"){
		     			
		     			console.log(formData)
		     			var startdate = formData.get('startdate');
		     			console.log(startdate);
		     			var enddate = formData.get('enddate');
		     			console.log(enddate);
		     			
		     			if(startdate > enddate && startdate != "" && enddate != ""){
		     				alert("起始日期不可小於結束日期，這不是時空旅行！！！");
		     				return;
		     			}else{
		     				
		     			var inum = formData.get('initiatingnum');
			     		formData.delete("initiatingnum");
			     		formData.append("initiatingnum", parseInt(inum));
			     		var uid = formData.get("userprofiles");
			     		console.log(uid);
			     		formData.delete("userprofiles");
		     				
		     			const data = Object.fromEntries(formData);
						const json = JSON.stringify(data);
		     			
		     			fetch('select.controller/{' + uid + '}', {
							method: 'POST',
							headers: {
								'Content-Type': 'application/json'
							},
							body: json
						})
							.then(function (response) {
								console.log(response);
								if (response.status == 200) {
									response.json().then(function (data){
										var resultText = "";
										var tableData = "";
										tableData += 
										"<td>" + "揪團編號" + 
										"</td>" + "<td>" + "發文會員" + 
										"</td>" + "<td>" + "發文日期" + "</td>" + "<td>" + "開始日期" + "</td>" + "<td>" +
										"結束日期" + "</td>" + "<td>" + "目前人數" + "</td>" + "<td>" + "接受人數" + "</td>" +
										"<td>" + "露營地點" + "</td>" + "<td>" + "配對狀態" + "</td>"
										;
										if(data.length == 0){
											tableData = "查無資料";
										}
										for (var i = 0; i < data.length; i++) {
											var pDay = new Date(data[i].postdate).toLocaleDateString("zh-TW", {year: 'numeric', month: '2-digit', day: '2-digit'});
											var sDay = new Date(data[i].startdate).toLocaleDateString("zh-TW", {year: 'numeric', month: '2-digit', day: '2-digit'});;
											var eDay = new Date(data[i].enddate).toLocaleDateString("zh-TW", {year: 'numeric', month: '2-digit', day: '2-digit'});;
											
											var pair = "可配對";
											if (data[i].pair != 0) {
												pair = "不可配對"
											}
											
											resultText += data[i].initiatingnum + " " 
											+ data[i].userprofiles.uid
												+ " " + pDay + " " + sDay + " "
												+ eDay + " " + data[i].currentnum + " "
												+ data[i].acceptablenum + " " + data[i].camparea + " "
												+ pair + "<br/>";
												
											tableData += "<tr>" +"<td>" + data[i].initiatingnum + 
											"</td>" + "<td>" + data[i].userprofiles.uid + 
											"</td>" + "<td>" + pDay + "</td>" + "<td>" + sDay + "</td>" + "<td>" +
											eDay + "</td>" + "<td>" + data[i].currentnum + "</td>" + "<td>" + data[i].acceptablenum + "</td>" +
											"<td>" + data[i].camparea + "</td>" + "<td>" + pair + "</td>" + "</tr>"
										}
										document.getElementById('selectResult').innerHTML = tableData;
									});
								}
							});
		     			
		     			}//else結束
		     			
		            }
		            
		        });
		    });
		}