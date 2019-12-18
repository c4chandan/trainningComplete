<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       

<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="Loginform" method="post">
<table>
<tr> 
<td> User Id</td>
<td>:</td>
<td><input type="number" name="userId"/></td>
</tr>
<tr> 
<td>Password</td>
<td>:</td>
<td><input type="password" name="password"/></td>
</tr>
<tr>
<td></td>
<td></td>
<td><input type="submit" name="submit" value="submit"/></td>
</tr>
</table>
</form>
</body>
</html>