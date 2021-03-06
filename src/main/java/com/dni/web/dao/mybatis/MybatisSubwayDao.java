package com.dni.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dni.web.dao.SubwayDao;
import com.dni.web.entity.Member;
import com.dni.web.entity.Subway;

@Repository
public class MybatisSubwayDao implements SubwayDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int insert(Subway subway) {
		SubwayDao subwayDao = sqlSession.getMapper(SubwayDao.class);
		return subwayDao.insert(subway);
	}

	@Override
	public int update(Subway subway) {
		SubwayDao subwayDao = sqlSession.getMapper(SubwayDao.class);
		return subwayDao.insert(subway);
	}

	@Override
	public int delete(int id) {
		SubwayDao subwayDao = sqlSession.getMapper(SubwayDao.class);
		return subwayDao.delete(id);
	}

	@Override
	public Subway get(String regUserId) {
		SubwayDao subwayDao = sqlSession.getMapper(SubwayDao.class);
		return subwayDao.get(regUserId);
	}
	
	@Override
	public Subway get(String regUserId, int id) {
		SubwayDao subwayDao = sqlSession.getMapper(SubwayDao.class);
		return subwayDao.get(regUserId);
	}

	@Override
	public List<Subway> getList() {
		SubwayDao subwayDao = sqlSession.getMapper(SubwayDao.class);
		return subwayDao.getList();
	}

	
	@Override
	public List<Subway> getList(int page) {
		SubwayDao subwayDao = sqlSession.getMapper(SubwayDao.class);
		return subwayDao.getList(page);
	}

	@Override
	public List<Subway> getList(String field, String name) {
		SubwayDao subwayDao = sqlSession.getMapper(SubwayDao.class);
		return subwayDao.getList(field, name);
	}

	@Override
	public List<Subway> getList(String field, String name, int page) {
		SubwayDao subwayDao = sqlSession.getMapper(SubwayDao.class);
		return subwayDao.getList(field, name, page);
	}

}
