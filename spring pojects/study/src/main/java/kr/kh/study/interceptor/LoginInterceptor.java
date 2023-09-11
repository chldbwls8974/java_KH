package kr.kh.study.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.study.service.MemberService;
import kr.kh.study.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	MemberService memberService;

	@Override
	public void postHandle(
		HttpServletRequest request,
		HttpServletResponse respose,
		Object handler,
		ModelAndView mv){
			
		MemberVO user = (MemberVO)mv.getModel().get("user");
		
		if(user != null) {
			request.getSession().setAttribute("user", user);
			
			// 자동로그인을 체크한 경우 user 의 isAutoLogin이 참이면
			if(user.isAutoLogin()) {
				// 쿠키를 생성
				// 쿠키에는 loginCookie 라는 이름에 세션아이디를 넣어줌
				Cookie cookie = new Cookie("loginCookie", request.getSession().getId());
				cookie.setPath("/"); // 경로는 메인으로
				int day = 7;
				int time = 60 * 60 * 24 * day; // time은 단위가 sec
				cookie.setMaxAge(time); // 세션 만료 기간은 1주일로, 
				respose.addCookie(cookie);
				
				// 쿠키에 넣은 정보를 db에도 추가
				user.setMe_session_id(request.getSession().getId());
				Date date = new Date(System.currentTimeMillis() + time * 1000);
				user.setMe_session_limit(date);
				memberService.updateMemberSession(user);
			}
		}
	}
	
}
