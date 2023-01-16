<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Purchase Order</title>
<link rel="stylesheet" href="/css/ordersystem.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
   var indexPage =1;
   
   $(function(){
	   load(indexPage);
   });

   function load(indexPage){
	   $.ajax({
		   type:'post',
		   url:'/product/queryByPage/' + indexPage,
		   dataType:'JSON',
		   contentType:'application/json',
		   success: function(data){
			   console.log(data);
			   $('#showproduct').empty("");
			   
			   if(data==null){
				   $('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
			   }else{
				   var table = $('#showproduct');
				   table.append("<tr id='ptitle'><th>ID</th><th>Product Name</th><th>Product Price</th><th>Note</th></tr>");
				   
				   $.each(data, function(i,n){
					   var tr = "<tr align='center'>" + "<td><a href='/order/purchaseOrderProduct.controller?pid=" + n.id + "'>" + n.id +
					            "</a></td>" +
					            "<td>" + n.pname + "</td>" + "<td>" + n.price + "</td>" +
					            "<td>" + n.note + "</td>" +
					            "</tr>";
					   table.append(tr);
				   });				   
			   }
		   }
	   });
   }

   function change(page){
	   indexPage = page;
	   load(indexPage);
   }
</script>
</head>
<body>
<div id="productListTitle">Purchase Order System</div>
<table border="1" id="showproduct"></table>

<table id="showpage">
   <tr>
      <td>Total Pages:${totalPages}  Total Elements:${totalElements}</td>
      <td colspan="3" align="right">Previous
          <c:forEach var="i" begin="1" end="${totalPages}" step="1">
              <button id="myPage" type="button" onclick="change(${i})" value="${i}">${i}</button>
          </c:forEach>Next
      </td>
   </tr>
</table>
</body>
</html>