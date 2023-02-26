<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center" class="container">
		<div class="jumbotron">
			<div class="alert alert-danger">
				<strong>*preview form</strong>
			</div>
			<span><b>Resume Id:</b></span><span>${user.id}</span><br />
			<span><b>Designation:</b></span><span>${user.desgn}</span><br />
			<span><b>Salary:</b></span><span>${user.salary}</span><br /> 
		</div>
	</div>

</body>
</html>