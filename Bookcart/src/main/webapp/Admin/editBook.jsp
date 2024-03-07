<%@page import="com.bookcart.entity.Books"%>
<%@page import="com.bookcart.database.JDBConnection"%>
<%@page import="com.bookcart.DAO.BooksDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
<%@include file="../allCss/bootstrapStyle.jsp"%>
<link href="myStyle.css" rel="stylesheet">
</head>
<body>
	<div style="margin-top: 10px;"></div>
	<%@include file="nevbar.jsp"%>

	<div class="containder">
		<%
		String bookId = request.getParameter("bookId");

		BooksDAOImpl booksDAOImpl = new BooksDAOImpl(JDBConnection.getConnect());

		Books book = booksDAOImpl.getBook(bookId);
		%>
		<div class="row">
			<div class="col-md-4 offset-4"
				style="background-color: white; margin-top: 20px">
				<center>
					<h2 style="padding-top: 20px">Edit Book</h2>
				</center>
				<form action="../updateBook" method="post">
					<div class="form-group">
					<input type="hidden" value="<%=bookId%>" name="bookId">
						<label for="exampleInputEmail1">Book Name</label> <input
							type="Text" class="form-control" id="exampleInputEmail1"
							placeholder="Please enter book name" name="bookName"
							value="<%=book.getBookName()%>" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Author</label> <input type="phone"
							class="form-control" id="exampleInputEmail1"
							placeholder="Please enter Author" name="bookAuthor"
							value="<%=book.getBookAuthor()%>" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Price</label> <input type="text"
							class="form-control" id="exampleInputEmail1"
							placeholder="Enter Price" name="bookPrice"
							value="<%=book.getBookPrice()%>" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Status</label> <Select
							class="form-control" name="bookType" id="exampleInputEmail1"
							required>
							<%
							if (book.getBookType().equals("Old Book")) {
							%><option value="Old Book">Old Book</option>
							<%
							} else {
							%>
							<option value="New Book">New Book</option>
							<%
							}
							%>
						</Select>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Status</label> <Select
							class="form-control" name="bookStatus" id="exampleInputEmail1"
							value="<%=book.getBookStatus()%>" required>
							<%
							if (book.getBookStatus().equals("Active")) {
							%><option value="Active">Active</option>
							<%
							} else {
							%>
							<option value="Inactive">Inactive</option>
							<%
							}
							%>
						</Select>
					</div>

					<br>
					<center>
						<div class="form-group">
							<button type="submit" class="btn btn-warning">Update</button>
						</div>
					</center>
				</form>

			</div>
		</div>

	</div>

</body>
</html>