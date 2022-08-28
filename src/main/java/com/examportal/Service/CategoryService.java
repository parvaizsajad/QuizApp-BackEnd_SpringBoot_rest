package com.examportal.Service;

import java.util.Set;

import com.examportal.Entity.Category;

public interface CategoryService {
	
	public Category addCategory(Category category) throws Exception;
	public Category updateCategory(Category category) throws Exception;
	public Set<Category> getCategories();
	public Category getCategoryById(Integer categoryId) throws Exception;
	public void deleteCategory(Integer categoryId)throws Exception;

}
