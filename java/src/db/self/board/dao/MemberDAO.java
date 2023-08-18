package db.self.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import db.self.board.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(String id);

	// �Ű������� 2�� �̻��̸� param�� �ٿ������.
	void insertMember(@Param("id")String id,@Param("pw") String pw);

	void deleteMember(String id);

	ArrayList<MemberVO> selectMemberList();

}
