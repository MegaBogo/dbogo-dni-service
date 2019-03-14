package com.dni.web.service.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dni.web.dao.MemberDao;
import com.dni.web.entity.Member;
import com.dni.web.service.MemberService;

public class MybatisMemberService implements MemberService {

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member getMember(String id) {
		return memberDao.get(id);
	}

	@Override
	public List<Member> getMemberList() {
		return memberDao.getList();
	}

	@Override
	public int addMember(Member member) {
		return memberDao.insert(member);
	}

	@Override
	public boolean isEmailDuplicated(String email) {
		Member member = memberDao.getByEmail(email);
		
		if(member != null)
			return true;
		
		return false;
	}

	@Override
	public boolean isIdDuplicated(String id) {
		Member member = memberDao.get(id);
		if(member != null) 
			return true;
		
		return false;
	}

}
