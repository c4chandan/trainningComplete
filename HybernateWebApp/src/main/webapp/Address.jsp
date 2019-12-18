<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
       <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<title>Address</title>
</head>
<body >
<h1 class="jumbotron" align="center">Address</h1>
 
  <form action="AddAddress" method="post">
  
  <div class="container">
 
  <table class="table table-dark"">
    <tbody>
      <tr>
        <td>State</td>
        <td>:</td>
        <td><input type="text" name="State" class="form-control" id="name" placeholder="State" required/></td>
      </tr>
      <tr>
        <td>City</td>
        <td>:</td>
        <td> <select  name="city" style="width:200px;height:45px;border-radius:5px;" >
                                    <option >Select your city</option>
                                    <option value="Delhi">Greater Noida</option>
                                    <option value="Noida">Noida</option>
                                    <option value="agra">Agra</option>
                                    <option value="goa">Goa</option>
                                    <option value="Aligarh">Aligarh</option>
                                    <option value="Lucknow">Lucknow</option>
                                </select>                    
               </td>
      </tr>
      <tr>
        <td>Pincode</td>
        <td>:</td>
        <td><input type="text" name="pincode" class="form-control" pattern=[0-9]{7} placeholder="pincode" required/></td>
      </tr>
      <tr>
        <td colspan="2"></td>
       
        <td> <input type="submit" name="submit" class="btn btn-primary" value="Submit"  > </td>
      </tr>
      
    </tbody>
  </table>
</div>
  
                             
  
  
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