// 載入 你的.html
fetch("/morari/camper/html/guestedit.html")
    .then(response => response.text())
    .then(html => {
        // 將載入的 HTML 放入 .footer 元素中
        document.querySelector(".guestedit").innerHTML = html;
        fetch("/morari/admin/camper/api/guestdetail")
        .then(response => response.json())
        .then(data=>{
            // document.getElementById("uid").textContent = data.uid;
            document.getElementById("nickname").value = data.nickname;
            document.getElementById("exp").value = "Exp : "+data.exp;
            document.getElementById("level").value = "Level : "+data.level;
            document.getElementById("point").value = "Point : "+data.point;
            document.getElementById("shotimg").src = data.shot;
            document.getElementById("about").value = data.about;
        })            
    });