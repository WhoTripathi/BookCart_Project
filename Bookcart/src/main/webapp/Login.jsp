<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<%@include file="allCss/bootstrapStyle.jsp"%>
</head>
<body>
	<div class="page-top"></div>
	<%@include file="allCss/nevbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-3"></div>
			<div class="col-6 p-3"
				style="background-color: white; margin: 20px 0px 20px 0px; border-radius: 10px;">
				<center>
					<h2 class="green">Login</h2>
					<c:if test="${not empty invalidPass}">
					<h5><i><p class="text-danger">${invalidPass}</p></i></h5>
					<c:remove var="invalidPass" scope="session"/>
					</c:if>
				</center>
				<form action="login" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							type="email" class="form-control" id="exampleInputEmail1"
							placeholder="Enter email" name="email">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Password</label> <input
							type="password" class="form-control" id="exampleInputEmail1"
							placeholder="Password" name="password">
					</div>
					<br>
					<center>
						<div class="form-group">
							<button type="submit" class="btn btn-success">Login</button>
						</div>
					</center>
				</form>
			</div>
		</div>
	</div>
</body>
</html>