package com.srm.spring.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.srm.spring.app.dto.CustomerDetailsDTO;
import com.srm.spring.app.service.CustomerDetailsService;

@RestController
@RequestMapping(value = "/rest/custdtl")
public class CustomerDetailsController {
	
	@Autowired
	private CustomerDetailsService customerDetailsService;
	
	@RequestMapping(value = "/savecustomerdtls", method = RequestMethod.POST)
	public @ResponseBody CustomerDetailsDTO saveCustomerDetails(@RequestBody CustomerDetailsDTO custDtlsDto){
		try{
			custDtlsDto=customerDetailsService.saveCustomerDetails(custDtlsDto);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	   return custDtlsDto;
	}
	
	@RequestMapping(value = "/updatecustomerdtls", method = RequestMethod.PUT)
	public @ResponseBody CustomerDetailsDTO updateCustomerDetails(@RequestBody CustomerDetailsDTO custDtlsDto){
		try{
			custDtlsDto=customerDetailsService.updateCustomerDetails(custDtlsDto);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	   return custDtlsDto;
	}
	
	@RequestMapping(value = "/retrieveCustomerDetails", method = RequestMethod.GET)
	public @ResponseBody CustomerDetailsDTO retrieveCustomerDetails(@RequestParam("custid")Integer custid){
		CustomerDetailsDTO custDto = null;
		try{
			custDto=customerDetailsService.retrieveCustomerDetails(custid);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	   return custDto;
	}

	@RequestMapping(value = "/retrievecustomerandcredientials", method = RequestMethod.GET)
	public @ResponseBody CustomerDetailsDTO retrieveCustomerAndCredientialDtls(@RequestParam("custid")Integer custid){
		CustomerDetailsDTO custDto=null;
		try{
			custDto=customerDetailsService.retrieveCustomerAndCredientialDtls(custid);
		}catch(Exception ex){
			ex.printStackTrace();
		} 	  
		return custDto;  
		  
	}
	
	 @RequestMapping(value = "/retrieveCustomerAndCredientialDtlsByCriteria", method = RequestMethod.GET)
	 public CustomerDetailsDTO retrieveCustomerAndCredientialDtlsByCriteria(@RequestParam("custid") Integer custid) throws Exception{
		 CustomerDetailsDTO custDto=null;
			try{
				custDto=customerDetailsService.retrieveCustomerAndCredientialDtlsByCriteria(custid);
			}catch(Exception ex){
				ex.printStackTrace();
			} 	  
			return custDto;  
	 }
	
	@RequestMapping(value = "/retrieveCustomerByHQL", method = RequestMethod.GET)
    public @ResponseBody CustomerDetailsDTO retrieveCustomerByHQL(@RequestParam("custid")Integer custid) throws Exception{
		CustomerDetailsDTO custDto=null;
		try{
			custDto=customerDetailsService.retrieveCustomerByHQL(custid);
		}catch(Exception ex){
			ex.printStackTrace();
		} 	  
		return custDto;  
	}
	
	 @RequestMapping(value = "/updateCustomerDetailsbyHQL", method = RequestMethod.POST)
	 public @ResponseBody String updateCustomerDetailsbyHQL(@RequestBody CustomerDetailsDTO custDtlsDto) throws Exception{
		  String status=null;
			try{
				status=customerDetailsService.updateCustomerDetailsbyHQL(custDtlsDto);
			}catch(Exception ex){
				ex.printStackTrace();
			} 	  
		return status;  
		 	 
	 }
	
	 @RequestMapping(value = "/deleteCustomerDetailsbyHQL", method = RequestMethod.POST)
	 public String deleteCustomerDetailsbyHQL(@RequestParam("custid")Integer custid) throws Exception{
		  String status=null;
			try{
				status=customerDetailsService.deleteCustomerDetailsbyHQL(custid);
			}catch(Exception ex){
				ex.printStackTrace();
			} 	  
		return status;  
	}
	 
	 @RequestMapping(value = "/getCustomerDetailsByNamedQuery", method = RequestMethod.GET)
	 public CustomerDetailsDTO getCustomerDetailsByNamedQuery(Integer custId){
		 CustomerDetailsDTO dto=null;
			try{
				dto=customerDetailsService.getCustomerDetailsByNamedQuery(custId);
			}catch(Exception ex){
				ex.printStackTrace();
			} 	  
		 return dto;
	 }
	 
	 
	 
}
