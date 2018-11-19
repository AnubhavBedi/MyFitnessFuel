package com.Frontend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.dao.Categorydao;
import com.onlineshop.dao.Productdao;
import com.onlineshop.models.Category;



@Controller
public class CategoryController {
	
	
	@Autowired
	Categorydao categoryDaoObj;
	
	@Autowired
	Productdao productDaoObj;
	
	@RequestMapping(value="/admin/c1",method=RequestMethod.GET) 
	public ModelAndView getAddCategoryForm(){
			ModelAndView mv= new ModelAndView("CategoryForm");
			mv.addObject("heading","Add Category Form");
			mv.addObject("button","Add Category");
			mv.addObject("categoryObj",new Category());
			return mv;
	}
	
	@RequestMapping(value="/admin/c3",method=RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute("categoryobj")Category categoryobj){
		
			
			ModelAndView mv= new ModelAndView("ViewCategory");
			if(categoryobj.getCategoryid()==0){
				mv.addObject("msgToDisplay","Category Added Succesfully");	
			}
			else {
				mv.addObject("msgToDisplay","Category Updated Succesfully");
			}
			categoryDaoObj.addCategory(categoryobj);
			
			
			mv.addObject("categoryList",categoryDaoObj.getAllCategories());
			return mv;
	
	}
	
	@RequestMapping(value="/admin/c2",method=RequestMethod.GET)
	 public ModelAndView fetchcategory(){
		ModelAndView mv =new 	ModelAndView ("ViewCategory");
		List<Category> catobj=categoryDaoObj.getAllCategories();
		mv.addObject("categoryList",catobj);
		return mv;
		
		
	}
	@RequestMapping(value="/admin/deleteCategory/{cId}",method=RequestMethod.GET)
	public ModelAndView deleteCategory(@PathVariable("cId")int categoryId){
		
		Category obj=categoryDaoObj.getCategoryById(categoryId);
		categoryDaoObj.deleteCategory(obj);
		
		System.out.println("Category Deleted");
		
		ModelAndView mv= new ModelAndView("ViewCategory");  
		mv.addObject("msgToDisplay","Category Deleted Succesfully");
		mv.addObject("categoryList",categoryDaoObj.getAllCategories());
		return mv;
	}
	
	@RequestMapping(value="/admin/updateCategory/{cId}",method=RequestMethod.GET)
	public ModelAndView updateCategoryForm(@PathVariable("cId")int categoryId){
		Category catObj=categoryDaoObj.getCategoryById(categoryId);
		
		
		ModelAndView mv=new ModelAndView("CategoryForm");
		mv.addObject("categoryObj",catObj);
		mv.addObject("heading","Update Category Form");
		mv.addObject("button","Update Category");
		return mv;
	}
	@RequestMapping(value="/viewAllProducts/{cId}",method=RequestMethod.GET)
	 public ModelAndView fetchProductsForCategory(@PathVariable("cId")int categoryId){
		ModelAndView mv =new 	ModelAndView ("ViewProduct");
		mv.addObject("productlist",productDaoObj.getAllProductsByCategory(categoryId));
		return mv;
		
		
	}
	
		
}
