package com.software.employee;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.software.Dao.CategoryDao;
import com.software.modal.Category;

public class TestCaseCategory {

	@Autowired
	CategoryDao categoryDao;
	@Autowired
	Category category;
	AnnotationConfigApplicationContext context;
	@Before
	public void init()
	{
		context  = new AnnotationConfigApplicationContext();
		context.scan("com.software");
		context.refresh();
		CategoryDao categoryDao =(CategoryDao) context.getBean("categoryDao");
		Category category=(Category) context.getBean("category");
	}
	@Test
	public void categoryListTestCase()
	{
		List<Category> list = categoryDao.list();
		int rowCount = list.size();
		assertEquals("Category List Test Case ", rowCount,5);
	}
	@Test
	public void categoryaddTestCase()
	{
		category.setId("c100097");
		category.setName("MANOJKUMAR");
		category.setDescription("this is description about c100097");
	}
	@Test
	public void categoryGetTestCase()
	{
		category = categoryDao.get("c100097");
		assertEquals(category.getName(), "MANOJKUMAR");
	}
	}



