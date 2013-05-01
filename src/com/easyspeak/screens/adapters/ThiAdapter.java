package com.easyspeak.screens.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.easyspeak.screens.customviews.cvThi;
import com.easyspeak.dto.*;

public class ThiAdapter extends ArrayAdapter<CauHoiDTO>{
	
	private List<CauHoiDTO> m_ArrayList;
	private Context ctx=null;
	Activity m_ac;
	

	public ThiAdapter(Context context, int textViewResourceId,
			List<CauHoiDTO> objects,Activity ac) {
		super(context, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
		this.ctx=context;
		this.m_ArrayList=objects;
		m_ac=ac;
	}
	
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		View recordView = convertView;
		if(recordView == null){
			recordView = new cvThi(getContext());
		}
		
		final CauHoiDTO his = m_ArrayList.get(position);
		if(his != null){
			TextView stt = ((cvThi)recordView).getM_txtSTT();
			TextView cauhoi = ((cvThi)recordView).getM_txtTenCauHoi();
			RadioButton[] answers = ((cvThi)recordView).getM_rAnswers();
			
			stt.setText(Integer.toString(position+1)+": ");
			cauhoi.setText(his.getTenCauHoi());
			answers[0].setText(his.getDapAnA());
			answers[1].setText(his.getDapAnB());
			answers[2].setText(his.getDapAnC());
			answers[3].setText(his.getDapAnD());
			
			answers[0].setChecked(false);
			answers[1].setChecked(false);
			answers[2].setChecked(false);
			answers[3].setChecked(false);
			cvThi c=(cvThi)recordView;
			c.chDTO=his;
			c.setStt(position);
			
			int iSelected=his.getIsSeleted();
			if(iSelected!=-1){
				answers[iSelected].setChecked(true);
			}
			
			c.bindAnsewr(m_ac);
			
			if(his.isFinished){
				c.getResult();
			}
			
		}
		return recordView;
	}
	
	

}
