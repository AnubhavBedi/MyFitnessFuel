 <jsp:include page="./shared/header.jsp"></jsp:include>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="images" value="/resources/images"/>


<style>	
	.glyphicon{
	font-size:50px;
	}
</style>
 <c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
 
 <body >
<div class="container">

<br/>


 
<h1 style="color:green">${msg}</h1>
<h1>Cart</h1>
<table class="table table-bordered ">
    <thead>
      <tr>
        <th>Item Name</th>
        <th>Price Per Quantity</th>
       	<th>Quantity</th>
       	<th>Total Price</th>
       	<th>Image</th>
       	<th>Remove from Cart</th>
       	<th>Increase Quantity</th>
       	<th>Decrease Quantity</th>
      </tr>
    </thead>
   <tbody  >
 <c:forEach items="${itemsList}" var="itemObj">
 		
  		<tr>
  			<td>${itemObj.product.productname}</td>
  			<td>${itemObj.price}</td>
  			<td>${itemObj.quantity}</td>
  			<td>
  			<c:out value="${itemObj.price * itemObj.quantity}"/>
  			</td>
  			<td><img src="${images}/${itemObj.product.imgName}" style="height:200px;width:200px"/></td>
  			<td>
  				<a href="${contextRoot}/addToCart/deleteItem/${itemObj.itemId}"><span class="glyphicon glyphicon-remove-sign"></span></a>
  			</td>	
  			<td><a href="${contextRoot}/addToCart/increaseQuantity/${itemObj.itemId}"><span class="glyphicon glyphicon-plus-sign bt-lg"></span></a></td>
  			<td><a href="${contextRoot}/addToCart/decreaseQuantity/${itemObj.itemId}"><span class="glyphicon glyphicon-minus-sign bt-lg"></span></a></td>
  			
  		</tr>
  		
  </c:forEach>
  <tr>
  <td>
  <a href="${contextRoot}/addToCart/placeOrder" class="btn btn-primary">Place Order</a>
  </td>
  </tr>
  </tbody>
 
</table>


<div style="margin-top: 100px">
<jsp:include page="./shared/footer.jsp"></jsp:include>
</div>
</div></body>
