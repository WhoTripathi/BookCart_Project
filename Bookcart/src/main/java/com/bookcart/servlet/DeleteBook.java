package com.bookcart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookcart.DAO.BooksDAOImpl;
import com.bookcart.database.JDBConnection;

@WebServlet("/deleteBook")
public class DeleteBook extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookId=req.getParameter("bookId");
		System.out.println(bookId);
		BooksDAOImpl booksDAOImpl=new BooksDAOImpl(JDBConnection.getConnect());
		if(booksDAOImpl.deleteBook(bookId))
		{
			System.out.println("Record Deleted Successfully...");
		}
		resp.sendRedirect("Admin/activeBooks.jsp");
		
	}
}
