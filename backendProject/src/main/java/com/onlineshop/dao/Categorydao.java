package com.onlineshop.dao;

import java.util.List;

import com.onlineshop.models.Category;

public interface Categorydao {

	public boolean addCategory(Category categoryObj);
	public boolean deleteCategory(Category categoryObj);
	public boolean updateCategory(Category category );
	public Category getCategoryById(int categoryId);
	public List<Category> getAllCategories();
	}