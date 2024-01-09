package com.srm.spring.app.dao;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.srm.spring.app.model.CustomerCredientials;

@Repository
public class CustomerCredientialsDAO {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	
	public CustomerCredientials saveCustomerCredientials(CustomerCredientials custcreditdtls) throws Exception{
		try{
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			session.beginTransaction();
			session.save(custcreditdtls);
			session.getTransaction().commit();
		}catch(Exception ex){
			throw ex;
		}
		return custcreditdtls;
	}
	
	
	public CustomerCredientials updateCustomerCredientials(CustomerCredientials custcreditdtls) throws Exception{
		try{
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			session.beginTransaction();
			session.saveOrUpdate(custcreditdtls);
			session.getTransaction().commit();
		}catch(Exception ex){
			throw ex;
		}
		return custcreditdtls;
	}
	
	

	
	
	
	
	
	
	

}
