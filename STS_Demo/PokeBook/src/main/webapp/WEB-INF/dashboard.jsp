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
			<h1>PokeBook</h1>
			<a href="/item/new">Add a Item</a>
		</div>
		<div>
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Vendor</th>
						<th>Amount</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ allItems }" var="item">
						<tr>
							<td><c:out value="${ item.name }"/></td>
							<td><c:out value="${ item.vendor }"/></td>
							<td><c:out value="${ item.amount }"/></td>
							<td>
								<a href="/dogs/${item.id }">View</a>|
								<a href="/dogs/${item.id }/edit"> Edit </a>|
								<a href="/dogs/${item.id }/delete">Delete</a>|
							</td>
						

						</tr>
					</c:forEach>
				</tbody>
				
			</table>
		</div>
		
	</div>


</body>
</html>