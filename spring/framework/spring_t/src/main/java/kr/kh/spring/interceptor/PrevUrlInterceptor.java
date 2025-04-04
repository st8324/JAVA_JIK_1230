package kr.kh.spring.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring.model.vo.MemberVO;
import kr.kh.spring.service.MemberService;
import lombok.extern.log4j.Log4j;

@Log4j
public class PrevUrlInterceptor extends HandlerInterceptorAdapter{
	
	//컨트롤러에서 나올 때 가로채는 경우 호출이 됨
	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
				
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		if(user == null) {
			return;
		}
		//이전 URL을 가져옴
		String prevUrl = (String)session.getAttribute("prevUrl");
		log.info(prevUrl);
		if(prevUrl == null) {
			return;
		}
		
		response.sendRedirect(prevUrl);
		session.removeAttribute("prevUrl");
		return;
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