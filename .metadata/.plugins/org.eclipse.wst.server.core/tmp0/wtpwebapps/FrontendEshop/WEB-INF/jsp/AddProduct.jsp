<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add product</title>

<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha256-pasqAKBDmFT4eHoN2ndd6lN370kFiGUFyTiUHWhU7k8="
	crossorigin="anonymous">
  </script>

</head>
<body>


	<h1>${product}</h1>


	<h2>${msg}</h2>
	<f:errors path="*" />
	<f:form action="${path}/AddProduct" method="POST" modelAttribute="productObj" id="confirm">
		<table align="center" id="dialog-1">
			<tr>
				<td>Product Name</td>
				<td>:</td>
				<td><f:input path="productName" /></td>
				<td><f:errors path="productName" cssClass="error" /></td>
			</tr>
		<tr>
				<td>price :</td>
				<td>:</td>
				<td><f:input path="price" /></td>
				<td><f:errors path="price" cssClass="error" /></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="submit" value="Add" class="getConfirmation" /></td>
			</tr>
		</table>
	</f:form>
	<script type="text/javascript">
	 $(document).ready(function() {
		$('.getConfirmation').click(function(){
			var a=confirm("Are you Sure u want to submit this");
			if(a==true)
				{
				$("#confirm").submit
				}
			else
				{
				return false;
				}
		});
	 });
			
    
      </script>
</body>
</html>