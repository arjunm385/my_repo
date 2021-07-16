package com.icicibank.DAO.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.icicibank.DAO.Icicibank_DAO;
import com.icicibank.dbutil.PostgresConnection;
import com.icicibank.exceptions.BusinessException;
import com.icicibank.model.User;
import com.icicibank.model.UserAccount;
import com.icicibank.model.UserTransaction;

public class Icicibank_DAOImpl implements Icicibank_DAO {
	
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
