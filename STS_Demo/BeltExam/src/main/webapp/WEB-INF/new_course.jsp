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
<div class="container">


		<div class="header d-flex justify-content-between align-items-center">
			<h1>Create a Course!</h1>
			<a href="/dashboard">Dashboard</a>
			<a href="/logout">logout</a>
		</div>
		
		<div class="main">
			<form:form action="/course/create" method="post" modelAttribute="newCourse">
				
				<!-- ________________Name____________________ -->
				<div class="form-group">
					<form:label path="name">Name:</form:label>
					<form:input type="text" path="name" />
					<form:errors class="text-danger" path="name" />
				</div>
				
				<!-- ________________Day____________________ -->
				<div class="form-group">
					<form:label path="day">Weekday:</form:label>
						<form:select type="text" path="day">
						  <form:option value="Monday">Monday</form:option>
						  <form:option value="Tuesday">Tuesday</form:option>
						  <form:option value="Wednesday">Wednesday</form:option>
						  <form:option value="Thursday">Thursday</form:option>
						  <form:option value="Friday">Friday</form:option>
						 </form:select>
						
					<form:errors class="text-danger" path="day" />
				</div>
				
				<!-- ________________Price____________________ -->
				<div class="form-group">
					<form:label path="price">Price:</form:label>
					<form:input type="double" path="price" min="0.01" value="0.00" />
					<form:errors class="text-danger" path="price" />
				</div>
				
				<!-- ________________Description____________________ -->
				<div class="form-group">
					<p>                </p>
					<p>Description:</p>
					<form:label path="description"></form:label>
					<form:textarea rows="4" cols="50" type="text" path="description" />
					<form:errors class="text-danger" path="description" />
				</div>
				
				<!-- ________________Cancel Btn____________________ -->
				<a href="/dashboard" class="btn btn-warning">Cancel</a>
				
				<!-- ________________Create Btn____________________ -->
				<button class="btn btn-success">Create!</button>
			</form:form>
		</div>
	</div>
</body>
</html>