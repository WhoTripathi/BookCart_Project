<%@page import="com.bookcart.entity.RegisteredUser"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bookcart.DAO.UserDAOImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../allCss/bootstrapStyle.jsp"%>
<link href="myStyle.css" rel="stylesheet">
<title>Registered User</title>
</head>
<body>
	<div style="margin-top: 10px;"></div>
	<%@include file="nevbar.jsp"%>
	<div class="container">
		<div style="background-color: white; margin-top: 20px; height: 35px;">
			<center>
				<h3 style="padding: 2px 0px 2px 0px">Registered Users</h3>
			</center>
		</div>
		<table class="table" style="background-color: white; margin-top: 1px">
			<thead class="thead-success">
				<tr>
					<th scope="col">User ID</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Phone</th>
					<th scope="col">Address</th>
					<th scope="col">Pin Code</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
			
			<%UserDAOImp userDAOImp=new UserDAOImp(); 
			ArrayList<RegisteredUser>list=userDAOImp.fetchAllUser();
			for(RegisteredUser rs:list)
			{
			
			%>
				<tr>
					<th scope="row"><%=rs.getId() %></th>
					<td><%=rs.getName() %></td>
					<td><%=rs.getUserEmail() %></td>
					<td><%=rs.getPhoneNumber() %></td>
					<td><%=rs.getAddress() %></td>
					<td><%=rs.getPinCode() %></td>
					<td><a href="../deleteUser?id=<%=rs.getId() %>"><button type="button" class="btn btn-danger">Delete</button></a></td>
				</tr>
				<%} %>
			</tbody>
		</table>
	</div>
</body>
</html>