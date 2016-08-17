package com.software.employee;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.software.Dao.SupplierDao;
import com.software.modal.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.software");
		context.refresh();
		SupplierDao supplierDao=(SupplierDao) context.getBean("supplierDao");
		Supplier supplier=(Supplier) context.getBean("supplier");
		supplier.setId("s100092");
		supplier.setName("ganesh");
		supplier.setaddress("hyd");
		if(supplierDao.save(supplier)==true)
		{
			System.out.println("Supplier saved successfully");
		}
		else
		{
			System.out.println("Error while saving supplier");
		}
		System.out.println("No.of suppliers"+supplierDao.list().size());
	}

}
