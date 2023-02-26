<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Manager</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
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
			<h2 class="text-primary text-center">Employee Manager</h2>
			<spring:url value="/addEmp" var="AddURL" />
			<a class="btn btn-primary" href="${AddURL}" role="button">Add New
				Employee</a>
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="row">RESUME_ID</th>
						<th scope="row">DESIGNATION</th>
						<th scope="row">SALARY</th>
						<th scope="row" rowspan="2" align="center">UPDATE</th>
						<th scope="row" rowspan="2" align="center">DELETE</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
						<tr>
							<td>${list.id}</td>
							<td>${list.desgn}</td>
							<td>${list.salary}</td>
							<td><spring:url value="/UpdateEmp/${list.id}"
									var="UpdateURL" /> <a class="btn btn-success"
								href="${UpdateURL}" role="button">Update</a></td>
							<td><spring:url value="/delete/${list.id}" var="deleteURL" />
								<a class="btn btn-danger" href="${deleteURL}" role="button">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>
