<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Functions --> 
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div class="container">
		<div class="header d-flex justify-content-between">
			<h1>Dojos and Ninja</h1>
			<a href="/dashboard">Dashboard</a>
		</div>
		
		<div class="main">
			<h2>Add a Dojo</h2>
			<form:form action="/dojos/create" method="post" modelAttribute="dojo">
			
				<div class="form=group">
				
					<form:select path="ninja">
						<c:forEach items="${ allNinjas }" var="ninja">
							<form:option value="${ ninja.id }" label="${ ninja.name }"/>
						</c:forEach>
					</form:select>
					
				</div>
				
				<div class="form=group">
				
					<form:label path="name">Name</form:label>
					<form:input type="text" path="name"/>
					<form:errors path="name" class="text-danger"/>
					
				</div>
				
				<button class="btn btn-success">Add a Dojo</button>
			</form:form>
			
		</div>
	</div>
	
</body>
</html>