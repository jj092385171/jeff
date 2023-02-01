(function ($) {
    "use strict";

    // Initiate the wowjs animation library
    new WOW().init();

    // Initiate menu
    $('#header').after('<div class="mobile-menu d-xl-none">');
    $('.top-menu').clone().appendTo('.mobile-menu');
    $('.mobile-menu-btn').click(function () {
        $('.mobile-menu').stop().slideToggle();
    });

    // Back to top button
    $(window).scroll(function () {
        if ($(this).scrollTop() > 100) {
            $('.back-to-top').fadeIn('slow');
        } else {
            $('.back-to-top').fadeOut('slow');
        }
    });
    $('.back-to-top').click(function () {
        $('html, body').animate({ scrollTop: 0 }, 1500, 'easeInOutExpo');
        return false;
    });

    //Portfolio modal slider
    $('.port-slider').delay(10000);
    $('.port-slider').slick({
        autoplay: true,
        slidesToShow: 1,
        slidesToScroll: 1,
        arrows: false,
        fade: true,
        asNavFor: '.port-slider-nav'
    });
    $('.port-slider-nav').slick({
        autoplay: true,
        slidesToShow: 5,
        slidesToScroll: 1,
        asNavFor: '.port-slider',
        arrows: false,
        dots: false,
        centerMode: true,
        focusOnSelect: true
    });

    $('#popover-content-download').hide();
    $("[data-toggle=popover]").each(function (e) {
        $(this).popover({
            html: true,
            content: function () {
                var id = $(this).attr('id')
                return $('#popover-content-' + id).html();
            }
        });

    });

    // Date and time picker
    $('#date-1, #date-2, #date-3, #date-4, #date-5, #date-6').datetimepicker({
        format: 'L'
    });
    $('#time-1, #time-2').datetimepicker({
        format: 'LT'
    });
})(jQuery);

window.onload = function () {
    document.body.style.display = 'block';
    // 登入狀態驗證
    fetch("/morari/api/auth/state", {
        method: "POST",
        // 發送請求時附帶Cookie
        credentials: "include"
    })
        .then(response => response.json())
        .then(loginstate => {
            if (loginstate) {
                // 登入
                document.getElementById("loginstate").innerHTML = ' <a class="fa fa-user" onclick="toggleDropdown()">登入</a> <div class="dropdown-content" id="dropdown-content" style="display: none; right: 0;left: auto;position: absolute;background-color: #f9f9f9;min-width: 160px;box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);z-index: 9999;"> <a href="#">個人資料</a><a href="#">登出</a></div>';
            } else {
                // 未登入
                document.getElementById("loginstate").innerHTML = '<a class="fa fa-user" href="/morari/login">登入</a>';
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });


        // 監聽頁面上的點擊事件
        document.addEventListener("click", function (event) {
        
        console.log("in")
        
            let loginstate = document.getElementById("loginstate2");
            let dropdownContent = document.getElementById("dropdown-content");
            if (event.target !== loginstate && event.target.parentNode !== loginstate &&
                event.target !== dropdownContent && event.target.parentNode !== dropdownContent) {
                dropdownContent.style.display = "none";
            }
        });

}
// 切換下拉選單顯示/隱藏
function toggleDropdown() {
let dropdownContent = document.getElementById("dropdown-content");
if (dropdownContent.style.display === "none") {

    console.log("b")

    dropdownContent.style.display = "block";
    
    console.log(dropdownContent.style.display)

    } else {
        dropdownContent.style.display = "none";
    }
};
