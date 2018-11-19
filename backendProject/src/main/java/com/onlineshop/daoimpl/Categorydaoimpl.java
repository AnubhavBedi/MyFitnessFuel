package com.onlineshop.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.Categorydao;
import com.onlineshop.models.Category;

@Repository("categorydao") /*is used to indicate that the class provides the mechanism for storage, 
						   retrieval, search, update and delete operation on objects.*/

@Transactional  /*The transactional annotation itself defines the scope of a single database transaction. 
				The database transaction happens inside the scope of a persistence context.*/

public class Categorydaoimpl implements Categorydao{
	
		@Autowired
		SessionFactory sessionFactory;
		

		@Override
		public boolean addCategory(Category categoryObj) {
			try {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(categoryObj);
			return true;
			}
			catch(Exception e){
			e.printStackTrace();
			return false;
			}
	}


		@Override
		public boolean deleteCategory(Category categoryObj) {
			try {
				Session session=sessionFactory.getCurrentSession();
				session.delete(categoryObj);
				return true;
				}
				catch(Exception e){
				e.printStackTrace();
				return false;
				}
		}


		@Override
		public boolean updateCategory(Category category) {
			try {
				Session session=sessionFactory.getCurrentSession();
				session.update(category);
				return true;
				}
				catch(Exception e){
				e.printStackTrace();
				return false;
				}
		}


		@Override
		public Category getCategoryById(int categoryId) {
			try{
			Session session=sessionFactory.getCurrentSession();
			Category cObj=(Category)session.get(Category.class,categoryId);
			return cObj;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}


		@Override
		public List<Category> getAllCategories() {
			try{
			Session session=sessionFactory.getCurrentSession();
			Query q=session.createQuery("from com.onlineshop.models.Category");
			List<Category> list=q.getResultList();
			return list;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}

}
