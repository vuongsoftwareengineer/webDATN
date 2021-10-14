package com.banhang.model;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class TaiKhoan {
	@NotBlank(message = "Không được để trống mã tài khoản")
	private String id;
	@NotBlank(message = "Không được để trống địa chỉ")
	private String diaChi;
	@NotBlank(message = "Không được để trống Email")
	private String email;
	@NotBlank(message = "Không được để trống họ tên")
	private String hoTen;
	@NotBlank(message = "Không được để trống số điện thoại")
	private String sdt;
	@NotBlank(message = "Không được để trống username")
	private String username;
	@NotBlank(message = "Không được để trống password")
	private String password;
	@NotBlank(message = "Không được để trống quyền tài khoản")
	private String quyen;
	
	private String anh;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getQuyen() {
		return quyen;
	}
	public void setQuyen(String quyen) {
		this.quyen = quyen;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	
	
	
}
