package com.bookcart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bookcart.database.JDBConnection;
import com.bookcart.entity.PlacedOrder;

public class PlacedOrderDAOImpl implements PlacedOrderDAO {
	private Connection connection;

	public PlacedOrderDAOImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	public boolean placeOrder(PlacedOrder placedOrder) {
		boolean f = false;
		try {
			String insertQuery = "insert into orderHistory(OrderID,BookName,Images,Price,BookType,Address,Pincode,DeliveryStatus,Ordered_at,userId,bookId) values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, placedOrder.getOrderId());
			preparedStatement.setString(2, placedOrder.getBookName());
			preparedStatement.setString(3, placedOrder.getBookImage());
			preparedStatement.setString(4, placedOrder.getBookPrice());
			preparedStatement.setString(5, placedOrder.getBookType());
			preparedStatement.setString(6, placedOrder.getDileveryAddress());
			preparedStatement.setString(7, placedOrder.getPincode());
			preparedStatement.setString(8, placedOrder.getDileveryStatus());
			preparedStatement.setString(10, placedOrder.getUserId());
			preparedStatement.setString(11, placedOrder.getBookId());
			preparedStatement.setString(9, placedOrder.getOrder_at().toString());

			int i = preparedStatement.executeUpdate();
			if (i == 1) {

				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public ArrayList<PlacedOrder> allOrders(String userId) {
		ArrayList<PlacedOrder> orders = new ArrayList<PlacedOrder>();
		try {
			String fetchOrders = "Select * from orderhistory where userId=? order by ordered_at";
			PreparedStatement preparedStatement = connection.prepareStatement(fetchOrders);
			preparedStatement.setString(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				PlacedOrder order = new PlacedOrder();
				order.setOrderId(rs.getString(1));
				order.setBookName(rs.getString(2));
				order.setBookImage(rs.getString(3));
				order.setBookPrice(rs.getString(4));

				order.setBookType(rs.getString(5));

				order.setDileveryAddress(rs.getString(6));

				order.setDileveryStatus(rs.getString(7));

				order.setUserId(rs.getString(9));

				order.setBookId(rs.getString(10));
				order.setPincode(rs.getString(11));

				orders.add(order);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orders;
	}

	public ArrayList<PlacedOrder> fetchAllOrder() {
		ArrayList<PlacedOrder> orders = new ArrayList<PlacedOrder>();
		try {
			String fetchOrders = "Select * from orderhistory order by ordered_at";
			PreparedStatement preparedStatement = connection.prepareStatement(fetchOrders);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				PlacedOrder order = new PlacedOrder();
				order.setOrderId(rs.getString(1));
				order.setBookName(rs.getString(2));
				order.setBookImage(rs.getString(3));
				order.setBookPrice(rs.getString(4));

				order.setBookType(rs.getString(5));

				order.setDileveryAddress(rs.getString(6));

				order.setDileveryStatus(rs.getString(7));

				order.setUserId(rs.getString(9));

				order.setBookId(rs.getString(10));
				order.setPincode(rs.getString(11));

				orders.add(order);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orders;
	}

	public boolean markAsDelivered(String orderId) {
		boolean f = false;
		try {
			String query = "Update orderhistory set DeliveryStatus='Delivered' where orderId=?";
			PreparedStatement pStatement = connection.prepareStatement(query);
			pStatement.setString(1, orderId);
			int i = pStatement.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

}
