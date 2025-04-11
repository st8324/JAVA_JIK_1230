package kr.kh.spring2.service;

import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring2.dao.MemberDAO;
import kr.kh.spring2.model.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;

	@Autowired
	PasswordEncoder passwordEncoder1;
	
	@Override
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		if(member.getMe_id() == null || !Pattern.matches("^[a-zA-Z0-9]{3,13}$", member.getMe_id())) {
			return false;
		}
		if(member.getMe_pw() == null || !Pattern.matches("^[a-zA-Z0-9!@#$]{3,15}$", member.getMe_pw())) {
			return false;
		}
		try {
			String encPw = passwordEncoder1.encode(member.getMe_pw());
			member.setMe_pw(encPw);
			return memberDao.insertMember(member);
		}catch(Exception e) {
			e.printStackTrace();
			//중복검사 안했을 경우
			return false;
		}
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null) {
			return null;
		}
		//아이디를 이용하여 회원 정보를 가져옴. 왜? => 암호화된 비번과 암호화 안된 비번을 비교해야 하기 때문에
		MemberVO user = memberDao.selectMember(member.getMe_id());
		//아이디 불일치
		if(user == null) {
			return null;
		}
		//비번 불일치
		if(!passwordEncoder1.matches(member.getMe_pw(), user.getMe_pw())) {
			return null;
		}
		return user;
	}

	@Override
	public void updateMemberCookie(String me_id, String me_cookie, Date me_limit) {
		memberDao.updateMemberCookie(me_id, me_cookie, me_limit );
	}

	@Override
	public MemberVO getMemberByCookie(String me_cookie) {
		if(me_cookie == null) {
			return null;
		}
		return memberDao.selectMemberByCookie(me_cookie);
	}
}
