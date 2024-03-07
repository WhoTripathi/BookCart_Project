package com.bookcart.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookcart.DAO.BooksDAOImpl;
import com.bookcart.database.JDBConnection;
import com.bookcart.entity.Books;

@WebServlet("/updateBook")
public class UpdateBook extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			String bookId = req.getParameter("bookId");
			String bookName = req.getParameter("bookName");
			String bookAuthor = req.getParameter("bookAuthor");
			String bookType = req.getParameter("bookType");
			String bookStatus = req.getParameter("bookStatus");
			String bookPrice = req.getParameter("bookPrice");
			
			

			Books book = new Books();
			book.setBookAuthor(bookAuthor);
			book.setBookId(bookId);
			book.setBookName(bookName);
			book.setBookPrice(bookPrice);
			book.setBookStatus(bookStatus);
			book.setBookType(bookType);
			book.setDatetime_at(LocalDateTime.now());

			BooksDAOImpl booksDAOImpl = new BooksDAOImpl(JDBConnection.getConnect());
			boolean result=booksDAOImpl.updateBookById(book);
			
			HttpSession session=req.getSession();


			if (result) {
				session.setAttribute("success", "Book Updated Successfully...!");
				resp.sendRedirect("Admin/activeBooks.jsp");

			} else {
				session.setAttribute("failed", "Somthing went wrong...!");
				resp.sendRedirect("Admin/Home.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
