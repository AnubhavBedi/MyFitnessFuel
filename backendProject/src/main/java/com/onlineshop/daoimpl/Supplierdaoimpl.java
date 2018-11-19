package com.onlineshop.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.Supplierdao;
import com.onlineshop.models.Category;
import com.onlineshop.models.Supplier;

@Repository("Supplierdao")
@Transactional
public class Supplierdaoimpl implements Supplierdao{
	@Autowired 
	SessionFactory sessionFactory;
	
	
	@Override
	public boolean addSupplier(Supplier supplierObj) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(supplierObj);
			return true;
			}
			catch(Exception e){
			e.printStackTrace();
			return false;
			}	
		}

	@Override
	public boolean deleteSupplier(Supplier supplierObj) {
		try {
			Session session=sessionFactory.getCurrentSession();
			session.delete(supplierObj);
			return true;
			}
			catch(Exception e){
			e.printStackTrace();
			return false;
			}
	}

	@Override
	public boolean updateSupplier(Supplier Supplier) {
		try{
			Session session=sessionFactory.getCurrentSession();
			session.update(Supplier);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public Supplier getSupplierById(int supplierId) {
		try{
			Session session=sessionFactory.getCurrentSession();
			Supplier sObj=(Supplier)session.get(Supplier.class,supplierId);
			return sObj;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public List<Supplier> getAllSupplier() {
		try{
			Session session=sessionFactory.getCurrentSession();
			Criteria cr=session.createCriteria(Supplier.class);
			List<Supplier> list=cr.list();
			return list;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
	}

}
