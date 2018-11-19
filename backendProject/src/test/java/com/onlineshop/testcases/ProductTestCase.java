package com.onlineshop.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshop.dao.Productdao;
import com.onlineshop.models.Category;
import com.onlineshop.models.Product;

public class ProductTestCase {

public static Productdao productObj;
	
	@BeforeClass
	public static void init(){
		
		AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext();
		app.scan("com.onlineshop");
		app.refresh();
		productObj=app.getBean("Productdao",Productdao.class);
	}

	
	@Test
	@Ignore
	public void addProduct(){
		Product pro=new Product();
		pro.setProductname("Protien");
		pro.setPrice(500);
		pro.setQuantity(40);
		pro.setProductdescription("For muscle growth");
		pro.setCategoryid(1);
		pro.setSupplierid(68);
		pro.setImgName("Whey Protien");
		//pro.setStatus("Active");
		 boolean r=productObj.addProduct(pro);
		 
		
		assertTrue("Problem in Adding Category",r);
	}
	
	@Test
	@Ignore
	public void deleteProduct(){
		Product pro=productObj.getProductById(1);
		if(pro==null){
			System.out.println("Product doesnt exists");
		}
		
		if(pro!= null)
		{
		boolean r=productObj.deleteProduct(pro);
		
		assertTrue("Problem in deleting Product",r);
		}
		
		
	}
		@Test
		@Ignore
		public void updateProduct(){
			Product pro=productObj.getProductById(69);
			pro.setProductdescription("Protien Protien");
			boolean r=productObj.updateProduct(pro);
			
			assertTrue("Problem in updating Category",r);
		
		}
		
		@Test
		@Ignore
		public void getProductId(){
			Product proObj=productObj.getProductById(69);
			System.out.println(proObj);
			assertNotNull("Category Not Found", proObj);
		}

		@Test
		@Ignore
		public void getAllProducts(){
			List<Product> productList=productObj.getAllProducts();
			System.out.println(productList);
			assertNotNull("Products Not Found", productList);
		}
		
		@Test
		@Ignore
		public void getAllProductsByCategory() {
			List<Product> productList=productObj.getAllProductsByCategory(1);
			System.out.println(productList);
			assertNotNull("Products Not Found", productList);
		}
		}

