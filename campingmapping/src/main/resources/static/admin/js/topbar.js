fetch("admin/share/topbar.html")
    .then(response => response.text())
    .then(html => {
        // 將載入的 HTML 放入 .header 元素中
        document.querySelector(".topbarshare").innerHTML = html;
    });