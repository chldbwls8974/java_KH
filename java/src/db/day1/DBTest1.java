package db.day1;

import java.sql.*;
import java.util.Scanner;

public class DBTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Connection con = null; 
		
		
		String url = "jdbc:mysql://localhost:3306/test";
		System.out.println("DB 계정");
		String dbId = sc.next();
		System.out.println("DB 비밀번호");
		String dbPw = sc.next();
		
		// 예외처리 필수
		try {
			con = DriverManager.getConnection(url, dbId, dbPw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("연결성공");
		
		
		/*
		String sql = "insert into member(me_id,me_pw) values(?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("ID: ");
			String id = sc.next();
			System.out.println("PW: ");
			String pw = sc.next();
			
			// 쿼리에 있는 ? 대신 입력한 아이디와 비번을 넣어줌
			// setXXX(index, value) : index는 ?의 위치로 1부터 시작, value는 ? 대신 들어갈 값
			ps.setString(1, id);
			ps.setString(2, pw);
			
			int resultCount = ps.executeUpdate();
			
			if(resultCount != 0) {
				System.out.println("회원가입 성공!");
			}else {
				System.out.println("회원가입 실패!");
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
			
			System.out.print("속성의 변경 값");
			int count = sc.nextInt();
			
			ps.setInt(1, count);
			ps.setString(2, id);
			
			int resultCount = ps.executeUpdate(); // 실행이 적용된 행의 개수라서 select 문에는 적용이 불가능
			
			if(resultCount != 0) {
				System.out.println("업데이트 성공!");
			}else {
				System.out.println("업데이트 실패!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		String sql = "select * from member";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// 설정: ? 가 없어서 생략
			// 쿼리를 실행
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
		
		
		
		
		
		
		// 연결한 connection을 닫아줌
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
