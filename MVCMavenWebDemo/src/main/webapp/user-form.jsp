<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>

        <body>
       		<div class="container text-center">
				<h2>User Form</h2>
			</div>
			<div>
				
		 		<c:if test="${user == null}">
                    <form action="insert" method="post">
                  </c:if>				
	<!-- 	<form action="insert" object="${newUser}" method="post"> -->
            	<br>
            	<div class="container col-md-5">
               		<c:if test="${user != null}">
                            <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
                    </c:if> 
               		<fieldset class="form-group">
               			<label>User Name</label> <input type="text" value="<c:out value='${user.name}' />" class="form-control" name="name" required="required">
               		</fieldset>
					<button type="submit" class="btn btn-success">Save</button> 
	             </div>
           </form>
          </div>  
        </body>

       </html>
