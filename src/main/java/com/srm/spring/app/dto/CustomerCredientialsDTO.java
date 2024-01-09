package com.srm.spring.app.dto;

import com.srm.spring.app.model.CustomerDetails;

public class CustomerCredientialsDTO {
		
	private Integer credientialid;
	
	private CustomerDetails custid;
	
	private String username;

	private String password;

	public Integer getCredientialid() {
		return credientialid;
	}

	public void setCredientialid(Integer credientialid) {
		this.credientialid = credientialid;
	}

	public CustomerDetails getCustid() {
		return custid;
	}

	public void setCustid(CustomerDetails custid) {
		this.custid = custid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
}
