package com.easyspeak;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class QuaTrinhHocActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qua_trinh_hoc);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_qua_trinh_hoc, menu);
		return true;
	}

}
