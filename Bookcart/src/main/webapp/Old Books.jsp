<%@page import="java.util.ArrayList"%>
<%@page import="com.bookcart.database.JDBConnection"%>
<%@page import="com.bookcart.DAO.BooksDAOImpl"%>
<%@page import="com.bookcart.entity.Books"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Books</title>
<%@include file="allCss/bootstrapStyle.jsp"%>
</head>
<body>
	<div>
		<div class="page-top"></div>
		<%@include file="allCss/nevbar.jsp"%>

		<div class="container">
			<br>
			<center>
				<h3>Old Books</h3>
			</center>
			<div class="row" style="margin-top: 20px">


				<%
				BooksDAOImpl booksDAOImpl = new BooksDAOImpl(JDBConnection.getConnect());

				ArrayList<Books> list = booksDAOImpl.fetchBook();

				for (int i = 0; i < list.size(); i++) {
					Books book = list.get(i);
					if (book.getBookType().equals("Old Book")) {
				%>
				<div class="col-3" style="margin-top: 20px">
					<center>
						<div style="background-color: white;">
							<div>
								<div>
									<img src="BookImages/<%=book.getBookImage()%>"
										style="padding: 10px; filter: drop-shadow(10px 5px 10px green);"
										height="200px" width="150px">
								</div>
								<hr>
								<span class="card-title"><h5><%=book.getBookName()%></h5>
									<h6>
										(<%=book.getBookType()%>)
									</h6></span>
							</div>
							<hr>
							<div class="card-content" style="padding: 10px">
								<h5>
									Author :
									<%=book.getBookAuthor()%></h5>
							</div>
							<button class="btn btn-danger">
								<i class="fa-solid fa-indian-rupee-sign"> <%=book.getBookPrice()%></i>
							</button>
							<hr>
							<div class="card-action pb-3">
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
										<button class="btn btn-warning">Add to Cart</button><%} %>
								</a> <a href="bookDetails.jsp?bookId=<%=book.getBookId()%>"><button
										class="btn btn-success" style="margin-left: 15px">View
										Detail</button></a>
							</div>
						</div>
					</center>
				</div>

				<%
				}
				}
				%>


			</div>
		</div>
	</div>
</body>
</html>