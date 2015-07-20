package com.toplong.perfectparents.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.toplong.perfectparents.R;
import com.toplong.perfectparents.util.NetUtil;
import com.toplong.perfectparents.util.ToastUtil;



public class LoginActivity extends BaseActivity implements OnClickListener {

	private Button guest,login,register,forgetpwd;
	private EditText username,password;
	private ImageButton thidloginb,pwdclear,unclear;
	private TextView thirdloginshow;
	private LinearLayout thirdloginbottom;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginactivity);
		initViews();
	}
	
	public void initViews(){
		guest = (Button) findViewById(R.id.loginactivity_guest);
		guest.setOnClickListener(this);
		login = (Button) findViewById(R.id.loginactivity_login);
		login.setOnClickListener(this);
		register = (Button) findViewById(R.id.loginactivity_register);
		register.setOnClickListener(this);
		forgetpwd = (Button) findViewById(R.id.loginactivity_forgetpwd);
		forgetpwd.setOnClickListener(this);
		username = (EditText) findViewById(R.id.loginactivity_username);
		password = (EditText) findViewById(R.id.loginactivity_password);
		thidloginb = (ImageButton) findViewById(R.id.thirdloginib);
		thidloginb.setOnClickListener(this);
		thirdloginshow = (TextView) findViewById(R.id.thirdloginshow);
		thirdloginbottom = (LinearLayout) findViewById(R.id.thirdloginbottom);
		pwdclear = (ImageButton) findViewById(R.id.loginactivity_pwdclear);
		pwdclear.setOnClickListener(this);
		unclear = (ImageButton) findViewById(R.id.loginactivity_unclear);
		unclear.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.loginactivity_guest:
			Intent mainIntent = new Intent(this,MainActivity.class);
			startActivity(mainIntent);
			break;
		case R.id.loginactivity_login:
			String un = username.getText().toString();
			String pwd = password.getText().toString();
			new NetUtil(getPerfectParentsAPP(),loginHandler).urlGetData(NetUtil.Login, un,pwd);
			break;
		case R.id.loginactivity_register:
			Intent registerIntent = new Intent(this,RegisterActivity.class);
			startActivity(registerIntent);
			break;  
		case R.id.loginactivity_forgetpwd:
			Intent forgetpwdIntent = new Intent(this,ForgetPosswordActivity.class);
			startActivity(forgetpwdIntent);
			break;  
		case R.id.thirdloginib:
			if(thirdloginshow.getVisibility()==View.VISIBLE){
				thirdloginshow.setVisibility(View.GONE);
				thirdloginbottom.setVisibility(View.VISIBLE);
				thidloginb.setImageResource(R.drawable.loginactivity_third_down);
			}else{
				thirdloginshow.setVisibility(View.VISIBLE);
				thirdloginbottom.setVisibility(View.GONE);
				thidloginb.setImageResource(R.drawable.loginactivity_third_up);
			}
			break;  
		case R.id.loginactivity_pwdclear:
			password.setText("");
			break;  
		case R.id.loginactivity_unclear:
			username.setText("");
			break;  
		}
		
	}
	
	private Handler loginHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case NetUtil.RESULTTRUE+NetUtil.Login:
				ToastUtil.show(LoginActivity.this, "登录成功");
				Intent loginIntent = new Intent(LoginActivity.this,MainActivity.class);
				startActivity(loginIntent);
				finish();
				break;
			case NetUtil.RESULTNULL+NetUtil.Login:
				ToastUtil.show(LoginActivity.this, "该用户名不存在");
				break;
			case NetUtil.RESULTFALSE+NetUtil.Login:
				ToastUtil.show(LoginActivity.this, "密码输入错误");
				break;
			}
		};
	};
}
