package kr.kh.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.service.MemberService;
import kr.kh.spring.util.Message;
import kr.kh.spring.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired // 객체 만들어주는 annotation, dynamic과 다르게 이렇게 @ 만 붙여줘도 됨.
	private MemberService memberService;
	
	// url 과 연결해주는 @
	// dynamic과 다르게 get post를 하나의 메서드로 통일하여 사용이 가능
	@RequestMapping(value="/member/signup", method=RequestMethod.GET)
	public String signup() {
		return "member/signup";
	}
	
	@RequestMapping(value="/member/signup", method=RequestMethod.POST)
	public String signupPost(MemberVO member, Model model) {
		Message msg = new Message("/member/signup","회원가입 실패");
		if(memberService.signup(member)) {
			msg = new Message("/member/signup","회원가입 성공");
		}
		
		model.addAttribute("msg",msg);
		return "message";
	}
	
	
	
	@GetMapping(value="/member/login")
	public String memberlogin() {
		return "member/login";
	}
	
	// model은 화면에 전송해줄때 사용
	@PostMapping(value="/member/login")
	public String memberLoginPost(MemberVO member, Model model) {
		Message msg = new Message("/member/login","로그인 실패");
		MemberVO user = memberService.login(member);
		
		if(user!=null) {
			msg = new Message("/","로그인 성공");
		}
		model.addAttribute("user",user);
		model.addAttribute("msg",msg);
		return "message";
	}
	
	
	@GetMapping(value="/member/logout")
	public String memberLogout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberVO user =(MemberVO)session.getAttribute("user");
		Message msg = new Message("/",null);
		
		if(user != null) {
			session.removeAttribute("user");
			msg.setMsg("로그아웃 성공");
		}
		model.addAttribute("msg",msg);
		
		return "message";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}