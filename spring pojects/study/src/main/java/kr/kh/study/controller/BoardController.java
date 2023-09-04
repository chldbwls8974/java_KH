package kr.kh.study.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.study.service.BoardService;
import kr.kh.study.util.Message;
import kr.kh.study.vo.BoardVO;
import kr.kh.study.vo.MemberVO;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	
	@GetMapping(value="/board/list")
	public String boardListPost(Model model) {
		List<BoardVO> list = boardService.getBoardList();
		model.addAttribute("list",list);
		return "/board/list";
	}
	
	@GetMapping(value="/board/detail")
	public String boardDetail(Model model , Integer bo_num) {
		boardService.updateViews(bo_num);
		BoardVO board = boardService.getBoard(bo_num);
		model.addAttribute("board",board);
		return "/board/detail";
	}
	
	@GetMapping(value="/board/insert")
	public String boardInsert() {
		return "/board/insert";
	}
	
	@PostMapping(value="/board/insert")
	public String boardInsertPost(BoardVO board, Model model,  HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		boolean res = boardService.insertBoard(board,user);
		if(res) {
			msg = new Message("/board/list", "게시글 등록 성공");
		}else
			msg = new Message("/board/insert", "게시글 등록 실패");
		
		model.addAttribute("msg",msg);
		return "/util/message";
	}
	
	@GetMapping(value="/board/update")
	public String boardUpdate(Model model, Integer bo_num) {
		BoardVO board = boardService.getBoard(bo_num);
		model.addAttribute("board",board);
		return "/board/update";
	}
	
	@PostMapping(value="/board/update")
	public String boardUpdatePost(Model model, BoardVO board, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		boolean res = boardService.updateBoard(board,user);
		if(res) {
			msg = new Message("/board/detail?bo_num="+board.getBo_num(), "게시글 수정 성공");
		}else
			msg = new Message("/board/detail?bo_num="+board.getBo_num(), "게시글 수정 실패");
		
		model.addAttribute("msg",msg);
		return "/util/message";
	}
	

	
	@GetMapping(value="/board/delete")
	public String boardDeletePost(Integer bo_num, BoardVO board, Model model, HttpSession session) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.deleteBoard(board,user);
		Message msg;
		if(res) {
			msg = new Message("/board/list", "게시글 삭제 성공");
		}else
			msg = new Message("/board/list", "게시글 삭제 실패");
		
		model.addAttribute("msg",msg);
		return "/util/message";
	}
}



















