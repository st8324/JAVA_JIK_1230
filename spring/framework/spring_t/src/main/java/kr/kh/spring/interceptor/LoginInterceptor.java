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

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	MemberService memberService;
	
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
		if(user == null) {
			return;
		}
		session.setAttribute("user", user);
		//자동 로그인이 체크 되어 있지 않으면 종료
		if(!user.isAuto()) {
			return;
		}
		
		//체크 되어 있으면 
		//쿠키를 생성해서 클라이언트에게 전송
		//현재 로그인 시도할 때 세션 아이디를 value로 갖는 쿠키를 생성
		Cookie cookie = new Cookie("LC", session.getId());
		cookie.setPath("/");
		int time = 60 * 60 * 24 * 7; //단위 초(7일을 초로 환산)
		cookie.setMaxAge(time);
		//response 객체에 쿠키를 담아서 전송 => 클라이언트에 쿠키가 전송
		response.addCookie(cookie);
		
		//db에 자동 로그인 정보를 저장
		user.setMe_cookie(session.getId());
		//System.currentTimeMillis() : 현재 시간을 밀리초로 반환
		//1주일 뒤의 날짜
		Date date = new Date(System.currentTimeMillis() + time * 1000);
		user.setMe_limit(date);
		memberService.updateCookie(user);
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