// 載入 你的.html
fetch("/morari/work/html/resumeUpdate.html")
    .then(response => response.text())
    .then(html => {
        // 將載入的 HTML 放入 .footer 元素中
        document.querySelector(".resumeUpdate").innerHTML = html;
    });