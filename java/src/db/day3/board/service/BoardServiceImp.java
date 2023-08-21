package db.day3.board.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.day3.board.dao.BoardDAO;
import db.day3.board.dao.MemberDAO;
import db.day3.board.vo.BoardVo;
import db.day3.board.vo.MemberVo;

public class BoardServiceImp implements BoardService {
	private BoardDAO boardDao;
	private MemberDAO memberDao;
	private final String MYBATIS_CONFIG_PATH="db/day3/board/config/mybatis-config.xml";
	
	public BoardServiceImp() {
		try {
			InputStream is = Resources.getResourceAsStream(MYBATIS_CONFIG_PATH);
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			// true ���� : ���� ���� �� �ڵ����� Ŀ�Եǰ� ����. 
			SqlSession session = sf.openSession(true);
			boardDao = session.getMapper(BoardDAO.class);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			System.out.println("failed");
		}
	}

	@Override
	public boolean insertBoard(BoardVo board) {
		if(board == null || board.getBo_me_id() == null || board.getBo_title() == null) {
		return false;
		}
		
		// �ۼ��� Ȯ��
		MemberVo member = memberDao.selectMember(board.getBo_me_id());
		if(member == null) {
			return false;
		}
		
		if(boardDao.insertBoard(board)!=0) {
			// �Խñ��� ��ϵǸ� ȸ���� �ۼ��� �Խñ� �� ����
			memberDao.updateBoardCount(board.getBo_me_id());
			return true;
		}
		return false;
	}

	@Override
	public List<BoardVo> getBoardList() {
		return boardDao.selectBoardList();
	}

	@Override
	public boolean updateBoard(BoardVo board) {
		if(board == null || board.getBo_title() == null) {
			return false;
		}
		
		// �Խñ� ��ȣ�� �̿��Ͽ� �Խñ��� ������
		BoardVo dbBoard = boardDao.selectBoard(board.getBo_number());
		
		// �Խñ��� ������ ����
		if(dbBoard == null) {
			return false;
		}
		
		// ������ ������ �Խñ��� ������ ����
		dbBoard.setBo_title(board.getBo_title());
		
		// �ٿ����� �Խñ��� �����϶�� ��Ŵ
		if(boardDao.updateBoard(dbBoard) != 0) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean deleteBoard(BoardVo board) {
		if(board == null || board.getBo_me_id() == null) {
			return false;
		}
		
		// �Խñ� ��ȣ�� �̿��Ͽ� �Խñ��� ������
		BoardVo dbBoard = boardDao.selectBoard(board.getBo_number());
		
		// �Խñ��� ������ ����
		if(dbBoard == null) {
			return false;
		}
		
		// �Խñ� �ۼ��ڿ� ���̵� �ٸ��� ����
		if(!dbBoard.getBo_me_id().equals(board.getBo_me_id())) {
			return false;
		}
		
		// �ٿ����� �Խñ��� �����϶�� ��Ŵ
		if(boardDao.deleteBoard(board.getBo_number())) {
			return true;
		}
		
		return false;
	}
	
	
}
