package db.day2.board.service;

import java.sql.Connection;
import java.util.Scanner;

import db.day2.board.dao.MemberDAO;
import db.day2.board.dao.MemberMapper;
import db.day2.board.vo.MemberVO;

public class MemberServiceImp implements MemberService {

	private Connection con;
	private MemberDAO memberDao;
	
	public MemberServiceImp(Connection con, Scanner sc) {
		this.con = con;
		memberDao = new MemberMapper(con);
	}

	@Override
	public boolean signUp(String id, String pw) {

		// 아이디가 id인 회원정보를 가져옴
		MemberVO member = memberDao.getMember(id);
		
		// 회원의 수가 0 이 아니면 등록을 안하고
		if (member!= null) {
			return false;
		}
		// 0 이면 회원을 등록
		memberDao.insertMember(id,pw);
		return true;
	}

	@Override
	public boolean withdraw(String id, String pw) {
		// id 주고 회원정보 불러오기
		MemberVO member = memberDao.getMember(id);
		
		if(member != null && member.getMe_pw().equals(pw)) {
			memberDao.deleteMember(id);
			return true;
		}
		
		return false;
	}

}
