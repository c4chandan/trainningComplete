<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Updated</title>
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

	</tr>
	<tr>
	<td><input type="text" name="id" value="${upone.id}	"></td>
	<td>${upone.name}</td>
	<td>${upone.gender}</td>
	<td>${upone.email}</td>
	<td>${upone.password}</td>
	<td>${upone.city}</td>

		</tr>

</Table>
</body>
</html>