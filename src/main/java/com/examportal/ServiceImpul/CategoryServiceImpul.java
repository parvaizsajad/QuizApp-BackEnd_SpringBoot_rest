package com.examportal.ServiceImpul;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examportal.Entity.Category;
import com.examportal.Repository.CategoryRepo;
import com.examportal.Service.CategoryService;
@Service
public class CategoryServiceImpul implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Category addCategory(Category category) throws Exception {
		Optional<Category> findByTitle = categoryRepo.findByTitle(category.getTitle());
		if(findByTitle.isPresent()) {
			throw new Exception("Category already present");
		}
		return categoryRepo.save(category);
	}

	@Override
	public Category updateCategory(Category category) throws Exception {
		
	Category cat = categoryRepo.findByTitle(category.getTitle()).orElseThrow(()->new Exception("category not found"));
		
		cat.setTitle(category.getTitle());
		cat.setDescription(category.getDescription());
		
	return	categoryRepo.save(cat);
	}

	@Override
	public Set<Category> getCategories() {
		
		return new LinkedHashSet<Category>( categoryRepo.findAll());
	}

	@Override
	public Category getCategoryById(Integer categoryId) throws Exception {
	Category category = categoryRepo.findById(categoryId).orElseThrow(()->new Exception("category not found"));
	
		return category;
	}

	@Override
	public void deleteCategory(Integer categoryId) throws Exception {
		Category category = categoryRepo.findById(categoryId).orElseThrow(()->new Exception("category not found"));
		categoryRepo.delete(category);
		

	}

}
