package com.easyspeak.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;

import com.easyspeak.helpers.DataHelper;
import com.easyspeak.dto.DeThiDTO;

public class DeThiDAO {
	private Context m_context;

	private DeThiDAO(){}
		
	public DeThiDAO(Context ctx) {
		this.m_context = ctx;
	}

	public List<DeThiDTO> getAll() {
		List<DeThiDTO> lst = new ArrayList<DeThiDTO>();
		//lst.add(new DeThiDTO(1, "abc"));
		//lst.add(new DeThiDTO(2, "abcd"));
		//lst.add(new DeThiDTO(3, "abcf"));
		DataHelper myDbHelper = new DataHelper(m_context);
		
		try {
			myDbHelper.openDataBase();
			Cursor c= myDbHelper.getMyDataBase().query("DeThi",new String[]{"Madethi","Tendethi"},null,null,null,null,null);
		 	
			if (c != null) {
				if (c.moveToFirst()) {
					do {
						int id=c.getInt(0);
						String name=c.getString(1);
						DeThiDTO ddt= new DeThiDTO(id, name);
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
