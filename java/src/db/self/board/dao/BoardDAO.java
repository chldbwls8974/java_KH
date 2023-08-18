package db.self.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import db.self.board.vo.BoardVO;

public interface BoardDAO {

	int insertBoard(@Param("title")String title, @Param("id")String id);


	ArrayList<BoardVO> selectBoardList();


	BoardVO getBoard(String title);


	void deleteBoard(String title);

}
