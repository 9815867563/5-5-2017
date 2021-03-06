package com.niit.dao;

import java.util.List;

import com.niit.domain.Category;



public interface CategoryDao {
	public boolean insert(Category category);

	public boolean save(Category category);

	public boolean update(Category category);

	public boolean delete(String id);

	public Category getCategoryById(String id);

	public Category getCategoryByName(String name);

	public List<Category> list();
}
