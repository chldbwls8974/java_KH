package db.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBEx1 {

	public static void main(String[] args) {
		// mysql�� ����
		
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// url : jdbc:dbms ����: //url �ּ�
			// ����
			// ���
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
		} catch (SQLException e) {
			System.out.println("Connection Fail!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) { 
			System.out.println("Driver not found!");
			e.printStackTrace();
		}
		System.out.println("Connection success!");
	}

}
