<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>

	<div align="center" style="border: 2px solid green; padding: 10px;">
		<h1>Add Order</h1>
		<form:form action="add-order" method="post" modelAttribute="productuser">
			<table border="0">
				<tr>
					<td>Product Id</td>
					<td><form:input path="productId" /></td>
				</tr>

				<tr>
					<td>User Id :</td>
					<td><form:input path="userId" /></td>
				</tr>

				<tr>
					<td>Submit</td>
					<td><input type="submit" value="Add Order" /></td>
				</tr>

			</table>

		</form:form>
	</div>
</body>
</html>