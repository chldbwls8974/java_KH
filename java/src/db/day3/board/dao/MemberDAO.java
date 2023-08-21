package db.day3.board.dao;

import org.apache.ibatis.annotations.Param;

import db.day3.board.vo.MemberVo;

public interface MemberDAO {

	MemberVo selectMember(@Param("me_id")String me_id);

	void insertMember(@Param("member")MemberVo member);

	// 매개변수에 Param을 붙였을때와 아닐때의 차이를 보여주기 위한 insertMember2
	void insertMember2(MemberVo member);

	void deleteMember(@Param("me_id")String me_id);

	void updateBoardCount(@Param("me_id")String me_id);

}
