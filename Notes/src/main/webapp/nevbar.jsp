<%@page import="org.apache.catalina.tribes.ChannelSender"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark green">
	<%String value=(String)session.getAttribute("Useremail"); %>
		<a class="navbar-brand"
			href=<%if(value==null){%>"index.jsp"<%}else{ %>"allNotes.jsp"<%} %>>ToDo
			Notes</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<%if(value!=null){ %>
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link myfont"
					href="OpenNotes">All Notes <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link myfont"
					href="addNotes.jsp">Add Note <span class="sr-only">(current)</span>
				</a></li>
				<%if(value.equals("bhupendrat@google.com")){ %>
				<li class="nav-item active"><a class="nav-link myfont"
					href="Registration.jsp">Register User <span class="sr-only">(current)</span>
				</a></li>
				<%} %>
				
				<form action="DestroySession" method="GET">
				<input type="submit" value="LogOut" style="height:25px;float:left; border:1px solid; margin-left:800px; border-radius:5px"/>
				
				</form>
			</ul>
			<%} %>
		</div>
	</nav>
</body>
</html>