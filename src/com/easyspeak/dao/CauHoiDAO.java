package com.easyspeak.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;

import com.easyspeak.helpers.DataHelper;
import com.easyspeak.dto.*;

public class CauHoiDAO {
	private Context m_context;

	private CauHoiDAO() {
	}

	public CauHoiDAO(Context ctx) {
		this.m_context = ctx;
	}

	/*
	 * public List<CauHoiDTO> getAll() { List<CauHoiDTO> lst = new
	 * ArrayList<CauHoiDTO>(); lst.add(new
	 * CauHoiDTO(1,"abc","a","b","c","d","a",1,1 )); lst.add(new
	 * CauHoiDTO(2,"abc","a","b","c","d","a",1,1 )); lst.add(new
	 * CauHoiDTO(3,"abc","a","b","c","d","a",1,1 )); return lst; }
	 */

	public List<CauHoiDTO> getAll() {
		List<CauHoiDTO> lst = new ArrayList<CauHoiDTO>();
		// lst.add(new DeThiDTO(1, "abc"));
		// lst.add(new DeThiDTO(2, "abcd"));
		// lst.add(new DeThiDTO(3, "abcf"));
		DataHelper myDbHelper = new DataHelper(m_context);

		try {
			myDbHelper.openDataBase();
			Cursor c = myDbHelper.getMyDataBase().query(
					"CauHoi",
					new String[] { "MaCauHoi", "TenCauHoi", "DapAnA", "DapAnB",
							"DapAnC", "DapAnD", "DapAnDung", "MaDeThi",
							"MaLoaiCH" }, null, null, null, null, null);

			if (c != null) {
				if (c.moveToFirst()) {
					do {
						try {
							int id = c.getInt(0);
							String tencauhoi = new String(c.getBlob(1));
							// 7662485261137
							String dapanA = c.getString(2);
							String dapanB = c.getString(3);
							String dapanC = c.getString(4);
							String dapanD = c.getString(5);
							String dapanDung = c.getString(6);
							int madethi = c.getInt(7);
							int maloaicauhoi = c.getInt(8);
							CauHoiDTO ddt = new CauHoiDTO(id, tencauhoi,
									dapanA, dapanB, dapanC, dapanD, dapanDung,
									madethi, maloaicauhoi);
							lst.add(ddt);
						} catch (Exception e) {
							// TODO: handle exception
						}
					} while (c.moveToNext());
				}

			}

			myDbHelper.close();
		} catch (SQLException sqle) {
			throw sqle;
		}

		return lst;
	}
	
	public List<CauHoiDTO> getByTest(int _iTestId) {
		List<CauHoiDTO> lst = new ArrayList<CauHoiDTO>();
		// lst.add(new DeThiDTO(1, "abc"));
		// lst.add(new DeThiDTO(2, "abcd"));
		// lst.add(new DeThiDTO(3, "abcf"));
		DataHelper myDbHelper = new DataHelper(m_context);

		try {
			myDbHelper.openDataBase();
			Cursor c = myDbHelper.getMyDataBase().query(
					"CauHoi",
					new String[] { "MaCauHoi", "TenCauHoi", "DapAnA", "DapAnB",
							"DapAnC", "DapAnD", "DapAnDung", "MaDeThi",
							"MaLoaiCH" }, "MaDeThi="+_iTestId +" and MaLoaiCH=2", null, null, null, null);

			if (c != null) {
				if (c.moveToFirst()) {
					do {
						try {
							int id = c.getInt(0);
							String tencauhoi = new String(c.getBlob(1));
							// 7662485261137
							String dapanA = c.getString(2);
							String dapanB = c.getString(3);
							String dapanC = c.getString(4);
							String dapanD = c.getString(5);
							String dapanDung = c.getString(6);
							int madethi = c.getInt(7);
							int maloaicauhoi = c.getInt(8);
							CauHoiDTO ddt = new CauHoiDTO(id, tencauhoi,
									dapanA, dapanB, dapanC, dapanD, dapanDung,
									madethi, maloaicauhoi);
							lst.add(ddt);
						} catch (Exception e) {
							// TODO: handle exception
						}
					} while (c.moveToNext());
				}

			}

			myDbHelper.close();
		} catch (SQLException sqle) {
			throw sqle;
		}

		return lst;
	}
}
