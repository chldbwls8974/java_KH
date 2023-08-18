package db.self.board.service;

public interface MemberService {

	boolean signUp(String id, String pw);

	boolean withdraw(String id, String pw);

}
