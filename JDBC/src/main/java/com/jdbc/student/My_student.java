package com.jdbc.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class My_student {

	public static void main(String[] args) {
		Connection con=null;
		System.out.println("welcome to my database");
		try {
			//step 1
			Class.forName("org.postgresql.Driver");
			System.out.println("drivers loaded sucessfully");
			
			//step 2
			con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","123");   //"url","username","pass"
			System.out.println("connection successful");
			
			//step 3
			String q = "select * from mydb.student order by id ";
			Statement stmt = con.createStatement();
			ResultSet set=stmt.executeQuery(q);
			
			//step 4
			while(set.next())
			{
				int id=set.getInt("id");
				String name=set.getString("name");
				String city=set.getString("city");
				System.out.println("id: "+id);
				System.out.println("name: "+name);
				System.out.println("city: "+city);
			}
			
		} 
		catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e2) {
		
			System.out.println(e2);
		}
		
		finally {
			try {
				con.close();
			} 
			catch (SQLException e3) 
			{
				System.out.println(e3);
			}
		}
		

	}

}
