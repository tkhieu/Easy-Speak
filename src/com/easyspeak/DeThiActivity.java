package com.easyspeak;

import java.util.List;

import com.easyspeak.R;
import com.easyspeak.R.layout;
import com.easyspeak.R.menu;
import com.easyspeak.dao.DeThiDAO;
import com.easyspeak.dto.DeThiDTO;

import android.R.string;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class DeThiActivity extends Activity {

	private ListView m_lvDanhSachDeThi;
	private List<DeThiDTO> m_lstDanhSachDeThi;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_de_thi);
		
		m_lvDanhSachDeThi=(ListView)findViewById(R.id.listViewDeThi);
		m_lvDanhSachDeThi.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				DeThiDTO deThiSelected=m_lstDanhSachDeThi.get(arg2);
				Intent in=new Intent(arg1.getContext(),ThiActivity.class);
				in.putExtra("idDeThi", deThiSelected.getMaDeThi());
				startActivity(in);
				finish();
				
				//Toast.makeText(arg0.getContext(), arg2, Toast.LENGTH_SHORT);
			}
		});
		initList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_de_thi, menu);
		return true;
	}
	
	private void initList()
	{
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
		this, android.R.layout.simple_list_item_1);
		DeThiDAO dt=new DeThiDAO(this);
		m_lstDanhSachDeThi=dt.getAll();
		for (DeThiDTO deThiDTO : m_lstDanhSachDeThi) {
			adapter.add(deThiDTO.toString());
		}
		m_lvDanhSachDeThi.setAdapter(adapter);
	}
}
