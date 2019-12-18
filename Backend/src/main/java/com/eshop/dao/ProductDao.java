package com.eshop.dao;

import java.util.List;

import com.eshop.model.Product;
import com.eshop.model.User;

public interface ProductDao {

	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public Product validateUser(int Id, String name);
	public Product getProductById(int uid);
	public List<Product> getAllProduct( );
}
