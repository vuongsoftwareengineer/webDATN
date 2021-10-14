package com.banhang.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CT_PhieuNhapHang {
	
	@NotBlank(message = "Không được để trống mã chi tiết")
	private String id;
	@NotNull(message = "Không được để trống số lượng")
	@DecimalMin(value = "0", message = "Số lượng không được nhỏ hơn 0")
	private int soLuong;
	@NotBlank(message = "Không được để trống mã đơn hàng")
	private String idPhieuNhapHang;
	@NotBlank(message = "Không được để trống mã sản phẩm")
	private String idhh;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	
	public String getidPhieuNhapHang() {
		return idPhieuNhapHang;
	}
	public void setidPhieuNhapHang(String idPhieuNhapHang) {
		this.idPhieuNhapHang = idPhieuNhapHang;
	}
	public String getidhh() {
		return idhh;
	}
	public void setidhh(String idhh) {
		this.idhh = idhh;
	}
		
}
