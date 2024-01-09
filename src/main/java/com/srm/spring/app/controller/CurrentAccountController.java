package com.srm.spring.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.srm.spring.app.dto.CurrentAccountDTO;
import com.srm.spring.app.service.CurrentAccountService;

@RestController
@RequestMapping(value = "/rest/curracc")
public class CurrentAccountController {
	
	@Autowired
	private CurrentAccountService currentAccountService;
	
	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public @ResponseBody CurrentAccountDTO currAccDeposit(@RequestBody CurrentAccountDTO dto){
		/*try{
			dto=currentAccountService.currAccDeposit(dto);
		}catch(Exception ex){
			ex.printStackTrace();
		}*/
	   return dto;
	}
	
	
	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String getReport(){
		
		return "Report";
	}

}
