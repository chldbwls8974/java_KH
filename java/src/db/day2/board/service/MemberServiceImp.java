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

		// ���̵� id�� ȸ�������� ������
		MemberVO member = memberDao.getMember(id);
		
		// ȸ���� ���� 0 �� �ƴϸ� ����� ���ϰ�
		if (member!= null) {
			return false;
		}
		// 0 �̸� ȸ���� ���
		memberDao.insertMember(id,pw);
		return true;
	}

	@Override
	public boolean withdraw(String id, String pw) {
		// id �ְ� ȸ������ �ҷ�����
		MemberVO member = memberDao.getMember(id);
		
		if(member != null && member.getMe_pw().equals(pw)) {
			memberDao.deleteMember(id);
			return true;
		}
		
		return false;
	}

}
