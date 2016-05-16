<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div id="root">
	<c:url value="/" var="root" />
</div>
<head>

<link rel="stylesheet" media="screen"
	href=" <c:url value='/resources/css/business-frontpage.css'/>">




</head>
<body>
	

	<!-- Page Content -->
	<!-- Page Content -->
	<%@include file="dynamicheader.jsp"%>
	
		<div class="row" style="margin-top: 200px;">
	<div class="col-xs-4"></div>
	<div class="col-xs-4">
	<p> ${success} </p>
	<p> ${error} </p>
	</div>
	<div class="col-xs-4"></div>
	</div>
	
	

	
	

		<%@include file="footer.jsp"%>
	
</body>
</html>