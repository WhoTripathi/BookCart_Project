package com.bookcart.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookcart.DAO.PlacedOrderDAOImpl;
import com.bookcart.database.JDBConnection;

@WebServlet("/deliver")
public class MarkDelivered extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String orderId = req.getParameter("orderId");
		PlacedOrderDAOImpl placedOrderDAOImpl = new PlacedOrderDAOImpl(JDBConnection.getConnect());
		if (placedOrderDAOImpl.markAsDelivered(orderId)) {
			resp.sendRedirect("Admin/orderHistory.jsp");
		}
	}

}
