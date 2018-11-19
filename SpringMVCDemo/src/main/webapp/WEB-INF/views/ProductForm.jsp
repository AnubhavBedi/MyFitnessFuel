<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ProductForm</title>
</head>

<body style="background-color:#ffd480">


<jsp:include page="./shared/header.jsp"/>


<div class="container">

	<h2>Fitness Fuel-Product  </h2>
	<br>
		
		<h3>${heading}</h3>
		<br>
		<br>
	
	<form:form action="${contextRoot}/admin/addProduct" method="POST" modelAttribute="productobj" enctype="multipart/form-data">
		<c:if test="${productobj.productid!=0}">
		<div class="form-group" >
			<label for="productid">Product Id:</label>
			<form:input type="text" path="productid" readonly="true" class="form-control"/>
		</div>
		</c:if>	
		
		
			
		<div class="form-group">	
			<label for="productName">Product Name </label>
			<form:input type="text"  path="productname" class="form-control"/>
		</div>
			
		<div class="form-group">
			<label for="price">Product Price</label>
			<form:input type="text"  path="price" class="form-control"/>
		</div>
			
		<div class="form-group">
			<label for="quantity">Product Quantity </label>
			<form:input type="text"  path="quantity" class="form-control"/>
		</div>
			
		<div class="form-group">
			<label for="productdescription">Product Description</label>
			<form:input type="text"  path="productdescription" class="form-control"/>
		</div>
			
			
			<div class="form-group">
			<label for="categoryid">Select Category : </label>
				<form:select path="categoryid" class="form-control">
				<form:option value="0" class="form-control">----------------Select Category------------------</form:option>
				<c:forEach items="${categoryList}" var="catObj">
							<form:option value="${catObj.categoryid}" class="form-control">${catObj.categoryname}</form:option>
						</c:forEach>
					</form:select>
			
			</div>
			<div class="form-group">
				<label for="supplierid">Select Supplier : </label>
				
					<form:select path="supplierid" class="form-control">
						<form:option value="0" class="form-control">----------------Select Supplier------------------</form:option>
						<c:forEach items="${supplierList}" var="suppObj">
							<form:option value="${suppObj.supplierid}" class="form-control">${suppObj.suppliername}</form:option>
						</c:forEach>
					</form:select>
				
			</div>
			
			<div class="form-group">
			<label for="pimage">Upload Image</label>
			
				<form:input path="pimage" type="file" placeholder="Upload Product Image" class="form-control"/>	
			</div>			
			
			
			<div>
				<input type="submit"  class="btn btn-primary btn-lg"  value="${button}">
			</div>
	</form:form>

</div>


<div style="margin-top:300px">
<jsp:include page="./shared/footer.jsp"/>
</div>

</body>
</html>