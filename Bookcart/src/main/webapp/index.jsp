<%@page import="com.bookcart.entity.Books"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bookcart.database.JDBConnection"%>
<%@page import="com.bookcart.DAO.BooksDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="allCss/bootstrapStyle.jsp"%>
<title>Home</title>
</head>
<body>
	<div>
		<div class="page-top"></div>
		<%@include file="allCss/nevbar.jsp"%>
		<%@include file="allCss/imageSection.jsp"%>

		<div class="container">
			<br>
			<center>
				<h3>Recent Books</h3>
			</center>
			<div class="row" style="margin-top: 20px">
				<%
				BooksDAOImpl booksDAOImpl = new BooksDAOImpl(JDBConnection.getConnect());
				ArrayList<Books> list = booksDAOImpl.fetchBook();
				int count = 0;
				for (Books book : list) {
					if (count == 4) {
						break;
					}
				%>
				<div class="col-3">
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
								} else {
								%>
								<a href="Login.jsp">
									<button class="btn btn-warning">Add to Cart</button> <%
 }
 %>
								</a> <a href="bookDetails.jsp?bookId=<%=book.getBookId()%>"><button
										class="btn btn-success" style="margin-left: 15px">View
										Detail</button></a>
							</div>
						</div>
					</center>

				</div>
				<%
				count = count + 1;
				}
				%>

				</center>
			</div>
			<p>
				<br>
			<center>
				<a href="Recent Books.jsp"><button type="button"
						class="btn btn-light center">See All Books...</button></a>
			</center>
			<hr>
			<br>
			<center>
				<h3>New Books</h3>
			</center>
			<div class="row" style="margin-top: 20px">
				<%
				count = 0;
				for (Books book : list) {
					if (book.getBookType().equals("New Book") && count != 4) {
				%>
				<div class="col-3">
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
								} else {
								%>
								<a href="Login.jsp">
									<button class="btn btn-warning">Add to Cart</button> <%
 }
 %> <a href="bookDetails.jsp?bookId=<%=book.getBookId()%>"><button
											class="btn btn-success" style="margin-left: 15px">View
											Detail</button></a>
							</div>
						</div>
					</center>

				</div>
				<%
				count = count + 1;
				}
				}
				%>

				</center>
			</div>

			<p>
				<br>
			<center>
				<a href="NewBooks.jsp"><button type="button"
						class="btn btn-light center">More...</button></a>
			</center>
			<hr>
			<br>
			<center>
				<h3>Old Books</h3>
			</center>
			<div class="row" style="margin-top: 20px">
				<%
				count = 0;
				for (Books book : list) {
					if (book.getBookType().equals("Old Book") && count != 4) {
				%>
				<div class="col-3">
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
								} else {
								%>
								<a href="Login.jsp">
									<button class="btn btn-warning">Add to Cart</button> <%
 }
 %> <a href="bookDetails.jsp?bookId=<%=book.getBookId()%>"><button
											class="btn btn-success" style="margin-left: 15px">View
											Detail</button></a>
							</div>
						</div>
					</center>
				</div>
				<%
				count = count + 1;
				}
				}
				%>

			</div>
			<p>
				<br>
			<center>
				<a href="Old Books.jsp"><button type="button"
						class="btn btn-light center">More...</button></a>
			</center>
			<hr>
			<br>

		</div>
	</div>
</body>
</html>