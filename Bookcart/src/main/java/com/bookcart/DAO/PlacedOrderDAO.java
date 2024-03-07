package com.bookcart.DAO;

import java.util.ArrayList;

import com.bookcart.entity.PlacedOrder;

public interface PlacedOrderDAO {
	
	public boolean placeOrder(PlacedOrder placedOrder);
	public ArrayList<PlacedOrder> allOrders(String userId);
	public ArrayList<PlacedOrder> fetchAllOrder();
	public boolean markAsDelivered(String orderId);

}
