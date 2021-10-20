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
			<h1>Hello <c:out value="${ loggedInUser.firstName }" />, Welcome to Course </h1>
			<a href="/logout">logout</a>
		</div>
		<div class="main">
			<h2>All Course</h2>
			<table class="table border border-black">
			
			
				<thead>
					<tr>
						<th>Name</th>
						<th>Weekday</th>
						<th>Instructor</th>
						<th>Price</th>
						<th>Actions</th>
					</tr>
				</thead>
				
				
				<tbody>
					<c:forEach items="${ allCourse }" var="course">
						<tr>
						
							<!-- ________________Name____________________ -->
							<td> 
								<a href="/course/${ course.id }">
									<c:out  value="${ course.name }" />
								</a>
							 </td>
														
							<!-- ________________Day____________________ -->
							<td><c:out value="${ course.day }" /></td>
							
							<!-- ________________Name____________________ -->
							<td> 							
									<c:out  value="${ course.creator.firstName }" />
							 </td>
									
							<!-- ________________Price____________________ -->
							<td>$<c:out value="${ course.price }" /></td>
							
							
							<td class="d-flex ">
							
								<!-- ________________Display Route____________________ -->
								<a class="btn btn-link" href="/course/${ course.id }">View</a>
																
								<!-- __________Edit Route For Logged in User__________ -->
								<c:if test="${ loggedInUser.id == course.creator.id }">
									<a class="btn btn-link" href="/course/${ course.id }/edit">Edit</a>
									
									<!-- __________Delete btn for Logged in User__________ -->
									<form action="/course/${ course.id }/delete" method="post">
										<input type="hidden" name="_method" value="delete"/>
										<button class="btn btn-link">Delete</button>
									</form>
								</c:if>
							</td>
							
						</tr>
					</c:forEach>
				</tbody>
				
				
			</table>
			<a href="/course/new" class="btn btn-link">Create a Course!</a>
		</div>
	</div>
</body>
</html>