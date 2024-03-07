package com.bookcart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bookcart.entity.Books;
import com.bookcart.entity.UserCart;

public class CartDAOImpl implements CartDAO{

	private Connection connection;
	public CartDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}
	public boolean addToCart(UserCart userCart) {
		boolean f=false;
		try {
			
			
			String fetchBook="Select * from Books where bookId=?";
			PreparedStatement pStatement=connection.prepareStatement(fetchBook);
			pStatement.setString(1, userCart.getBookId());
			ResultSet rs=pStatement.executeQuery();
			Books book=new Books();
			while(rs.next())
			{
			   	book.setBookName(rs.getString(2));
				book.setBookAuthor(rs.getString(3));
				book.setBookPrice(rs.getString(6));
				book.setBookImage(rs.getString(7));
				book.setBookType(rs.getString(4));
			}
			userCart.setBookName(book.getBookName());
			userCart.setBookAuthor(book.getBookAuthor());
			userCart.setBookPrice(book.getBookPrice());
			userCart.setBookType(book.getBookType());
			userCart.setBookImage(book.getBookImage());
			
			
			String qyery="insert into usercart(cartId,bookId,userId,bookName,bookPrice,bookType,bookImage,bookAuthor) values(?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(qyery);
			preparedStatement.setString(1, userCart.getCartId());
			preparedStatement.setString(2,userCart.getBookId());
			preparedStatement.setString(3, userCart.getUserId());
			preparedStatement.setString(4, userCart.getBookName());
			preparedStatement.setString(5,userCart.getBookPrice());
			preparedStatement.setString(6, userCart.getBookType());
			preparedStatement.setString(7, userCart.getBookImage());
			preparedStatement.setString(8,userCart.getBookAuthor());
			int i=preparedStatement.executeUpdate();
			if(i==1)
			{
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}
	public ArrayList<UserCart> fatchUserCart(String userId) {
		ArrayList<UserCart> list=new ArrayList<UserCart>();
		try {
			String query="Select * from usercart where userid=?";
			PreparedStatement preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				UserCart userCart=new UserCart();
				userCart.setBookId(rs.getString(2));
				userCart.setCartId(rs.getString(1));
				userCart.setUserId(rs.getString(3));
				userCart.setBookImage(rs.getString(8));
				userCart.setBookName(rs.getString(5));
				userCart.setBookPrice(rs.getString(4));
				userCart.setBookAuthor(rs.getString(6));
				userCart.setBookType(rs.getString(7));
				list.add(userCart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public boolean deleteFromCart(String cartId) {
		boolean f=false;
		try {
			String deleteQyery="Delete from usercart where cartId=?";
			PreparedStatement pStatement=connection.prepareStatement(deleteQyery);
			pStatement.setString(1, cartId);
			int i=pStatement.executeUpdate();
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
