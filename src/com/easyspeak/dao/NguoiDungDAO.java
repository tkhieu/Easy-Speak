package com.easyspeak.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;

import com.easyspeak.helpers.DataHelper;
import com.easyspeak.dto.*;

public class NguoiDungDAO {

	private Context m_context;

	private NguoiDungDAO(){}
		
	public NguoiDungDAO(Context ctx) {
		this.m_context = ctx;
	}

	public List<NguoiDungDTO> getAll() {
		List<NguoiDungDTO> lst = new ArrayList<NguoiDungDTO>();
		//lst.add(new DeThiDTO(1, "abc"));
		//lst.add(new DeThiDTO(2, "abcd"));
		//lst.add(new DeThiDTO(3, "abcf"));
		DataHelper myDbHelper = new DataHelper(m_context);
		
		try {
			myDbHelper.openDataBase();
			Cursor c= myDbHelper.getMyDataBase().query("DeThi",new String[]{"MaNguoiDung","HoTen","Username","Password"},null,null,null,null,null);
		 	
			if (c != null) {
				if (c.moveToFirst()) {
					do {
						int id=c.getInt(0);
						String hoten=c.getString(1);
						String user=c.getString(2);
						String pass=c.getString(3);
						
						NguoiDungDTO ddt= new NguoiDungDTO(id,hoten,user,pass);
						lst.add(ddt);
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
