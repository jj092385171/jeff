<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PO</title>
<link rel="stylesheet" href="/css/ordersystem.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
   $(function(){
	   var pid = $('#pid').val();
	   load(pid);
   })
   
   function load(pid){
	   //alert(pid);
	   $.ajax({
		   type:'post',
		   url:'/product/query/'+pid,
		   dataType:'JSON',
		   contentType:'application/json',
		   success:function(data){
			   $('#showproduct').empty("");
			   if(data==null){
				   $('table').prepend("<tr><td colspan='2'>暫無資料</td></tr>");
			   }else{
				   var table = $('#showproduct');
				   table.append("<tr id='ptitle'><th>ID</th><th>Product Name</th><th>Product Price</th><th>Product Quantity</th><th>Note</th>" + 
						        "<th>Order Qualtity</th><th>Order</th></tr>");
				   var tr = "<tr align='center'>" +
				            "<td>" + data.id + "</td>" +
				            "<td>" + data.pname + "</td>" +
				            "<td><input id='price' type='text' value='" + data.price + "' readonly/></td>" +
				            "<td><input id='quantity' type='text' value='"+ data.quantity +"' readonly/></td>" +
				   "<td>" + data.note + "</td>" + "<td><input id='orderQuantity' type='text'/></td>" +
				   "<td><button id='order' type='button' value='order' onclick='sendOrder(" + data.id + ")'>order</button></td>" +
				   "</tr>";
				   table.append(tr);
			   }
		   }
	   });
   }
   
   function sendOrder(id){
	   //alert('id:' + id);
	  var orderQuantity = $('#orderQuantity').val();
	  var price = $('#price').val();
	  var productQuantity = $('#quantity').val();
	  
	  var amount = parseInt(orderQuantity)*parseInt(price);
	  
	  if($.trim(orderQuantity)==''){
		  alert('Order Quantity is empty');
		  return;
	  }
	  
	  if(parseInt(orderQuantity)>parseInt(productQuantity)){
		  alert('Order Quantity can not more than Product Quantity');
		  return;
	  }
	  
	  var params = {
			         "amount":amount,
			         "userid":1000,
			         "productid":id
			       };
	  
	  $.ajax({
		   type:'post',
		   url:'/order/poinsert.controller',
		   dataType:'JSON',
		   contentType:'application/json',
		   data: JSON.stringify(params),
		   success: function(data){
			   $('#feedback').html('insert success');
		   }
	  });
   }
</script>
</head>
<body>
<div id="productListTitle">Purchase Order</div>
<table border="1" id="showproduct"></table>

<input id="pid" type="hidden" value="${pid}"/>
<div id="feedback" align="center"></div>
</body>
</html>