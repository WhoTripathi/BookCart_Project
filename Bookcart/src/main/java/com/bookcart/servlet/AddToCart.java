package com.bookcart.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookcart.DAO.CartDAOImpl;
import com.bookcart.database.JDBConnection;
import com.bookcart.entity.UserCart;

@WebServlet("/addToCart")
public class AddToCart extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookId=req.getParameter("bookId");
		String userId=req.getParameter("userId");
		int id=new Random().nextInt(10000);
		String cartId=String.valueOf(id);
		
		System.out.println("Book id:"+bookId+",UserId:"+userId);
		
		UserCart cart=new UserCart();
		cart.setBookId(bookId);
		cart.setCartId(cartId);
		cart.setUserId(userId);
		
		
		
		CartDAOImpl cartDAOImpl=new CartDAOImpl(JDBConnection.getConnect());
		if(cartDAOImpl.addToCart(cart))
		{
			HttpSession session=req.getSession();
			session.setAttribute("success", "Book Added SuccessFully...!");
			resp.sendRedirect("bookDetails.jsp?bookId="+bookId);
		}
		else {
			HttpSession session=req.getSession();
			session.setAttribute("failed", "Somthing Went Wrong...");
			resp.sendRedirect("bookDetails.jsp?bookId="+bookId);
		}
	}
	
	

}
