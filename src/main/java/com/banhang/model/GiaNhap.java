package com.banhang.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties
public class GiaNhap {
	
	String ngayApDung;
	BigDecimal gia;
	String idHH;
	
	
	public String getNgayApDung() {
		return ngayApDung;
	}
	public void setNgayApDung(String ngayApDung) {
		this.ngayApDung = ngayApDung;
	}
	public BigDecimal getGia() {
		return gia;
	}
	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}
	public String getIdHH() {
		return idHH;
	}
	public void setIdHH(String idHH) {
		this.idHH = idHH;
	}
	
	

}
