<!doctype html>
<%@page import="Entity.Notes"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="helperClases.FactoryProvider"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link href="css/style.css" rel="stylesheet" />
<title>All Notes</title>

</head>
<body>

	<div class="container-fluid">

		<%@include file="nevbar.jsp" %>
	
		<%
		Session s=FactoryProvider.getFactory().openSession();
		Query q =s.createQuery("from Notes where userEmail=:x");
		String email=(String)session.getAttribute("Useremail");
		q.setParameter("x",email);
		List<Notes> list=q.list();
		for(Notes note:list)
		{%>
			<div class="card" style="width: 100vmin; margin-top:20px; margin-right:25px; float:left">
			  <img class="center" src="images/noteicon.png" style="height:50px; width:50px; margin-left:20px; margin-top:15px" alt="Card image cap">
			  <div class="card-body">
			    <h5 class="card-title"><%out.print(note.getNoteTitle()); %></h5>
			    <p class="card-text"><%out.print(note.getNoteInstruction()); %></p>
			    <a href="DeletNote?note_id=<%= note.getNoteId()%>" class="btn btn-danger">Delete</a>
			    <a href="updateNote.jsp?note_id=<%=note.getNoteId()%>" class="btn btn-primary">Update</a>
			  </div>
			</div>

			<%
		}
		
		
		%>

	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>