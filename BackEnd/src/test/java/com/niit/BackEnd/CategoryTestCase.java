package com.niit.BackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDao;

import com.niit.domain.Category;

public class CategoryTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	static CategoryDao categoryDao;

	@Autowired
	static Category category;

	// The above objects need to initialize
	/**
	 * This method is going execute before calling any one of test case and will
	 * execute only once
	 */
	@Before
	public void initialize() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();

		// get the CategoryDAO from context
		// get the Category from context

		categoryDao = (CategoryDao) context.getBean("cdao");
		System.out.println(categoryDao);

		category = context.getBean(Category.class);
		System.out.println(category);

	}
	
	//insert database

	@Test
	public void createCategoryTestCase() {
		category.setId("7");
		category.setName("clothig");
		category.setDescription("clothes");

		// Category.setMobile(9815);
		boolean flag = categoryDao.insert(category);
		System.out.println("saved");
		assertEquals("CategoryTestCase", true, flag);
		
	}
	
	//updating database
	
	/*@Test
	public void updateCategoryTestCase(){
		category=categoryDao.getCategoryById("3433");
		category.setName("Appliances");
		
		//Boolean flag=categoryDao.update(category);
		System.out.println("update");
		assertEquals("CategoryTestCase", true, categoryDao.update(category));
	}*/
	
	//delete database
	
	@Test
	public void deleteCategoryTestCase(){
		//category=categoryDao.getCategoryById("1");
		//boolean flag=categoryDao.delete(category);
		System.out.println("delete");
		assertEquals("CategoryTestCase",true,categoryDao.delete("1"));
	}
	
 /*  //reading database
	
	@Test
	public void listCategoryTestCase(){
	
		assertEquals("CategoryTestCase",2,categoryDao.list().size());
	}
	*/
	

}
