package com.srm.spring.app.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.srm.spring.app.dto.CustomerCredientialsDTO;
import com.srm.spring.app.dto.CustomerDetailsDTO;
import com.srm.spring.app.model.CustomerAddressDetails;
import com.srm.spring.app.model.CustomerCredientials;
import com.srm.spring.app.model.CustomerDetails;


@Repository
public class CustomerDetailsDAO {
	
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	
	public CustomerDetails saveCustomerDetails(CustomerDetails custdtls) throws Exception{
		try{
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			session.beginTransaction();
			session.save(custdtls);
			session.getTransaction().commit();
		}catch(Exception ex){
			throw ex;
		}
		return custdtls;
	}
	
	public CustomerDetails updateCustomerDetails(CustomerDetails custdtls) throws Exception{
		try{
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			session.beginTransaction();
			session.saveOrUpdate(custdtls);
			session.getTransaction().commit();
		}catch(Exception ex){
			throw ex;
		}
		return custdtls;
	}
	
	public CustomerDetails retrieveCustomerDetails(Integer custid) throws Exception{
		CustomerDetails obj;
		try{
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			//session.beginTransaction();
			obj=(CustomerDetails)session.get(CustomerDetails.class,custid);
			//session.getTransaction().commit();
		}catch(Exception ex){
			throw ex;
		}
		return obj;
	}
	
	
	public CustomerDetailsDTO retrieveCustomerAndCredientialDtls(Integer custid) throws Exception{
		CustomerDetailsDTO custDtls = new CustomerDetailsDTO();
		CustomerCredientialsDTO crediential = new CustomerCredientialsDTO();
		try{
			
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			
			String querystr="Select cust.custid,cust.custname,cust.fathername,cust.dod,cust.occupation,cust.panno,"
					+ "crd.credientialid,crd.username,crd.password"
					+ " from CustomerDetails cust join CustomerCredientials crd on cust.custid=crd.custid and cust.custid="+custid;
			
			Query<?> query = session.createSQLQuery(querystr);
			List<Object[]> result = (List<Object[]>) query.list();
			
			for(Object[] object : result){
				
				custDtls.setCustid(new Integer(object[0].toString()));
				custDtls.setCustname(object[1].toString());
				custDtls.setFathername(object[2].toString());
				//Date dob=(Date) new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(object[3].toString());
				//custDtls.setDod(dob);
				//custDtls.setDod(Date.valueOf(object[3].toString()));
				custDtls.setOccupation(object[4].toString());
				custDtls.setPanno(object[5].toString());
				crediential.setCredientialid(new Integer(object[6].toString()));
				crediential.setUsername(object[7].toString());
				crediential.setPassword(object[8].toString());
			}
				
			custDtls.setCustCredientialsDTO(crediential);
			
		}catch(Exception ex){
			throw ex;
		}
		return custDtls;
	}
	
	
	
	public CustomerDetailsDTO retrieveCustomerAndCredientialDtlsByCriteria(Integer custid) throws Exception{
		CustomerDetailsDTO custDtls = new CustomerDetailsDTO();
		CustomerCredientialsDTO crediential = new CustomerCredientialsDTO();
		try{
			
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();

			CriteriaBuilder crBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Object[]> criteriaQuery = crBuilder.createQuery(Object[].class);
			Root<CustomerDetails> custRoot = criteriaQuery.from(CustomerDetails.class);
			Root<CustomerCredientials> credientialsRoot = criteriaQuery.from(CustomerCredientials.class);
			criteriaQuery.multiselect(custRoot, credientialsRoot);
	        criteriaQuery.where(crBuilder.equal(custRoot.get("custid"), credientialsRoot.get("custid")),crBuilder.equal(custRoot.get("custid"),custid));
					
	        Query<Object[]> query=session.createQuery(criteriaQuery);
			List<Object[]> result = (List<Object[]>) query.list();
			
			for(Object[] object : result){
				
				CustomerDetails custobj =(CustomerDetails)object[0];
				CustomerCredientials credientialobj =(CustomerCredientials)object[1];
				
				custDtls.setCustid(custobj.getCustid());
				custDtls.setCustname(custobj.getCustname());
				custDtls.setFathername(custobj.getFathername());
				custDtls.setDod(custobj.getDod());
				custDtls.setOccupation(custobj.getOccupation());
				custDtls.setPanno(custobj.getPanno());
				crediential.setCredientialid(credientialobj.getCredientialid());
				crediential.setUsername(credientialobj.getUsername());
				crediential.setPassword(credientialobj.getPassword());
		
			}
				
			custDtls.setCustCredientialsDTO(crediential);
			
		}catch(Exception ex){
			throw ex;
		}
		return custDtls;
	}
	
	
	
	public CustomerDetailsDTO retrieveCustomerByHQL(Integer custid) throws Exception{
		CustomerDetailsDTO custDtls = new CustomerDetailsDTO();
		try{
			
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			
			String querystr="FROM CustomerDetails cust WHERE cust.custid="+custid;
			
			Query<?> query = session.createQuery(querystr);
			List<CustomerDetails> result = (List<CustomerDetails>) query.list();
			
			for(CustomerDetails custobj : result){
				
				custDtls.setCustid(custobj.getCustid());
				custDtls.setCustname(custobj.getCustname());
				custDtls.setCustname(custobj.getFathername());
				custDtls.setDod(custobj.getDod());
				custDtls.setOccupation(custobj.getOccupation());
				custDtls.setPanno(custobj.getPanno());
				
			}
						
		}catch(Exception ex){
			throw ex;
		}
		return custDtls;
	}
	
	public String updateCustomerDetailsbyHQL(CustomerDetails custdtls) throws Exception{
		String status=null;
		try{
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			session.beginTransaction();
			int updatedEntities = session
					.createQuery(
							"UPDATE CustomerDetails "
							 + "SET occupation = :occupation,panno=:panno "
							 + "where custid=:custid")
					.setParameter("custid",custdtls.getCustid())
					.setParameter("occupation",custdtls.getOccupation())
					.setParameter("panno", custdtls.getPanno()).executeUpdate();
			session.getTransaction().commit();
			if(updatedEntities>0){
				status="Customer details updated successfully";
			}else{
				status="Customer details not updated successfully";
			}
						
		}catch(Exception ex){
			status="Customer details not updated successfully";
			throw ex;
		}
		return status;
	}
	
	
	public String deleteCustomerDetailsbyHQL(Integer custid) throws Exception{
		String status=null;
		try{
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			session.beginTransaction();
			
			/*
			CustomerDetails custobj = new CustomerDetails();
			custobj.setCustid(custid);
			 String crdquerystr="FROM CustomerCredientials crdtls WHERE crdtls.custid="+custobj;
			List<CustomerCredientials> crdlist=(List<CustomerCredientials>)session.createQuery(crdquerystr);
			if(crdlist!=null&&crdlist.size()>0){
			   CustomerCredientials crddtl =crdlist.get(0);
				session.createQuery(
						"DELETE FROM CustomerCredientials"
						 + " where credientialid=:credientialid")
				.setParameter("credientialid",crddtl.getCredientialid()).executeUpdate();
			}
			
			String addquerystr="FROM CustomerAddressDetails crdtls WHERE crdtls.custid="+custobj;
			List<CustomerAddressDetails> addlist =(List<CustomerAddressDetails>)session.createQuery(addquerystr);
			for(CustomerAddressDetails obj:addlist){
				session.createQuery(
						"DELETE FROM CustomerAddressDetails"
						 + " where addressid=:addressid")
				.setParameter("addressid",obj.getAddressid()).executeUpdate();
			}*/
			
			CustomerDetails custobj = new CustomerDetails();
			custobj.setCustid(custid);
			
			session.createQuery("DELETE CustomerCredientials" + " where custid=:custid").setParameter("custid", custobj).executeUpdate();
			
			session.createQuery("DELETE CustomerAddressDetails" + " where custid=:custid").setParameter("custid", custobj).executeUpdate();
			
			session.createQuery("DELETE CustomerDetails where custid=:custid").setParameter("custid",custid).executeUpdate();
			
			session.getTransaction().commit();				
			status="Customer details deleted successfully";			
		
		}catch(Exception ex){
			status="Customer details not deleted successfully";
			throw ex;
		}
		return status;
		
	}
	
	
	public CustomerDetails getCustomerDetailsByNamedQuery(Integer custId){
		CustomerDetails custDetails = null;
		try{
			
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			Query query =session.getNamedSQLQuery("CustomerDetailsByCustId").setParameter("custid", custId);
			List<CustomerDetails> list =query.getResultList();
			if(list!=null&&list.size()>0){
				custDetails	=list.get(0);
			}
							
	     }catch(Exception ex){
	    	 throw ex; 
	     }
		return custDetails;
	}
	
	
	
	
	

}
