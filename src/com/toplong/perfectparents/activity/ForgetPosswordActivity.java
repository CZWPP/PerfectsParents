package com.toplong.perfectparents.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.toplong.perfectparents.R;


public class ForgetPosswordActivity extends BaseActivity implements OnClickListener{
	
	private TextView title;
	private Button vercode,submit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViews();
	}
	
	private void initViews(){
		setContentView(R.layout.forgetpasswordactivity);
		title = (TextView) findViewById(R.id.includetitle1_title);
		title.setText("Íü¼ÇÃÜÂë");
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.forgetpasswordactivity_vercode:
			
			break;

		case R.id.forgetpasswordactivity_submit:
			
			break;
		}
		
	}
}