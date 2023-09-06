package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.vo.MemberVO;

public class GuestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션에 회원정보가 없으면 메인 페이지로 이동 
		// 회원 정보가 필요한 것이 아니라 있는지 없는지만 판별하면 되기 때문에 Object로 처리해줄 수 있다. 
		Object user = request.getSession().getAttribute("user");
		if(user != null) {
			// 로그인을하면 메인 페이지로 이동
			response.sendRedirect(request.getContextPath()+"/member/login");
			// 기존에 가려면 url로 방문하지 않고 메인으로 이동
			return false;
		}
		// 로그인 했으면 기존에 가려던 url을 방문해주면 됨
		return true;
	}

	
}
