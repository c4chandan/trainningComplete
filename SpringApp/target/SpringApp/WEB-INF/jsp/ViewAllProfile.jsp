<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Profile</title>
</head>
<body>
<table cellpadding="5px" cellspacing="5px" style="padding:10px 20px;font-size:20px;">
<tr><th>Id</th>
<th>Name</th>
<th>Password</th>
<th>Gender</th>
<th>Role</th>
</tr>
<c:forEach var="i" items="${UserObject}" >
	<tr>
	<td>${i.userId}</td>
	<td>${i.name}</td>
	<td>${i.password}</td>
	<td>${i.gender}</td>
	<td>${i.role}</td>
	
	<td ><a href="${path}/UpdateUser/${i.userId}">Update</a></td>
	<td ><a href="${path}/DeleteUser/${i.userId}">Delete</a></td>
		</tr>
	</c:forEach>

</table>
</body>
</html>