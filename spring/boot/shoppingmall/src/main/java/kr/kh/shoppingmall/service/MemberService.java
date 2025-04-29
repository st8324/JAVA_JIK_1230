package kr.kh.shoppingmall.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.shoppingmall.dao.MemberDAO;
import kr.kh.shoppingmall.model.vo.MemberVO;

@Service
public class MemberService {
	
	@Autowired
	MemberDAO memberDAO;

	@Autowired
	PasswordEncoder passwordEncoder;

	public boolean signup(MemberVO member) {
		if(member == null){
			return false;
		}
		//아이디 정규 표현식 확인
		if(!Pattern.matches("^[a-zA-Z0-9]{3,12}$", member.getMe_id())){
			return false;
		}
		//비번 정규 표현식 확인
		if(!Pattern.matches("^[a-zA-Z0-9!@#$]{3,12}$", member.getMe_pw())){
			return false;
		}
		//전화번호 정규 표현식 확인
		if(!Pattern.matches("^0\\d{1,2}-\\d{3,4}-\\d{4}$", member.getMe_number())){
			return false;
		}
		//이메일 정규 표현식 확인
		if(!Pattern.matches("^[A-Za-z0-9\\._]+@[A-Za-z0-9]+(\\.[A-Za-z]{2,})+$", member.getMe_email())){
			return false;
		}
		//비번 암호화
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		//가입된 아이디 확인
		if(memberDAO.selectMember(member.getMe_id()) != null)	{
			return false;
		}
		return memberDAO.insertMember(member);
	}

	public boolean checkId(String id) {
		return memberDAO.selectMember(id) == null;
	}

}
