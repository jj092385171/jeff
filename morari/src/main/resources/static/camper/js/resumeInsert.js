// 載入 你的.html
$(document).ready(function() {
	// let uid;
	fetch("/morari/utils/getuid")
		.then(response => response.text())
		.then(data => {
			document.getElementById("uid").value = data;
		})

	$("#send").click(function() {
		function getFormData($form) {
			var unindexed_array = $form.serializeArray();
			var indexed_array = {};

			$.map(unindexed_array, function(n, i) {
				indexed_array[n['name']] = n['value'];
			});
			console.log(indexed_array);
			return indexed_array;
		}

		$.ajax({
			type: 'POST',
			url: '/morari/guest/work/resumeInsert.controller',
			contentType: 'application/json',
			data: JSON.stringify(getFormData($("#insert"))),
			success: function(response) {
				alert(response)
							window.location.href="/morari/guest/work/resume.controller"
				}
			
		});
	});
});