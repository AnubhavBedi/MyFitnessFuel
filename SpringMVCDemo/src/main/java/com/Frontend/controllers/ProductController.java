package com.Frontend.controllers;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onlineshop.dao.Categorydao;
import com.onlineshop.dao.Productdao;
import com.onlineshop.dao.Supplierdao;
import com.onlineshop.models.Category;
import com.onlineshop.models.Product;
import com.onlineshop.models.Supplier;



@Controller
public class ProductController {
	
	@Autowired 
	Productdao productdao;
	
	@Autowired 
	Categorydao categorydao;
	
	@Autowired 
	Supplierdao supplierdao;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping (value="/admin/getProductForm" ,method=RequestMethod.GET )
	public  ModelAndView getAddProductForm(){
		ModelAndView mv= new ModelAndView("ProductForm");
		
		List<Category> catlist=categorydao.getAllCategories();
		List<Supplier> supplist=supplierdao.getAllSupplier();
		
		mv.addObject("categoryList",catlist);
		mv.addObject("supplierList",supplist);
		mv.addObject("heading","Add Product Form");
		mv.addObject("button","Add Product");
		mv.addObject("productobj",new Product());
		return mv;
	}
	
	@RequestMapping(value="/admin/addProduct" ,method=RequestMethod.POST ) 
	public ModelAndView addProduct(@ModelAttribute("productobj")Product product){
		
		String filePathString =session.getServletContext().getRealPath("/");
		System.out.println("filePathString : "+filePathString);
		
		
		String fileName=product.getPimage().getOriginalFilename();
		System.out.println("filname  :"+fileName);
		
		product.setImgName(fileName);
		productdao.addProduct(product);
		
		try{
			
			byte[] imageBytes=product.getPimage().getBytes();
			FileOutputStream fos=new FileOutputStream(filePathString+"/resources/images/"+fileName);
			BufferedOutputStream bos= new BufferedOutputStream(fos);
			bos.write(imageBytes);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ModelAndView mv =new ModelAndView("ViewProduct");
		
		if(product.getProductid()==0){
		mv.addObject("MsgToDisplay", "Product Added Sucessfully!!!!!!!!");
		}
		else{
		mv.addObject("MsgToDisplay", "Product Updated Sucessfully!!!!!!!!");	
		}
		mv.addObject("productlist",productdao.getAllProducts());
		return mv;
	}
		
		@RequestMapping(value="/admin/ViewProduct",method=RequestMethod.GET)
		public ModelAndView fetchproduct(){
			ModelAndView mv=new ModelAndView("ViewProduct");
			List<Product> proList=productdao.getAllProducts();
			
			System.out.println("Product List : "+proList);
			mv.addObject("productlist",proList);
			return mv;
	
	}
		@RequestMapping(value="/admin/deleteProduct/{pId}",method=RequestMethod.GET)
		public ModelAndView deleteProduct(@PathVariable("pId")int productId){
			
			Product obj=productdao.getProductById(productId);
			productdao.deleteProduct(obj);
			
			System.out.println("Product Deleted");
			
			ModelAndView mv= new ModelAndView("ViewProduct");  
			mv.addObject("msgToDisplay","Product Deleted Succesfully");
			mv.addObject("productlist",productdao.getAllProducts());
			return mv;
		}
		
		@RequestMapping(value="/admin/updateProduct/{pId}",method=RequestMethod.GET)
			public ModelAndView updateProduct(@PathVariable("pId")int productId){
			Product obj=productdao.getProductById(productId);
				
				ModelAndView mv=new ModelAndView("ProductForm");
				mv.addObject("productobj", obj);
				mv.addObject("heading", "Product Update Form");
				mv.addObject("button", "Update Product");
				return mv;
			
			
		}
}