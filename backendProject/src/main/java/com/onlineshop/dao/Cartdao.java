package com.onlineshop.dao;

import com.onlineshop.models.Cart;

public interface Cartdao {
	boolean addCart(Cart cart);
	Cart getCartByCustomer(String customerId);
	boolean deleteCart(int cartId);

}
