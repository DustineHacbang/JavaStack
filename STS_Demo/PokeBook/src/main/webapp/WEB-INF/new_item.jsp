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
			<h1>The Kennel</h1>
			<a href="/dashboard">Dashboard</a>
		</div>
		
		<div class="main">
			<h2>Add an Expense</h2>
			<form:form action="/item/create" method="post" modelAttribute="item">
				<div class="form=group">
					<form:label path="name">Expense Name</form:label>
					<form:input type="text" path="name"/>
					<form:errors path="name"/>
				</div>
				<div class="form=group">
					<form:label path="amount">Amount</form:label>
					<form:input type="number" path="amount" min="0.01" value="0.01"/>
					<form:errors path="amount"/>
				</div>
				<div class="form=group">
					<form:label path="vendor">Vendor</form:label>
					<form:input type="text" path="vendor"/>
					<form:errors path="vendor"/>
				</div>
				
				<button class="btn btn-success">Add an Expense</button>
			</form:form>
			
		</div>
	</div>
	
</body>
</html>