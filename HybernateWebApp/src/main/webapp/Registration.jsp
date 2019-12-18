<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
       <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="registration.css">

</head>
<body >

<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600' rel='stylesheet' type='text/css'>
<link href="//netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
<div class="testbox">
 <h1>Registration</h1>
 
  <form action="RegistrationServlet" method="post">
  <label id="icon" for="name"><i class="icon-user"></i></label>
  <input type="text" name="cname" id="name" placeholder="Name" required/>
  <br/> <br/>
  <div class="gender">
       <input type="radio" value="Male" id="male" name="gender" checked/>
    <label for="male" class="radio" checked>Male</label>
    <input type="radio" value="Female" id="female" name="gender" />
    <label for="female" class="radio">Female</label>
    
   </div> 
   <label id="icon" for="name"><i class="icon-envelope "></i></label>
  <input type="text" name="email" id="name" placeholder="Email" required/>
  
   
   <label id="icon" for="name"><i class="icon-shield"></i></label>
  <input type="password" name="pswd" id="name" placeholder="Password" required/>
               
   <p>By clicking Register, you agree on our <a href="#">terms and condition</a>.</p>
   <input type="submit" id="button" name="submit" value="Submit"  >
  </form>
  <br/>
  <c:if test="${not empty errormsg}">
  <div class="alert alert-danger">
  ${errormsg}
  </div>
  </c:if>
</div>

</body>
</html>