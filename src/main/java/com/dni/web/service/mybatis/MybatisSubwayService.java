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
	public Subway getSubway(int id) {
		return subwayDao.get(id);
	}

	@Override
	public List<Subway> getSubwayList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addSubway(Subway subway) {
		// TODO Auto-generated method stub
		return 0;
	}

}
