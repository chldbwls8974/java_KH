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
			// true 역할 : 쿼리 실행 후 자동으로 커밋되게 해줌. 
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
		
		// 작성자 확인
		MemberVo member = memberDao.selectMember(board.getBo_me_id());
		if(member == null) {
			return false;
		}
		
		if(boardDao.insertBoard(board)!=0) {
			// 게시글이 등록되면 회원이 작성한 게시글 수 증가
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
		
		// 게시글 번호를 이용하여 게시글을 가져옴
		BoardVo dbBoard = boardDao.selectBoard(board.getBo_number());
		
		// 게시글이 없으면 종료
		if(dbBoard == null) {
			return false;
		}
		
		// 있으면 가져온 게시글의 제목을 수정
		dbBoard.setBo_title(board.getBo_title());
		
		// 다오에게 게시글을 수정하라고 시킴
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
		
		// 게시글 번호를 이용하여 게시글을 가져옴
		BoardVo dbBoard = boardDao.selectBoard(board.getBo_number());
		
		// 게시글이 없으면 종료
		if(dbBoard == null) {
			return false;
		}
		
		// 게시글 작성자와 아이디가 다르면 종료
		if(!dbBoard.getBo_me_id().equals(board.getBo_me_id())) {
			return false;
		}
		
		// 다오에게 게시글을 삭제하라고 시킴
		if(boardDao.deleteBoard(board.getBo_number())) {
			return true;
		}
		
		return false;
	}
	
	
}
