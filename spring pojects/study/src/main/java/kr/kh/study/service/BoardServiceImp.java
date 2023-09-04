package kr.kh.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.study.dao.BoardDAO;
import kr.kh.study.vo.BoardVO;
import kr.kh.study.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	private BoardDAO boardDao;

	@Override
	public List<BoardVO> getBoardList() {
		return boardDao.selectBoardList();
	}

	@Override
	public void updateViews(Integer bo_num) {
		if(bo_num == null) {
			return;
		}
		boardDao.updateView(bo_num);
		
	}

	@Override
	public BoardVO getBoard(Integer bo_num) {
		if(bo_num == null) {
			return null;
		}
		return boardDao.selectBoard(bo_num);
	}

	@Override
	public boolean insertBoard(BoardVO board, MemberVO user) {
		if(user==null || user.getMe_id() == null) {
			return false;
		}
		if(board == null || board.getBo_title() == null || board.getBo_title().length()==0) {
			return false;
		}
		board.setBo_me_id(user.getMe_id());
		boolean res = boardDao.insertBoard(board);
		return res;
	}




	
}
