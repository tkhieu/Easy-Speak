package com.easyspeak.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;

import com.easyspeak.helpers.DataHelper;
import com.easyspeak.dto.*;

 public class LoaiCauHoiDAO {
		private Context m_context;

		private LoaiCauHoiDAO(){}
			
		public LoaiCauHoiDAO(Context ctx) {
			this.m_context = ctx;
		}

		public List<LoaiCauHoiDTO> getAll() {
			List<LoaiCauHoiDTO> lst = new ArrayList<LoaiCauHoiDTO>();
			//lst.add(new DeThiDTO(1, "abc"));
			//lst.add(new DeThiDTO(2, "abcd"));
			//lst.add(new DeThiDTO(3, "abcf"));
			DataHelper myDbHelper = new DataHelper(m_context);
			
			try {
				myDbHelper.openDataBase();
				Cursor c= myDbHelper.getMyDataBase().query("LoaiCauHoi",new String[]{"MaLoai","TenLoai"},null,null,null,null,null);
			 	
				if (c != null) {
					if (c.moveToFirst()) {
						do {
							int id=c.getInt(0);
							String tenloai=c.getString(1);
							LoaiCauHoiDTO ddt= new LoaiCauHoiDTO(id, tenloai);
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
