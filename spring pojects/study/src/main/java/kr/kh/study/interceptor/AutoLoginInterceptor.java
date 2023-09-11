package kr.kh.study.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.study.service.MemberService;
import kr.kh.study.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	MemberService memberService;

	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception{
	
			HttpSession session = request.getSession();
			MemberVO user = (MemberVO)session.getAttribute("user");
		
			if(user==null) {
				Cookie cookie = WebUtils.getCookie(request, "loginCookie");
				// loginCookie 가 null이 아니면 >> 자동로그인을 하기로 하면
				if(cookie != null) {
					// 쿠키에 있는 값을 가져옴
					String session_id = cookie.getValue();
					user = memberService.getMemberBySession(session_id);
					
					//회원 정보가 있으면 세션에 저장(자동로그인 성공)
					if(user != null) {
						session.setAttribute("user", user);
					}
				}
			}
		return true;
	}
	
}
