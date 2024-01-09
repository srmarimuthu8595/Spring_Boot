package com.srm.spring.app.dao;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srm.spring.app.model.CustomerAddressDetails;

@Repository
public class CustomerAddressDAO {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	
	public CustomerAddressDetails saveCustomerAddressDetails(CustomerAddressDetails custadddtls) throws Exception{
		try{
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			session.beginTransaction();
			session.save(custadddtls);
			session.getTransaction().commit();
		}catch(Exception ex){
			throw ex;
		}
		return custadddtls;
	}
	
	public CustomerAddressDetails updateCustomerAddressDetails(CustomerAddressDetails custadddtls) throws Exception{
		try{
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			session.beginTransaction();
			session.saveOrUpdate(custadddtls);
			session.getTransaction().commit();
		}catch(Exception ex){
			throw ex;
		}
		return custadddtls;
	}
	
	
	
	
	

}
