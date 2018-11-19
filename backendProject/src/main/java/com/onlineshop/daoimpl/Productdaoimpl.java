package com.onlineshop.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Ignore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.Productdao;
import com.onlineshop.models.Category;
import com.onlineshop.models.Product;

@Repository("Productdao")
@Transactional
public class Productdaoimpl implements Productdao {
	
	@Autowired
	SessionFactory sessionFactory;
	
		
	@Override
	@Ignore
	public boolean addProduct(Product ProductObj) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(ProductObj);
			return true;
			}
			catch(Exception e){
			e.printStackTrace();
			return false;
			}
	
	}

	@Override
	@Ignore
	public boolean deleteProduct(Product ProductObj) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.delete(ProductObj);
			return true;
			}
			catch(Exception e){
			e.printStackTrace();
			return false;
			}
	}

	@Override
	@Ignore
	public boolean updateProduct(Product Product) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.update(Product);
			return true;
			}
			catch(Exception e){
			e.printStackTrace();
			return false;
			}
	}

	@Override
	public Product getProductById(int productId) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Product pObj=(	Product)session.get(	Product.class,	productId);
			return pObj;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;	}

	@Override
 
	public List<Product> getAllProducts() {
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria cr=session.createCriteria(Product.class);
			List<Product> list= cr.list();
			return list;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
	

	@Override
	
	public List<Product> getAllProductsByCategory(int categoryId) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria cr=session.createCriteria(Product.class);
			cr.add(Restrictions.eq("categoryid",categoryId));
			List<Product> list=cr.list();
			return list;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
}
	
	
	

}
