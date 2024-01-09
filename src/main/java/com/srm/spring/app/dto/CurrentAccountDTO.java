package com.srm.spring.app.dto;

import java.util.Date;


public class CurrentAccountDTO {

	private Integer curracid;
	private String customerid;
	private String curraccno;
	private String actiontype;
	private Date depositdate;
	private Date withdrawdate;
	private Double amount;

	
	public Integer getCurracid() {
		return curracid;
	}

	public void setCurracid(Integer curracid) {
		this.curracid = curracid;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getCurraccno() {
		return curraccno;
	}

	public void setCurraccno(String curraccno) {
		this.curraccno = curraccno;
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
