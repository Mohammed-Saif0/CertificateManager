<!doctype html>
<html xmlns:th="http://www.w3.org/1999/xhtml" xmlns:sf="http://www.w3.org/1999/xhtml" lang="en">
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page isELIgnored="false" %>
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

<title>SIGN UP</title>
</head>
<body>


	<h1 class="text-center text-primary">Signup Page</h1>
	<form style="margin : 3% 30%" method='POST' action="submitOrganizationSignup">
		<div class="form-group">
			<label for="username">organizationName</label> <input name="organizationName"
				type="text" class="form-control" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="Enter email"> <small
				id="username" class="form-text text-muted">Please Enter unique organizationName.</small>
		</div>
		<div class="form-group">
			<label for="firstName">address</label> <input type="text"
				class="form-control" id="firstName" name="address"
				placeholder="address">
		</div>

		<div class="form-group">
			<label for="phoneNumber">phoneNumber</label> <input type="text"
				class="form-control" id="phoneNumber" name="phoneNumber"
				placeholder="phoneNumber">
		</div>

		
		<div class="form-group">
			<label for="email">email</label> <input type="email"
				class="form-control" id="email" name="email"
				placeholder="email">
		</div>
		
		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				class="form-control" id="password" name="password"
				placeholder="password">
		</div>
		
		<c:if test="${param.error != null }">
			<div class="alert alert-danger" style="margin:5% 15%; padding-bottom:0;	"><p class="text-center">${param.error }</p></div>
		</c:if>
		<button type="submit" class="btn btn-outline-primary mt-3">Submit</button>
		
	</form>
	
	<!-- Optional JavaScript; choose one of the two! -->

	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	<!-- Option 2: Separate Popper and Bootstrap JS -->
	<!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
</body>
</html>
