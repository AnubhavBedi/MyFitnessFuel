<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="contextRoot" value="${ pageContext.request.contextPath}"/>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style >
  .btn{
	background-color:  #ffa366 ;
}

.btn:hover {
    background-color: #b34700
  
  </style>  
<title>Product Option</title>
</head>
<body>

<div align="center">

<jsp:include page="./shared/header.jsp"/>
	<div class="panel panel-info" >
 	<div class="panel-heading"><h1><strong>Product-Option</strong></h1></div>
	
	
	<hr/>
	
	
	<div class="btn-group-vertical  btn-group-lg  ">
	<a href="${contextRoot }/admin/getProductForm" class="btn btn-primary">Add Product</a><br/>
	<a href="${contextRoot }/admin/ViewProduct" class="btn btn-primary">View All Product</a><br/>
	
	</div>
	
	
</div>
</div>
<div style="margin-top:350px">
<jsp:include page="./shared/footer.jsp"/>
</div>
</body>
</html>