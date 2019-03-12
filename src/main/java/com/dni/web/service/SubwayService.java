package com.dni.web.service;

import java.util.List;

import com.dni.web.entity.Subway;

public interface SubwayService {
	public Subway getSubway();
	public List<Subway> getSubwayList();
	public int addSubway(Subway subway);
}
