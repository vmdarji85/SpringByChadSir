package com.vivek.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;


public class TestJdbc {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/hb_student_tracker?serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		
		try {
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Successful !!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
