<!doctype html>
<html xmlns:th="http://www.w3.org/1999/xhtml"
	xmlns:sf="http://www.w3.org/1999/xhtml" lang="en">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page isELIgnored="false"%>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</head>
<body>






	<nav class="navbar bg-dark border-bottom border-bottom-dark"
		data-bs-theme="dark">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Organization's Page</a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<c:choose>
					<c:when test="${username!=null }">
						<li class="dropdown"><a class="dropdown-toggle"
							data-toggle="dropdown" href="#">${username }<span
								class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a
									href="${pageContext.servletContext.contextPath}/logout">LOGOUT</a></li>

							</ul></li>
					</c:when>
					<c:when test="${username==null }">
						<li><a
							href="${pageContext.servletContext.contextPath }/signup"><span
								class="glyphicon glyphicon-user"></span> Sign Up</a></li>
						<li><a
							href="${pageContext.servletContext.contextPath }/login"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</c:when>
				</c:choose>

			</ul>
		</div>
	</nav>


	<c:if test="${username!=null }">
		<div class="container">


			<form method='POST' action='certificateUpload' enctype="multipart/form-data"
				class="mx-auto" style="width: 600px">
				<div class="input-group mb-3">
					<label class="input-group-text" for="picture">Upload</label> <input
						type="file" name="certificate" class="form-control" id="picture">
				</div>
				
				<div class="mb-3">
					<label for="certificateName" class="form-label">Certificate
						Name</label> <input type="text" name="certificateName"
						class="form-control" id="certificateName"
						placeholder="certificateName">
				</div>
				<div class="mb-3">
					<label for="username" class="form-label">username </label> <input
						type="text" name="username" class="form-control"
						id="certificateName" placeholder="username">
				</div>
				
				<button class="btn btn-success" type="submit">Upload</button>
			</form>


			
				

			
			</form>
		</div>
	</c:if>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</body>
</html>