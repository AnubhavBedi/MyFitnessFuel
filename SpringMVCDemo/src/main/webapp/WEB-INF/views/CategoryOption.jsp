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
    
<title>Category options</title>
<style type="text/css" >
.btn{
	background-color: #ffa366 ;
}

.btn:hover {
    background-color: #b34700 ;
}
</style>
</head>
<body style="background-color:#ffccb3">
<jsp:include page="./shared/header.jsp"/>

<div align="center">
	
	<div class="panel panel-info" >
 	<div class="panel-heading"><h1><strong> Category-Option</strong></h1></div>
	
	<hr/>
	
	<div class="btn-group-vertical  btn-group-lg ">
	<a href="${contextRoot }/admin/c1" class="btn btn-primary">Add Category</a><br/>
	<a href="${contextRoot }/admin/c2" class="btn btn-primary">View All Categories</a><br/>
	
	
	</div>
</div>
</div>
<div style="margin-top:330px">
<jsp:include page="./shared/footer.jsp"/>
</div>
</body>
</html>