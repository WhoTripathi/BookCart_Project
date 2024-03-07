package com.bookcart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookcart.DAO.CartDAOImpl;
import com.bookcart.DAO.UserDAOImp;
import com.bookcart.database.JDBConnection;
import com.bookcart.entity.UserCart;

@WebServlet("/deleteItem")
public class DeleteFromCart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cartId=req.getParameter("cartId");
		CartDAOImpl cartDAOImpl=new CartDAOImpl(JDBConnection.getConnect());
	    if(cartDAOImpl.deleteFromCart(cartId))
	    {
	    	resp.sendRedirect("userCart.jsp");
	    }
	}
	
}
