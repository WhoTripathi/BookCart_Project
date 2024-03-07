

<%@page import="com.bookcart.entity.RegisteredUser"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="index.jsp"><h1 class="green">BookCart</h1></a>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">

		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="index.jsp"><i
					class="fa-solid fa-house"></i>Home</a></li>
			<li class="nav-item active"><a class="nav-link"
				href="Recent Books.jsp"><i class="fa-solid fa-book-open"></i>
					Recent Books </a></li>
			<li class="nav-item active"><a class="nav-link"
				href="NewBooks.jsp"><i class="fa-solid fa-book"></i> New Books</a></li>

			<li class="nav-item active"><a class="nav-link disabled"
				href="Old Books.jsp"><i class="fa-solid fa-address-book"></i>
					Old Books</a></li>
		</ul>



		<div>
			<div class="row">
				<%
				RegisteredUser user = (RegisteredUser) session.getAttribute("user");
				if (user == null) {
				%>
				<div class="col-5">
					<a href="Register.jsp"><button type="button"
							class="btn btn-primary">
							<i class="fa-solid fa-user"></i> Register
						</button></a>

				</div>
				<div class="col-3">

					<a href="Login.jsp"><button type="button"
							class="btn btn-success">
							<i class="fa-solid fa-right-to-bracket"></i> Login
						</button></a>
				</div>
				<%
				} else {
				%>
				<a href="userCart.jsp"><button type="button"
						class="btn btn-warning" style="margin-right: 20px">
						<i class="fa-solid fa-cart-shopping"></i> View Cart
					</button></a> <a href="orderHistory.jsp"><button type="button"
						class="btn btn-success" style="margin-right: 20px">
						<i class="fa-solid fa-truck-fast"></i> Order History
					</button></a> <a href="profile.jsp"><button type="button"
						class="btn btn-primary" style="margin-right: 30px">
						<i class="fa-solid fa-user"></i>
						<%=user.getName()%>
					</button></a> <a href="logout"><button type="button" class="btn btn-danger"
						style="margin-right: 30px">
						<i class="fa-solid fa-right-from-bracket"></i> Logout
					</button></a>

				<%
				}
				%>
			</div>
		</div>


	</div>
</nav>