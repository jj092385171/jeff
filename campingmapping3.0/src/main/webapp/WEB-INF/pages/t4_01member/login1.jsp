<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<h1>µn¤J</h1>


<form action="MemberLoginServlet" method="post">
  <label for="uname">±b¸¹</label><br>
  <input type="text" id="uname" name="uname"><br>
  <label for="pwd">±K½X</label><br>
  <input type="text" id="pwd" name="pwd"><br><br>
  <p>${errorMsgMap.LoginError}</p>
  <input type="submit" value="Submit">
</form> 

</body>
</html>