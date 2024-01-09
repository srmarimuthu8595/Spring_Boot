package com.srm.spring.app.dao;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srm.spring.app.model.CurrentAccount;

@Repository
public class CurrentAccountDAO {
	
/*	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	public CurrentAccount currAccDeposit(CurrentAccount curracc) throws Exception{
		try{
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			session.beginTransaction();
			session.save(curracc);
			session.getTransaction().commit();
		}catch(Exception ex){
			throw ex;
		}
		return curracc;
	}
	
	*/
	

}
