<%@page import="com.bookcart.entity.PlacedOrder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bookcart.database.JDBConnection"%>
<%@page import="com.bookcart.DAO.PlacedOrderDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../allCss/bootstrapStyle.jsp"%>
<link href="myStyle.css" rel="stylesheet">
<title>Delivered Order</title>
</head>
<body>
	<div style="margin-top: 10px;"></div>
	<%@include file="nevbar.jsp"%>
	<div class="container">
		<div style="background-color: white; margin-top: 20px; height: 35px;">
			<center>
				<h3 style="padding: 2px 0px 2px 0px">Delivered Order</h3>
			</center>
		</div>
		<table class="table" style="background-color: white; margin-top: 1px">
			<thead class="thead-success">
				<tr>
					<th scope="col">Order ID</th>
					<th scope="col">User Id</th>
					<th scope="col">Book ID</th>
					<th scope="col">Book Name</th>
					<th scope="col">Book Image</th>
					<th scope="col">Book Price</th>
					<th scope="col">Book Type</th>
					<th scope="col">Delivery Address</th>
					<th scope="col">PinCode</th>
					<th scope="col">Delivery Status</th>
				</tr>
			</thead>
			<tbody>
				<%
				PlacedOrderDAOImpl placedOrderDAOImpl = new PlacedOrderDAOImpl(JDBConnection.getConnect());
				ArrayList<PlacedOrder> list = placedOrderDAOImpl.fetchAllOrder();
				for (PlacedOrder order : list) {
					if (order.getDileveryStatus().equals("Delivered")) {
				%>
				<tr>
					<th scope="row"><%=order.getOrderId()%></th>
					<th scope="row"><%=order.getUserId()%></th>
					<th scope="row"><%=order.getBookId()%></th>
					<td><%=order.getBookName()%></td>
					<td><img src="../BookImages/<%=order.getBookImage()%>"
						height="70px" width="50px"></td>
					<td><%=order.getBookPrice()%>/-</td>
					<td><%=order.getBookType()%></td>
					<td><%=order.getDileveryAddress()%></td>
					<td><%=order.getPincode()%></td>
					<td><h6 style="color:green"><%=order.getDileveryStatus()%></h6></td>

				</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>