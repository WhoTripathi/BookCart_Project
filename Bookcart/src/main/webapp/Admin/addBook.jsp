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
<title>Add New Book</title>
</head>
<body>
	<div style="margin-top: 10px;"></div>
	<%@include file="nevbar.jsp"%>
	<div class="containder">
		<div class="row">
			<div class="col-md-4 offset-4"
				style="background-color: white; margin-top: 20px">
				<center>
					<h2 style="padding-top: 20px">Add Book</h2>
					<c:if test="${not empty success}">
					<h5><i><p class="text-success">${success}</p></i></h5>
					<c:remove var="success" scope="session"/>
					</c:if>
					<c:if test="${not empty failed}">
					<h5><i><p class="text-danger">${failed}</p></i></h5>
					<c:remove var="failed" scope="session"/>
					</c:if>
				</center>
				<form action="../saveBook" method="post"
					enctype="multipart/form-data">
					<div class="form-group">
						<label for="exampleInputEmail1">Book Name</label> <input
							type="Text" class="form-control" id="exampleInputEmail1"
							placeholder="Please enter book name" name="bookName" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Author</label> <input type="phone"
							class="form-control" id="exampleInputEmail1"
							placeholder="Please enter Author" name="bookAuthor" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Price</label> <input type="text"
							class="form-control" id="exampleInputEmail1"
							placeholder="Enter Price" name="bookPrice" required>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Status</label> <Select
							class="form-control" name="bookType" id="exampleInputEmail1"
							required>
							<option value="Old Book">Old</option>
							<option value="New Book">New</option>
						</Select>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Status</label> <Select
							class="form-control" name="bookStatus" id="exampleInputEmail1"
							required>
							<option value="Active">Active</option>
							<option value="Inactive">Inactive</option>
						</Select>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Book Image</label> <input
							type="file" class="form-control" name="bookImage" required>
					</div>
					<br>
					<center>
						<div class="form-group">
							<button type="submit" class="btn btn-success">Submit</button>
						</div>
					</center>
				</form>

			</div>
		</div>

	</div>
</body>
</html>