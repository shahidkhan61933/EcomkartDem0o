<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of products</title>
</head>
<body>
	
	<jsp:include page="index.jsp"></jsp:include>
	
	<div align="center" style="border: 2px solid green; padding: 10px;">
	<core:choose>
		<core:when test="${products.size()> 0 }">
			
				<table border="1">
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Price</th>
						<th>Date Added</th>
					</tr>
					<core:forEach var="product" items="${products}">
						<tr>
							<td>${product.getId()}</td>
							<td>${product.getName()}</td>
							<td>${product.getPrice()}</td>
							<td>${product.getDateAdded()} </td>
						</tr>
					</core:forEach>
				</table>				
				<br>			
		</core:when>
		<core:otherwise>
			<p>Product list is empty !</p>
		</core:otherwise>
	</core:choose>
	
	</div>
	
</body>
</html>