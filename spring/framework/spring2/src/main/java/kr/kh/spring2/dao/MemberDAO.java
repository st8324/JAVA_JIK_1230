package kr.kh.spring2.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring2.model.vo.MemberVO;

public interface MemberDAO {

	boolean insertMember(@Param("member")MemberVO member);

}
