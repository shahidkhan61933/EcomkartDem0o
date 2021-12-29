<%@page import="com.ecom.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Request Successful </title>
</head>
<body>
		<jsp:include page="index.jsp"></jsp:include>
		
        <table>
            <tr>
            	
            	 <!-- Successful Registration -->
            	<%
            		String email = (String) request.getAttribute("email");
            		if(email!=null){
            			out.println("<h1>Welcome User "+email+"</h1>");
            		}
            	%>
               <!-- Successful login -->
               <%
              
	       		User user = (User) request.getAttribute("user");
	       		if(user !=null && email==null){
	       			out.println("<h1>Welcome User "+user.getFirstname() +"   " + user.getLastname()+"</h1>");
	       			out.println("<p> username  : "+user.getUsername()+"</p>");
	       			out.println("<p> password  : "+user.getPassword()+"</p>");
	       			out.println("<p> email : "+user.getEmail()+"</p>");
	       			out.println("<p> phone : "+user.getPhone()+"</p>");
	       			out.println("<p> address :"+user.getAddress()+"</p>");
	       		}
               %>
               
              
            </tr>
            <tr>
            </tr>
            <tr>
            </tr>
            <tr>
                <td><a href="index">Home</a>
                </td>
            </tr>
        </table>
</body>
</html>