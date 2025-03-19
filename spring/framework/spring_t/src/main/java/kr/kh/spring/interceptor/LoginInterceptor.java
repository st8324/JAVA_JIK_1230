package kr.kh.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	//컨트롤러에서 나올 때 가로채는 경우 호출이 됨
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		//컨트롤러가 보내준 회원 정보를 가져옴
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");
		
		//가져온 회원 정보가 있으면 세션에 회원 정보를 저장
		HttpSession session = request.getSession();
		if(user != null) {
			session.setAttribute("user", user);
		}
	}
	//컨트롤러로 들어가기전 가로채는 경우 호출이 됨
	//리턴이 true이면 가던 URL로 가서 실행
	//리턴이 false이면 가던 URL로 가지 못함. 보통 이 경우는 redirect로 다른 URL로 가라고 함.
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
			
			//구현
			return true;
	}
}