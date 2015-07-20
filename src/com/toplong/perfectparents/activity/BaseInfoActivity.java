package com.toplong.perfectparents.activity;

import com.toplong.perfectparents.R;

import android.os.Bundle;


public class BaseInfoActivity extends BaseActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViews();
	}
	
	private void initViews(){
		setContentView(R.layout.baseinfoactivity);
	}
}