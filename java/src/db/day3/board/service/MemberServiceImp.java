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
			// true 역할 : 쿼리 실행 후 자동으로 커밋되게 해줌. 
			SqlSession session = sf.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			System.out.println("failed");
		}
	}

	@Override
	public boolean signUp(MemberVo member) {
		// controller 입장에서는 매개변수가 무조건 있지만
		// service 입장에서는 받았는지 안받았는지 모르기 때문에 매개변수가 제대로 들어왔는지 확인해주는 작업
		if(member == null || member.getMe_id() == null) {
			return false;
		}
		// 아이디 중복체크 => 아이디와 일치하는 회원 정보를 조회해서 가져옴
		MemberVo dbMember = memberDao.selectMember(member.getMe_id());
		// 아이디가 중복되지 않으면 회원가입 진행
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
		// 아이디를 이용하여 회원 정보를 가져옴
		MemberVo dbMember = memberDao.selectMember(member.getMe_id());
		
		// 가져온 회원 정보의 비번과 입력받은 비번이 같으면 삭제, 다르면 삭제하지 않음
		if(dbMember != null && dbMember.getMe_pw().equals(member.getMe_pw())) {
			memberDao.deleteMember(member.getMe_id());
			return true;
		}
		
		return false;
	}

	
}
