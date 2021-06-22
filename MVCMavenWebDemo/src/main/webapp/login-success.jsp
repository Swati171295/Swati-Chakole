<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.web.MVCMavenWebDemo.model.UserModel"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>
</head>
<body>
	<h1>You are successfully logged in!</h1>  
	<%
  	UserModel bean=(UserModel)request.getAttribute("bean");  
  			out.print("Welcome, "+bean.getName());
  	%>  
	
</body>
</html>