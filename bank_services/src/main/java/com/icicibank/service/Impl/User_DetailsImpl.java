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
import com.icicibank.service.User_Details;

public class User_DetailsImpl implements User_Details {

	@Override
	public User registerUser(User user) throws BusinessException {
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "insert into icicibank_db.user_details(name,pass,phone) values(?,?,?)";
	
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
			System.out.println(e);// logger
			throw new BusinessException("Internal error occured... Kindly conatct SYSADMIN........");
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
					userAccount.setUserid(resultSet.getInt(1));
				}
			} else {
				throw new BusinessException("Product Registration Failure Please Retry!!!");
			}

		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			System.out.println("Internal error occured... Kindly conatct SYSADMIN........");
			;
		}
		
		return userAccount ;
	}

	@Override
	public int checkUserid() throws BusinessException {
		
		return 0;
	}

	@Override
	public String checkUserPassword() throws BusinessException {
		
		return null;
	}
	
	
	

}
