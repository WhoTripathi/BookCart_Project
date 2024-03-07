<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<%@include file="allCss/bootstrapStyle.jsp"%>
</head>
<body>
	<div class="page-top"></div>
	<%@include file="allCss/nevbar.jsp"%>

	<div class="container">

		<div class="row">

			<div class="col-md-2 offset-3"
				style="background-color: white; margin-top: 50px; padding-top:20px; color:#3333ff;">
				<h4>Name :</h4>
				<hr>
				<h4>Email :</h4>
				<hr>
				<h4>Phone no :</h4>
				<hr>
				<h4>Address :</h4>
				<hr>
				<h4>Pin code :</h4>
				
			</div>
			<div class="col-md-4"
				style="background-color: white; margin-top: 50px; padding-top:20px; color:#3333ff;">
				<h4><%= user.getName() %></h4>
				<hr>
				<h4><%= user.getUserEmail() %> </h4>
				<hr>
				<h4><%= user.getPhoneNumber() %> </h4>
				<hr>
				<h4><%= user.getAddress() %> </h4>
				<hr>
				<h4><%= user.getPinCode() %> </h4>
				<hr>
				
			</div>

		</div>
	</div>
</body>
</html>