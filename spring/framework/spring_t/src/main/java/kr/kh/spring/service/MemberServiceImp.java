package kr.kh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
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

}
