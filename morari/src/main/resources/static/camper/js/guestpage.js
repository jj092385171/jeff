// 載入 你的.html
let currentURL = window.location.href;
var uid = currentURL.substring(currentURL.lastIndexOf("/") + 1);
fetch("/morari/camper/html/guestpage.html")
    .then(response => response.text())
    .then(html => {
        document.querySelector(".guestpage").innerHTML = html;
        if (uid!=="notlogin") {
            fetch("/morari/guest/camper/api/userdetail/"+uid)
            .then(response => response.json())
            .then(data=>{
                // document.getElementById("uid").textContent = data.uid;
                document.getElementById("nickname").textContent = data.nickname;
                document.getElementById("exp").textContent = "Exp : "+data.exp;
                document.getElementById("level").textContent = "Level : "+data.level;
                document.getElementById("point").textContent = "Point : "+data.point;
                document.getElementById("campershot").src = data.shot;
                document.getElementById("about").textContent = data.about;
                
                
                
                
            })            
        } 











    });