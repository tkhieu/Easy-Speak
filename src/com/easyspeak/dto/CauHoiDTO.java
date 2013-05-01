package com.easyspeak.dto;

public class CauHoiDTO {
	private int maCauHoi;
	private String tenCauHoi;
	private String dapAnA;
	private String dapAnB;
	private String dapAnC;
	private String dapAnD;
	private String dapAnDung;
	private int maDeThi;
	private int maLoaiCauHoi;
	private int isSeleted=-1;
	public boolean isFinished=false;
	public boolean isRight=false;
	public String strResult;
	
	public int getIsSeleted() {
		return isSeleted;
	}
	public void setIsSeleted(int isSeleted) {
		this.isSeleted = isSeleted;
	}
	public int getMaCauHoi() {
		return maCauHoi;
	}
	public void setMaCauHoi(int maCauHoi) {
		this.maCauHoi = maCauHoi;
	}
	public String getTenCauHoi() {
		return tenCauHoi;
	}
	public void setTenCauHoi(String tenCauHoi) {
		this.tenCauHoi = tenCauHoi;
	}
	public String getDapAnA() {
		return dapAnA;
	}
	public void setDapAnA(String dapAnA) {
		this.dapAnA = dapAnA;
	}
	public String getDapAnB() {
		return dapAnB;
	}
	public void setDapAnB(String dapAnB) {
		this.dapAnB = dapAnB;
	}
	public String getDapAnC() {
		return dapAnC;
	}
	public void setDapAnC(String dapAnC) {
		this.dapAnC = dapAnC;
	}
	public String getDapAnD() {
		return dapAnD;
	}
	public void setDapAnD(String dapAnD) {
		this.dapAnD = dapAnD;
	}
	public String getDapAnDung() {
		return dapAnDung;
	}
	public void setDapAnDung(String dapAnDung) {
		this.dapAnDung = dapAnDung;
	}
	public int getMaDeThi() {
		return maDeThi;
	}
	public void setMaDeThi(int maDeThi) {
		this.maDeThi = maDeThi;
	}
	public int getMaLoaiCauHoi() {
		return maLoaiCauHoi;
	}
	public void setMaLoaiCauHoi(int maLoaiCauHoi) {
		this.maLoaiCauHoi = maLoaiCauHoi;
	}
	public CauHoiDTO(int maCauHoi, String tenCauHoi, String dapAnA,
			String dapAnB, String dapAnC, String dapAnD, String dapAnDung,
			int maDeThi, int maLoaiCauHoi) {
		super();
		this.maCauHoi = maCauHoi;
		this.tenCauHoi = tenCauHoi;
		this.dapAnA = dapAnA;
		this.dapAnB = dapAnB;
		this.dapAnC = dapAnC;
		this.dapAnD = dapAnD;
		this.dapAnDung = dapAnDung;
		this.maDeThi = maDeThi;
		this.maLoaiCauHoi = maLoaiCauHoi;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getTenCauHoi();
	}
	
}
