package com.bookcart.entity;

import java.time.LocalDateTime;

public class PlacedOrder {
	private String orderId;
	private String bookId;
	private String bookName;
	private String bookImage;
	private String bookPrice;
	private String bookType;
	private String dileveryAddress;
	private String pincode;
	private String dileveryStatus;
	private LocalDateTime order_at;
	private String userId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

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

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public String getDileveryAddress() {
		return dileveryAddress;
	}

	public void setDileveryAddress(String dileveryAddress) {
		this.dileveryAddress = dileveryAddress;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDileveryStatus() {
		return dileveryStatus;
	}

	public void setDileveryStatus(String dileveryStatus) {
		this.dileveryStatus = dileveryStatus;
	}

	public LocalDateTime getOrder_at() {
		return order_at;
	}

	public void setOrder_at(LocalDateTime order_at) {
		this.order_at = order_at;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
