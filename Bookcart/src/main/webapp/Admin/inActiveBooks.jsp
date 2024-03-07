<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bookcart.entity.Books"%>
<%@page import="java.util.List"%>
<%@page import="com.bookcart.database.JDBConnection"%>
<%@page import="com.bookcart.DAO.BooksDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="../allCss/bootstrapStyle.jsp"%>
<link href="myStyle.css" rel="stylesheet">
<title>Active books</title>
</head>
<body>
	<div style="margin-top: 10px;"></div>
	<%@include file="nevbar.jsp"%>
	<div class="container">
		<div style="background-color: white; margin-top: 20px; height: 35px;">
			<center>
				<h3 style="padding: 2px 0px 2px 0px">Inactive Books</h3>
			</center>
		</div>

		<c:if test="${not empty success}">
			<div style="background-color: white;height:25px;">
				<center>
					<i class="text-success"><h5 style="padding: 2px 0px 2px 0px">${success}</h5></i>
				</center>
			</div>
			<c:remove var="success" scope="session" />
		</c:if>
		<c:if test="${not empty failed}">
			<div style="background-color: white; height: 25px;">
				<center>
					<i class="text-danger"><h5 style="padding: 2px 0px 2px 0px">${failed}</h5></i>
				</center>
			</div>

			<c:remove var="failed" scope="session" />
		</c:if>
		<table class="table" style="background-color: white; margin-top: 1px">
			<thead class="thead-success">
				<tr>
					<th scope="col">Book ID</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author Name</th>
					<th scope="col">Book Price</th>
					<th scope="col">Book Image</th>
					<th scope="col">Book Type</th>
					<th scope="col">Status</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				BooksDAOImpl books = new BooksDAOImpl(JDBConnection.getConnect());

				ArrayList<Books> list = books.fetchBook();
				for (Books book : list) 
				
				if(book.getBookStatus().equals("Inactive")){
				%>
				<tr>
					<th scope="row"><%=book.getBookId()%></th>
					<td><%=book.getBookName()%></td>
					<td><%=book.getBookAuthor()%></td>
					<td><%=book.getBookPrice()%></td>
					<td><img alt="image"
						src="../BookImages/<%=book.getBookImage()%>"
						style="height: 50px; width: 40px;"></td>
					<td><%=book.getBookType()%></td>
					<td><%=book.getBookStatus()%></td>
					<td><a href="../deleteBook?bookId=<%=book.getBookId()%>">
							<button type="button" class="btn btn-danger" name="deleteID"
								value="<%=book.getBookId()%>">Delete</button>
					</a> <a href="editBook.jsp?bookId=<%=book.getBookId()%>"><button
								type="button" class="btn btn-warning" style="marging-left: 3px">Edit
								Book</button></td>
					</a>
				</tr>
				<%
				}
				%>
			</tbody>
			</tbody>
		</table>
	</div>
</body>
</html>