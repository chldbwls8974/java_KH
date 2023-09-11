package kr.kh.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.study.dao.MemberDAO;
import kr.kh.study.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;


	@Override
	public boolean signup(MemberVO member) {
		if(member == null || member.getMe_id() == null || member.getMe_pw() ==null || member.getMe_email()==null) {
			return false;
		}
		if(!checkRegexMember(member)) {
			return false;
		}
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		if(dbMember != null) {
			return false;
		}
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		return memberDao.insertMember(member);
	}

	
	private boolean checkRegexMember(MemberVO member) {
		// 유효성 검사 필요하면 추가
		return true;
	}


	@Override
	public MemberVO login(MemberVO member) {
		if(member == null) {
			return null;
		}
		
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());		
		
		if(dbMember == null) {
			return null;
		}
		
		if( passwordEncoder.matches(member.getMe_pw(), dbMember.getMe_pw())) {
			return dbMember;
		}
		return null;
	}


	@Override
	public void updateMemberSession(MemberVO user) {
		if(user == null) {
			return;
		}
		memberDao.updateMemberSession(user);
		
	}


	@Override
	public MemberVO getMemberBySession(String session_id) {
		return memberDao.selectMemberBySession(session_id);
	}

}
