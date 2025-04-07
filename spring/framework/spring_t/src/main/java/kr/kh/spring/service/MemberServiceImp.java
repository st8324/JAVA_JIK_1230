package kr.kh.spring.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		//아이디 정규 표현식 체크
		
		//비번 정규 표현식 체크
		
		//이메일 정규 표현식 체크
		
		//가입된 아이디인지 확인
		MemberVO user = memberDao.selectMember(member.getMe_id());
		if(user != null) {
			return false;
		}
		
		//암호화
		String encodedPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encodedPw);
		return memberDao.insertMember(member);
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null) {
			return null;
		}
		MemberVO user = memberDao.selectMember(member.getMe_id());
		//아이디가 일치하지 않을 때 
		if(user == null) {
			return null;
		}
		//비번이 일치하지 않을 때
		if(!passwordEncoder.matches(member.getMe_pw(), user.getMe_pw())) {
			return null;
		}
		
		//아이디 비번이 다 일치할 때
		return user;
	}

	@Override
	public boolean checkId(String id) {
		MemberVO user = memberDao.selectMember(id);
		return user == null;
	}

	@Override
	public void updateCookie(MemberVO user) {
		memberDao.updateCookie(user);
	}

	@Override
	public MemberVO getMemberByCookie(String cookieId) {
		return memberDao.selectMemberByCookie(cookieId);
	}

	@Override
	public boolean findPw(String id) {
		MemberVO user = memberDao.selectMember(id);
		if(user == null) {
			return false;
		}
		try {
			//새 비번을 생성
			String newPw = createPw(8);
			//새 비번을 이메일로 전송
			boolean res = 
				mailSend(user.getMe_email(), 
						"새 비밀번호입니다.", 
						"새 비밀번호는 <b>"+newPw+"</b> 입니다.");
			if(!res) {
				return false;
			}
			//새 비번으로 db에 업데이트
			newPw = passwordEncoder.encode(newPw);
			memberDao.updatePw(user.getMe_id(), newPw);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private String createPw(int size) {
		String pw = "";
		if(size < 3) {
			return null;
		}
		while(pw.length() < size) {
			//랜덤으로 정수를 생성(0~61)
			int r = (int)(Math.random()*62);
			
			//0~9이면 문자0~9로 맵핑 후 이어붙임
			if(r < 10) {
				pw += r;
			}
			//10~35이면 a~z로 맵핑 후 이어붙임
			else if(r < 36) {
				pw += (char)(r - 10 + 'a');
			}
			//36~61이면 A~Z로 맵핑 후 이어붙임
			else {
				pw += (char)(r - 36 + 'A');
			}
			
		}
		return pw;
	}

	private boolean mailSend(String to, String title, String content) {

	    String setfrom = "stajun@naver.com";
	   try{
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper
	            = new MimeMessageHelper(message, true, "UTF-8");

	        messageHelper.setFrom(setfrom);// 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(to);// 받는사람 이메일
	        messageHelper.setSubject(title);// 메일제목은 생략이 가능하다
	        messageHelper.setText(content, true);// 메일 내용

	        mailSender.send(message);
	        return true;
	    } catch(Exception e){
	        e.printStackTrace();
	        return false;
	    }
	}
}
