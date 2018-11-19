package com.onlineshop.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration 
@EnableTransactionManagement 
@ComponentScan({"com.onlineshop"})
public class HibernateConfig {

	@Bean("dataSource")
	public DataSource dataSource(){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		
		/*To create the object of DriverManagerDataSource u need to provide database 
		 details like Drivername, Connection string ,username and password*/
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		return dataSource;
	}
	
	
	public Properties hibernateProperties(){
	Properties properties=new Properties();
	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.hbm2ddl.auto","update");
    return properties;   
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setHibernateProperties(hibernateProperties());
		sessionFactory.setPackagesToScan(new String[]{"com.onlineshop.models"});
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s){
	HibernateTransactionManager txManager=new HibernateTransactionManager();
	txManager.setSessionFactory(s);
	return txManager;
	}

	
}



	