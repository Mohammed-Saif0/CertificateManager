<!doctype html>
<html xmlns:th="http://www.w3.org/1999/xhtml"
	xmlns:sf="http://www.w3.org/1999/xhtml" lang="en">
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page isELIgnored="false"%>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Certificate Handler</a>
			</div>
			<ul class="nav navbar-nav">
				<li ><a href="${pageContext.servletContext.contextPath }/home">Home</a></li>
			</ul>
			<ul class="nav navbar-nav">
				<li ><a href="${pageContext.servletContext.contextPath}/getcertificates">View Certificate</a></li>
			</ul>
			
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


</body>
</html>