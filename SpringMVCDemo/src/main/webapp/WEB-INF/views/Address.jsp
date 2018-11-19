<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Address</title>
</head>
<body style="background-color:#ffd480">

<jsp:include page="./shared/footer.jsp"/>

<div class="container">

	<h2>Address Form</h2>
	<br/>
	
	<form:form action="${contextRoot}/addToCart/addAddress" modelAttribute="addressObj" method="POST">
	<div class="form-group">
    <label for="houseNumber">House Number</label>
    <form:input type="text" class="form-control" id="houseNumber" path="houseNumber"/>
 	</div>
 	
 	<div class="form-group">
    <label for="locality">Locality :</label>
    <form:input type="text" class="form-control" id="locality" path="locality"/>
 	</div>
 	
 	<div class="form-group">
    <label for="city ">City :</label>
    <form:input type="text" class="form-control" id="city" path="city"/>
 	</div>
 	
 	
 	<div class="form-group">
    <label for="country">Country :</label>
    <form:input type="text" class="form-control" id="country" path="country"/>
 	</div>
 	
 	<div class="form-group">
    <label for="pincode">Pincode :</label>
    <form:input type="text" class="form-control" id="pincode" path="pinCode"/>
 	</div>
 	
 	
 	<div class="form-group">
    
    <input type="submit" class="form-control btn btn-primary" value="Add"/>
		</div>
 	</form:form>


</div>
<div style="margin-top:350px">
<jsp:include page="./shared/footer.jsp"/>
</div>
</body>
</html>
