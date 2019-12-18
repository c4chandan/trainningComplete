
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.iris.model.User"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
       <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  
<title>ViewallCustomers</title>
</head>
<body>

<div align="center" >welcome ${custobj.userName} 
</div>
<h3 align="center" style="color:green"> Address Added successfully.........</h3>

<div class="container">
<Table class="table" align="center" cellspacing="3px" cellpadding="3px;"  style="padding:20px 20px;">
<thead  class="thead-dark">
	<tr>
	<th>State</th>
	<th>City</th>
	<th>Pincode</th>
	</tr>
	</thead>
	<c:forEach var="i" items="${requestScope.addobj}" >
	<tr>
	<td class="table-primary">${i.State}</td>
	<td>${i.city}</td>
	<td>${i.pincode}</td>
			</tr>
	</c:forEach>
</Table>
</div>
</body>
</html>