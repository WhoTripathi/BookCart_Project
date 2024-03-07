package com.bookcart.DAO;

import java.util.ArrayList;

import com.bookcart.entity.UserCart;

public interface CartDAO {
	public boolean addToCart(UserCart userCart);
	public ArrayList<UserCart> fatchUserCart(String userId);
	public boolean deleteFromCart(String cartId);
}
