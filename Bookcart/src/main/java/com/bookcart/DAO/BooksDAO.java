package com.bookcart.DAO;

import java.util.ArrayList;

import com.bookcart.entity.Books;

public interface BooksDAO {
	
	public boolean saveBook(Books book);
	public ArrayList<Books> fetchBook();
	public boolean deleteBook(String bookID);
	public Books getBook(String bookId);
	public boolean updateBookById(Books book);
}
