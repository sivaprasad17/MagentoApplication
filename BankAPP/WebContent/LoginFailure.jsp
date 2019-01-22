<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%out.println("Invalid CustomerId or Password"); %>
<form action="LoginController">
<table>

<tr>
<td><label>CustomerID</label></td>
<td><input type="text"name ="customerid" required/></td>
</tr>

<tr>
<td><label>Password</label></td>
<td><input type="password"name ="password" required/></td>
</tr>

<tr>
<td><input type="submit"value ="Login" required/></td><a href="">ForgotPassword?</a>
</tr>

</table>

</form>
</body>
</html>