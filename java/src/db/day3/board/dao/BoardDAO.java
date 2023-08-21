package db.day3.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import db.day3.board.vo.BoardVo;

public interface BoardDAO {

	int insertBoard(@Param("board")BoardVo board);

	List<BoardVo> selectBoardList();

	BoardVo selectBoard(@Param("bo_number")int bo_number);

	int updateBoard(@Param("board")BoardVo dbBoard);

	boolean deleteBoard(@Param("bo_number")int bo_number);

}
