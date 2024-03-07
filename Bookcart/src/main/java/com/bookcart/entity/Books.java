package com.bookcart.entity;
import java.time.LocalDateTime;

public class Books {

	private String bookId;
	private String bookName;
	private String bookAuthor;
	private String bookType;
	private String bookStatus;
	private String bookPrice;
	private String bookImage;
	private LocalDateTime datetime_at;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}
	public String getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	public Books(String bookId, String bookName, String bookAuthor, String bookType, String bookStatus,
			String bookPrice, String bookImage) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookType = bookType;
		this.bookStatus = bookStatus;
		this.bookPrice = bookPrice;
		this.bookImage = bookImage;
	}
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LocalDateTime getDatetime_at() {
		return datetime_at;
	}
	public void setDatetime_at(LocalDateTime datetime_at) {
		this.datetime_at = datetime_at;
	}
	
	
}
