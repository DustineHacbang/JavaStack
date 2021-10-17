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
			<h1>PokeBook</h1>
			<a href="/dashboard">Dashboard</a>
		</div>
		
		<div class="main">
			<h2 class="">Expense Details <c:out value="${item.name}"></c:out></h2>
			<ul class="">
			 
				<li class="">Amount:<c:out value="${ item.age }"></c:out></li> 
				<li class="">Vendor: <c:out value="${item.vendor}"/> </li>
				
			</ul>
		</div>
		<a href="/items/${item.id }/edit"> Edit </a>|
		<a href="/items/${item.id }/delete">Delete</a>|
	</div>
</body>
</html>