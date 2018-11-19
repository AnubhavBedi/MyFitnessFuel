package com.onlineshop.testcases;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.onlineshop.dao.Categorydao;
import com.onlineshop.models.Category;

public class CategoryTestCase {

	
		
		static Categorydao categoryObj;
		
		@BeforeClass /*as soon as this class will get instialized this class will be called bzs of this annotattion*/
		public static void init(){
			
			AnnotationConfigApplicationContext app=new AnnotationConfigApplicationContext();
			app.scan("com.onlineshop");
			app.refresh();
			categoryObj=app.getBean("categorydao",Categorydao.class);
		}
		
		@Test /* To run only the selected test, position the cursor on the test method name and use the shortcut. */
		@Ignore
		public void addCategory(){
			
			Category cat=new Category();
			cat.setCategoryname("Pre-workout");
			cat.setCategorydescription("increase body energy  ");
			
			boolean r=categoryObj.addCategory(cat);
			
			/*This test will fail if value of r is false . */
			assertTrue("Problem in Adding Category",r);
		}
		
		@Test
		@Ignore
		public void deleteCategory(){
			Category cat=categoryObj.getCategoryById(100);
			boolean r=categoryObj.deleteCategory(cat);
			
			assertTrue("Problem in deleting Category",r);
			
			
			
		}
			@Test
			@Ignore
			public void updateCategory(){
				Category cat=categoryObj.getCategoryById(33);
				cat.setCategorydescription("Full of Energy");
				
				boolean r=categoryObj.updateCategory(cat);
				
				assertTrue("Problem in updating Category",r);
				
			}
			
			
			@Test
			@Ignore
			public void getCategoryId(){
				Category catObj=categoryObj.getCategoryById(34);
				System.out.println(catObj);
				assertNotNull("Category Not Found", catObj);
			}

			@Test
			@Ignore
			public void getAllCategories(){
				List<Category> categoryList=categoryObj.getAllCategories();
				System.out.println(categoryList);
				assertNotNull("Categories Not Found", categoryList);
			}

			
					
		}
		
		
		
		
		
	






