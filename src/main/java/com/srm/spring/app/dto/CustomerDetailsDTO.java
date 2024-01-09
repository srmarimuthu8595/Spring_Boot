package com.srm.spring.app.dto;

import java.util.Date;
import java.util.List;

public class CustomerDetailsDTO {

	private Integer custid;

	private String custname;

	private String fathername;
	
	private Date dod;
	
	private String occupation;

	private String panno;
	
	private List<CustomerAddressDetailsDTO> custAddressDtlsDTOList;
	
	private CustomerCredientialsDTO custCredientialsDTO;

	public Integer getCustid() {
		return custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public Date getDod() {
		return dod;
	}

	public void setDod(Date dod) {
		this.dod = dod;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}
	
	public List<CustomerAddressDetailsDTO> getCustAddressDtlsDTOList() {
		return custAddressDtlsDTOList;
	}

	public void setCustAddressDtlsDTOList(List<CustomerAddressDetailsDTO> custAddressDtlsDTOList) {
		this.custAddressDtlsDTOList = custAddressDtlsDTOList;
	}

	public CustomerCredientialsDTO getCustCredientialsDTO() {
		return custCredientialsDTO;
	}

	public void setCustCredientialsDTO(CustomerCredientialsDTO custCredientialsDTO) {
		this.custCredientialsDTO = custCredientialsDTO;
	}
	
}
