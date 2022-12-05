﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
<h1>營地: ${ CampBean.campName } 的資料新增成功</h1>
縣市: ${ CampBean.cityID }<br>
地址: ${ CampBean.location }<br>
圖片: <img src="data:image/jpg;base64,${CampBean.getBinaryString()}"><br>
簡介: ${ CampBean.discription }<br>

<p>
<a href="<c:url value='/T4_24/CampIndex.jsp' />" >回首頁</a>
</body>
</html>