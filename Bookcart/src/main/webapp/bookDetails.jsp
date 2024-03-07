<%@page import="com.bookcart.entity.Books"%>
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
<%@include file="allCss/bootstrapStyle.jsp"%>
<title>Book Details</title>
</head>
<body>
	<div class="page-top"></div>
	<%@include file="allCss/nevbar.jsp"%>

	<div class="container">
		<%
		String bookId = request.getParameter("bookId");
		BooksDAOImpl booksDAOImpl = new BooksDAOImpl(JDBConnection.getConnect());
		Books book = booksDAOImpl.getBook(bookId);
		%>

		<div class="row">
			<div class="col-md-6"
				style="border-right: 1px solid; height: 450px; background-color: white; margin-top: 20px; border-radius: 2px 30px 30px 2px">
				<img src="BookImages/<%=book.getBookImage()%>"
					style="padding: 10px; filter: drop-shadow(10px 5px 10px green); margin: 25px 0px 0px 75px;"
					height="400px" width="350px;" />
			</div>

			<div class="col-md-6"
				style="border-left: 1px solid; height: 450px; background-color: white; margin-top: 20px; border-radius: 30px 2px 2px 30px">
				<center>
					<h3 style="margin-top: 15px">Book Details</h3>
				</center>
				<hr>
				<div class="row">
					<div class="col-md-6" style="padding-left: 50px">
						<h4 style="margin-top: 20px">Book Name :</h4>
						<hr>
						<h4>Author :</h4>
						<hr>
						<h4>Book Type :</h4>
						<hr>
						<h4>Price :</h4>
						<hr>

					</div>
					<div class="col-md-6">
						<h4 style="margin-top: 20px"><%=book.getBookName()%></h4>
						<hr>
						<h4><%=book.getBookAuthor()%></h4>
						<hr>
						<h4><%=book.getBookType()%></h4>
						<hr>
						<h4><%=book.getBookPrice()%>/-
						</h4>
						<hr>
					</div>
				</div>
				<center>
					<c:if test="${not empty success}">
						<h5>
							<i><p class="text-success">${success}</p></i>
						</h5>
						<c:remove var="success" scope="session" />
					</c:if>

					<c:if test="${not empty failed}">
						<h5>
							<i><p class="text-danger"">${failed}</p></i>
						</h5>
						<c:remove var="failed" scope="session" />
					</c:if>
				</center>
				<div class="row" style="margin-top: 30px">
					<div class="col-md-6 offset-3">

						<%
						if (user != null) {
						%><a
							href="addToCart?bookId=<%=book.getBookId()%>&&userId=<%=user.getId()%>">
							<button class="btn btn-warning">Add to Cart</button>
						</a>
						<%
						}else{
						%>
						<a href="Login.jsp">
							<button class="btn btn-warning">Add to Cart</button>
						</a><%} %> <a href="index.jsp" style="margin-left: 10px">
							<button class="btn btn-success">Continue Shopping</button>
						</a>
					</div>
				</div>
				<hr>


			</div>

		</div>

	</div>
</body>
</html>