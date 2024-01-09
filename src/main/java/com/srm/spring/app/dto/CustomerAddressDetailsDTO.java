package com.srm.spring.app.dto;

import com.srm.spring.app.model.CustomerDetails;

public class CustomerAddressDetailsDTO {

	private Integer addressid;

	private CustomerDetails custid;

	private String addresstype;

	private String address;

	private String street;

	private String city;

	private String pincode;

	public Integer getAddressid() {
		return addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	public CustomerDetails getCustid() {
		return custid;
	}

	public void setCustid(CustomerDetails custid) {
		this.custid = custid;
	}

	public String getAddresstype() {
		return addresstype;
	}

	public void setAddresstype(String addresstype) {
		this.addresstype = addresstype;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
		
}
