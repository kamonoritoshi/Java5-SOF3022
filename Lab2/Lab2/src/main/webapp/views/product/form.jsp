<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
	<form action="/product/save" method="post">
		<input name="name" value="${product.name}" >
		<input name="price" value="${product.price}" >
		<button>Save</button>
	</form>
	<ul>
		<li>${savedProduct.name}</li>
		<li>${savedProduct.price}</li>
	</ul>
	<ul>
		<c:forEach var="item" items="${items}">
			<li>${item.name}</li>
			<li>${item.price}</li>
		</c:forEach>
	</ul>
</body>
</html>