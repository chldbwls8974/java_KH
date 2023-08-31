package kr.kh.study.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.kh.study.service.MemberService;
import kr.kh.study.util.Message;
import kr.kh.study.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	
	@GetMapping(value="/member/signup")
	public String signup() {
		return "member/signup";
	}
	
	@PostMapping(value="/member/signup")
	public String signupPost(MemberVO member, Model model) {
		Message msg = new Message("/member/signup","회원가입 실패");
		if(memberService.signup(member)) {
			msg = new Message("/member/signup","회원가입 성공");
		}
		
		model.addAttribute("msg",msg);
		return "/util/message";
	}
	
	@GetMapping(value="/member/login")
	public String login() {
		return "member/login";
	}
	
	@PostMapping(value="/member/login")
	public String loginPost(Model model, MemberVO member) {
		Message msg = new Message("/member/login","로그인 실패");
		MemberVO user = memberService.login(member);
		
		if(user!=null) {
			msg = new Message("/","로그인 성공");
		}
		model.addAttribute("user",user);
		model.addAttribute("msg",msg);
		return "/util/message";
	}
	
	@RequestMapping(value="/member/logout")
	public String logout(HttpServletRequest request, Model model) {
		Message msg = new Message("/","로그아웃 성공");
		request.getSession().setAttribute("user", null);
		model.addAttribute("msg",msg);
		return "/util/message";
	}
	
}
