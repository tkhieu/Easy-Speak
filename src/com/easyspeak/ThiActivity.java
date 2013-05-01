package com.easyspeak;

import java.util.ArrayList;
import java.util.List;

import com.easyspeak.R;
import com.easyspeak.R.layout;
import com.easyspeak.R.menu;
import com.easyspeak.dao.CauHoiDAO;
import com.easyspeak.dao.DeThiDAO;
import com.easyspeak.dto.CauHoiDTO;
import com.easyspeak.dto.DeThiDTO;
import com.easyspeak.screens.adapters.ThiAdapter;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ThiActivity extends Activity {
	public static final int VOICE_RECOGNITION_REQUEST_CODE = 1001;
	public static int id = -1;
	private ListView m_lvDanhSachCauHoi;
	private List<CauHoiDTO> m_lstDanhSachCauHoi;
	ThiAdapter ad = null;

	//Button m_btnHome;
	Button m_btnResult;
	TextView tvResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thi);

		m_lvDanhSachCauHoi = (ListView) findViewById(R.id.lvThi);
		//m_btnHome = (Button) findViewById(R.id.btnHome);
		m_btnResult = (Button) findViewById(R.id.button2);
		tvResult = (TextView) findViewById(R.id.textView1);
		m_btnResult.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getResult();
			}
		});
		

		final Bundle bundle = this.getIntent().getExtras();
		int id = bundle.getInt("idDeThi");
		CauHoiDAO dt = new CauHoiDAO(this);
		m_lstDanhSachCauHoi = dt.getByTest(id);
		ad = new ThiAdapter(this, 0, m_lstDanhSachCauHoi, this);
		initList();
	}

	protected void getResult() {
		// TODO Auto-generated method stub
		int iRight=0;
		for (int i = 0; i < m_lstDanhSachCauHoi.size(); i++) {
			CauHoiDTO c = m_lstDanhSachCauHoi.get(i);
			c.isFinished = true;
			if(c.strResult==null)
				continue;
			//showToastMessage(c.strResult+":"+c.getDapAnDung());
			if (c.strResult.toLowerCase().equals(c.getDapAnDung().trim().toLowerCase())){
				c.isRight = true;
				iRight++;
			}
			else
				c.isRight = false;
		}
		//showToastMessage("getResult");
		tvResult.setText("Kết quả: "+iRight+"/"+m_lstDanhSachCauHoi.size());
		ad.notifyDataSetChanged();
		m_lvDanhSachCauHoi.invalidateViews();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_thi, menu);
		return true;
	}

	private void initList() {

		m_lvDanhSachCauHoi.setAdapter(ad);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == VOICE_RECOGNITION_REQUEST_CODE)

			// If Voice recognition is successful then it returns RESULT_OK
			if (resultCode == RESULT_OK) {

				ArrayList<String> textMatchList = data
						.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

				if (!textMatchList.isEmpty()) {
					// If first Match contains the 'search' word
					// Then start web search.
					if (textMatchList.get(0).contains("search")) {

						String searchQuery = textMatchList.get(0).replace(
								"search", " ");
						Intent search = new Intent(Intent.ACTION_WEB_SEARCH);
						search.putExtra(SearchManager.QUERY, searchQuery);
						startActivity(search);
					} else {
						// populate the Matches
						//showToastMessage("Trả lời câu hỏi số: " + (id + 1));
						answer(textMatchList.get(0));
					}
				}
				// Result code for various error.
			} else if (resultCode == RecognizerIntent.RESULT_AUDIO_ERROR) {
				showToastMessage("Audio Error");
			} else if (resultCode == RecognizerIntent.RESULT_CLIENT_ERROR) {
				showToastMessage("Client Error");
			} else if (resultCode == RecognizerIntent.RESULT_NETWORK_ERROR) {
				showToastMessage("Network Error");
			} else if (resultCode == RecognizerIntent.RESULT_NO_MATCH) {
				showToastMessage("No Match");
			} else if (resultCode == RecognizerIntent.RESULT_SERVER_ERROR) {
				showToastMessage("Server Error");
			}
		super.onActivityResult(requestCode, resultCode, data);
	}

	void showToastMessage(String message) {
		Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
	}

	View getSelectedView() {
		return null;
	}

	// kiá»ƒm tra sá»‘ % giá»‘ng nhau cá»§a 2 chuá»—i kÃ­ tá»±
	// tráº£ vá»� % giá»‘ng nhau 0-100
	int compare(String _strSrc, String _strDes) {

		// kiem tra cÃ³ bao nhiÃªu kÃ­ tá»± trong s1 cÃ³ trong s2
		int iCount = 0;
		for (int i = 0; i < _strSrc.length(); i++) {
			char c = _strSrc.charAt(i);
			if (_strDes.indexOf(c, 0) > -1) {
				iCount++;
			}
		}
		//showToastMessage("Compare: " + _strSrc + ":" + _strDes + "=" + iCount);
		if (iCount > _strDes.length() / 2)
			return iCount;
		return 0;
	}

	private void answer(String text) {
		// TODO Auto-generated method stub
		CauHoiDTO ch = m_lstDanhSachCauHoi.get(id);
		int t1 = 0, t2 = 0, t3 = 0, t4 = 0, temp = 0;
		String strResult = "";
		t1 = compare(text, ch.getDapAnA());
		t2 = compare(text, ch.getDapAnB());
		t3 = compare(text, ch.getDapAnC());
		t4 = compare(text, ch.getDapAnD());

		if (t1 > t2) {
			temp = t1;
			strResult = ch.getDapAnA();
			ch.setIsSeleted(0);
		} else {
			temp = t2;
			strResult = ch.getDapAnB();
			ch.setIsSeleted(1);
		}

		if (temp < t3) {
			temp = t3;
			strResult = ch.getDapAnC();
			ch.setIsSeleted(2);
		}

		if (temp < t4) {
			temp = t4;
			strResult = ch.getDapAnD();
			ch.setIsSeleted(3);
		}
		if (temp == 0) {
			ch.setIsSeleted(-1);
			showToastMessage("Không có kết quả phù hợp");
		} else {
			// m_lvDanhSachCauHoi.refreshDrawableState();
			ch.strResult = strResult;
			ad.notifyDataSetChanged();
			m_lvDanhSachCauHoi.invalidateViews();
			//showToastMessage("MAX = " + temp + " : " + strResult);
		}
	}
}
