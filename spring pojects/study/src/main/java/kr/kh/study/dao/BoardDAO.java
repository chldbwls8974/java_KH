package kr.kh.study.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.study.vo.BoardVO;

public interface BoardDAO {

	List<BoardVO> selectBoardList();

	BoardVO selectBoard(@Param("bo_num")Integer bo_num);

	void updateView(@Param("bo_num")Integer bo_num);

	boolean insertBoard(@Param("board")BoardVO board);

	boolean updateBoard(@Param("board")BoardVO board);

	boolean deleteBoard(@Param("board")BoardVO board);

}
