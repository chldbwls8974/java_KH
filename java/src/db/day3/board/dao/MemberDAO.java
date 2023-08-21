package db.day3.board.dao;

import org.apache.ibatis.annotations.Param;

import db.day3.board.vo.MemberVo;

public interface MemberDAO {

	MemberVo selectMember(@Param("me_id")String me_id);

	void insertMember(@Param("member")MemberVo member);

	// �Ű������� Param�� �ٿ������� �ƴҶ��� ���̸� �����ֱ� ���� insertMember2
	void insertMember2(MemberVo member);

	void deleteMember(@Param("me_id")String me_id);

	void updateBoardCount(@Param("me_id")String me_id);

}
