<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>new discussion</title>
	<style>
        h3 {
            color: brown;
            text-align: center;
        }
        
        .disBlock {
            padding: 5px 5px;
            margin: 5px 5px;
        }
        
    </style>
</head>
<body>
	<header>
        <h3>新增貼文</h3>
    </header>
    <article>
        <form action="<c:url value='/T4_33/servlet/newDiscussionServlet' />" method="POST">
            <div class="disBlock">
                <label for="">*標題</label>
                <input type="text" name="title" maxlength="30" size="100" required="required">
            </div>
            <div class="disBlock">
                <label for="">*內容</label>
                <textarea name="content" id="" cols="82" rows="10" required="required"></textarea>
            </div>
            <div class="disBlock">
                <label for="">上傳照片</label>
                <input type="file" name="picture">
            </div>
            <div class="disBlock">
                <label for="">露營人數</label>
                <select name="people" id="">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </div>
            <div class="disBlock">
                <label for="">露營費用</label>
                <input type="number" name="price">
            </div>
            <div class="disBlock">
                <label for="">露營城市</label>
                <select name="county" id="">
                    <option value="TPE">台北市</option>
                    <option value="TPH">新北市</option>
                    <option value="KLU">基隆市</option>
                    <option value="TYC">桃園市</option>
                    <option value="HSH">新竹縣</option>
                    <option value="HSC">新竹市</option>
                    <option value="MAL">苗栗縣</option>
                    <option value="TXG">台中市</option>
                    <option value="CWH">彰化縣</option>
                    <option value="NTO">南投縣</option>
                    <option value="YLH">雲林縣</option>
                    <option value="CHY">嘉義縣</option>
                    <option value="CYI">嘉義市</option>
                    <option value="TNN">台南市</option>
                    <option value="KHH">高雄市</option>
                    <option value="IUH">屏東縣</option>
                    <option value="ILN">宜蘭縣</option>
                    <option value="HWA">花蓮縣</option>
                    <option value="TTT">台東縣</option>
                    <option value="PEH">澎湖縣</option>
                    <option value="KMN">金門縣</option>
                    <option value="LNN">連江縣</option>
                </select>
            </div>
            <div class="disBlock">
                <label for="">開始日期</label>
                <input type="date" name="startDate">
            </div>
            <div class="disBlock">
                <label for="">結束日期</label>
                <input type="date" name="endDate">
            </div>
            <div class="disBlock">
                <label for="">評分</label>
                <select name="score" id="">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </div>
            <div class="disBlock">
                <input type="submit">
                <input type="reset" name="" id="">
            </div>
        </form>
    </article>
    <aside></aside>
</body>
</html>