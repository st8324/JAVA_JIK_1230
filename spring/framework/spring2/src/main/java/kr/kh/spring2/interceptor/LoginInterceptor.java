package kr.kh.spring2.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.spring2.model.vo.MemberVO;
import kr.kh.spring2.service.MemberService;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Autowired
	MemberService memberService;
	
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

		if(user == null) {
			return;
		}
		
		session.setAttribute("user", user);
		//자동 로그인을 체크안하면 종료
		if(!user.isAuto()) {
			return;
		}
		
		//쿠키를 생성. 유지시간 7일, 쿠키 이름을 LC로. 값은 세션id
		int second = 7 * 24 * 60 * 60;
		Cookie cookie = new Cookie("LC", session.getId());
		cookie.setPath("/");
		cookie.setMaxAge(second);

		//생성된 쿠키를 클라이언트에 전송
		response.addCookie(cookie);
		
		//회원 정보에 쿠키값과 만료시간을 업데이트
		int ms = second * 1000;
		long nowMs = System.currentTimeMillis() + ms; //7일후를 ms로 계산
		Date limitDate = new Date(nowMs);
		memberService.updateMemberCookie(user.getMe_id(), session.getId(), limitDate);
		
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
