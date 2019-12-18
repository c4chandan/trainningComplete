<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring</title>
<style>
.error
{
	color:red;
	FONT-FAMILY:Lucida Handwriting;
	font-size:10px;
}

body
{
	margin-left:50px;
	padding:10px 20px;
	font-size:20px;	
}

table{	
	width:500px;
	height:250px;
	margin:5px;
	paddding:10px 20px;
	font-size:20px;
}

table tr td input{
	border-radius:3px;
	width:250px;
	height:25px;
}
table tr td input:hover{
	background-color:lightyellow;
}


</style>

</head>
<body>
<f:errors path="*"/>
<h2 align="center" style="color:red;font-size:20px;padding:10px 20px;">${formLabel}</h2>
	<f:form action="${path}/registerUser" method="post"	modelAttribute="userObj">
		<table align="center">
			<tr>
				<td>User Id</td>
				<td>:</td>
				<td><f:input path="userId" /></td>
				<td>
				<f:errors path="userId" cssClass = "error" />
		</td>
			</tr>

			<tr>
				<td>User Name</td>
				<td>:</td>
				<td><f:input path="name" /></td>
	<td>
				<f:errors path="name" cssClass = "error" />
		</td>
			</tr>

			

				<tr>

					<td>Password :</td>
					<td>:</td>	
					<td><f:password path="password" /></td>
	<td>
				<f:errors path="password" cssClass = "error" />
		</td>
				</tr>
			<tr>
				<td>Gender</td>
				<td>:</td>
				<td><f:input path="gender" /></td>
		<td>
				<f:errors path="gender" cssClass = "error" />
		</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="submit"  value="${btnLabel}" /></td>
			</tr>
		</table>
	</f:form>


</body>
</html>