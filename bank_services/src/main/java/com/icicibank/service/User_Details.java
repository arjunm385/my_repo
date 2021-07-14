package com.icicibank.service;

import com.icicibank.exceptions.BusinessException;
import com.icicibank.model.User;
import com.icicibank.model.UserAccount;

public interface User_Details {

	public User registerUser(User user) throws BusinessException;
	public UserAccount registerUserAccount(UserAccount userAccount) throws BusinessException;
	public int checkUserid()throws BusinessException;
	public String checkUserPassword()throws BusinessException;

}
