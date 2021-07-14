package com.icicibank.service;

import com.icicibank.exceptions.BusinessException;
import com.icicibank.model.User;
import com.icicibank.model.UserAccount;

public interface User_Details {

	public User registerUser(User user) throws BusinessException;
	public UserAccount registerUserAccount(UserAccount userAccount) throws BusinessException;
	public boolean checkUserid(int id)throws BusinessException;
	public  boolean checkUserPassword(String password,int id)throws BusinessException;
	public long getAccountNumber(int id)throws BusinessException;
	public float checkBalance(long account)throws BusinessException;

}
