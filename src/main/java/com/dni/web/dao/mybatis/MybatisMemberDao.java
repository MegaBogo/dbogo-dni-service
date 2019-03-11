package com.dni.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dni.web.dao.MemberDao;
import com.dni.web.entity.Member;

@Repository
public class MybatisMemberDao implements MemberDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(Member member) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.insert(member);
	}

	@Override
	public int update(Member member) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.update(member);
	}

	@Override
	public int delete(String id) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.delete(id);
	}

	@Override
	public Member get(String id) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.get(id);
	}

	@Override
	public List<Member> getList() {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.getList();
	}

	@Override
	public List<Member> getList(int page) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.getList(page);
	}

	@Override
	public List<Member> getList(String field, String name) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.getList(field, name);
	}

	@Override
	public List<Member> getList(String field, String name, int page) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.getList(field, name, page);
	}

	@Override
	public Member getByEmail(String email) {
		MemberDao memberDao = sqlSession.getMapper(MemberDao.class);
		return memberDao.getByEmail(email);
	}

}
