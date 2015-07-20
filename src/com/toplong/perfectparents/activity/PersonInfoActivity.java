package com.toplong.perfectparents.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.toplong.perfectparents.R;



public class PersonInfoActivity extends BaseActivity implements OnClickListener{

	private TextView title;
	private ImageButton backarrow;
	private LinearLayout areainfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViews();
	}
	
	public void initViews(){
		setContentView(R.layout.personinfoactivity);
		title = (TextView) findViewById(R.id.includetitle1_title);
		title.setText("个人信息");
		backarrow = (ImageButton) findViewById(R.id.includetitle1_backarrow);
		backarrow.setOnClickListener(this);
		areainfo = (LinearLayout) findViewById(R.id.personinfoactivity_areainfo);
		areainfo.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.includetitle1_backarrow:
			finish();
			break;
		case R.id.personinfoactivity_areainfo:
			Intent 
			break;
		}
		
	}
}
