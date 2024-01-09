package com.srm.spring.app.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@NamedQueries({
	 @NamedQuery(
	 name = "CustomerDetailsByCustId",
	 query = "from CustomerDetails c where c.custid = :custid"
	 )
	})



@Entity
@Table(name="customerdetails")
public class CustomerDetails {
	
	@Id
	@Column(name="custid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer custid;
	
	@Column(name="custname")
	private String custname;
	
	@Column(name="fathername")
	private String fathername;
	
	@Column(name="dod")
	private Date dod;
	
	@Column(name="occupation")
	private String occupation;
	
	@Column(name="panno")
	private String panno;

	// @OneToOne(cascade= CascadeType.PERSIST) 
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "custid", insertable = false, updatable = false)
	private List<CustomerAddressDetails> custAddressDtlList;
	
	/*
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "custid", insertable = false, updatable = false)
	private CustomerCredientials customerCredientials;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "custid", insertable = false, updatable = false)
	private List<CurrentAccount> currentAccountList;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "custid", insertable = false, updatable = false)
	private List<SavingsAccount> savingsAccountList;
*/
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
	
	public List<CustomerAddressDetails> getCustAddressDtlList() {
		return custAddressDtlList;
	}

	public void setCustAddressDtlList(List<CustomerAddressDetails> custAddressDtlList) {
		this.custAddressDtlList = custAddressDtlList;
	}

	/*
	
	public CustomerCredientials getCustomerCredientials() {
		return customerCredientials;
	}

	public void setCustomerCredientials(CustomerCredientials customerCredientials) {
		this.customerCredientials = customerCredientials;
	}
   
	public List<CurrentAccount> getCurrentAccountList() {
		return currentAccountList;
	}

	public void setCurrentAccountList(List<CurrentAccount> currentAccountList) {
		this.currentAccountList = currentAccountList;
	}

	public List<SavingsAccount> getSavingsAccountList() {
		return savingsAccountList;
	}

	public void setSavingsAccountList(List<SavingsAccount> savingsAccountList) {
		this.savingsAccountList = savingsAccountList;
	}*/
		
}
