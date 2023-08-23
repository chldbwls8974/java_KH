package kr.kh.app.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.kh.app.dao.BoardDAO;
import kr.kh.app.dao.MemberDAO;

public class BoardServiceImp implements BoardService {
	private BoardDAO boardDao;
	private MemberDAO memberDao;
	private final String MYBATIS_CONFIG_PATH="kr/kh/app/config/mybatis-config.xml";
	
	public BoardServiceImp() {
		try {
			InputStream is = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			// true 역할 : 쿼리 실행 후 자동으로 커밋되게 해줌. 
			SqlSession session = sf.openSession(true);
			boardDao = session.getMapper(BoardDAO.class);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			System.out.println("failed");
		}
	}
}
