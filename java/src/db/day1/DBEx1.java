package db.day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBEx1 {

	public static void main(String[] args) throws SQLException {
		// mysql�� ����
		
		String url = "jdbc:mysql://localhost:3306/test";
		String dbId = "root";
		String dbPw = "root";
		
		Connection con = dbConnect(url,dbId,dbPw);
		
		String id = "root";
		String pw = "root";
		//insertMember(con,id,pw);
		//deleteMember(con,id);
		//updateMember(con,id,5);
		ArrayList<Member> list = getMembers(con);
		
		for(Member tmp : list) {
			System.out.println(tmp);
		}
		
		System.out.println("sign up!!");
		
	}
	
	public static ArrayList<Member> getMembers(Connection con) throws SQLException {
		ArrayList<Member> list = new ArrayList<>();
		String sql = "select * from member";
		ResultSet rs = null;
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			String me_id = rs.getString(1);
			String me_pw = rs.getString(2);
			int me_board_count = rs.getInt(3);
			Member member = new Member(me_id,me_pw, me_board_count);
			list.add(member);
		}
		return list;
	}
	
	
	
	
	
	
	
	public static int updateMember(Connection con, String id, int count) throws SQLException {
		
		String sql = "update member set me_board_count = ? where me_id = ?";
		PreparedStatement pstmt = null;  
		pstmt= con.prepareStatement(sql);
		pstmt.setInt(1, count);
		pstmt.setString(2, id);
		return pstmt.executeUpdate();
	}
	
	
	
	
	
	public static int deleteMember(Connection con, String id) throws SQLException {
	
		String sql = "delete from member where me_id = ?";
		PreparedStatement pstmt = null;  
		pstmt= con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	
	public static int insertMember(Connection con, String id, String pw) throws SQLException {
		
		/*
		String sql = "insert into member(me_id, me_pw) values('asdasd1','asdasd1')";
			// ������ ������ �̿� ex) select * from member where me_id = 'abc123' 
		Statement stmt = null;  
		stmt = con.createStatement();
		stmt.execute(sql);
		;
		*/
	
		// ���������� �̿� ex) ��ܿ��ÿ��� where me_id = ? �� �� �� ? �´� ���� ���Ŀ� ���� 
		String sql = "insert into member(me_id, me_pw) values(?,?)";
		PreparedStatement pstmt = null;  
		pstmt= con.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		// ������ ����� ���� ������ ���� Mysql���� ���� ����� x row(s) affected ���� x�� �ش�
		return pstmt.executeUpdate();
	}
	
	
	
	public static Connection dbConnect(String url, String id, String pw) {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  // ������ ���� ��� ���� ����
			con = DriverManager.getConnection(url,id,pw);
		} catch (SQLException e) {
			System.out.println("Connection Fail!");
			return null;
		} catch (ClassNotFoundException e) { 
			System.out.println("Driver not found!");
			return null;
		}
		System.out.println("Connection success!");
		return con;
	}

}
