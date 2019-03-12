package com.dni.web.service.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dni.web.dao.SubwayDao;
import com.dni.web.entity.Subway;
import com.dni.web.service.SubwayService;

public class MybatisSubwayService implements SubwayService{
	
	@Autowired
	private SubwayDao subwayDao;

	@Override
	public Subway getSubway(String userId) {
		return subwayDao.get(userId);
	}
	
	@Override
	public Subway getSubway(String userId, int id) {
		return subwayDao.get(userId, id);
	}

	
	@Override
	public List<Subway> getSubwayList() {
		return subwayDao.getList();
	}

	@Override
	public int addSubway(Subway subway) {
		return subwayDao.insert(subway);
	}

}
