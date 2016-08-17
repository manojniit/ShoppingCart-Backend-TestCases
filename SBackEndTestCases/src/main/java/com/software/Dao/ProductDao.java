package com.software.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.software.modal.Product;



@Repository
public interface ProductDao {

	public boolean save(Product product);
	public boolean update(Product product);
	public boolean delete(Product product);
	public Product get(String id);
	public List<Product>  list();
}
