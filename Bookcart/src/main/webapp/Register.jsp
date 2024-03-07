<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>

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
					<h2 class="green">Register Here</h2>
					<c:if test="${not empty success}">
					<h5><i><p class="text-success">${success}</p></i></h5>
					<c:remove var="success" scope="session"/>
					</c:if>
					
					<c:if test="${not empty failed}">
					<h5><i><p class="text-danger">${failed}</p></i></h5>
					<c:remove var="failed" scope="session"/>
					</c:if>
					
				</center>
				<form action="register" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Name</label> <input type="Text"
							class="form-control" id="exampleInputEmail1"
							placeholder="Please enter name" name="name" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Phone</label> <input type="phone"
							class="form-control" id="exampleInputEmail1"
							placeholder="Please enter Phone No" name="phone" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							type="email" class="form-control" id="exampleInputEmail1"
							placeholder="Enter email" name="email" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Password</label> <input
							type="password" class="form-control" id="exampleInputEmail1"
							placeholder="Password" name="password" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Address</label> <input
							type="test" class="form-control" id="exampleInputEmail1"
							placeholder="Please enter you address" name="address" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Pin Code</label> <input
							type="text" class="form-control" id="exampleInputEmail1"
							placeholder="Please Enter Pic Code" name="pincode" required>
					</div>
					<br>
					<center>
						<div class="form-group">
							<button type="submit" class="btn btn-success">Submit</button>
						</div>
					</center>
				</form>
			</div>
		</div>
	</div>
</body>
</html>