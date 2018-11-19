<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page isELIgnored="false" %>


<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<spring:url value="/resources/images" var="images"/>

<!DOCTYPE html>
<html lang="en">
<head>

  <title>Fitness Fuel Center</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
	<style>	
	.navbar-inverse {
		background-color:#b30000;
		color:#000000;
	}
	.navbar-inverse ul li {
		font-weight:bold;
	}
	
	.glyphicon{
	font-size:20px;
	}
</style> 
<body>



<nav class="navbar1 navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="http://localhost:7838/SpringMVCDemo/">Fitness Fuel</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="${contextRoot}/">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Shop By Category<span class="caret"></span></a>
        <ul class="dropdown-menu">
        <c:forEach items="${sessionScope.catList}" var="catObj">
        	<li><a href="${contextRoot}/viewAllProducts/${catObj.categoryid}">${catObj.categoryname}</a></li>
        </c:forEach>
          
        </ul>
    </li>

     
      <li><a href="${contextRoot}/AboutUs">About Us</a></li>
      <li><a href="${contextRoot}/ContactUs">Contact Us</a></li>
      
      <sec:authorize access="hasAuthority('ADMIN')" >
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Admin Options<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${contextRoot}/admin/getProductPage">Product</a></li>
          <li><a href="${contextRoot}/admin/getCategoryPage">Category</a></li>
          <li><a href="${contextRoot}/admin/getSupplierPage">Supplier</a></li>
     
        </ul>
      </li>
      </sec:authorize>
    </ul>
    
    
      <sec:authorize access="hasAuthority('USER')" >
    
    	<ul class="nav navbar-nav ">
    	<li><a href="${contextRoot}/addToCart/viewCart?uEmail=${sessionScope.userEmail}"><span class="glyphicon glyphicon-shopping-cart bt-lg"></span></a></li>
    	</ul>
    </sec:authorize>	
    	
    
    <sec:authorize access="isAnonymous()">
    <ul class="nav navbar-nav navbar-right">
      <li><a href="${contextRoot}/getSignUpForm"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${contextRoot}/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
    </sec:authorize>
    
     <sec:authorize access="isAuthenticated()">
    	<ul class="nav navbar-nav navbar-right">
    		<li>		Welcome :${sessionScope.userName}</li>
    		<li><a href="${contextRoot}/dologout">Logout</a></li>
    	</ul>
    </sec:authorize>
  </div>
  </div>
</nav>
</body>
</html>