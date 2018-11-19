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
<body>
<jsp:include page="./shared/header.jsp"/>
<div align="center">

	<div class="panel panel-info">
 	<div class="panel-heading"><h1><strong> All Supplier</strong></h1></div>
 	
 	
 	<div class="container">
	<br>
 	<c:if test="${not empty msgToDisplay }">
		<div class="alert alert-success">
		${msgToDisplay}
		</div>
		</c:if>
	
	<table class="table table-bordered" Style="background-color:#ddccff;">
		<tr>
			<th><strong>Supplier ID</strong> </th>
			<th><strong>Supplier Name</strong> </th>
			<th><strong>Delete Supplier</strong> </th>
			<th><strong>Update Supplier</strong></th>
		</tr>	
			<c:forEach items="${supplierlist}" var="sppobj">
		<tr>
			<td>${sppobj.supplierid}</td>
			<td>${sppobj.suppliername}</td>
		
		
			<td><a href="${contextRoot }/admin/deleteSupplier/${sppobj.supplierid}"> <span class="glyphicon glyphicon-trash bt-lg"></span></a></td>
			<td><a href="${contextRoot }/admin/updateSupplier/${sppobj.supplierid}"> <span class="glyphicon glyphicon-edit bt-lg"></span></a></td>
			</tr>
			</c:forEach>
			
</table>
</div>
</div>
</div>
<div style="margin-top:350px">
<jsp:include page="./shared/footer.jsp"/>
</div>
</body>
</html>