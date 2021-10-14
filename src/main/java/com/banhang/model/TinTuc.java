package com.banhang.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class TinTuc {
	@NotBlank(message = "Không được để trống mã tin tức")
	private String id;
	@NotBlank(message = "Không được để trống tên chủ đề")
    private String chuDe;
	@NotBlank(message = "Không được để trống địa chỉ ảnh")
	private String anh;
	@NotBlank(message = "Không được để trống nội dung")
    private String noiDung;
    @Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayDang;
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getChuDe() {
		return chuDe;
	}
	public void setChuDe(String chuDe) {
		this.chuDe = chuDe;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public Date getNgayDang() {
		return ngayDang;
	}
	public void setNgayDang(Date ngayDang) {
		this.ngayDang = ngayDang;
	}
	
	
}
