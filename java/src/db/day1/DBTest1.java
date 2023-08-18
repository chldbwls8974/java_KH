package db.day1;

import java.sql.*;
import java.util.Scanner;

public class DBTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Connection con = null; 
		
		
		String url = "jdbc:mysql://localhost:3306/test";
		System.out.println("DB ����");
		String dbId = sc.next();
		System.out.println("DB ��й�ȣ");
		String dbPw = sc.next();
		
		// ����ó�� �ʼ�
		try {
			con = DriverManager.getConnection(url, dbId, dbPw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("���Ἲ��");
		
		
		/*
		String sql = "insert into member(me_id,me_pw) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("ID: ");
			String id = sc.next();
			System.out.println("PW: ");
			String pw = sc.next();
			
			// ������ �ִ� ? ��� �Է��� ���̵�� ����� �־���
			// setXXX(index, value) : index�� ?�� ��ġ�� 1���� ����, value�� ? ��� �� ��
			ps.setString(1, id);
			ps.setString(2, pw);
			
			int resultCount = ps.executeUpdate();
			
			if(resultCount != 0) {
				System.out.println("ȸ������ ����!");
			}else {
				System.out.println("ȸ������ ����!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		
		/*
		String sql = "update member set me_board_count = ? where me_id = ?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.print("id");
			String id = sc.next();
			
			System.out.print("�Ӽ��� ���� ��");
			int count = sc.nextInt();
			
			ps.setInt(1, count);
			ps.setString(2, id);
			
			int resultCount = ps.executeUpdate(); // ������ ����� ���� ������ select ������ ������ �Ұ���
			
			if(resultCount != 0) {
				System.out.println("������Ʈ ����!");
			}else {
				System.out.println("������Ʈ ����!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		String sql = "select * from member";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// ����: ? �� ��� ����
			// ������ ����
			ResultSet resultSet = ps.executeQuery();
			
			while(resultSet.next()) {
				String id = resultSet.getString(1);
				String pw = resultSet.getString(2);
				int boardCount = resultSet.getInt(3);
				
				System.out.println(id  + " : " + pw + " : " + boardCount);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		// ������ connection�� �ݾ���
		try {
			if(con != null && !con.isClosed()) {
				con.close();
			}
		
			sc.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
