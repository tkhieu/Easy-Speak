package com.easyspeak.screens.customviews;

import java.util.List;

import com.easyspeak.R;
import com.easyspeak.ThiActivity;
import com.easyspeak.dto.CauHoiDTO;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.speech.RecognizerIntent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

public class cvThi extends LinearLayout {
	// private static final int VOICE_RECOGNITION_REQUEST_CODE = 1001;

	private TextView m_txtTenCauHoi;
	private TextView m_txtSTT;
	private RadioButton[] m_rAnswers;
	private Button m_btnAnswer;

	// private int iChoice=-1;

	private Context m_ctx;
	private int stt;
	public CauHoiDTO chDTO;

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public Button getM_btnAnswer() {
		return m_btnAnswer;
	}

	public void setM_btnAnswer(Button m_btnAnswer) {
		this.m_btnAnswer = m_btnAnswer;
	}

	public TextView getM_txtTenCauHoi() {
		return m_txtTenCauHoi;
	}

	public void setM_txtTenCauHoi(TextView m_txtTenCauHoi) {
		this.m_txtTenCauHoi = m_txtTenCauHoi;
	}

	public TextView getM_txtSTT() {
		return m_txtSTT;
	}

	public void setM_txtSTT(TextView m_txtSTT) {
		this.m_txtSTT = m_txtSTT;
	}

	public RadioButton[] getM_rAnswers() {
		return m_rAnswers;
	}

	public void setM_rAnswers(RadioButton[] m_rAnswers) {
		this.m_rAnswers = m_rAnswers;
	}

	public cvThi(Context context) {
		super(context);
		this.m_ctx = context;
		// TODO Auto-generated constructor stub
		LayoutInflater li = (LayoutInflater) this.getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		li.inflate(R.layout.cv_cauhoi, this, true);
		m_rAnswers = new RadioButton[4];
		// Lấy v�? các View qua ID
		m_txtTenCauHoi = (TextView) findViewById(R.id.cv_txtTenCauHoi);
		m_txtSTT = (TextView) findViewById(R.id.cv_txtSTT);
		m_rAnswers[0] = (RadioButton) findViewById(R.id.cv_rA);
		m_rAnswers[1] = (RadioButton) findViewById(R.id.cv_rB);
		m_rAnswers[2] = (RadioButton) findViewById(R.id.cv_rC);
		m_rAnswers[3] = (RadioButton) findViewById(R.id.cv_rD);
		m_btnAnswer = (Button) findViewById(R.id.btnTraLoi);
		m_btnAnswer.setEnabled(false);

		android.content.ContextWrapper c = new ContextWrapper(m_ctx);
		PackageManager pm = c.getPackageManager();
		List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(
				RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
		if (activities.size() == 0) {
			m_btnAnswer.setEnabled(false);
			m_btnAnswer.setText("No internet access");
		} else {
			m_btnAnswer.setEnabled(true);
		}

		for (int i = 0; i < 4; i++) {
			m_rAnswers[i].setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					for (int i = 0; i < 4; i++) {
						if (m_rAnswers[i].equals(v)) {
							m_rAnswers[i].setChecked(true);
							//Toast.makeText(m_ctx,
							//		m_rAnswers[i].getText().toString(),
							//		Toast.LENGTH_SHORT).show();
							chDTO.setIsSeleted(i);
							chDTO.strResult=m_rAnswers[i].getText().toString();
						} else {
							m_rAnswers[i].setChecked(false);
							
						}
						// m_rAnswers[i].setEnabled(false);
						// Toast.makeText(m_ctx,
						// m_rAnswers[i].getText().toString(),
						// Toast.LENGTH_SHORT).show();
					}
				}
			});
		}
	}

	public void getResult() {
		int index = chDTO.getIsSeleted();
		m_txtTenCauHoi.setTextColor(Color.parseColor("#CC0000"));
		for (int i = 0; i < m_rAnswers.length; i++) {
			// if(m_rAnswers[i].getText().toString().equals(chDTO.getDapAnDung())
			// ){
			m_rAnswers[i].setTextColor(Color.parseColor("#000000"));
			// }
			if (i == index) {
				if (chDTO.isRight){// dung
					m_rAnswers[index].setTextColor(Color.parseColor("#0000FE"));
					m_txtTenCauHoi.setTextColor(Color.parseColor("#0000FE"));
				}
				else {// sai
					m_rAnswers[index].setTextColor(Color.parseColor("#CC0000"));
				}
			}
			if(m_rAnswers[i].getText().toString().toLowerCase().equals(chDTO.getDapAnDung().trim().toLowerCase())){
				m_rAnswers[i].setTextColor(Color.parseColor("#0000FE"));
			}
		}
	}

	public void bindAnsewr(final Activity ac) {

		// android.content.ContextWrapper c = new ContextWrapper(m_ctx);
		// PackageManager pm = c.getPackageManager();
		// List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(
		// RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
		// if (activities.size() == 0) {
		// m_btnAnswer.setEnabled(false);
		// Toast.makeText(m_ctx, "Voice recognizer not present",
		// Toast.LENGTH_SHORT).show();
		// } else {

		m_btnAnswer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(
						RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
				// Specify the calling package to identify your application
				intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
						getClass().getPackage().getName());

				// Given an hint to the recognizer about what the user is going
				// to say
				intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
						RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);

				intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
				intent.putExtra("stt", m_txtSTT.getText());
				// if()
				ThiActivity.id = stt;
				// android.app.Activity c=new Activity();
				ac.startActivityForResult(intent,
						ThiActivity.VOICE_RECOGNITION_REQUEST_CODE);
			}
		});
		// }

	}

}
