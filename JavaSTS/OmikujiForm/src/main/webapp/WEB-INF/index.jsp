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
	<h1>Send an Omikuji</h1>
	<form action="/submit" method="post">
	
	
	<h2>Pick any number from 5 to 25</h2>
	<input type="number" id="number" name="number" min="5" max="25">
		
	<h2>Enter name of a city</h2>
	<input type="text" name="city" id="city"/>
	
	<h2>Enter name of a real person</h2>
	<input type="text" name="person" id="person"/>
	
	<h2>Enter professional endeavor or hobby:</h2>
	<input type="text" name="hobby" id="hobby"/>
	
	<h2>Enter any type of living thing</h2>
	<input type="text" name="living_thing" id="living_thing"/>
	
	<h2>Say something nice to someone</h2>
	<input type="text" name="compliment" id="compliment"/>
	
	<h2>___________________________________________________</h2>
	<button class="btn btn-success">Send</button>
	
	
	
	


	
	</form>
	
	
</body>
</html>