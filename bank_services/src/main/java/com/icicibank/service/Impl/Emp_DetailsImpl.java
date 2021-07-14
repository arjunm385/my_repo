package com.icicibank.service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.icicibank.service.Emp_Details;
import com.icicibank.dbutil.PostgresConnection;
import com.icicibank.model.Emp;

public class Emp_DetailsImpl implements Emp_Details {

	@Override
	public int checkEmpUid() {

		int id = 0;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select user_id from emp_details";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			 {
			  id=resultSet.getInt("user_id");
			 }
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			while(resultSet.next())
			 {
			  pass=resultSet.getString("password");
			 }
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			while(resultSet.next())
			 {
			  name=resultSet.getString("name");
			 }
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	
	}

}
