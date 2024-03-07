package com.bookcart.DAO;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bookcart.database.ConnectDB;
import com.bookcart.entity.Books;

public class BooksDAOImpl implements BooksDAO {

	private Connection connection;

	public BooksDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	public boolean saveBook(Books book) {
		boolean f = false;
		try {
			String queryString = "Insert into Books(bookID,bookName,bookAuthor,bookPrice,bookStatus,bookType,bookImage,datetime_at) values(?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, book.getBookId());
			preparedStatement.setString(2, book.getBookName());
			preparedStatement.setString(3, book.getBookAuthor());
			preparedStatement.setString(4, book.getBookPrice());
			preparedStatement.setString(5, book.getBookStatus());
			preparedStatement.setString(6, book.getBookType());
			preparedStatement.setString(7, book.getBookImage());
			preparedStatement.setString(8, book.getDatetime_at().toString());
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public ArrayList<Books> fetchBook() {
		ArrayList<Books> list = new ArrayList<Books>();

		try {
			String fetchQuery = "Select * from Books order by datetime_at DESC";
			PreparedStatement preparedStatement = connection.prepareStatement(fetchQuery);
			ResultSet rSet = preparedStatement.executeQuery();
			while (rSet.next()) {
				Books book = new Books();
				book.setBookId(rSet.getString(1));
				book.setBookName(rSet.getString(2));
				book.setBookAuthor(rSet.getString(3));
				book.setBookType(rSet.getString(4));
				book.setBookStatus(rSet.getString(5));
				book.setBookPrice(rSet.getString(6));
				book.setBookImage(rSet.getString(7));
				

				list.add(book);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean deleteBook(String bookID) {
		boolean f = false;

		try {

			String deleteQuery = "delete from Books where bookID=?";
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setString(1, bookID);
			int i = preparedStatement.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public Books getBook(String bookId) {
		Books book =null;
		try {
			String getBookQuery = "Select * from Books where bookId=? order by datetime_at DESC";
			PreparedStatement preparedStatement = connection.prepareStatement(getBookQuery);
			preparedStatement.setString(1, bookId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				book=new Books();
				book.setBookId(resultSet.getString(1));
				book.setBookName(resultSet.getString(2));
				book.setBookAuthor(resultSet.getString(3));
				book.setBookType(resultSet.getString(4));
				book.setBookStatus(resultSet.getString(5));
				book.setBookPrice(resultSet.getString(6));
				book.setBookImage(resultSet.getString(7));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	public boolean updateBookById(Books book) {
		boolean f=false;
		try {
			String updateBook="Update Books set bookName=?, bookAuthor=?,bookType=?,bookStatus=?,bookPrice=?,datetime_at=? where bookID=?";
			PreparedStatement ps=connection.prepareStatement(updateBook);
			ps.setString(1, book.getBookName());
			ps.setString(2, book.getBookAuthor());
			ps.setString(3, book.getBookType());
			ps.setString(4, book.getBookStatus());
			ps.setString(5, book.getBookPrice());
			ps.setString(6, book.getDatetime_at().toString());
			ps.setString(7, book.getBookId());
		    int i=ps.executeUpdate();
		    if(i==1)
		    {
		    	f=true;
		    }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}

}
