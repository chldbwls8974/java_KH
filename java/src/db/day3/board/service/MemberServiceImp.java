package db.day3.board.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.day3.board.dao.MemberDAO;
import db.day3.board.vo.MemberVo;

public class MemberServiceImp implements MemberService {
	private MemberDAO memberDao;
	private final String MYBATIS_CONFIG_PATH="db/day3/board/config/mybatis-config.xml";
	
	public MemberServiceImp() {
		try {
			InputStream is = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			// true ���� : ���� ���� �� �ڵ����� Ŀ�Եǰ� ����. 
			SqlSession session = sf.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			System.out.println("failed");
		}
	}

	@Override
	public boolean signUp(MemberVo member) {
		// controller ���忡���� �Ű������� ������ ������
		// service ���忡���� �޾Ҵ��� �ȹ޾Ҵ��� �𸣱� ������ �Ű������� ����� ���Դ��� Ȯ�����ִ� �۾�
		if(member == null || member.getMe_id() == null) {
			return false;
		}
		// ���̵� �ߺ�üũ => ���̵�� ��ġ�ϴ� ȸ�� ������ ��ȸ�ؼ� ������
		MemberVo dbMember = memberDao.selectMember(member.getMe_id());
		// ���̵� �ߺ����� ������ ȸ������ ����
		if(dbMember == null) {
			memberDao.insertMember2(member);
			return true;
		}
		return false;
	}

	@Override
	public boolean withdraw(MemberVo member) {
		if(member == null || member.getMe_id() == null) {
			return false;
		}
		// ���̵� �̿��Ͽ� ȸ�� ������ ������
		MemberVo dbMember = memberDao.selectMember(member.getMe_id());
		
		// ������ ȸ�� ������ ����� �Է¹��� ����� ������ ����, �ٸ��� �������� ����
		if(dbMember != null && dbMember.getMe_pw().equals(member.getMe_pw())) {
			memberDao.deleteMember(member.getMe_id());
			return true;
		}
		
		return false;
	}

	
}
