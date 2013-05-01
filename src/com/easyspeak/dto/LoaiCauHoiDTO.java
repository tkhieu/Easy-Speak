package com.easyspeak.dto;

public class LoaiCauHoiDTO {
	private int maLoaiCauHoi;
	private String tenLoaiCauHoi;
	
	public int getMaLoaiCauHoi() {
		return maLoaiCauHoi;
	}
	public void setMaLoaiCauHoi(int maLoaiCauHoi) {
		this.maLoaiCauHoi = maLoaiCauHoi;
	}
	public String getTenLoaiCauHoi() {
		return tenLoaiCauHoi;
	}
	public void setTenLoaiCauHoi(String tenLoaiCauHoi) {
		this.tenLoaiCauHoi = tenLoaiCauHoi;
	}
	public LoaiCauHoiDTO(int maLoaiCauHoi, String tenLoaiCauHoi) {
		super();
		this.maLoaiCauHoi = maLoaiCauHoi;
		this.tenLoaiCauHoi = tenLoaiCauHoi;
	}
	
}
