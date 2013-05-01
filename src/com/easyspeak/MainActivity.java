package com.easyspeak;

import java.util.List;

import com.easyspeak.R;
import com.easyspeak.dao.DeThiDAO;
import com.easyspeak.dto.DeThiDTO;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnDeThi = (Button) findViewById(R.id.Button01);
		Button btnExit = (Button) findViewById(R.id.Button05);
		Button btnAbout = (Button) findViewById(R.id.button1);
		Button btnUpdate = (Button) findViewById(R.id.btnDeThi);
		Button btnContact = (Button) findViewById(R.id.Button04);
		Button btnHistory = (Button) findViewById(R.id.Button02);
		
		btnHistory.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(v.getContext(), QuaTrinhHocActivity.class);
				startActivity(in);
				//finish();
			}
		});
		
		btnContact.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(v.getContext(), LienHeActivity.class);
				startActivity(in);
				//finish();
			}
		});
		
		btnUpdate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(v.getContext(), CapNhatActivity.class);
				startActivity(in);
				//finish();
			}
		});
		
		btnAbout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(v.getContext(), AboutActivity.class);
				startActivity(in);
				//finish();
			}
		});
		
		btnExit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});

		//DeThiDAO dethiDAO = new DeThiDAO(this);
		//List<DeThiDTO> lst = dethiDAO.getAll();
		//for (DeThiDTO dt : lst) {
			//Log.d("id", dt.getTenDeThi());
		//}

		btnDeThi.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in = new Intent(v.getContext(), DeThiActivity.class);
				startActivity(in);
				//finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
