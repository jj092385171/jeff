
//記住我
$(function () {
	$(document).ready(function () {
		$.ajax({
			url: "/campingmapping/RemberServlet",
			type: "POST",
			//提交方式
			data: { "rm": "rm" },
			dataType: "json",
		}).done(function (data) {
			let account = data.account;
			let password = data.password;
			let rember = data.rember;
			$("#account").val(account);
			$("#password").val(password);
			if (rember == "true") {
				$("#rember").prop("checked", true);
			}
		})
	})

})
// 判斷密碼格式
function checkPass(s) {
	if (s.length < 8) {
		return 0;
	}
	let ls = 0;
	if (s.match(/([a-z])+/)) {
		ls++;
	}
	if (s.match(/([0-9])+/)) {
		ls++;
	}
	if (s.match(/([A-Z])+/)) {
		ls++;
	}
	if (s.match(/[^a-zA-Z0-9]+/)) {
		ls++;
	}
	return ls
}
// 登入驗證碼
$(function () {
	var gRandom;

	$(function () {
		$("#sign").click(function () {
			validate('#canvasValue', gRandom)
		})
		// .on('click', function () {
		// 	draw_Captcha();
		// 	$('#canvasValue').val("");
		// })
	})

	function getRandom(min, max) {
		return Math.floor(Math.random() * (max - min + 1)) + min;
	};

	//--隨機生成RGB顏色
	function randomRgbColor(xV) {
		let r = Math.floor(Math.random() * xV); //隨機生成256以內r值
		let g = Math.floor(Math.random() * xV); //隨機生成256以內g值
		let b = Math.floor(Math.random() * xV); //隨機生成256以內b值
		return "rgb(" + r + "," + g + "," + b + ")"; //返回rgb(r,g,b)格式顏色
	}

	function draw_Captcha() {
		gRandom = getRandom(10000, 99999);
		let canvas = document.getElementById("canvas");
		let context = canvas.getContext("2d");
		canvas.width = 110;
		canvas.height = 38;
		context.strokeRect(0, 0, canvas.width, canvas.height);
		// console.log('gRandom = ', gRandom);

		//---驗証數字
		for (let i = 0; i < gRandom.toString().length; i++) {
			let x = 5 + i * 20;
			let y = 26;
			//let deg = Math.random() * 70 * Math.PI / 180;//隨機弧度
			let deg = Math.random() * 38 * Math.PI / 160;//隨機弧度
			let txt = gRandom.toString()[i];
			context.fillStyle = randomRgbColor(100);
			context.font = "bold 25px Arial";
			//修改座標原點和旋轉角度
			context.translate(x, y);
			context.rotate(deg);
			context.fillText(txt, 0, 0);
			//恢復座標原點和旋轉角度
			context.rotate(-deg);
			context.translate(-x, -y);

		}

		//---干擾線
		for (let i = 0; i < 6; i++) {
			context.strokeStyle = randomRgbColor(256);
			context.beginPath();
			context.moveTo(Math.random() * 120, Math.random() * 40);
			context.lineTo(Math.random() * 120, Math.random() * 40);
			context.stroke();
		}
		//---干擾點
		for (let i = 0; i < 50; i++) {
			context.fillStyle = randomRgbColor(256);
			context.beginPath();
			context.arc(Math.random() * 120, Math.random() * 40, 1, 0, 2 * Math.PI);
			context.fill();
		}
	}
	draw_Captcha();
	$('body').off('click').on('click', '#canvas', function () {
		draw_Captcha();
		$('#canvasValue').val("");
	})


	function validate(txtinput, code1) {
		let inputCode = $(txtinput).val();
		// console.log(inputCode);
		if (inputCode.length <= 0) {
			$('#loginError').text("輸入驗證碼");
			draw_Captcha();

		} else if (inputCode != code1) {
			$('#loginError').text("驗證碼錯誤");
			draw_Captcha();
			$('#canvasValue').val("");

		} else {
			$(function loginSubmit() {
				$('#loginError').text("");
				// alert('ok'); //獲取使用者名稱和密碼: 
				let account = $('#account').val();
				let password = $('#password').val();
				let rember = null;
				// alert(rember); 
				$("#sign").submit();
				if ($('#rember').prop('checked')) {
					rember = $('#rember').val();
				}
				$.ajax({
					url: "/campingmapping/login",
					type: "POST",
					//提交方式
					data: { "account": account, "password": password, "rember": rember },
					dataType: "json",
				}).done(function (data) {
					if (data.res == 1) {
						// alert('username') 
						location.href = "/campingmapping/index.jsp";
						rel = "external nofollow";
					} else {
						// alert('username'); 
						$('#loginError').text('帳號密碼錯誤');
						// draw_Captcha();
						// $('#canvasValue').val("");

					}
				})
			});
		}



	};
})
// 註冊驗證碼
$(function () {
	var acsame = 1;
	// 帳號重複比對
	$(function () {
		$("#joinAccount").on("keyup", function () {
			console.log($("#joinAccount").val());

			let account = $('#joinAccount').val();

			$.ajax({
				url: "/campingmapping/accountsame",
				type: "POST",
				//提交方式
				data: {
					"account": account
				},
				dataType: "json"
			}).done(function (data) {
				if (data.res == 1) {
					acno();
					acsame = 1;
				} else {
					acok();
					acsame = 0;
				}
			})
		})
	});
	var gRandom;
	$(function () {
		$("#join").click(function () {
			validate('#canvasValue2', gRandom)
		})
		// .on('click', function () {
		// 	draw_Captcha();
		// 	$('#canvasValue2').val("");
		// })
	})
	function getRandom(min, max) {
		return Math.floor(Math.random() * (max - min + 1)) + min;
	};
	//--隨機生成RGB顏色
	function randomRgbColor(xV) {
		let r = Math.floor(Math.random() * xV); //隨機生成256以內r值
		let g = Math.floor(Math.random() * xV); //隨機生成256以內g值
		let b = Math.floor(Math.random() * xV); //隨機生成256以內b值
		return "rgb(" + r + "," + g + "," + b + ")"; //返回rgb(r,g,b)格式顏色
	}
	function draw_Captcha() {
		gRandom = getRandom(10000, 99999);
		let canvas = document.getElementById("canvas2");
		let context = canvas.getContext("2d");
		canvas.width = 110;
		canvas.height = 38;
		context.strokeRect(0, 0, canvas.width, canvas.height);
		// console.log('gRandom = ', gRandom);

		//---驗証數字
		for (let i = 0; i < gRandom.toString().length; i++) {
			let x = 5 + i * 20;
			let y = 26;
			//let deg = Math.random() * 70 * Math.PI / 180;//隨機弧度
			let deg = Math.random() * 38 * Math.PI / 160;//隨機弧度
			let txt = gRandom.toString()[i];
			context.fillStyle = randomRgbColor(100);
			context.font = "bold 25px Arial";
			//修改座標原點和旋轉角度
			context.translate(x, y);
			context.rotate(deg);
			context.fillText(txt, 0, 0);
			//恢復座標原點和旋轉角度
			context.rotate(-deg);
			context.translate(-x, -y);

		}

		//---干擾線
		for (let i = 0; i < 6; i++) {
			context.strokeStyle = randomRgbColor(256);
			context.beginPath();
			context.moveTo(Math.random() * 120, Math.random() * 40);
			context.lineTo(Math.random() * 120, Math.random() * 40);
			context.stroke();
		}
		//---干擾點
		for (let i = 0; i < 50; i++) {
			context.fillStyle = randomRgbColor(256);
			context.beginPath();
			context.arc(Math.random() * 120, Math.random() * 40, 1, 0, 2 * Math.PI);
			context.fill();
		}
	}
	draw_Captcha();
	$('body').off('click').on('click', '#canvasBox2', function () {
		draw_Captcha();
		$('#canvasValue2').val("");
	})
	function IsEmail(email) {
		let regex = /^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (!regex.test(email)) {
			return false;
		} else {
			return true;
		}
	}
	function validate(txtinput, code1) {
		// 格式英數字
		let inputCode = $(txtinput).val();


		$("body").off('click').on('click', "#join", function () {
			//			console.log(IsEmail($("#joinEmail").val()));
			console.log($("#joinBirthday").val());
			//			console.log("----------------------");

			if (inputCode.length <= 0) {
				$('#joinError').text("輸入驗證碼");
				draw_Captcha();
			} else if (inputCode != code1) {
				$('#joinError').text("驗證碼錯誤");
				draw_Captcha();
				$('#canvasValue').val("");
			} else if ($("#joinAccount").val().trim().replace(/\s/g, "") == "") {
				$('#joinError').text("帳號不能為空");
			}
			else if (acsame == 1) {
				$('#joinError').text("帳號重複");
			} else if ($('#joinAccount').val().match(/[^a-zA-Z0-9]+/)) {
				$('#joinError').text("帳號只能為英數字");
			}
			else if ($("#joinAccount").val().match(/\s/) != null) {
				$('#joinError').text("帳號不能含有空格");
			}
			else if ($("#joinPassword").val().match(/\s/) != null) {
				$('#joinError').text("密碼不能含有空格");
			}
			else if ($("#joinPassword").val().trim().replace(/\s/g, "") == "") {
				$('#joinError').text("密碼不能為空");
			}
			else if ($("#joinPassword").val().trim().replace(/\s/g, "").length < 8) {
				$('#joinError').text("密碼必須8位以上");
			}
			else if (checkPass($("#joinPassword").val().trim().replace(/\s/g, "")) < 3) {
				$('#joinError').text("密碼必須是 字母大寫，字母小寫，數字，特殊符號 任兩種組合");
			} else if ($("#joinPassword").val() !== $("#joinPasswordCheck").val()) {
				$('#joinError').text("密碼與驗證密碼不一致");
			}
			else if (!IsEmail($("#joinEmail").val())) {
				$('#joinError').text("信箱格式錯誤");
			}
			else if ($("#joinBirthday").val() == "") {
				$('#joinError').text("請輸入出生年月日");
			}
			else {
				$('#joinError').text("");
				// 	// alert('ok'); //獲取使用者名稱和密碼:
				let account = $('#joinAccount').val();
				let password = $('#joinPassword').val();
				let email = $('#joinEmail').val();
				let birthday = new Date($('#joinBirthday').val()).getTime();
				// console.log(birthday);
				//				$("#join").submit();
				// alert(rember);
				$.ajax({
					url: "/campingmapping/join",
					type: "POST",
					//提交方式
					data: {
						"account": account,
						"password": password,
						"email": email,
						"birthday": birthday
					},
					dataType: "json",
				}).done(function (data) {
					if (data.res == 1) {
						alert('註冊會員成功')
						location.href = "/campingmapping/T4_01/login/login.html"
						rel = "external nofollow"
					} else {
						// alert('username');
						$('.joinError').show().html('註冊會員失敗')
					}
				})
			}

		})
	}
}
)
// 切換登入註冊
$(function () {
	$("body").on("click", "#tojoin", function () {
		$("#joinbox").css("display", "block");
		$("#signbox").css("display", "none");
	})
	$("body").on("click", "#tosign", function () {
		$("#joinbox").css("display", "none");
		$("#signbox").css("display", "block");
	})

})
// 密碼確認
$(function samepass() {
	$("#joinPasswordCheck").on("keyup", function () {
		let inputpass = $("#joinPassword").val();
		let inputcheck = $("#joinPasswordCheck").val();

		if (inputpass === inputcheck) {
			psok();
			return true;
		} else {
			psno();
			return false;
		}
	})

});
// password icon v 
function psok() {
	$('#psno').css("display", "none")
	$('#psok').css("display", "block")
}
// password icon x 
function psno() {
	$('#psno').css("display", "block")
	$('#psok').css("display", "none")
}
// account icon v 
function acok() {
	$('#acno').css("display", "none")
	$('#acok').css("display", "block")
}
// account icon x 
function acno() {
	$('#acno').css("display", "block")
	$('#acok').css("display", "none")
}
