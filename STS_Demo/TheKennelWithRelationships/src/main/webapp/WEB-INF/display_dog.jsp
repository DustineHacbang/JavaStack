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
			<h1>The Kennel</h1>
			<a href="/dashboard">Dashboard</a>
		</div>
		
		<div class="main">
			<h2 class="">Here is information of Dog <c:out value="${dog.name}"></c:out></h2>
			<ul class="">
			 
				<li class="">Age:<c:out value="${ dog.age }"></c:out></li> 
				<li class="">Hair Color: <c:out value="${dog.hairColor}"/> </li>
				
			</ul>
			
			<h2>This Dog's Collars:</h2>
			
			<ul>
				<c:forEach items="${dog.collars }" var="collar">
					<li><c:out value ="${collar.color }"/></li>
				</c:forEach>
			</ul>
			<h3>The Number of Collars this dog owns is: <c:out value="${dog.collars.size() }"></c:out></h3>
			
		</div>
		<a href="/dogs/${dog.id }/edit"> Edit </a>|
		<a href="/dogs/${dog.id }/delete">Delete</a>|
	</div>
</body>
</html>