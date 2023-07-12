<!doctype html>
<html xmlns:th="http://www.w3.org/1999/xhtml"
	xmlns:sf="http://www.w3.org/1999/xhtml" lang="en">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page isELIgnored="false"%>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>LOGIN PAGE </title>
</head>
<body>



	<form style="margin: 3% 30%" method='POST' action='submitOrganizationLogin'>
		<h1 class="text-center text-primary">Login Page</h1>
		<div class="form-group">
			<label for="username">User Name</label> <input
				type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" name="userName" placeholder="UserName"> <small
				id="username" class="form-text text-muted">We'll never
				share your email with anyone else.</small>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Password</label> <input
				type="password" class="form-control" id="exampleInputPassword1"
				placeholder="Password" name="password">
		</div>
	
		<button type="submit" class="btn btn-outline-primary my-4">Submit</button>
	</form>
</body>
</html>