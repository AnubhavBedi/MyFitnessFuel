<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

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
		background-color:#A4A4A4;
		color:#ff0000;
	}
	.navbar-inverse ul li {
		font-weight:bold;
	}	
	
	
</style>
<body style="background-color:#e6ffe6">

<!-- header.jsp -->
<jsp:include page="./shared/header.jsp"/>

<br/>
<div class="container">
  

<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
    <img src="${images}/img6.jpg" style="width:100%">
    </div>
	
	
    <div class="item">
      <img src="${images}/img7.jpg" style="width:100%">
    </div>
	
	<div class="item">
      <img src="${images}/img10.jpg" style="width:100%">
    </div>
</div>
  <!-- Left and right controls -->
   <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
    </div>
  
  <div class="row">  
  
  	<a class="btn btn-social-icon btn-whatsapp btn-lg col-sm-3" style="font-size:48px;">
    <span class="fa fa-whatsapp"></span>
  	</a>
  	
	<a class="btn btn-social-icon btn-facebook btn-lg col-sm-3"  style="font-size:48px;">
    <span class="fa fa-facebook"></span>
  	</a>
  	
	<a class="btn btn-social-icon btn-twitter btn-lg col-sm-3" style="font-size:48px;">
    <span class="fa fa-twitter"></span>
  	</a>
  	
  	<a class="btn btn-social-icon btn-google btn-lg col-sm-3" style="font-size:48px;">
    <span class="fa fa-google"></span>
  	</a>
  	
  
  
  
 </div> 


  <br/>

<div class="jumbotron" style="background-color:#b3ffb3">
    <h1>--------Fitness Fuel Provider---------</h1> 
    <p>Health and fitness is the key to a long, active and enjoyable life. It is correctly stated that Health is the actual Wealth that a person can retain. Teachers assign this topic to their students to enhance their knowledge about staying healthy and fit, and create awareness among others as well. It also results in the development of a healthy lifestyle for children..</p> 
  </div>
</div>


<!-- Footer -->
<jsp:include page="./shared/footer.jsp"/>


</body>
</html>
