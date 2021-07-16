package com.icicibank.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icicibank.service.Emp_Details;
import com.icicibank.dbutil.PostgresConnection;
import com.icicibank.exceptions.BusinessException;
import com.icicibank.model.Emp;
import com.icicibank.model.UserAccount;
import com.icicibank.model.UserTransaction;

public class Emp_DetailsImpl implements Emp_Details {

	@Override
	public int checkEmpUid() {

		int id = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select user_id from emp_details";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				id = resultSet.getInt("user_id");
			}
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		return id;

	}

	@Override
	public String checkEmpPassword() {
		String pass = null;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select password from icicibank_db.emp_details";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				pass = resultSet.getString("password");
			}
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}

		return pass;
	}

	@Override
	public String getEmpName() {
		String name = null;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select name from icicibank_db.emp_details";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				name = resultSet.getString("name");
			}
		} catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		return name;

	}

	@Override
	public void getAllUserDetails() {

		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select userid,name,pan,aadhar,balance,city,state,pincode,account from user_account";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println("User Id: " + resultSet.getLong("userid"));
				System.out.println("Name: " + resultSet.getString("name"));
				System.out.println("Account number: " + resultSet.getLong("account"));
				System.out.println("PAN number: " + resultSet.getString("pan"));
				System.out.println("Aadhar number: " + resultSet.getString("aadhar"));
				System.out.println("Account Balance: " + resultSet.getFloat("balance"));
				System.out.println("City: " + resultSet.getString("city"));
				System.out.println("State: " + resultSet.getString("state"));
				System.out.println("Pincode: " + resultSet.getString("pincode"));
				System.out.println("\n");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.getMessage();
		}

	}

	@Override
	public UserAccount getAllUserDetailsByAccount(long account) throws BusinessException {

		UserAccount userAccount = new UserAccount(0, null, 0, null, null, null, null, false, null, 0);
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select userid,name,pan,aadhar,balance,city,state,pincode,account from user_account where account=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, account);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userAccount.setAccount(resultSet.getLong("account"));
				userAccount.setUserid(resultSet.getInt("userid"));
				userAccount.setAadhar(resultSet.getString("aadhar"));
				userAccount.setBalance(resultSet.getFloat("balance"));
				userAccount.setPan(resultSet.getString("pan"));
				userAccount.setName(resultSet.getString("name"));
				userAccount.setCity(resultSet.getString("city"));
				userAccount.setState(resultSet.getString("state"));
				userAccount.setPincode(resultSet.getString("pincode"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.getMessage();
		}

		return userAccount;
	}

	@Override
	public boolean checkUserAccount(long accno) throws BusinessException {

		boolean a = false;
		long accno1 = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select account from user_account where account=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, accno);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				accno1 = resultSet.getInt("account");
			}

			if (accno == accno1)
				a = true;
			else
				a = false;

		} catch (SQLException e) {
			e.getMessage();
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}

		return a;

	}

	@Override
	public UserAccount getAllUserDetailsById(int uid) throws BusinessException {
		UserAccount userAccount = new UserAccount(0, null, 0, null, null, null, null, false, null, 0);
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select userid,name,pan,aadhar,balance,city,state,pincode,account from user_account where userid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, uid);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userAccount.setAccount(resultSet.getLong("account"));
				userAccount.setUserid(resultSet.getInt("userid"));
				userAccount.setAadhar(resultSet.getString("aadhar"));
				userAccount.setBalance(resultSet.getFloat("balance"));
				userAccount.setPan(resultSet.getString("pan"));
				userAccount.setName(resultSet.getString("name"));
				userAccount.setCity(resultSet.getString("city"));
				userAccount.setState(resultSet.getString("state"));
				userAccount.setPincode(resultSet.getString("pincode"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.getMessage();
		}

		return userAccount;
	}

	@Override
	public void getAllTransactions() throws BusinessException {

		UserTransaction userTransaction = new UserTransaction(0, 0, 0, null);
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select transactionid,transactiontype,amt,account from transactions";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userTransaction.setTransactionid(resultSet.getLong("transactionid"));
				userTransaction.setAccountno(resultSet.getLong("account"));
				userTransaction.setTransactiontype(resultSet.getString("transactiontype"));
				userTransaction.setAmt(resultSet.getFloat("amt"));
				System.out.println("transaction id: " + userTransaction.getTransactionid() + " account number: "
						+ userTransaction.getAccountno() + " transaction type: " + userTransaction.getTransactiontype()
						+ " transaction amount: " + userTransaction.getAmt());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.getMessage();
		}

	}

	@Override
	public void getTransactionsByaccount(long account) throws BusinessException {

		UserTransaction userTransaction = new UserTransaction(0, 0, 0, null);
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select transactionid,transactiontype,amt,account from transactions where account=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, account);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userTransaction.setTransactionid(resultSet.getLong("transactionid"));
				userTransaction.setAccountno(resultSet.getLong("account"));
				userTransaction.setTransactiontype(resultSet.getString("transactiontype"));
				userTransaction.setAmt(resultSet.getFloat("amt"));
				System.out.println("transaction id: " + userTransaction.getTransactionid() + " account number: "
						+ userTransaction.getAccountno() + " transaction type: " + userTransaction.getTransactiontype()
						+ " transaction amount: " + userTransaction.getAmt());
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void deleteCustomerAccount(long account) throws BusinessException {
		int id = getUserIdByAccount(account);
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql1 = "delete from user_details where userid =?";
			String sql2 = "delete from user_account where userid =?";
			String sql3 = "delete from transactions where account =?";
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
			preparedStatement1.setLong(1, id);
			preparedStatement2.setLong(1, id);
			preparedStatement3.setLong(1, account);
			preparedStatement3.executeUpdate();
			preparedStatement2.executeUpdate();
            preparedStatement1.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public int getUserIdByAccount(long account) throws BusinessException {
		int userid = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select userid from user_account where account=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, account);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userid = resultSet.getInt("userid");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return userid;
	}

}
