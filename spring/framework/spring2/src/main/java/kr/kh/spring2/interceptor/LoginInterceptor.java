package kr.kh.spring2.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring2.model.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView mv)
	    throws Exception {
		 //구현   
		MemberVO user = (MemberVO)mv.getModel().get("user");
		HttpSession session = request.getSession();
		if(user != null) {
			session.setAttribute("user", user);
		}
	}
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, 
			Object handler)
			throws Exception {
			
		//구현
		System.out.println("인터센터 : 컨트롤러에 들어가기 전");
		return true;
	}
}
