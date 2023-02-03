function delmember(uid) {


	if (confirm('確認刪除資料?') == true) {

		$.ajax({
			url: "/campingmapping/DelMemberServlet",
			type: "POST",
			//提交方式
			data: { "account": account },
			dataType: "text",
		}).done(function (data) {
			if (data == 1) {
				alert('刪除成功')
				location.reload()
			} else {
				alert('刪除失敗')

			}

		})


	} else {
		console.log('您已取消確認');
	}

};



function editmember(vallist) {

	// 		$("#edform").

}





$(function () {
	$(document)
		.ready(
			function () {
				let i = 0;
				let vallist = [];
				$('#memberlist')
					.DataTable(
						{
							"ajax": {
								"url": "/morari/admin/camper/api/showall",
								"type": "GET",
								// 發送請求
								"dataSrc": ""
							},
							// processing : true,
							// serverSide : true,
							"columns": [
								{
									"data": 'UID'
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(data)
										return data
									}
								},
								{
									"data": 'email'
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(data)
										return data
									}
								},
								{
									"data": 'Nickname'
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(data)
										return data
									}
								},
								{
									"data": 'firstname'
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(data)
										return data
									}
								},
								{
									"data": 'lastname'
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(data)
										return data
									}
								},
								{
									"data": 'phone'
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(data)
										return data
									}
								},
								{
									"data": 'role'
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(data)
										return data
									}
								},
								{
									"data": 'birthday',
									"render": function (
										data, type,
										row, meta) {
										vallist.push(moment(Date.parse(data)).format('YYYY-MM-DD'))
										data = moment(Date.parse(data)).format('YYYY/MM/DD')
										return data
									}
								},
								{
									"data": 'address'
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(data)
										return data
									}
								},
								{
									"data": 'gender'
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(data)
										return data
									}
								},
								{
									"data": 'leavel'
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(data)
										return data
									}
								},
								{
									"data": 'exp'
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(data)
										return data
									}
								},

								{
									"data": 'point'
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(data)
										return data
									}
								},
								{
									"data": "registerdata"
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(moment(Date.parse(data)).format('YYYY-MM-DD'))
										data = moment(Date.parse(data)).format('YYYY/MM/DD')
										return data
									}
								},
								{
									"data": 'subscribed'
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(data)
										return data
									}
								},
								{
									"data": 'shot'
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(data)
										return data
									}
								},
								{
									"data": 'about'
									, "render": function (
										data, type,
										row, meta) {
										vallist.push(data)
										return data
									}
								},
								{
									"data": "uid",
									render: function (data, type, row) {


										return '<button type="button" class="btn btn-warning btn-sm" id=' + "'" + "edit" + data + "'" + ' onclick= "editmember( ' + "'" + data + "'" + ')">編輯</button> ' +
											'<button type="button" class="btn btn-danger btn-sm"id=' + "'" + "del" + data + "'" + 'onclick= "delmember(' + data + ' )" >刪除</button>'
									}
								}


							],
							dom: 'Bfrtip',
							buttons: [
								'copy', 'excel', 'pdf'
							]
							,
							responsive: true,
							columnDefs: [
								{ "defaultContent": "-", "targets": "_all" },
								{
									// uid
									targets: [0],
									responsivePriority: 15,
								},
								{
									// acc
									targets: [1],
									responsivePriority: 20,
									width: "30%",
								},
								{
									// nik
									targets: [2],
									responsivePriority: 50,
								},
								{
									// fn
									targets: [3],
									responsivePriority: 55,
								},
								{
									// ln
									targets: [4],
									responsivePriority: 60,
								},
								{
									// exp
									targets: [5],
									responsivePriority: 65,
								},
								{
									// level
									targets: [6],
									responsivePriority: 70,
								},
								{
									// pot
									targets: [7],
									responsivePriority: 75,
								},
								{
									// phone
									targets: [8],
									responsivePriority: 80,
								},
								{
									// bir
									targets: [9],
									responsivePriority: 40,
								},
								{
									// add
									targets: [10],
									responsivePriority: 45,
								},
								{
									// email
									targets: [11],
									responsivePriority: 85,
								},
								{
									// gender
									targets: [12],
									responsivePriority: 35,
								},
								{
									// rgd
									targets: [13],
									responsivePriority: 30,
								},
								{
									// sub
									targets: [14],
									responsivePriority: 90,
								},
								{
									// shot
									targets: [15],
									responsivePriority: 95,
								},
								{
									// crud
									targets: [16],
									responsivePriority: 25,
								}],
							breakpoints: [
								{ name: 'desktop', width: Infinity },
								{ name: 'tablet-l', width: 1024 },
								{ name: 'tablet-p', width: 767 },//原本是768~1024不含768
								{ name: 'mobile-l', width: 480 },
								{ name: 'mobile-p', width: 320 }
							],
							// "columnDefs": [
							// 	{
							// 		targets: [0], // 第一欄 
							// 		createdCell: function (cell, cellData, rowData, rowIndex, colIndex) {
							// 			$(td).css('width', '30%') //可寫其他設定
							// 		},
							// 	},
							// 	{
							// 		targets: '_all',//全部攔
							// 		className: 'text-center'
							// 	}
							// ]
							// "processing" : "處理中...",
							// "loadingRecords" : "載入中...",
							// "paginate" : {
							// 	"first" : "第一頁",
							// 	"previous" : "上一頁",
							// 	"next" : "下一頁",
							// 	"last" : "最後一頁"
							// },
							// "emptyTable" : "目前沒有資料",
							// "datetime" : {
							// 	"previous" : "上一頁",
							// 	"next" : "下一頁",
							// 	"hours" : "時",
							// 	"minutes" : "分",
							// 	"seconds" : "秒",
							// 	"amPm" : [ "上午", "下午" ],
							// 	"unknown" : "未知",
							// 	"weekdays" : [ "週日", "週一",
							// 			"週二", "週三", "週四",
							// 			"週五", "週六" ],
							// 	"months" : [ "一月", "二月",
							// 			"三月", "四月", "五月",
							// 			"六月", "七月", "八月",
							// 			"九月", "十月", "十一月",
							// 			"十二月" ]
							// },
							// "searchBuilder" : {
							// 	"add" : "新增條件",
							// 	"condition" : "條件",
							// 	"deleteTitle" : "刪除過濾條件",
							// 	"button" : {
							// 		"_" : "複合查詢 (%d)",
							// 		"0" : "複合查詢"
							// 	},
							// 	"clearAll" : "清空",
							// 	"conditions" : {
							// 		"array" : {
							// 			"contains" : "含有",
							// 			"equals" : "等於",
							// 			"empty" : "空值",
							// 			"not" : "不等於",
							// 			"notEmpty" : "非空值",
							// 			"without" : "不含"
							// 		},
							// 		"date" : {
							// 			"after" : "大於",
							// 			"before" : "小於",
							// 			"between" : "在其中",
							// 			"empty" : "為空",
							// 			"equals" : "等於",
							// 			"not" : "不為",
							// 			"notBetween" : "不在其中",
							// 			"notEmpty" : "不為空"
							// 		},
							// 		"number" : {
							// 			"between" : "在其中",
							// 			"empty" : "為空",
							// 			"equals" : "等於",
							// 			"gt" : "大於",
							// 			"gte" : "大於等於",
							// 			"lt" : "小於",
							// 			"lte" : "小於等於",
							// 			"not" : "不為",
							// 			"notBetween" : "不在其中",
							// 			"notEmpty" : "不為空"
							// 		},
							// 		"string" : {
							// 			"contains" : "含有",
							// 			"empty" : "為空",
							// 			"endsWith" : "字尾為",
							// 			"equals" : "等於",
							// 			"not" : "不為",
							// 			"notEmpty" : "不為空",
							// 			"startsWith" : "字首為",
							// 			"notContains" : "不含",
							// 			"notStartsWith" : "開頭不是",
							// 			"notEndsWith" : "結尾不是"
							// 		}
							// 	},
							// 	"data" : "欄位",
							// 	"leftTitle" : "群組條件",
							// 	"logicAnd" : "且",
							// 	"logicOr" : "或",
							// 	"rightTitle" : "取消群組",
							// 	"title" : {
							// 		"_" : "複合查詢 (%d)",
							// 		"0" : "複合查詢"
							// 	},
							// 	"value" : "內容"
							// },
							// "editor" : {
							// 	"close" : "關閉",
							// 	"create" : {
							// 		"button" : "新增",
							// 		"title" : "新增資料",
							// 		"submit" : "送出新增"
							// 	},
							// 	"remove" : {
							// 		"button" : "刪除",
							// 		"title" : "刪除資料",
							// 		"submit" : "送出刪除",
							// 		"confirm" : {
							// 			"_" : "您確定要刪除您所選取的 %d 筆資料嗎？",
							// 			"1" : "您確定要刪除您所選取的 1 筆資料嗎？"
							// 		}
							// 	},
							// 	"error" : {
							// 		"system" : "系統發生錯誤(更多資訊)"
							// 	},
							// 	"edit" : {
							// 		"button" : "修改",
							// 		"title" : "修改資料",
							// 		"submit" : "送出修改"
							// 	},
							// 	"multi" : {
							// 		"title" : "多重值",
							// 		"info" : "您所選擇的多筆資料中，此欄位包含了不同的值。若您想要將它們都改為同一個值，可以在此輸入，要不然它們會保留各自原本的值。",
							// 		"restore" : "復原",
							// 		"noMulti" : "此輸入欄需單獨輸入，不容許多筆資料一起修改"
							// 	}
							// },
							// "autoFill" : {
							// 	"cancel" : "取消"
							// },
							// "buttons" : {
							// 	"copySuccess" : {
							// 		"_" : "複製了 %d 筆資料",
							// 		"1" : "複製了 1 筆資料"
							// 	},
							// 	"copyTitle" : "已經複製到剪貼簿",
							// 	"excel" : "Excel",
							// 	"pdf" : "PDF",
							// 	"print" : "列印",
							// 	"copy" : "複製",
							// 	"colvis" : "欄位顯示",
							// 	"colvisRestore" : "重置欄位顯示",
							// 	"csv" : "CSV",
							// 	"pageLength" : {
							// 		"-1" : "顯示全部",
							// 		"_" : "顯示 %d 筆"
							// 	},
							// 	"createState" : "建立狀態",
							// 	"removeAllStates" : "移除所有狀態",
							// 	"removeState" : "移除",
							// 	"renameState" : "重新命名",
							// 	"savedStates" : "儲存狀態",
							// 	"stateRestore" : "狀態 %d",
							// 	"updateState" : "更新"
							// },
							// "searchPanes" : {
							// 	"collapse" : {
							// 		"_" : "搜尋面版 (%d)",
							// 		"0" : "搜尋面版"
							// 	},
							// 	"emptyPanes" : "沒搜尋面版",
							// 	"loadMessage" : "載入搜尋面版中...",
							// 	"clearMessage" : "清空",
							// 	"count" : "{total}",
							// 	"countFiltered" : "{shown} ({total})",
							// 	"title" : "過濾條件 - %d",
							// 	"showMessage" : "顯示全部",
							// 	"collapseMessage" : "摺疊全部"
							// },
							// "stateRestore" : {
							// 	"emptyError" : "名稱不能空白。",
							// 	"creationModal" : {
							// 		"button" : "建立",
							// 		"columns" : {
							// 			"search" : "欄位搜尋",
							// 			"visible" : "欄位顯示"
							// 		},
							// 		"name" : "名稱：",
							// 		"order" : "排序",
							// 		"paging" : "分頁",
							// 		"scroller" : "卷軸位置",
							// 		"search" : "搜尋",
							// 		"searchBuilder" : "複合查詢",
							// 		"select" : "選擇",
							// 		"title" : "建立新狀態",
							// 		"toggleLabel" : "包含："
							// 	},
							// 	"duplicateError" : "此狀態名稱已經存在。",
							// 	"emptyStates" : "名稱不可空白。",
							// 	"removeConfirm" : "確定要移除 %s 嗎？",
							// 	"removeError" : "移除狀態失敗。",
							// 	"removeJoiner" : "和",
							// 	"removeSubmit" : "移除",
							// 	"removeTitle" : "移除狀態",
							// 	"renameButton" : "重新命名",
							// 	"renameLabel" : "%s 的新名稱：",
							// 	"renameTitle" : "重新命名狀態"
							// },
							// "select" : {
							// 	"columns" : {
							// 		"_" : "選擇了 %d 欄資料",
							// 		"1" : "選擇了 1 欄資料"
							// 	},
							// 	"rows" : {
							// 		"1" : "選擇了 1 筆資料",
							// 		"_" : "選擇了 %d 筆資料"
							// 	},
							// 	"cells" : {
							// 		"1" : "選擇了 1 格資料",
							// 		"_" : "選擇了 %d 格資料"
							// 	}
							// },
							// "zeroRecords" : "沒有符合的資料",
							// "aria" : {
							// 	"sortAscending" : "：升冪排列",
							// 	"sortDescending" : "：降冪排列"
							// },
							// "info" : "顯示第 _START_ 至 _END_ 筆結果，共 _TOTAL_ 筆",
							// "infoEmpty" : "顯示第 0 至 0 筆結果，共 0 筆",
							// "infoFiltered" : "(從 _MAX_ 筆結果中過濾)",
							// "infoThousands" : ",",
							// "lengthMenu" : "顯示 _MENU_ 筆結果",
							// "search" : "搜尋：",
							// "searchPlaceholder" : "請輸入關鍵字",
							// "thousands" : ",",
							// "columnDefs" : [ {
							// 	targets : [ 0 ],
							// 	width : "30%",
							// } ],
							// {
							// 	targets : [ 17 ],
							// 	responsivePriority : 2,
							// }, 



						});
			});
	// searching”:
	// 是否開啟搜尋欄位，參數值有true/false。

	// “paging”:
	// 設置是否要開啟分頁功能，參數值有true/false。

	// “sPaginationType”:
	// 分頁功能呈現樣式，預設參數值"full_numbers"
	// 關於官方說明可參考 https://datatables.net/reference/option/pagingType

	// “lengthMenu”:
	// 設置顯示筆數下拉選單內，顯示可區分幾筆參數
	// 預設參數值 [[10, 25, 50, -1], [10, 25, 50, “All”]]，代表要顯示10、25、50筆資料，其中 -1是告訴Datatables要關閉分頁欄位，因為是顯示全部資料，所以到這裡也可以發現它是跟"ALL"配對呼應的，只是要有一個開關去告訴Datatables要關閉分頁欄位，不然顯示全部資料那分頁就應該不需要存在才對。

	// “processing”:
	// 當頁面剛載入時候，是否要顯示當前資料處理狀態資訊，參數值有true/false

	// “serverSide”:
	// 設置是否透過Server端處理分頁、排序、過濾處理機制模式，也就是決定這三者功能是否給Server端處理好在回傳給前端顯示，或者，全都給Client端去做處理，參數值有true/false。
	// 全都給Client端處理情況下，必須要注意資料量多寡問題，當資料筆數是非常龐大的時候，受限於電腦效能，如果電腦效能不太穩定可能會帶來不好的體驗，並且也要考慮到資料安全問題，因為必須要將全部資料回傳給Client端自己去做分頁、排序、過濾處理機制。
	// 給予Server端處理情況下，透過ajax與指定API發送請求，透過特定關鍵字條件參數，告知後端要在特定條件參數值下，回傳符合的結果資料即可，不需回傳全部的資料給前端處理。

	// “stateSave”:
	// 設置在頁面刷新時，是否要保存當前表格資料與狀態，不保存便會在刷新時回復到原始初始狀態，參數值有true/false。

	// “destroy”:
	// 設置每一次Datatables有做修改時，是否銷毀當前暫存資料，參數值有true/false。

	// “info”:
	// 設置是否要顯示Datatables基本資訊狀態欄，參數值有true/false。

	// “autoWidth”:
	// 設置是否要自動調整表格寬度(自適應當前資料量設置表格寬度)，如果為false代表不要自適應，讓表格寬度遠永填滿當前所在區塊大小，參數值有true/false。

	// “ordering”:
	// 設置是否要開啟欄位排序，如果為true情況下，可以點擊header欄位來進行當前資料排序，點哪一個欄位就是以該欄位作為排序依據，參數值有true/false。

	// “scrollCollapse”:
	// 設置是否開始滾軸功能控制X、Y軸，參數值有true/false。

	// “scrollY”:
	// 設置Y軸最大高度，如果有設置此選項就會開啟Y軸滾軸功能，假設為"200px"代表最大高度為200px，當資料筆數呈現高度超過此限制就會開啟滾軸功能。

	// “scrollX”:
	// 設置X軸最大寬度，如果有設置此選項就會開啟X軸滾軸功能，假設為"500px"代表最大寬度為500px，當資料筆數呈現寬度超過此限制就會開啟滾軸功能。

	// “dom”:
	// 設置各Datattables元件所處在位置，
	// 可參考關於Datatables各元件位置設定(DOM positioning)
	// https://datatables.net/examples/basic_init/dom.html

})


