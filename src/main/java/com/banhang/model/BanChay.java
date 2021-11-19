package com.banhang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class BanChay {
	
	String idhh;
	
	int gia;
	
	String ten;
	
	int tong;

	public String getIdhh() {
		return idhh;
	}

	public void setIdhh(String idhh) {
		this.idhh = idhh;
	}


	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTong() {
		return tong;
	}

	public void setTong(int tong) {
		this.tong = tong;
	}
	
	
	public BanChay() {
		super();
	}

	public BanChay(String id, int gia, String ten, int tong) {
		super();
		this.idhh = id;
		this.gia = gia;
		this.ten = ten;
		this.tong = tong;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	
	

}
