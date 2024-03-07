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
<title>Order Hisroty</title>
<%@include file="allCss/bootstrapStyle.jsp"%>
</head>
<body>
	<div class="page-top"></div>
	<%@include file="allCss/nevbar.jsp"%>
	<div class="container">
		<div style="background-color: white; margin-top: 20px; height: 35px;">
			<center>
				<h3 style="padding: 2px 0px 2px 0px">Order Hisroty</h3>
			</center>
		</div>
		<table class="table"
			style="background-color: #c6ffb3; margin-top: 1px">
			<thead class="thead-success">
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">Book Name</th>
					<th scope="col">Image</th>
					<th scope="col">Price</th>
					<th scope="col">Book Type</th>
					<th scope="col">Pin Code</th>
					<th scope="col">Delivery Address</th>
					<th scope="col">Delivery Status</th>
				</tr>
			</thead>

			<%
			PlacedOrderDAOImpl placedOrder = new PlacedOrderDAOImpl(JDBConnection.getConnect());
			ArrayList<PlacedOrder> list = placedOrder.allOrders(String.valueOf(user.getId()));
			for (PlacedOrder order : list) {
			%>
			<tbody>
				<tr>
					<th scope="row"><%=order.getOrderId()%></th>
					<td><%=order.getBookName()%></td>
					<td><img src="BookImages/<%=order.getBookImage()%>"
						height="70px" width="50px"></td>
					<td><%=order.getBookPrice()%>/-</td>
					<td><%=order.getBookType()%></td>
					<td><%=order.getDileveryAddress()%></td>
					<td><%=order.getPincode()%></td>
					<td>
						<%
						if (order.getDileveryStatus().equals("Pending")) {
						%>
						<h6 style="color: red"><%=order.getDileveryStatus()%></h6> <%
 } else {
 %>
						<h6 style="color: #3333ff"><%=order.getDileveryStatus()%></h6> <%
 }
 %>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>