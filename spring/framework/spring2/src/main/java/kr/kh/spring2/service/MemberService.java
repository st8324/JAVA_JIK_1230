package kr.kh.spring2.service;

import kr.kh.spring2.model.vo.MemberVO;

public interface MemberService {

	boolean signup(MemberVO member);

	MemberVO login(MemberVO member);

}
