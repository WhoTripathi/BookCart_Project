<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
a{
text-decoration: none;
}

</style>
<title>Admin Home</title>
<%@include file="../allCss/bootstrapStyle.jsp"%>
<link href="myStyle.css" rel="stylesheet">
</head>
<body>
<% if(session.getAttribute("admin")==null)
	{
	response.sendRedirect("../index.jsp");
	}else{%>

	<div style="margin-top: 10px;"></div>
	<%@include file="nevbar.jsp"%>

	<div class="container">
		<div class="row p-2" style="margin-top: 50px">
			<div class="col-md-3 offset-1">
				<a href="addBook.jsp">
					<div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-plus fa-3x"></i>
							<h3>Add Book</h3>
							<p>-------------------</p>
						</div>
					</div>
				</a>
			</div>
			<div class="col-md-3">
				<a href="activeBooks.jsp"><div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-book-bookmark fa-3x"></i>
							<h3>Active Books</h3>
							<p>-------------------</p>
						</div>

					</div></a>
			</div>
			<div class="col-md-3">
				<a href="orderHistory.jsp"><div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-cart-shopping fa-3x"></i>
							<h3>Order History</h3>
							<p>-------------------</p>
						</div>

					</div></a>
			</div>
		</div>
		<div class="row p-2" style="margin-top: 50px">

			<div class="col-md-3 offset-1">
				<a href="registeredUsers.jsp"><div class="card">
						<div class="card-body text-center">

							<i class="fa-solid fa-user fa-3x"></i>
							<h3>Registered User</h3>
							<p>-------------------</p>
						</div>

					</div></a>
			</div>
			<div class="col-md-3">
				<a href="inActiveBooks.jsp"><div class="card">
						<div class="card-body text-center">

							<i class="fa-solid fa-circle-xmark fa-3x"></i>
							<h3>In Active Books</h3>
							<p>-------------------</p>

						</div>

					</div></a>
			</div>
			<div class="col-md-3">
				<a href="deliveredOrder.jsp"><div class="card">
						<div class="card-body text-center">
							<i class="fa-solid fa-truck fa-3x"></i>
							<h3>Delivered</h3>
							<p>-------------------</p>
						</div>

					</div></a>
			</div>
		</div>
	</div>
	<%} %>
</body>
</html>