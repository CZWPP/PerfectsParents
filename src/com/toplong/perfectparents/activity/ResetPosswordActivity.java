package com.toplong.perfectparents.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.toplong.perfectparents.R;


public class ResetPosswordActivity extends BaseActivity implements OnClickListener{
	
	private TextView title;
	private EditText pwd,pwdagain;
	private ImageButton pwdshow,pwdclear,pwdagainshow,pwdagainclear;
	private Button submit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViews();
	}
	
	private void initViews(){
		setContentView(R.layout.resetpasswordactivity);
		title = (TextView) findViewById(R.id.includetitle1_title);
		title.setText("Íü¼ÇÃÜÂë");
		pwd = (EditText) findViewById(R.id.resetpasswordactivity_pwd);
		pwdagain = (EditText) findViewById(R.id.resetpasswordactivity_pwd);
		pwdshow = (ImageButton) findViewById(R.id.resetpasswordactivity_pwdshow);
		pwdshow.setOnClickListener(this);
		pwdclear = (ImageButton) findViewById(R.id.resetpasswordactivity_pwdclear);
		pwdclear.setOnClickListener(this);
		pwdagainshow = (ImageButton) findViewById(R.id.resetpasswordactivity_pwdagainshow);
		pwdagainshow.setOnClickListener(this);
		pwdagainclear = (ImageButton) findViewById(R.id.resetpasswordactivity_pwdagainclear);
		pwdagainclear.setOnClickListener(this);
		submit = (Button) findViewById(R.id.resetpasswordactivity_submit);
		submit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.resetpasswordactivity_pwdshow:
			
			break;
		case R.id.resetpasswordactivity_pwdclear:
			
			break;
		case R.id.resetpasswordactivity_pwdagainshow:
			
			break;
		case R.id.resetpasswordactivity_pwdagainclear:
			
			break;
		case R.id.resetpasswordactivity_submit:
			
			break;
		}
		
	}
}