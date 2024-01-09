package com.srm.spring.app.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srm.spring.app.dao.CurrentAccountDAO;
import com.srm.spring.app.dto.CurrentAccountDTO;
import com.srm.spring.app.model.CurrentAccount;
@Component
public class CurrentAccountService {
	
	@Autowired
	CurrentAccountDAO currentAccountDAO;

	public CurrentAccountDTO currAccDeposit(CurrentAccountDTO dto) throws Exception{
		
	/*	CurrentAccount curraccobj = new CurrentAccount();
		curraccobj.setCustomerid(dto.getCustomerid());
		curraccobj.setCurraccno(dto.getCurraccno());
		curraccobj.setActiontype(dto.getActiontype());
		curraccobj.setDepositdate(dto.getDepositdate());
		curraccobj.setWithdrawdate(dto.getWithdrawdate());
		curraccobj.setAmount(dto.getAmount());
		CurrentAccount obj = currentAccountDAO.saveCurrentAccount(curraccobj);
		dto.setCurracid(obj.getCurraccid());*/
		return dto;
		
	}

}
