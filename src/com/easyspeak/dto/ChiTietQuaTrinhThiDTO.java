package com.easyspeak.dto;

public class ChiTietQuaTrinhThiDTO {
	private int maQuaTrinh;
	private int maCauHoi;
	public int getMaQuaTrinh() {
		return maQuaTrinh;
	}
	public void setMaQuaTrinh(int maQuaTrinh) {
		this.maQuaTrinh = maQuaTrinh;
	}
	public int getMaCauHoi() {
		return maCauHoi;
	}
	public ChiTietQuaTrinhThiDTO(int maQuaTrinh, int maCauHoi) {
		super();
		this.maQuaTrinh = maQuaTrinh;
		this.maCauHoi = maCauHoi;
	}
	public void setMaCauHoi(int maCauHoi) {
		this.maCauHoi = maCauHoi;
	}
}