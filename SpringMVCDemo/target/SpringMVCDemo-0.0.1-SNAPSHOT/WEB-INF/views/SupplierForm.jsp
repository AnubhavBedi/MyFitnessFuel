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
<body style="background-color:#ffd480">
<jsp:include page="./shared/header.jsp"/>

<div class="container">

	<h1> Fitness Fuel-Supplier  </h1>
		<hr/>
		<br/>

	<h3>${heading}</h3>
	<br/>
	<br/>

<form:form action="${contextRoot}/admin/a3"  method="post" modelAttribute="supplierObj">
	
			
			
			<c:if test="${supplierObj.supplierid!=0}">
			<div class="form-group">
				<label for="">Supplier ID </label>
				<form:input type="text" path="supplierid" readonly="true"/>
				
			</div>
			</c:if>
			
			<div class="form-group">	
			<label for="suppliername">Supplier Name </label>
			<form:input type="text"  path="suppliername" class="form-control"/>
			</div>
			
			<div class="form-group">
				<input type="submit"  class="btn btn-primary btn-lg"  value="${button}">
			</div>
			
			
		

</form:form>
</div>

<div style="margin-top:500px">
<jsp:include page="./shared/footer.jsp"/>
</div>
</body>
</html>