package com.onlineshop.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshop.dao.Orderdao;
import com.onlineshop.models.Order;


@Repository("orderdao")
@Transactional
public class Orderdaoimpl implements Orderdao {

		@Autowired
		private SessionFactory sessionFactory;
		
		public Session getSession(){
			return sessionFactory.getCurrentSession();
		}

		@Override
		public int makeOrder(Order order) {
			return (int) getSession().save(order);
			
		}
	}


