<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
   <h1 class="jumbotron" align="center">Login</h1>
 
     <form action="LoginValidate" method="post">
  
  <div class="container">
 
  <table class="table table-dark" align="center" style="width:500px;height:200px;border-radius:30px;">
    <tbody>
      <tr>
        <td><label>UserName</label></td>
        <td>:</td>
        <td>  <input type="text" class="form-control" name="userName" placeholder="UserName"></td>
      </tr>
      <tr>
        <td><label >Password</label></td>
        <td>:</td>
        <td>  <input type="password" class="form-control" name="Password" placeholder="Password">           
               </td>
      </tr>
     
      <tr>
        <td colspan="2"></td>
       
        <td> <input type="submit" name="submit" class="btn btn-primary" value="Submit"  > </td>
      </tr>
      
    </tbody>
  </table>
  
    <c:if test="${not empty msg }">
    <div class="alert alert-danger">
    ${msg}
    </div>
    </c:if>
 </div>
 </form>   
</body>
</html>