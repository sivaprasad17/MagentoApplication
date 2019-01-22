<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%out.print("Hello, "+session.getAttribute("NAME")+" you have successfully logged in."); %></br>
<a href="Transfer.jsp">ThirdPartyTransfer</a></br>
<a href="BalanceController">CheckBalance</a></br>
<a href="">ApplyLoan</a></br>
<a href="">ChangePassword</a></br>
<a href="">MiniStatement</a></br>
<a href="">Logout</a></br>
</body>
</html>