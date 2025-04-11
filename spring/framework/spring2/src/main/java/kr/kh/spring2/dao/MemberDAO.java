package kr.kh.spring2.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring2.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("member")MemberVO member);

	MemberVO selectMember(@Param("me_id")String me_id);

	void updateMemberCookie(@Param("me_id")String me_id, @Param("me_cookie")String me_cookie, @Param("me_limit")Date me_limit);

	MemberVO selectMemberByCookie(@Param("me_cookie")String me_cookie);

}
