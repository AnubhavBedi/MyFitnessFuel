<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="form"  uri="http://www.springframework.org/tags/form"%>
 
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  	  <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fitness Fuel </title>
</head>
<body>
<jsp:include page="./shared/header.jsp"/>

<div class="container">

	<h1> Fitness Fuel-Supplier  </h1>
		<hr/>
		<br/>

	<h3>Make Payment</h3>
	<br/>
	<br/>

<form:form action="${contextRoot}/addToCart/finalOrder"  method="post" modelAttribute="orderObj">
	
			<div class="form-group">	
			<label for="cardNumber">Card Number : </label>
			<form:input type="text"  path="cardNumber" class="form-control"/>
			</div>
			
			<div class="form-group">	
			<label for="nameOnCard">Name On Card : </label>
			<form:input type="text"  path="nameOnCard" class="form-control"/>
			</div>
			
			<div>
				<label>Expiry Date : </label>
				<form:input type="text"  path="month" class="form-control"/>
				<form:input type="text"  path="year" class="form-control"/>	
			</div>
			
			<div class="form-group">	
			<label for="cvv">Cvv : </label>
			<form:input type="text"  path="cvv" class="form-control"/>
			</div>
			
			<div class="form-group">
				<input type ="submit" value="Make Payment"/>
			</div>	
			
		

</form:form>
</div>

<div style="margin-top:300px">
</div>
<jsp:include page="./shared/footer.jsp"/>
</body>
</html>