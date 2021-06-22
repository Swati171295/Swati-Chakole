<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >

        <body>

                        <br>

            <div class="row">
                
                <div class="container">
                    <h3 class="text-center">User Management Application</h3>
                    <hr>
                    <div class="container text-center">
                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New User</a>
  	                </div> <br> 
  	                <div class="container text-center">  	
  	                    <a href="<%=request.getContextPath()%>/list" class="btn btn-success">List of Users</a>
 				                   	
                    </div>
                    <br>
                    
                </div>
            </div>
        </body>

        </html>





<!--

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="ISO-8859-1">
		<title>List Students</title>
		<link rel="stylesheet" type="text/css" href="/webjars/bootstrap/css/bootstrap.min.css" />
		<script type="text/javascript" src="/webjars/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="/webjars/bootstrap/js/bootstrap.min.js"></script>

        <title>Maven Web Page</title>
    </head>
    <body><center>
    	<div class="container">
    		<h2><a href="/MVCMavenWebDemo/new">Add New User</a></h2>
    		<h2><a href="/MVCMavenWebDemo/list">User List</a></h2>
		</div>
    	<div class="container text-center">
		<div>
			<h1>List of Users</h1>
		</div>

		<div>
			<table class="table table-striped table-bordered">
				<thead class="thead-dark">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr th:each="user: ${listUser}">
						<td th:text="${user.id}">ID</td>
						<td th:text="${user.name}">Name</td>
						<td><a th:href="@{/MVCMavenWebDemo/edit/{id}(id=${user.id})}" class="btn btn-primary">Edit</a></td>
					
						<td><a th:href="@{/MVCMavenWebDemo/delete/{id}(id=${user.id})}" class="btn btn-primary">Delete</a></td>		
					</tr>
				</tbody>
			</table>
		</div>
		</div>
        				
    
    </center>
    
    
 
		
    </body> 
 
</html> -->
