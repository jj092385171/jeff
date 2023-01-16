// var token
// document.addEventListener("DOMContentLoaded", function () {
//     let submitBtn = document.getElementById("resumbit");
//     submitBtn.addEventListener("click", function (event) {
//         event.preventDefault();
//         var form = document.getElementById("register");
//         var formData = new FormData(form);
//         var jsonData = {};
//         for (var [key, value] of formData.entries()) {
//             jsonData[key] = value;
//         }
//         var xhr = new XMLHttpRequest();
//         xhr.open("POST", form.action, true);
//         xhr.setRequestHeader('Content-Type', 'application/json');
//         xhr.onreadystatechange = function () {
//             if (xhr.readyState === 4 && xhr.status === 200) {
//                 let response = JSON.parse(xhr.response);
//                 token = response.token;
//                 window.globalToken = token;

//                 console.log("var " + token);
//                 console.log("window " + window.globalToken);

//             }
//         };
//         xhr.send(JSON.stringify(jsonData));
//     });
// });

// fetch('/api/v1/auth/register', {
//     method: 'POST',
//     headers: {
//         'Content-Type': 'application/json'
//     },
//     body: JSON.stringify({
//         firstname: 'your_firstname',
//         lastname: 'your_lastname',
//         email: 'your_email',
//         password: 'your_password'
//     })
// })
//     .then(response => response.json())
//     .then(data => {
//         console.log(data);
//     })
//     .catch(error => console.error(error));



// $.get("/user", function (data) {
//     $("#user").html(data.name);
//     $(".unauthenticated").hide()
//     $(".authenticated").show()
// });
// var logout = function () {
//     $.post("/logout", function () {
//         $("#user").html('');
//         $(".unauthenticated").show();
//         $(".authenticated").hide();
//     })
//     return true;
// }
// $.ajaxSetup({
//     beforeSend: function (xhr, settings) {
//         if (settings.type == 'POST' || settings.type == 'PUT'
//             || settings.type == 'DELETE') {
//             if (!(/^http:.*/.test(settings.url) || /^https:.*/
//                 .test(settings.url))) {
//                 // Only send the token to relative URLs i.e. locally.
//                 xhr.setRequestHeader("X-XSRF-TOKEN",
//                     Cookies.get('XSRF-TOKEN'));
//             }
//         }
//     }
// });
// $.get("/error", function (data) {
//     if (data) {
//         $(".error").html(data);
//     } else {
//         $(".error").html('');
//     }
// });
// var originalFetch = window.fetch;
// window.fetch = function (url, options) {
//     options = options || {};
//     options.headers = options.headers || {};
//     options.headers['Authorization'] = 'Bearer ' + window.globalToken;

//     console.log("---------------");
//     console.log("window " + window.globalToken);
//     console.log("---------------");
//     console.log("var " + token);
//     // console.log(window.token);

//     return originalFetch(url, options);
// }


// console.log("jsvar " + token);
// console.log("jswindow " + window.globalToken);