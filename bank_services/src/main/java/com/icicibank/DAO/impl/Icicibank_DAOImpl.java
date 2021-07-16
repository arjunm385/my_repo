package com.icicibank.DAO.impl;

import com.icicibank.DAO.Icicibank_DAO;
import com.icicibank.exceptions.BusinessException;
import com.icicibank.model.User;
import com.icicibank.model.UserAccount;
import com.icicibank.model.UserTransaction;

public class Icicibank_DAOImpl implements Icicibank_DAO {

	@Override
	public int checkEmpUid() throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String checkEmpPassword() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmpName() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getAllUserDetails() throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserAccount getAllUserDetailsByAccount(long account) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUserAccount(long accno) throws BusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserAccount getAllUserDetailsById(int uid) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getAllTransactions() throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTransactionsByaccount(long account) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomerAccount(long account) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getUserIdByAccount(long account) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User registerUser(User user) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAccount registerUserAccount(UserAccount userAccount) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkUserid(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkUserPassword(String password, int id) throws BusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getAccountNumber(int id) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float checkBalance(long account) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addBal(float amount, float prevamount, long account) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void txnAdd(String t_type, long account, float amount) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdrawBal(float amt, float pamt, long acc) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void txnWithdraw(String t_type, long account, float amount) throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserTransaction getTxnDetails(long acc, UserTransaction userTransaction) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
