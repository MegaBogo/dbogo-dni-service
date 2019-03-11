package com.dni.web.dao;

import java.util.List;

import com.dni.web.entity.Subway;
public interface SubwayDao {
	int insert(Subway subway);
	int update(Subway subway);
	int delete(int id);	
	
	Subway get(int id);
	List<Subway> getList();

}
