<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
    <c:set var="contextRoot" value="${pageContext.request.contextPath}"/> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>View Supplier page</title>
</head>
<body style="background-color:#ffd480">

<jsp:include page="./shared/header.jsp"/>

<div align="center">

	<div class="panel panel-info">
 	<div class="panel-heading"><h1><strong> Order Page</strong></h1></div>
 	
 	
 	<div class="container">
	<br>
 	
 	

 	
 	<table class="table table-bordered" Style="background-color:#ddccff;">
		<tr>
			<th><strong>Item Name</strong> </th>
			<th><strong>Price</strong> </th>
			<th><strong>Quantity</strong> </th>
			
		</tr>	
			<c:forEach items="${itemsList}" var="item">
		<tr>
			<td>${item.product.productname}</td>
			<td>${item.product.price}</td>
			<td>${item.quantity}</td>
		
		</tr>
		
		
			</c:forEach>
		
		
		<tr>
			<th colspan="2">Grand Total</th>
			<th>${sum}</th>
		</tr>
			
			<tr>
			<td>Address for Delievery</td>
			<td>
				<address>
				House No : ${address.houseNumber}
				<br/>
				Locality : ${address.locality}
				<br/>
				City : ${address.country}
				<br/>
				Pincode : ${address.pinCode}
				</address>
			</td>
		</tr>
		
		<br/>
		<br/>
		<tr>
		<td></td>
		<td>
		<a href="${contextRoot}/addToCart/confirmAndPay" class="btn btn-primary">Confirm Order and Proceed to Pay</a>
		</td>
		</tr>
			
</table>
</div>
</div>
</div>
<div style="margin-top:350px">
<jsp:include page="./shared/footer.jsp"/>
</div>
</body>
</html>