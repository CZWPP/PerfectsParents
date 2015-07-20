package com.toplong.perfectparents.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.toplong.perfectparents.R;
import com.toplong.perfectparents.util.SharedUtil;



public class SplashActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashactivity);
		new Handler(){
			@Override
			public void handleMessage(android.os.Message msg) {
				Intent intent = null;
				if(SharedUtil.newInstance(SplashActivity.this).isFirst()){
					SharedUtil.newInstance(SplashActivity.this).putIsFirst();
					intent = new Intent(SplashActivity.this, GuideActivity.class);
				}else{
					intent = new Intent(SplashActivity.this, LoginActivity.class);
				}
				startActivity(intent);
				finish();
			};
			
		}.sendEmptyMessageDelayed(0, 2000);
	}
	
}
