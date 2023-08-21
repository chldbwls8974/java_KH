package db.day3.board.service;

import db.day3.board.vo.MemberVo;

public interface MemberService {

	boolean signUp(MemberVo member);

	boolean withdraw(MemberVo member);

}
