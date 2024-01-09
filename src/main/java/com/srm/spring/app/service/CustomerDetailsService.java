package com.srm.spring.app.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.srm.spring.app.dao.CustomerAddressDAO;
import com.srm.spring.app.dao.CustomerCredientialsDAO;
import com.srm.spring.app.dao.CustomerDetailsDAO;
import com.srm.spring.app.dto.CustomerAddressDetailsDTO;
import com.srm.spring.app.dto.CustomerCredientialsDTO;
import com.srm.spring.app.dto.CustomerDetailsDTO;
import com.srm.spring.app.model.CustomerAddressDetails;
import com.srm.spring.app.model.CustomerCredientials;
import com.srm.spring.app.model.CustomerDetails;

@Component
public class CustomerDetailsService {
	
	@Autowired
	CustomerDetailsDAO customerDetailsDAO;
	
	@Autowired
	CustomerAddressDAO customerAddressDAO;
	
	@Autowired
	CustomerCredientialsDAO customerCredientialsDAO;
	
	
	public CustomerDetailsDTO saveCustomerDetails(CustomerDetailsDTO custDtlsDTO)  throws Exception {
		
		CustomerDetails custDetails = new CustomerDetails();
		custDetails.setCustname(custDtlsDTO.getCustname());
		custDetails.setFathername(custDtlsDTO.getFathername());
		custDetails.setDod(custDtlsDTO.getDod());
		custDetails.setOccupation(custDtlsDTO.getOccupation());
		custDetails.setPanno(custDtlsDTO.getPanno());
		custDetails=customerDetailsDAO.saveCustomerDetails(custDetails);
		custDtlsDTO.setCustid(custDetails.getCustid());
		saveCustAddressDtls(custDtlsDTO.getCustAddressDtlsDTOList(),custDtlsDTO.getCustid());
		saveCustCredientialsDtls(custDtlsDTO.getCustCredientialsDTO(),custDtlsDTO.getCustid());
		return custDtlsDTO;
	}
	
	private List<CustomerAddressDetailsDTO> saveCustAddressDtls(List<CustomerAddressDetailsDTO> custAddList,Integer custId) throws Exception{
			
		for(CustomerAddressDetailsDTO dto :custAddList){
			CustomerAddressDetails custAddDtls = new CustomerAddressDetails();
			CustomerDetails custDetails = new CustomerDetails();
			custDetails.setCustid(custId);
			custAddDtls.setCustid(custDetails);
			custAddDtls.setAddresstype(custAddDtls.getAddresstype());
			custAddDtls.setAddress(dto.getAddress());
			custAddDtls.setStreet(dto.getStreet());
			custAddDtls.setCity(dto.getCity());
			custAddDtls.setPincode(dto.getPincode());
			custAddDtls=customerAddressDAO.saveCustomerAddressDetails(custAddDtls);
			dto.setAddressid(custAddDtls.getAddressid());
		}
		return custAddList;
	}
	
    private CustomerCredientialsDTO saveCustCredientialsDtls(CustomerCredientialsDTO custCredientialsDTO,Integer custId) throws Exception{
	   	CustomerCredientials obj = new CustomerCredientials();
	   	CustomerDetails custDetails = new CustomerDetails();
		custDetails.setCustid(custId);
	   	obj.setCustid(custDetails);
	   	obj.setUsername(custCredientialsDTO.getUsername());
	   	obj.setPassword(custCredientialsDTO.getPassword());
	   	obj=customerCredientialsDAO.saveCustomerCredientials(obj);
	   	custCredientialsDTO.setCredientialid(obj.getCredientialid());
		return custCredientialsDTO;
	}
	
    
public CustomerDetailsDTO updateCustomerDetails(CustomerDetailsDTO custDtlsDTO)  throws Exception {
		
		CustomerDetails custDetails = new CustomerDetails();
		custDetails.setCustid(custDtlsDTO.getCustid());
		custDetails.setCustname(custDtlsDTO.getCustname());
		custDetails.setFathername(custDtlsDTO.getFathername());
		custDetails.setDod(custDtlsDTO.getDod());
		custDetails.setOccupation(custDtlsDTO.getOccupation());
		custDetails.setPanno(custDtlsDTO.getPanno());
		custDetails=customerDetailsDAO.updateCustomerDetails(custDetails);
		custDtlsDTO.setCustid(custDetails.getCustid());
		updateCustAddressDtls(custDtlsDTO.getCustAddressDtlsDTOList(),custDtlsDTO.getCustid());
		updateCustCredientialsDtls(custDtlsDTO.getCustCredientialsDTO(),custDtlsDTO.getCustid());
		return custDtlsDTO;
	}
	
	private List<CustomerAddressDetailsDTO> updateCustAddressDtls(List<CustomerAddressDetailsDTO> custAddList,Integer custId) throws Exception{
			
		for(CustomerAddressDetailsDTO dto :custAddList){
			CustomerAddressDetails custAddDtls = new CustomerAddressDetails();
			CustomerDetails custDetails = new CustomerDetails();
			custAddDtls.setAddressid(custAddDtls.getAddressid());
			custDetails.setCustid(custId);
			custAddDtls.setCustid(custDetails);
			custAddDtls.setAddresstype(custAddDtls.getAddresstype());
			custAddDtls.setAddress(dto.getAddress());
			custAddDtls.setStreet(dto.getStreet());
			custAddDtls.setCity(dto.getCity());
			custAddDtls.setPincode(dto.getPincode());
			custAddDtls=customerAddressDAO.updateCustomerAddressDetails(custAddDtls);
			dto.setAddressid(custAddDtls.getAddressid());
		}
		return custAddList;
	}
	
    private CustomerCredientialsDTO updateCustCredientialsDtls(CustomerCredientialsDTO custCredientialsDTO,Integer custId) throws Exception{
	   	CustomerCredientials obj = new CustomerCredientials();
	   	CustomerDetails custDetails = new CustomerDetails();
		custDetails.setCustid(custId);
		obj.setCredientialid(custCredientialsDTO.getCredientialid());
	   	obj.setCustid(custDetails);
	   	obj.setUsername(custCredientialsDTO.getUsername());
	   	obj.setPassword(custCredientialsDTO.getPassword());
	   	obj=customerCredientialsDAO.updateCustomerCredientials(obj);
	   	custCredientialsDTO.setCredientialid(obj.getCredientialid());
		return custCredientialsDTO;
	}
	
    
    public CustomerDetailsDTO retrieveCustomerDetails(Integer custid) throws Exception{
    	
    	List<CustomerAddressDetailsDTO> custAddressDtlsDTOList = new  ArrayList<CustomerAddressDetailsDTO>();
    	CustomerDetailsDTO dto = new CustomerDetailsDTO();
    	CustomerDetails custDetails= customerDetailsDAO.retrieveCustomerDetails(custid);
    	dto.setCustid(custDetails.getCustid());
    	dto.setCustname(custDetails.getCustname());
    	dto.setFathername(custDetails.getFathername());
    	dto.setDod(custDetails.getDod());
    	dto.setOccupation(custDetails.getOccupation());
    	dto.setPanno(custDetails.getPanno());
    	List<CustomerAddressDetails> custAddressDtlList = custDetails.getCustAddressDtlList();
    	for(CustomerAddressDetails obj:custAddressDtlList){
    		
    		CustomerAddressDetailsDTO addressdto = new CustomerAddressDetailsDTO();
    		
    		addressdto.setAddressid(obj.getAddressid());
    		addressdto.setAddresstype(obj.getAddresstype());
    		addressdto.setAddress(obj.getAddress());
    		addressdto.setStreet(obj.getStreet());
    		addressdto.setCity(obj.getCity());
    		addressdto.setCustid(obj.getCustid());
    		addressdto.setPincode(obj.getPincode());
    		
    		custAddressDtlsDTOList.add(addressdto);
    		
    	}
    	 
    	dto.setCustAddressDtlsDTOList(custAddressDtlsDTOList);
    	return dto;
    }
    
    public CustomerDetailsDTO retrieveCustomerAndCredientialDtls(Integer custid) throws Exception{
    	   return customerDetailsDAO.retrieveCustomerAndCredientialDtls(custid);
    }
    
    public CustomerDetailsDTO retrieveCustomerAndCredientialDtlsByCriteria(Integer custid) throws Exception{
    	return customerDetailsDAO.retrieveCustomerAndCredientialDtlsByCriteria(custid);
    }
    
    public CustomerDetailsDTO retrieveCustomerByHQL(Integer custid) throws Exception{
    	return customerDetailsDAO.retrieveCustomerByHQL(custid);
    }
    
    public String updateCustomerDetailsbyHQL(CustomerDetailsDTO custDtlsDto) throws Exception{
    	CustomerDetails custDetails = new CustomerDetails();
    	custDetails.setCustid(custDtlsDto.getCustid());
    	custDetails.setFathername(custDtlsDto.getFathername());
    	custDetails.setOccupation(custDtlsDto.getOccupation());
    	custDetails.setPanno(custDtlsDto.getPanno());
    	return customerDetailsDAO.updateCustomerDetailsbyHQL(custDetails);
    }
    
    public String deleteCustomerDetailsbyHQL(Integer custid) throws Exception{
    	return customerDetailsDAO.deleteCustomerDetailsbyHQL(custid);
    }
    
    public CustomerDetailsDTO getCustomerDetailsByNamedQuery(Integer custId) throws Exception{
    	CustomerDetails custdetails;
    	custdetails= customerDetailsDAO.getCustomerDetailsByNamedQuery(custId);
    	CustomerDetailsDTO dto = new CustomerDetailsDTO();
    	dto.setCustid(custdetails.getCustid());
    	dto.setCustname(custdetails.getCustname());
    	dto.setFathername(custdetails.getFathername());
    	dto.setDod(custdetails.getDod());
    	dto.setOccupation(custdetails.getOccupation());
    	dto.setPanno(custdetails.getPanno());
    	return dto;
    }
    
	
	

}
