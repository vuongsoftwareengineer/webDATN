package com.banhang.model;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ThongKeLoiNhuan {
	private String id;
	int doanhthu;
	int loinhuan;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDoanhthu() {
		return doanhthu;
	}
	public void setDoanhthu(int doanhthu) {
		this.doanhthu = doanhthu;
	}
	public int getLoinhuan() {
		return loinhuan;
	}
	public void setLoinhuan(int loinhuan) {
		this.loinhuan = loinhuan;
	}
	
	}
