package com.spicybank.service.Impl;

import com.spicybank.DAO.Spicybank_DAO;
import com.spicybank.DAO.Impl.Spicybank_DAOImpl;
import com.spicybank.exceptions.BusinessException;
import com.spicybank.model.User;
import com.spicybank.model.UserAccount;
import com.spicybank.model.UserTransaction;
import com.spicybank.service.User_Details;

public class User_DetailsImpl implements User_Details {

	Spicybank_DAO spicybank_DAO = new Spicybank_DAOImpl();

	@Override
	public User registerUser(User user) throws BusinessException {

		try {
		return spicybank_DAO.registerUser(user);
		}
		catch(BusinessException e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public UserAccount registerUserAccount(UserAccount userAccount) throws BusinessException {

		try {
			return spicybank_DAO.registerUserAccount(userAccount);

			}
			catch(BusinessException e) {
				e.getMessage();
			}
			return null;
	}

	@Override
	public boolean checkUserid(int id) throws BusinessException {
		
		
		try {
			return spicybank_DAO.checkUserid(id);

			}
			catch(BusinessException e) {
				e.getMessage();
			}
		return false;
			
		
	}

	@Override
	public boolean checkUserPassword(String password, int id) throws BusinessException {
		
		
		try {
			return spicybank_DAO.checkUserPassword(password, id);

			}
			catch(BusinessException e) {
				e.getMessage();
			}
		return false;
		

	}

	@Override
	public float checkBalance(long account) throws BusinessException {
		
		try {
			return spicybank_DAO.checkBalance(account);

			}
			catch(BusinessException e) {
				e.getMessage();
			}
		return 0;
			
	}

	@Override
	public long getAccountNumber(int id) throws BusinessException {

		
		try {
			return spicybank_DAO.getAccountNumber(id);

			}
			catch(BusinessException e) {
				e.getMessage();
			}
		return 0;
			

	}

	@Override
	public void addBal(float amount, float prevamount, long account) throws BusinessException {

		
		try {
			spicybank_DAO.addBal(amount, prevamount, account);

			}
			catch(BusinessException e) {
				e.getMessage();
			}
			

	}

	@Override
	public void txnAdd(String t_type, long account, float amount) throws BusinessException {

		try {
			spicybank_DAO.txnAdd(t_type, account, amount);

			}
			catch(BusinessException e) {
				e.getMessage();
			}
	}

	@Override
	public void withdrawBal(float amt, float pamt, long acc) throws BusinessException {

		try {
			spicybank_DAO.withdrawBal(amt, pamt, acc);

			}
			catch(BusinessException e) {
				e.getMessage();
			}

	}


	@Override
	public UserTransaction getTxnDetails(long acc, UserTransaction userTransaction) throws BusinessException {

		
		try {
			return spicybank_DAO.getTxnDetails(acc, userTransaction);

			}
			catch(BusinessException e) {
				e.getMessage();
			}
			return null;
	}

	@Override
	public String getUserNameByAccount(long account) throws BusinessException {
		
		
		try {
			return spicybank_DAO.getUserNameByAccount(account);

			}
			catch(BusinessException e) {
				e.getMessage();
			}
			return null;
		
	}

	@Override
	public void moneyTransfer(float tr_amt, long acc, long tr_acc) throws BusinessException {
		
		
		try {
			spicybank_DAO.moneyTransfer(tr_amt, acc, tr_acc);

			}
			catch(BusinessException e) {
				e.getMessage();
			}
	}

	@Override
	public void addTransfer(float amount, float prevamount, long account, long prevacc) throws BusinessException {

	try {
		spicybank_DAO.addTransfer(amount, prevamount, account, prevacc);

		}
		catch(BusinessException e) {
			e.getMessage();
		}

	}

	@Override
	public void withdrawlTransfer(float amt, float pamt, long acc, long toacc) throws BusinessException {

		try {
			spicybank_DAO.withdrawlTransfer(amt, pamt, acc, toacc);

			}
			catch(BusinessException e) {
				e.getMessage();
			}
	}
}
