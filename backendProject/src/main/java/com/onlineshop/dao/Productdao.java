package com.onlineshop.dao;

import java.util.List;

import com.onlineshop.models.Product;

public interface Productdao {
	
	public boolean addProduct(Product ProductObj);
	public boolean deleteProduct(Product ProductObj);
	public boolean updateProduct(Product Product );
	public Product getProductById(int productId);
	public List<Product> getAllProducts();
	public List<Product> getAllProductsByCategory(int categoryId);
	
}
