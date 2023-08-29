package kr.kh.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.study.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/test")
	public String test() {
		int count = memberService.count();
		System.out.println(count);
		return "redirect:/"; //메인페이지로 바꿔주는 redirect
	}
	
}
