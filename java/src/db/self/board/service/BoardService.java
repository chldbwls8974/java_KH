package db.self.board.service;

import java.util.ArrayList;

import db.self.board.vo.BoardVO;

public interface BoardService {

	boolean insertBoard(String title, String id);

	ArrayList<BoardVO> getBoardList();

	boolean deleteBoard(String title, String id);
}
