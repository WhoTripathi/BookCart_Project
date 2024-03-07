package com.bookcart.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bookcart.DAO.BooksDAOImpl;
import com.bookcart.DAO.UserDAOImp;
import com.bookcart.database.JDBConnection;
import com.bookcart.entity.Books;

@WebServlet("/saveBook")
@MultipartConfig
public class SaveBook extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String bookName = req.getParameter("bookName");
		String bookAuthor = req.getParameter("bookAuthor");
		String bookPrice = req.getParameter("bookPrice");
		String bookType = req.getParameter("bookType");
		String bookStatus = req.getParameter("bookStatus");
		Part part = req.getPart("bookImage");

		int bookId;
		bookId = new Random().nextInt(1000);
		String id = String.valueOf(bookId);
		String fileName=part.getSubmittedFileName();
		String bookImageName = id + fileName;

		try {
			Books book = new Books();

			book.setBookId(id);
			book.setBookImage(bookImageName);
			book.setBookName(bookName);
			book.setBookAuthor(bookAuthor);
			book.setBookPrice(bookPrice);
			book.setBookStatus(bookStatus);
			book.setBookType(bookType);
			book.setDatetime_at(LocalDateTime.now());

			BooksDAOImpl booksDAOImpl=new BooksDAOImpl(JDBConnection.getConnect());

			HttpSession session = req.getSession();

			boolean f = booksDAOImpl.saveBook(book);
			if (f) {
	
				String path = getServletContext().getRealPath("") + "BookImages";
				System.out.println(path);
				File file = new File(path);
				part.write(path + File.separator + bookImageName);
				// System.out.println("Record Inserted SuccessFully...!");
				session.setAttribute("success", "Book Added SuccessFully...!");
				resp.sendRedirect("Admin/addBook.jsp");
			} else {
				// System.out.println("Somthing went wrond....!");
				session.setAttribute("failed", "Somthing went wrond....!");
				resp.sendRedirect("Admin/addBook.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
