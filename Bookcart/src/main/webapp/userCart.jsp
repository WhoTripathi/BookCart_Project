<%@page import="java.util.ArrayList"%>
<%@page import="com.bookcart.entity.UserCart"%>
<%@page import="com.bookcart.database.JDBConnection"%>
<%@page import="com.bookcart.DAO.CartDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="allCss/bootstrapStyle.jsp"%>
<title>My Cart</title>
</head>
<body>
	<div class="page-top"></div>
	<%@include file="allCss/nevbar.jsp"%>
	<div class="container">
		<div style="background-color: white; margin-top: 20px; height: 35px;">
			<center>
				<h3 style="padding: 2px 0px 2px 0px">Cart Items</h3>
			</center>
		</div>
		<%
		CartDAOImpl cart = new CartDAOImpl(JDBConnection.getConnect());
		ArrayList<UserCart> list = cart.fatchUserCart(String.valueOf(user.getId()));
		%>
		<table class="table"
			style="background-color: #ffcc80; margin-top: 1px">
			<thead class="thead-success">
				<tr>
					<th scope="col">Book Name</th>
					<th scope="col">Image</th>
					<th scope="col">Author</th>
					<th scope="col">Book Type</th>
					<th scope="col">Price</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (UserCart userCart : list) {
				%>
				<tr>
					<th scope="row"><%=userCart.getBookName()%></th>
					<td><img src="BookImages/<%=userCart.getBookImage()%>"
						/ height="50px" wigth="40px"></td>
					<td><%=userCart.getBookAuthor()%></td>
					<td><%=userCart.getBookType()%></td>
					<td><%=userCart.getBookPrice()%>/-</td>
					<td><a href="deleteItem?cartId=<%=userCart.getCartId()%>"><button
								class="btn btn-danger">Remove item</button></a></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>


		<table class="table" style="background-color: white; margin-top: 20px">
			<thead class="thead-success">
				<tr>
					<th scope="col"></th>
					<th scope="col">Total Amount</th>
					<th></th>
					

				</tr>
			</thead>
			<tbody>
				<tr>
					<td></td>
					<td>
					<% 
					int count=0;
					for (UserCart userCart : list) {
						count=count+Integer.parseInt(userCart.getBookPrice());
					}
					%><h4><%=count %>/-</h4>
					
					
					</td>
					<td><a href="placeOrder?userId=<%=user.getId()%>"><button class="btn btn-success"><i class="fa-solid fa-cart-shopping"></i> Place Order</button></a></td>
					
				</tr>
			</tbody>
		</table>

	</div>
</body>
</html>