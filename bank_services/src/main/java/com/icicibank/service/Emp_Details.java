package com.icicibank.service;

import com.icicibank.exceptions.BusinessException;
import com.icicibank.model.UserAccount;

public interface Emp_Details {
	
	public int checkEmpUid()throws BusinessException;
	public String checkEmpPassword()throws BusinessException;
	public String getEmpName()throws BusinessException;
	public void getAllUserDetails()throws BusinessException;
	public UserAccount getAllUserDetailsByAccount(long account)throws BusinessException;
	public boolean checkUserAccount(long accno)throws BusinessException;
	public UserAccount getAllUserDetailsById(int uid)throws BusinessException;
	public void getAllTransactions()throws BusinessException;
	public void getTransactionsByaccount(long account)throws BusinessException;
	public void deleteCustomerAccount(long account)throws BusinessException;
	public int getUserIdByAccount(long account)throws BusinessException;

}
