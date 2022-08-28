
package com.examportal.Controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examportal.Entity.Category;
import com.examportal.Service.CategoryService;



@RestController
@CrossOrigin("*")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/category")
	public ResponseEntity<?>  saveUser(@RequestBody Category category) throws Exception{
		System.out.println(category.getDescription());
		Category category2 = this.categoryService.addCategory(category);
		
		return new ResponseEntity<Category>(category2,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/category")
	public ResponseEntity<?> getAllCategories(){
	Set<Category> categories = this.categoryService.getCategories();
		return new ResponseEntity<Set<Category>>(categories,HttpStatus.CREATED);
	}
	
	@GetMapping("/category/{cid}")
	public ResponseEntity<?> getCategory(@PathVariable("cid") Integer cid) throws Exception{
	Category categories = this.categoryService.getCategoryById(cid);
		return new ResponseEntity<Category>(categories,HttpStatus.CREATED);
	}

	@PutMapping("/category")
	public ResponseEntity<?> updateCategory(@RequestBody Category category) throws Exception{
	Category categories = this.categoryService.updateCategory(category);
		return new ResponseEntity<Category>(categories,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/category/{cid}")
	public ResponseEntity<?> DeleteCategory(@PathVariable("cid") Integer cid) throws Exception{
	 this.categoryService.deleteCategory(cid);
		return new ResponseEntity<String>("Deleted",HttpStatus.CREATED);
	}
}
