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
    <title>Course</title>
    <!-- for Bootstrap CSS -->
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div class="container">
	
	
		<div class="header d-flex justify-content-between align-items-center">
			<h1>Hello <c:out value="${ loggedInUser.firstName }" />, Welcome to Course!</h1>
			<a href="/dashboard">Dashboard</a>
			<a href="/logout">logout</a>
		</div>
		
		
		<div class="main">
			<h2>Here is the information for the course: <c:out value="${ course.name }" /></h2>
			<p>Day: <c:out value="${ course.day }" /></p>
			<p>Price: <c:out value="${ course.price }" /></p>
			<p>Description: <c:out value="${ course.description }" /></p>
			
			<p>Created By: <c:out value="${ course.creator.firstName }" /></p>
		</div>
		<div class="d-flex">
			<!-- __________Edit Route For Logged in User__________ -->
			<c:if test="${ loggedInUser.id == course.creator.id }">
				<a class="btn btn-success" href="/course/${ course.id }/edit">Edit</a>
				
				<!-- __________Delete btn for Logged in User__________ -->
				<form action="/course/${ course.id }/delete" method="post">
					<input type="hidden" name="_method" value="delete"/>
					<button class="btn btn-warning">Delete</button>
				</form>
			</c:if>
		</div>
	</div>
</body>
</html>