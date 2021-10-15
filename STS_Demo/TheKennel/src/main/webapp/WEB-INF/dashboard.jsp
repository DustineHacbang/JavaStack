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
		<div class="header d-flex justify-content-between align-items-centers ">
			<h1>The Kennel</h1>
			<a href="/dog/new">Add a Dog</a>
		</div>
		<div>
			<h2>Here are the dogs in the kennel:</h2>
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Age</th>
						<th>Hair Color</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ allDogs }" var="dog">
						<tr>
							<td><c:out value="${ dog.name }"/></td>
							<td><c:out value="${ dog.age }"/></td>
							<td><c:out value="${ dog.hairColor }"/></td>
							<td>
								<a href="/dogs/${dog.id }">View</a>|
								<a href="/dogs/${dog.id }/edit"> Edit </a>|
								<a href="/dogs/${dog.id }/delete">Delete</a>|
							</td>
						

						</tr>
					</c:forEach>
				</tbody>
				
			</table>
		</div>
		
	</div>


</body>
</html>