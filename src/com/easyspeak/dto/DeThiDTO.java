package com.easyspeak.dto;

public class DeThiDTO {
	private int maDeThi;
	private String tenDeThi;
	
	public int getMaDeThi() {
		return maDeThi;
	}
	public void setMaDeThi(int maDeThi) {
		this.maDeThi = maDeThi;
	}
	public String getTenDeThi() {
		return tenDeThi;
	}
	public void setTenDeThi(String tenDeThi) {
		this.tenDeThi = tenDeThi;
	}
	public DeThiDTO(int maDeThi, String tenDeThi) {
		super();
		this.maDeThi = maDeThi;
		this.tenDeThi = tenDeThi;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getTenDeThi();
	}
}
