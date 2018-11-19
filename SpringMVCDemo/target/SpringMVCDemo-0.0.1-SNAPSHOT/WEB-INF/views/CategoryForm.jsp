<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fitness Fuel</title>
</head>
<body style="background-color:#ffd480">

<jsp:include page="./shared/header.jsp"/>
<div class="container">
	<h2>Fitness Fuel-Category  </h2>
	<br>
		
		<h3>${heading}</h3>
		<br>
		<br>
	
<form:form action="${contextRoot}/admin/c3" method="POST" modelAttribute="categoryObj">
	
		
			<c:if test="${categoryObj.categoryid!=0}">
			
			<div class="form-group">
				<label for="categoryid">Category Id:</label>
				<form:input type="text" path="categoryid" readonly="true" class="form-control"/>
			</div>
			</c:if>

			<div class="form-group">	
				<label for="categoryname">Category Name </label>
				<form:input type="text"  path="categoryname" class="form-control"/>
			</div>
			
			<div class="form-group">	
				<label for="categorydescription">Category Description </label>
				<form:input type="text"  path="categorydescription" class="form-control"/>
			</div>
			
			<div class="form-group">
				<input type="submit"  class="btn btn-primary btn-lg"  value="${button}">
			</div>
			
			
</form:form>
</div>

<div style="margin-top:200px">
<jsp:include page="./shared/footer.jsp"/>
</div>
</body>
</html>