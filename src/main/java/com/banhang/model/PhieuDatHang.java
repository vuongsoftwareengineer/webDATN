package com.banhang.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class PhieuDatHang {
	@NotBlank(message = "Không được để trống mã đơn hàng")
	private String id;
	@NotBlank(message = "Không được để trống ngày đặt")
	private Date ngayLap;
	@NotBlank(message = "Không được để trống tổng tiền")
	@DecimalMin(value = "0", message = "Tổng tiền không được nhỏ hơn 0")
	private int tongTien;
	@NotBlank(message = "Không được để trống mã tài khoản")
	private String taiKhoanId;
	@NotNull(message = "Không được để trống trạng thái")
	private int trangThai;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
	public String getTaiKhoanId() {
		return taiKhoanId;
	}
	public void setTaiKhoanId(String taiKhoanId) {
		this.taiKhoanId = taiKhoanId;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}	
	
}
