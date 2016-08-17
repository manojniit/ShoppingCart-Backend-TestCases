package com.software.employee;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.software.Dao.ProductDao;
import com.software.modal.Product;

public class ProductTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.software");
		context.refresh();
		ProductDao productDao=(ProductDao) context.getBean("productDao");
		Product product=(Product) context.getBean("product");
		product.setId("p100092");
		product.setName("iphone");
		product.setPrice(50000);
		product.setDescription("this is iphone description");
		if(productDao.save(product)==true)
		{
			System.out.println("Product saved successfully");
		}
		else
		{
			System.out.println("Error while saving product");
		}
		System.out.println("No.of products"+productDao.list().size());
	}

}
