<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring</title>
</head>
<body>
	<f:form action="${path}/registerUser" method="post"	modelAttribute="userObj">
		<table>
			<tr>
				<td>User Id</td>
				<td>:</td>
				<td><f:input path="userId" /></td>
			</tr>

			<tr>
				<td>User Name</td>
				<td>:</td>
				<td><f:input path="name" /></td>
			</tr>

			

				<tr>

					<td>Password :</td>
					<td>:</td>	
					<td><f:password path="password" /></td>

				</tr>
			<tr>
				<td>Gender</td>
				<td>:</td>
				<td><f:input path="gender" /></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="submit" name="submit" value="${btnLabel}" /></td>
			</tr>
		</table>
	</f:form>


</body>
</html>