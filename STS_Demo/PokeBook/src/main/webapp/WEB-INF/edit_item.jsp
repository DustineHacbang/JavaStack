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
			<h1>PokeBook</h1>
			<a href="/dashboard">Dashboard</a>
		</div>
		
		<div class="main">
			<h2>Edit An Expenses</h2>
			<form:form action="/items/${ dog.id }/update" method="post" modelAttribute="item">
			<input type="hidden" name="_method" value="put" />
				<div class="form=group">
					<form:label path="name">Expense Name</form:label>
					<form:input type="text" path="name" />
					<form:errors path="name" class="text-danger"/>
				</div>
				<div class="form=group">
					<form:label path="amount">Amount</form:label>
					<form:input type="number" path="amount" min="0.01" />
					<form:errors path="amount" class="text-danger"/>
				</div>
				<div class="form=group">
					<form:label path="vendor">Vendor</form:label>
					<form:input type="text" path="vendor" />
					<form:errors path="vendor" class="text-danger"/>
				</div>
				<button class="btn btn-success">Submit</button>
			</form:form>
			
		</div>
	</div>
	
</body>
</html>