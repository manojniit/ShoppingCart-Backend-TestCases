package com.software.employee;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.sql.Delete;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.software.Dao.ProductDao;
import com.software.modal.Product;

public class TestCaseProduct {
	@Autowired
	ProductDao productDao;
	@Autowired
	Product product;
	AnnotationConfigApplicationContext context;
	@Before
	public void init()
	{
		context  = new AnnotationConfigApplicationContext();
		context.scan("com.software");
		context.refresh();
		ProductDao productDao =(ProductDao) context.getBean("productDao");
		Product product=(Product) context.getBean("product");
	}
	@Test
	public void deleteProductTestCase()
	{
		product.setId("CP-001");
		boolean flag = productDao.delete(product);
		
		assertEquals("deleteProductTestCase ",flag,false);
	}
	
	
	@Test
	public void addProductTestCase()
	{
		product.setId("MOB-001");
		product.setName("iphone");
		product.setDescription("this is iphone");
		product.setPrice(50000);
		assertEquals("addProductTestCase",productDao.save(product),true);
	}@Test
	public void listProductTestCase()
	{
		
		assertEquals("listProductTestCase", productDao.list().size(),2);
	}
	@Test
	public void updateProductTestCase()
	{
		product.setId("MOB-002");
		product.setPrice(60000);
		assertEquals("update Product Test Case ",productDao.update(product),true);
	}
	
	@Test
	public void getProductTestCase()
	{
		assertEquals("getProductTestCase",productDao.get("MOB-001"),null);
	}

}

