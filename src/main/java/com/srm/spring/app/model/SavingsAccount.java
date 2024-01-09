package com.srm.spring.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="savingsaccount")
public class SavingsAccount {
	
	@Id
	@Column(name="saveaccid")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer saveaccid;
	
	@ManyToOne
	@JoinColumn(name = "custid")
	private CustomerDetails custid;
		
	@Column(name="saveaccno")
	private String saveaccno;
	
	@Column(name="actiontype")
	private String actiontype;
	
	@Column(name="depositdate")
	private Date depositdate;
	
	@Column(name="withdrawdate")
	private Date withdrawdate;
	
	@Column(name="amount")
	private Double amount;

	public Integer getSaveaccid() {
		return saveaccid;
	}

	public void setSaveaccid(Integer saveaccid) {
		this.saveaccid = saveaccid;
	}

	public CustomerDetails getCustid() {
		return custid;
	}

	public void setCustid(CustomerDetails custid) {
		this.custid = custid;
	}

	public String getSaveaccno() {
		return saveaccno;
	}

	public void setSaveaccno(String saveaccno) {
		this.saveaccno = saveaccno;
	}

	public String getActiontype() {
		return actiontype;
	}

	public void setActiontype(String actiontype) {
		this.actiontype = actiontype;
	}

	public Date getDepositdate() {
		return depositdate;
	}

	public void setDepositdate(Date depositdate) {
		this.depositdate = depositdate;
	}

	public Date getWithdrawdate() {
		return withdrawdate;
	}

	public void setWithdrawdate(Date withdrawdate) {
		this.withdrawdate = withdrawdate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	

}
