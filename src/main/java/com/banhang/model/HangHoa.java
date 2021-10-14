package com.banhang.model;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class HangHoa {
	@NotBlank(message = "Không được để trống mã sản phẩm")
	private String id;
	@NotBlank(message = "Không được để trống địa chỉ ảnh")
	private String anh;
	@NotBlank(message = "Không được để trống khối lượng")
	private String khoiLuong;
	@NotBlank(message = "Không được để trống mô tả")
	private String moTa;
	@NotNull(message = "Không được để trống số lượng tồn")
	private int soLuongTon;
	@NotBlank(message = "Không được để trống tên sản phẩm")
	private String ten;
	@NotBlank(message = "Không được để trống thương hiệu")
	private String thuongHieuId;
	@NotBlank(message = "Không được để trống thể loại")
	private String theLoaiId;
	@NotNull(message = "Không được để trống giá ")
	@DecimalMin(value = "0", message = "Giá không được nhỏ hơn 0")
	private int gia;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getKhoiLuong() {
		return khoiLuong;
	}
	public void setKhoiLuong(String khoiLuong) {
		this.khoiLuong = khoiLuong;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getThuongHieuId() {
		return thuongHieuId;
	}
	public void setThuongHieuId(String thuongHieuId) {
		this.thuongHieuId = thuongHieuId;
	}
	public String getTheLoaiId() {
		return theLoaiId;
	}
	public void setTheLoaiId(String theLoaiId) {
		this.theLoaiId = theLoaiId;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	
	
	
}
