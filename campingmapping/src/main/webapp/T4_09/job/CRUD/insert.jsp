<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert</title>

<style>
.c1{
  width:500px;
  border: 2px solid black;
  left:500px;
}

</style>
</head>
<body>
 <form action= "<c:url value='/T4_09/JobServletAdd'/>"  method="POST"  enctype = "multipart/form-data">
        <div class ="c1">
        <label class="lb"></label>
        <p>   會員id
             <input type="text" name="id">  
        </p>
        <hr>
        <p>   刊登編號
             <input type="text" name="rackID">  
        </p>
        <hr>
        <p>   職缺
             <input type="text" name="job">  
        </p>
        <hr>   
        <p>薪資
        	<input type="text" name="salary"> 
        </p>
        <hr>
      
        <p>人數
       		 <input type="text" name="quantity">
        </p>
        <hr>
     
        <p>地點
        	 <input type="text" name="place">
        </p>
        <hr>
      
        <p>可上班時段
        	 <input type="text" name="time">
        </p>
        <hr>
    
        <p>可上班日期
        	 <input type="text" name="date">
        </p>
        <hr>
    
        <p>上架日期
        	 <input type="date" name="rackUp">
        </p>
        <hr>
      
        <p>下架日期
        	 <input type="date" name="rackDown">
        </p>
        <hr>
      
        <p>照片上傳
         <input type="file" name="img" >
        </p>
        <hr>
 
        <p>備註
        <textarea name="remark" cols="20" rows="5"></textarea>
        </p>
     
        <input type="submit" value="送出">
        </div>
 </form>
</body>
</html>