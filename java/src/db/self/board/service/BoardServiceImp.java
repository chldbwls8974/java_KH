package db.self.board.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.self.board.dao.BoardDAO;
import db.self.board.vo.BoardVO;

public class BoardServiceImp implements BoardService{

	private BoardDAO boardDao;
	private InputStream inputStream;
	private SqlSession session;
	
	public BoardServiceImp() {
		String resource = "db/self/board/config/mybatis-config.xml";
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession();
			boardDao = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean insertBoard(String title, String id) {
		if(boardDao.insertBoard(title,id) != 0) {
			session.commit();
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<BoardVO> getBoardList() {
		// ��Ʈ�ѷ����� �ѹ� �������ֱ� ������ ���� �̷��� �� �ʿ� ���� �ٷ� ���� �ǳ�?
		//ArrayList<BoardVO> list = boardDao.selectBoardList();
		//return list;
		return boardDao.selectBoardList();
	}

	@Override
	public boolean deleteBoard(int index, String title, String id) {
		// �Խñ� ����
		BoardVO board = boardDao.getBoard(title);
		if(board != null && board.getBo_me_id().equals(id) && board.getBo_number() == index) {
			boardDao.deleteBoard(title);
			session.commit();
			return true;
		}
		return false;
	}
	
	
}
