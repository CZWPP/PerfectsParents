package com.toplong.perfectparents.activity;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.InputType;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.toplong.perfectparents.R;
import com.toplong.perfectparents.util.InputValidateUtil;
import com.toplong.perfectparents.util.NetUtil;
import com.toplong.perfectparents.util.ToastUtil;

public class RegisterSuccessActivity extends BaseActivity implements OnClickListener {
	
	private Button login,finishinfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registersuccessactivity);
		login = (Button) findViewById(R.id.registersuccessactivity_login);
		login.setOnClickListener(this);
		finishinfo = (Button) findViewById(R.id.registersuccessactivity_finishinfo);
		finishinfo.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.registersuccessactivity_login:
			Intent loginIntent = new Intent(this,LoginActivity.class);
			startActivity(loginIntent);
			break;
		case R.id.registersuccessactivity_finishinfo:
			Intent perfectIntent = new Intent(this, PerfectInfoActivity.class);
			startActivity(perfectIntent);
			break;
		}
	}
	
}