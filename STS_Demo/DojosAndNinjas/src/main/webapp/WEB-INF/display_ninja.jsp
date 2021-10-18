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
		<div class="header d-flex justify-content-between  align-items-centers">
			<h1>The Dojo</h1>
			<a href="/dashboard">Dashboard</a>
		</div>
		
		<div class="main">
			<h2 class="">Here is information of the Ninja <c:out value="${ninja.name}"></c:out></h2>
			<ul class="">
			 
				<li class="">Age:<c:out value="${ ninja.age }"></c:out></li> 
				
			</ul>
			
			<h2>This Ninja's Dojos:</h2>
			
			<ul>
				<c:forEach items="${ninja.dojos }" var="dojo">
					<li><c:out value ="${dojo.name }"/></li>
				</c:forEach>
			</ul>
			<h3>The Number of Dojos this Ninja is apart of: <c:out value="${ninja.dojos.size() }"></c:out></h3>
			
		</div>
		<a href="/dogs/${ninja.id }/edit"> Edit </a>|
		<a href="/dogs/${ninja.id }/delete">Delete</a>|
	</div>
</body>
</html>