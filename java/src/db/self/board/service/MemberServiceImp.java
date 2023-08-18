package db.self.board.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.self.board.dao.MemberDAO;
import db.self.board.vo.MemberVO;

public class MemberServiceImp implements MemberService {

	private MemberDAO memberDao;
	private InputStream inputStream;
	private SqlSession session;
	
	public MemberServiceImp() {
		String resource = "db/self/board/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession();
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		session.commit();
		//ȸ�� ����� ��ȸ
		ArrayList<MemberVO> list = memberDao.selectMemberList();
		for(MemberVO tmp : list) {
			System.out.println(tmp);
		}
		return true;
	}

	@Override
	public boolean withdraw(String id, String pw) {
		// id �ְ� ȸ������ �ҷ�����
		MemberVO member = memberDao.getMember(id);
		
		if(member != null && member.getMe_pw().equals(pw)) {
			memberDao.deleteMember(id);
			session.commit();
			return true;
		}
		
		return false;
	}

}
