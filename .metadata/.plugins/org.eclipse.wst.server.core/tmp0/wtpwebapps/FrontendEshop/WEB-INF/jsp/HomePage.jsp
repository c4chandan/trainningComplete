<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}" scope="application"/>

<html>
<head>
<title>HomePage</title>
</head>
<body>
 
<h2 style="color:red;">${msg} </h2>


<a href="getLoginForm">LogIn</a><br/>
<a href="getSignUpPage">SignUp</a><br/>
<a href="addProduct">Add Product</a><br/>


</body>
</html>