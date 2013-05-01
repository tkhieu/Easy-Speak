package com.easyspeak.dto;

public class NguoiDungDTO {
	private int maNguoiDung;
	private String hoTen;
	private String username;
	private String password;
	public int getMaNguoiDung() {
		return maNguoiDung;
	}
	public void setMaNguoiDung(int maNguoiDung) {
		this.maNguoiDung = maNguoiDung;
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
	public NguoiDungDTO(int maNguoiDung, String hoTen, String username,
			String password) {
		super();
		this.maNguoiDung = maNguoiDung;
		this.hoTen = hoTen;
		this.username = username;
		this.password = password;
	}
}
