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
<div class="container">
		<div class="header d-flex justify-content-between align-items-center">
			<h1>Create a Pokemon!</h1>
			<a href="/dashboard">Dashboard</a>
			<a href="/logout">logout</a>
		</div>
		<div class="main">
			<form:form action="/pokemon/create" method="post" modelAttribute="newPokemon">
				<div class="form-group">
					<form:label path="name">Name:</form:label>
					<form:input type="text" path="name" />
					<form:errors class="text-danger" path="name" />
				</div>
				<div class="form-group">
					<form:label path="type">Type:</form:label>
					<form:input type="text" path="type" />
					<form:errors class="text-danger" path="type" />
				</div>
				<div class="form-group">
					<form:label path="level">Level:</form:label>
					<form:input type="number" path="level" min="1" max="120" value="1"/>
					<form:errors class="text-danger" path="level" />
				</div>
				<button class="btn btn-warning">Create!</button>
			</form:form>
		</div>
	</div>
</body>
</html>