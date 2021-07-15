package com.icicibank.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.icicibank.dbutil.PostgresConnection;
import com.icicibank.exceptions.BusinessException;
import com.icicibank.model.User;
import com.icicibank.model.UserAccount;
import com.icicibank.model.UserTransaction;
import com.icicibank.service.User_Details;

public class User_DetailsImpl implements User_Details {

	@Override
	public User registerUser(User user) throws BusinessException {
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into user_details(name,pass,phone) values(?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, user.getCustname());
			preparedStatement.setString(2, user.getPass());
			preparedStatement.setString(3, user.getPhone());
			int c = preparedStatement.executeUpdate();
			if (c == 1) {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					user.setUserid(resultSet.getInt(1));
				}
			} else {
				throw new BusinessException("Product Registration Failure Please Retry!!!");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured... Kindly conatct SYSADMIN........");
		} catch (BusinessException e) {
			e.getMessage();
		}

		return user;

	}

	@Override
	public UserAccount registerUserAccount(UserAccount userAccount) throws BusinessException {

		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into user_account(userid,name,pan,aadhar,balance,city,state,status,pincode) values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setInt(1, userAccount.getUserid());
			preparedStatement.setString(2, userAccount.getName());
			preparedStatement.setString(3, userAccount.getPan());
			preparedStatement.setString(4, userAccount.getAadhar());
			preparedStatement.setFloat(5, userAccount.getBalance());
			preparedStatement.setString(6, userAccount.getCity());
			preparedStatement.setString(7, userAccount.getState());
			preparedStatement.setBoolean(8, userAccount.isStatus());
			preparedStatement.setString(9, userAccount.getPincode());
			int c = preparedStatement.executeUpdate();
			if (c == 1) {
				ResultSet resultSet = preparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					userAccount.setAccount(resultSet.getLong(10));
				}
			} else {
				throw new BusinessException("Product Registration Failure Please Retry!!!");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		return userAccount;
	}

	@Override
	public boolean checkUserid(int id) throws BusinessException {
		boolean a=false;
		int id1 = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select userid from user_details where userid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id1 = resultSet.getInt("userid");
			}
			
			if(id==id1)
				a=true;
			else
				a=false;
			
		} catch (SQLException e) {
		e.getMessage();
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}

		return a;
	}

	@Override
	public boolean checkUserPassword(String password, int id) throws BusinessException {
		boolean a = false;
		String pass = null;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select pass from user_details where userid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				pass = resultSet.getString("pass");
			}
			
			if(pass.equals(password))
				a=true;
			
			else
				a=false;
			
		} catch (SQLException e) {
		e.getMessage();
		} catch (ClassNotFoundException e) {
			e.getMessage();
		}

		return a;

	}

	@Override
	public float checkBalance(long account) throws BusinessException {
		float bal = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select balance from user_account where account=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, account);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			 {
			  bal=resultSet.getFloat("balance");
			 }
		}
		catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		return bal;
	}

	@Override
	public long getAccountNumber(int id) throws BusinessException {
		
		long account = 0;
		
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select account from user_account where userid=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			 {
			  account=resultSet.getLong("account");
			 }
		}
		catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		return account;
		
	}

	@Override
	public void addBal(float amount, float prevamount, long account) throws BusinessException {

		String t_type="deposited";
		txnAdd(t_type, account, amount);
		float tamt = amount+prevamount;
		try (Connection connection = PostgresConnection.getConnection()) 
		{
			String sql = "update user_account set balance=? where account=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setFloat(1, tamt);
			preparedStatement.setLong(2, account);
			preparedStatement.executeUpdate();
		}
		catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		
		
	}

	@Override
	public void txnAdd(String t_type, long account, float amount) throws BusinessException {
		
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into transactions(account,amt,transactiontype) values(?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setLong(1,account);
			preparedStatement.setFloat(2, amount);
			preparedStatement.setString(3,t_type);
			preparedStatement.executeUpdate();
//			preparedStatement.getGeneratedKeys();
		
	}
		catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
	}

	@Override
	public void withdrawBal(float amt, float pamt, long acc) throws BusinessException {

		
		String t_type="Withdrawl";
		txnWithdraw(t_type, acc, amt);
		float tamt = pamt-amt;
		try (Connection connection = PostgresConnection.getConnection()) 
		{
			String sql = "update user_account set balance=? where account=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setFloat(1, tamt);
			preparedStatement.setLong(2, acc);
			preparedStatement.executeUpdate();
		}
		catch (ClassNotFoundException e) {
			e.getMessage();
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}

	@Override
	public void txnWithdraw(String t_type, long account, float amount) throws BusinessException {
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into transactions(account,amt,transactiontype) values(?,?,?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setLong(1,account);
			preparedStatement.setFloat(2, amount);
			preparedStatement.setString(3,t_type);
			preparedStatement.executeUpdate();
	
	}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.getMessage();
		}
		
	}

	@Override
	public UserTransaction getTxnDetails(long acc , UserTransaction userTransaction) throws BusinessException {
      
		
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select transactionid,transactiontype,amt from transactions where account=? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1,acc);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			 {
				
				userTransaction.setTransactionid(resultSet.getLong("transactionid"));
				userTransaction.setTransactiontype(resultSet.getString("transactiontype"));
				userTransaction.setAmt(resultSet.getFloat("amt"));
				System.out.println("transaction id: "+userTransaction.getTransactionid()+" transaction type: "+userTransaction.getTransactiontype()+" transaction amount: "+userTransaction.getAmt());
				}

		
	}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.getMessage();
		}
		
		return null;
	}
}
