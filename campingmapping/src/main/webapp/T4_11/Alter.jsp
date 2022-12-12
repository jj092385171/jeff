<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
        div {
            justify-content: center;
            display: flex;
            margin: 0 auto;
            width: auto;
        }

        table {
            border: solid 1px black;
            width: 1000px;
            height: 200px;
        }

        tr {
            border: solid 1px black;
            height: 25%;
        }

        td {
            border: solid 1px black;
        }
    </style>
<body>
 <div>
            <h2>揪團清單</h2>
            <form action="<c:url value='/alter'/>" method="POST">
				<h2>修改</h2>
				<input type="hidden" id="initiatingnum" name="initiatingnum" value="${initiatingnum}"><br>
				起始日期:<input type="date" id="startdate" name="startdate"><br>
				結束日期:<input type="date" id="enddate" name="enddate"><br>
				現有人數:<input type="text" id="currentnum" name="currentnum" onkeyup="value=value.replace(/[^\d]/g,'') " placeholder="請輸入現有人數,僅限數字"><br>
				接受人數:<input type="text" id="acceptnum" name="acceptnum" onkeyup="value=value.replace(/[^\d]/g,'') " placeholder="請輸入接受人數,僅限數字"><br>
				露營地點:<input type="text" id="camparea" name="camparea" placeholder="請輸入露營地點"><br>
				配對狀態:<input type="text" id="pair" name="pair" onkeyup="value=value.replace(/[^\d]/g,'') "><br>
				<input type="submit" id="test" value="送出">
			</form>

            
    </div>
    <script type=“text/javascript” src="../jquery-3.6.1.js"></script>
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
    
</body>
</html>