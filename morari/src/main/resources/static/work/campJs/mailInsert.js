// 載入 你的.html
$(document).ready(function() {
	var url = window.location.href;
	var id = url.split("/").pop();
	console.log(id);
	$.ajax({
		type: 'POST',
		url: '/morari/admin/resume/selectNumber.controller/' + id,
		dataType: 'json',
		success: function(data) {
			$('#mail').val(data.mail);
		}
	});
	//文字編譯器
ClassicEditor.create( document.querySelector( '#editor' ) )
                      .then( editor => {
                                 console.log( editor );
                            } ).catch( error => {
                                      console.error( error );
                                } );
	$("#sendMail").submit(function(event) {
		event.preventDefault();
		$.ajax({
			type: "post",
			url: "/morari/admin/user/work/userMail.controller",
			data: $(this).serialize(),
			datatype: 'TEXT',
			success: function(response) {
				alert(response);
				window.location.href = '/morari/admin/user/work/startCrud.controller';
			}
		});
	});


});

