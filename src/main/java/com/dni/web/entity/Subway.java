package com.dni.web.entity;

import java.util.Date;

public class Subway {
	private int id;
	private String departingStation;
	private String arrivalStation;
	private String duration;
	private Date regDate;
	private Date modifyDate;
	private boolean stop;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDepartingStation() {
		return departingStation;
	}
	public void setDepartingStation(String departingStation) {
		this.departingStation = departingStation;
	}
	public String getArrivalStation() {
		return arrivalStation;
	}
	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public boolean isStop() {
		return stop;
	}
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public String toString() {
		return "Subway [id=" + id + ", departingStation=" + departingStation + ", arrivalStation=" + arrivalStation
				+ ", duration=" + duration + ", regDate=" + regDate + ", modifyDate=" + modifyDate + ", stop=" + stop
				+ "]";
	}
}
