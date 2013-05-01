package com.easyspeak.dto;

import java.util.Date;

public class QuaTrinhThiDTO {
	private int maQuaTrinh;
	private int maDeThi;
	private int maNguoiDung;
	private Date thoiGian;
	private int tongDiem;
	
	public int getMaQuaTrinh() {
		return maQuaTrinh;
	}
	public void setMaQuaTrinh(int maQuaTrinh) {
		this.maQuaTrinh = maQuaTrinh;
	}
	public int getMaDeThi() {
		return maDeThi;
	}
	public void setMaDeThi(int maDeThi) {
		this.maDeThi = maDeThi;
	}
	public int getMaNguoiDung() {
		return maNguoiDung;
	}
	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
	}
	public Date getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}
	public int getTongDiem() {
		return tongDiem;
	}
	public void setTongDiem(int tongDiem) {
		this.tongDiem = tongDiem;
	}
	public QuaTrinhThiDTO(int maQuaTrinh, int maDeThi, int maNguoiDung,
			Date thoiGian, int tongDiem) {
		super();
		this.maQuaTrinh = maQuaTrinh;
		this.maDeThi = maDeThi;
		this.maNguoiDung = maNguoiDung;
		this.thoiGian = thoiGian;
		this.tongDiem = tongDiem;
	}
	
}
