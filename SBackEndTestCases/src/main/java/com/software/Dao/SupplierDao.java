package com.software.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.software.modal.Supplier;



@Repository
public interface SupplierDao {

	public boolean save(Supplier supplier);
	public boolean update(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier get(String id);
	public List<Supplier>  list();
}
