package com.bookcart.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookcart.DAO.CartDAOImpl;
import com.bookcart.DAO.PlacedOrderDAOImpl;
import com.bookcart.DAO.UserDAOImp;
import com.bookcart.database.JDBConnection;
import com.bookcart.entity.PlacedOrder;
import com.bookcart.entity.RegisteredUser;
import com.bookcart.entity.UserCart;

@WebServlet("/placeOrder")
public class PlaceOrder extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		
		CartDAOImpl cart = new CartDAOImpl(JDBConnection.getConnect());
		ArrayList<UserCart> list = cart.fatchUserCart(userId);

		for (UserCart fetchCart : list) {
			PlacedOrder placedOrder = new PlacedOrder();
			placedOrder.setBookId(fetchCart.getBookId());
			placedOrder.setBookImage(fetchCart.getBookImage());
			placedOrder.setBookName(fetchCart.getBookName());
			placedOrder.setBookPrice(fetchCart.getBookPrice());
			placedOrder.setBookType(fetchCart.getBookType());
			placedOrder.setDileveryStatus("Pending");
			placedOrder.setOrder_at(LocalDateTime.now());
			UserDAOImp userDAOImp = new UserDAOImp();
			RegisteredUser rsUser = userDAOImp.fetchUserById(Integer.parseInt(userId));
			placedOrder.setPincode(rsUser.getPinCode());
			placedOrder.setDileveryAddress(rsUser.getAddress());
			placedOrder.setUserId(userId);
			int id = new Random().nextInt(100000);
			String orderId = String.valueOf(id);
			placedOrder.setOrderId(orderId);
			PlacedOrderDAOImpl placingOrder = new PlacedOrderDAOImpl(JDBConnection.getConnect());
			String cartId=fetchCart.getCartId();
			if(placingOrder.placeOrder(placedOrder))
			{
				CartDAOImpl cartDAOImpl=new CartDAOImpl(JDBConnection.getConnect());
				cartDAOImpl.deleteFromCart(cartId);
			}
		}
		resp.sendRedirect("userCart.jsp");
		
	}

}
