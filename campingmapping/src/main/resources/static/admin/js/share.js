fetch("admin/share/sidebar.html")
    .then(response => response.text())
    .then(html => {
        // 將載入的 HTML 放入元素中
        document.querySelector(".sidebarshare").innerHTML = html;
    });

fetch("admin/share/topbar.html")
    .then(response => response.text())
    .then(html => {
        // 將載入的 HTML 放入元素中
        document.querySelector(".topbarshare").innerHTML = html;
    });

fetch("admin/share/loginout.html")
    .then(response => response.text())
    .then(html => {
        // 將載入的 HTML 放入元素中
        document.querySelector(".loginoutshare").innerHTML = html;
    });

fetch("admin/share/footer.html")
    .then(response => response.text())
    .then(html => {
        // 將載入的 HTML 放入元素中
        document.querySelector(".footershare").innerHTML = html;
    });