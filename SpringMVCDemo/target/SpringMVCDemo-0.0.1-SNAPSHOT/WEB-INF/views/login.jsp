<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body style="background-color:#ffd480">

<jsp:include page="./shared/header.jsp"/>

<div class="container">

	<h2>Login Form</h2>
	<br/>
	
	
	<c:if test="${not empty msg}">
		<div class="alert alert-danger">
			${msg}
		</div>
	</c:if>
	<form action="${contextRoot }/login" method="POST" class="form-horizontal" id="loginForm">
	
	<div class="form-group">
   	 	<label for="email"  > Email:</label>
    	<input type="text" class="form-control" id="email" name="email"/>
 	</div>
 	
 	<div class="form-group">
   		 <label for="password">Password:</label>
    	 <input type="password" class="form-control" id="password" name="password"/>
 	</div>
 	
 	<div class="form-group">
          <div >
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          <input type="submit" value="Login" class="btn btn-primary btn-lg"/>
    </div>
    </div>
   
    </form>
<div style="margin-top:350px">
<jsp:include page="./shared/footer.jsp"/>
</div>
</body>
</html>
