
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



<title>Hello, world!</title>
</head>
<body>
	<jsp:include page="templates/nav.jsp"/>
	<c:forEach items="${certificate }" var="certi">
		
	



		<div class="card" style="width: 18rem;">
			<img class="card-img-top" src="<c:url value="/resources/images/${certi.org.organizationName }${username }${certi.certificateName }.jpg"></c:url>" alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title"><b>Certificate Name</b> : ${certi.certificateName }</h5>
				<p class="card-text"><b>Organization Name</b>${certi.org.organizationName }</p>
				<a href='<c:url value="/resources/images/${certi.org.organizationName }${username }${certi.certificateName }.jpg"></c:url>' class="btn btn-primary">View</a>
			</div>
		</div>

	</c:forEach>
	
	
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
	
</body>
</html>