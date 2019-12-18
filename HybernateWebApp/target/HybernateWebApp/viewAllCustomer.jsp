<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ViewallCustomers</title>
</head>
<body>
<Table align="center" cellspacing="3px" cellpadding="3px;"  style="padding:20px 20px;">
	<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Gender</th>
	<th>Email</th>
	<th>Password</th>
	<th>City</th>
	<th>Role</th>
	</tr>
	<c:forEach var="i" items="${cust}" >
	<tr>
	<td>${i.id}</td>
	<td>${i.name}</td>
	<td>${i.gender}</td>
	<td>${i.email}</td>
	<td>${i.password}</td>
	<td>${i.city}</td>
	<td>${i.role}</td>
	
	<td><a href="Update?mid=${i.id}">Update</a></td>
	<td><a href="Delete?cid=${i.id}">Delete</a></td>
		</tr>
	</c:forEach>
</Table>
<c:if test="${ not empty msg }">
<div class="alert alert-danger">
${msg}
</div>
</c:if>
</body>
</html>