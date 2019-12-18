<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.iris.model.User"
    pageEncoding="ISO-8859-1" isELIgnored="false" isELIgnored="false"%>
    
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>success</title>
</head>
<body>
<h3 style="color:green;text-align:center;font-size:20px;"> welcome ${custobj.userName} </h3>
<div align="center"><a href="getAllCustomer">ViewAllProfile</a></div>
<div align="center"><a href="LogoutServlet">Logout</a></div>

</body>
</html>