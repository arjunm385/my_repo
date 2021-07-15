package com.icicibank.service;

import com.icicibank.exceptions.BusinessException;
import com.icicibank.model.User;
import com.icicibank.model.UserAccount;
import com.icicibank.model.UserTransaction;

public interface User_Details {

	public User registerUser(User user) throws BusinessException;
	public UserAccount registerUserAccount(UserAccount userAccount) throws BusinessException;
	public boolean checkUserid(int id)throws BusinessException;
	public  boolean checkUserPassword(String password,int id)throws BusinessException;
	public long getAccountNumber(int id)throws BusinessException;
	public float checkBalance(long account)throws BusinessException;
	public void addBal(float amount, float prevamount, long account)throws BusinessException;
	public void txnAdd(String t_type,long account,float amount)throws BusinessException;
	public void withdrawBal(float amt, float pamt,long acc)throws BusinessException;
	public void txnWithdraw(String t_type,long account,float amount)throws BusinessException;
	public UserTransaction getTxnDetails(long acc, UserTransaction userTransaction)throws BusinessException;

}
