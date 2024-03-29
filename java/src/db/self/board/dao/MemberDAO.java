package db.self.board.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import db.self.board.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(String id);

	// 매개변수가 2개 이상이면 param을 붙여줘야함.
	void insertMember(@Param("id")String id,@Param("pw") String pw);

	void deleteMember(String id);

	ArrayList<MemberVO> selectMemberList();

}
