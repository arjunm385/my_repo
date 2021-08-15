package com.spicybank.service.Impl;

import com.spicybank.service.Emp_Details;
import com.spicybank.DAO.Spicybank_DAO;
import com.spicybank.DAO.Impl.Spicybank_DAOImpl;
import com.spicybank.exceptions.BusinessException;
import com.spicybank.model.UserAccount;

public class Emp_DetailsImpl implements Emp_Details {

	Spicybank_DAO spicybank_DAO = new Spicybank_DAOImpl();
	
	
	@Override
	public int checkEmpUid() {

		try {
			return spicybank_DAO.checkEmpUid();
		} catch (BusinessException e) {
			e.getMessage();
		}
		return 0;

	}

	@Override
	public String checkEmpPassword() {
		try {
			return spicybank_DAO.checkEmpPassword();
		} catch (BusinessException e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public String getEmpName() {
	try {
		return spicybank_DAO.getEmpName();
	} catch (BusinessException e) {
		e.getMessage();
	}
	return null;	
	}

	@Override
	public void getAllUserDetails() {

		try {
			spicybank_DAO.getAllUserDetails();
		} catch (BusinessException e) {
			e.getMessage();
		}

	}

	@Override
	public UserAccount getAllUserDetailsByAccount(long account) throws BusinessException {

		try {
		return spicybank_DAO.getAllUserDetailsByAccount(account);
		}
		catch(BusinessException e){
			e.getMessage();
		}
		return null;
	}

	@Override
	public boolean checkUserAccount(long accno) throws BusinessException {

		try {
		return spicybank_DAO.checkUserAccount(accno);
		}
		catch(BusinessException e) {
			e.getMessage();
		}
		return false;
	}

	@Override
	public UserAccount getAllUserDetailsById(int uid) throws BusinessException {
		try {
		return spicybank_DAO.getAllUserDetailsById(uid);
		}
		catch(BusinessException e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public void getAllTransactions() throws BusinessException {

		try {
			spicybank_DAO.getAllTransactions();
		} catch (BusinessException e) {
			e.getMessage();
		}

	}

	@Override
	public void getTransactionsByaccount(long account) throws BusinessException {

		try {
			spicybank_DAO.getTransactionsByaccount(account);
		} catch (BusinessException e) {
			e.getMessage();
		}

	}

	@Override
	public void deleteCustomerAccount(long account) throws BusinessException {
		try {
			spicybank_DAO.deleteCustomerAccount(account);
		}
		catch (BusinessException e) {
			e.getMessage();
		}
	}

	@Override
	public int getUserIdByAccount(long account) throws BusinessException {
		try {
			return spicybank_DAO.getUserIdByAccount(account);
		}
		catch(BusinessException e) {
			e.getMessage();
		}
		return 0;
}
}
