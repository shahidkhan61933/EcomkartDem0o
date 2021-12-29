<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Orders</title>
</head>
<body>
	
	<jsp:include page="index.jsp"></jsp:include>
	
	<div align="center" style="border: 2px solid green; padding: 10px;">
	<core:choose>
		<core:when test="${orders.size()> 0 }">
			
				<table border="1">
					<tr>
						<th>Order Id</th>
						<th>Product</th>
						<th>User</th>
						<th>Create At date</th>
					</tr>
					<core:forEach var="order" items="${orders}">
						<tr>
							<td>${order.getId()}</td>
							<td>${order.getProduct()}</td>
							<td>${order.getUser()}</td>
							<td>${order.getCreatedAt()} </td>
						</tr>
					</core:forEach>
				</table>				
				<br>			
		</core:when>
		<core:otherwise>
			<p>order list is empty !</p>
		</core:otherwise>
	</core:choose>
	
	</div>
	
</body>
</html>