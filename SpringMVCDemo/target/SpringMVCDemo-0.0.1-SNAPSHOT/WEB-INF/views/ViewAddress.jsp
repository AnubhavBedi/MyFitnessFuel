<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<spring:url value="/resources/images" var="images"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style >
  .btn{
	background-color:  #00cc66 ;
}

.btn:hover {
    background-color: #6666ff ;
}
  
  </style>  
<title>All Products</title>
</head>
<body>

<jsp:include page="./shared/header.jsp"/>

<div class="container">

	
	<h1>Select Address</h1>
	<div class="table-responsive">
	<table class="table table-bordered" Style="background-color:#ddccff;">

		<tr>
		<th><strong>Select</strong></th>  
			<th><strong>House Number</strong></th>
			<th><strong>Locality</strong></th>
			<th><strong>City</strong></th>
			<th><strong>Country</strong></th>
			<th><strong>Pin Code</strong></th>
			
		</tr>
			<c:forEach items="${addressList}" var="addrObj">
		<tr>
		<th><a href="${contextRoot}/addToCart/selectedAddress/${addrObj.addressid}">Choose for Delivery</a></th>	
			<td>${addrObj.houseNumber}</td>
			<td>${addrObj.locality}</td>
			<td>${addrObj.city}</td>
			<td>${addrObj.country}</td>
			<td>${addrObj.pinCode}</td>
			
			</tr>
			
				
			</c:forEach>
			
		
		</table>
		
		<a href="${contextRoot}/addToCart/getAddressForm">Add New Address</a>
		
		</div>
</div>
</div>
</div>

<jsp:include page="./shared/footer.jsp"/>

</body>
</html>