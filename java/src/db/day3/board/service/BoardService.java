package db.day3.board.service;

import java.util.List;

import db.day3.board.vo.BoardVo;

public interface BoardService {

	boolean insertBoard(BoardVo board);

	List<BoardVo> getBoardList();

	boolean updateBoard(BoardVo board);

	boolean deleteBoard(BoardVo board);

	

}
