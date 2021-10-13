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
		<h1>All Books</h1>
		<table class="table table-striped">
		    <thead>
		        <tr>
		            <th>ID</th>
		            <th>Title</th>
		            <th>Language</th>
		            <th>Number of Pages</th>
		        </tr>
		    </thead>
		    <tbody>
		         <c:forEach var="bk" items="${books}">
		         	<tr>
		         		<td><c:out value="${bk.id}"/> </td>
		         		<td><a href="/books/${bk.id}"><c:out value="${bk.title}"/></a></td>
		         		<td><c:out value="${bk.language}"/></td>
		         		<td><c:out value="${bk.numberOfPages}"/></td>
		         		
		         	</tr>
		         </c:forEach>
		    </tbody>
		</table>
	</div>