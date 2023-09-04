package kr.kh.study.service;

import java.util.List;


import kr.kh.study.vo.BoardVO;
import kr.kh.study.vo.MemberVO;

public interface BoardService {

	List<BoardVO> getBoardList();

	void updateViews(Integer bo_num);

	BoardVO getBoard(Integer bo_num);

	boolean insertBoard(BoardVO board, MemberVO user);

	boolean updateBoard(BoardVO board, MemberVO user);

	boolean deleteBoard(BoardVO board, MemberVO user);



}
