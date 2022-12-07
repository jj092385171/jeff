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
        <form name="form" action="<c:url value='/view'/>" method="POST">
            <h2>揪團清單</h2>
            <table>
				<c:forEach var="bean" items="${view}">
					<tr>
						<td>${bean.initiatingnum}</td>
						<td>${bean.postmember}</td>
						<td>${bean.postdate}</td>
						<td>${bean.startdate}</td>
						<td>${bean.enddate}</td>
						<td>${bean.currentnum}</td>
						<td>${bean.acceptablenum}</td>
						<td>${bean.camparea}</td>
						<td>${bean.pair}</td>
					</tr>
				</c:forEach>
            </table>
            <input type="submit" id="test" value="送出">
        </form>
    </div>
    <script type=“text/javascript” src="../jquery-3.6.1.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
//      form.submit();
// 						$('form').on('submit', function(){
// 						    $.ajax({
// 						        url: '/campingmapping/view',              // 要傳送的頁面
// 						        method: 'POST',               // 使用 POST 方法傳送請求
// 						        dataType: 'json',             // 回傳資料會是 json 格式
// 						        data: $('form').serialize(),  // 將表單資料用打包起來送出去
// 						        success: function(res){
// 						            // 成功以後會執行這個方法
// 						        },
// 						    });
// 						    return false;  // 阻止瀏覽器跳轉到 send.php，因為已經用 ajax 送出去了
// 						});
	</script>
</body>
</html>