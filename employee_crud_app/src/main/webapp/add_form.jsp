<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.form-group label {
	font-family: sans-serif;
	font-weight: 600;
	text-transform: uppercase;
}
body {
	background-color: fuchsia;
}

</style>
</head>
<body>
	<br>
	<br>
	<div class="container">
		<div class="jumbotron">

			<spring:url value="/save" var="saveURL" />
			<h2
				style="font-family: sans-serif; font-weight: 600; text-align: center; color: blue">
				New Employee</h2>
			<strong style="text-align:center; color: green;">${msg}</strong><br>
			<form:form modelAttribute="add" method="post" action="${saveURL}"
				cssClass="form">
				<div class="form-group">
					<label>Resume Id: </label>
					<form:input path="id" cssClass="form-control" id="id" />
				</div>
				<div class="form-group">
					<label>Designation: </label>
					<form:input path="desgn" cssClass="form-control" id="desgn" />
				</div>
				<div class="form-group">
					<label>Salary</label>
					<form:input path="salary" cssClass="form-control" id="add" />
				</div>
				<div class="nav navbar-nav navbar-right">
					<button type="submit" class="btn btn-success">Add</button>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>