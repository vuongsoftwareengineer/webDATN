package com.banhang.model;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class ThuongHieu {
	@NotBlank(message = "Không được để trống mã thương hiệu")
	private String id;
	@NotBlank(message = "Không được để trống tên thương hiệu")
	private String ten;
	@NotBlank(message = "Không được để trống địa chỉ ảnh")
	private String anh;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
}
