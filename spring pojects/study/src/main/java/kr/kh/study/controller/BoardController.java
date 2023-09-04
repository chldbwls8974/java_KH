package kr.kh.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.study.service.BoardService;
import kr.kh.study.vo.BoardVO;

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
	
	@GetMapping(value="board/detail")
	public String boardDetail(Model model , Integer bo_num) {
		boardService.updateViews(bo_num);
		BoardVO board = boardService.getBoard(bo_num);
		model.addAttribute("board",board);
		return "/board/detail";
	}
	
}
