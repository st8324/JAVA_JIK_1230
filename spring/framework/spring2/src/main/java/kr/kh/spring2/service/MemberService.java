package kr.kh.spring2.service;

import java.util.Date;

import kr.kh.spring2.model.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	MemberVO login(MemberVO member);

	void updateMemberCookie(String me_id, String id, Date limitDate);

	MemberVO getMemberByCookie(String me_cookie);

}
