package com.spicybank.DAO;

import com.spicybank.exceptions.BusinessException;
import com.spicybank.model.User;
import com.spicybank.model.UserAccount;
import com.spicybank.model.UserTransaction;

public interface Spicybank_DAO {
	
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
	
	public User registerUser(User user) throws BusinessException;
	public UserAccount registerUserAccount(UserAccount userAccount) throws BusinessException;
	public boolean checkUserid(int id)throws BusinessException;
	public  boolean checkUserPassword(String password,int id)throws BusinessException;
	public long getAccountNumber(int id)throws BusinessException;
	public float checkBalance(long account)throws BusinessException;
	public void addBal(float amount, float prevamount, long account)throws BusinessException;
	public void txnAdd(String t_type,long account,float amount)throws BusinessException;
	public void withdrawBal(float amt, float pamt,long acc)throws BusinessException;
	public UserTransaction getTxnDetails(long acc, UserTransaction userTransaction)throws BusinessException;
	public String getUserNameByAccount(long account)throws BusinessException;
	public void moneyTransfer(float tr_amt, long acc, long tr_acc)throws BusinessException;
	void addTransfer(float amount, float prevamount, long account, long prevacc) throws BusinessException;
	void withdrawlTransfer(float amt, float pamt, long acc , long toacc) throws BusinessException;
	
}
