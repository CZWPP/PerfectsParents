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

public class RegisterActivity extends BaseActivity implements OnClickListener {

	private ImageButton backarrow,userpic;
	private ImageButton nicknameclear,phoneclear,pwdclear,pwdagainclear;
	private ImageButton pwdshow,pwdagainshow;
	private TextView title;
	private Button vercode,submit;
	private EditText nickname,phone,code,pwd,pwdagain;
	
	private String pTemp,nnTemp,cTemp,pwTemmp,upTemp;
	private static final int RESULT_USERIMG = 100;
	private static final int RESULT_USERIMGCROP = 101;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViews();

	}

	private void initViews() {
		setContentView(R.layout.registeractivity);
		backarrow = (ImageButton) findViewById(R.id.includetitle1_backarrow);
		backarrow.setOnClickListener(this);
		title = (TextView) findViewById(R.id.includetitle1_title);
		title.setText("填写手机号");
		vercode = (Button) findViewById(R.id.registeractivity_vercode);
		vercode.setOnClickListener(this);
		phone = (EditText) findViewById(R.id.registeractivity_phone);
		submit = (Button) findViewById(R.id.registeractivity_submit);
		submit.setOnClickListener(this);
		nickname = (EditText) findViewById(R.id.registeractivity_nickname);
		code = (EditText) findViewById(R.id.registeractivity_code);
		pwd = (EditText) findViewById(R.id.registeractivity_pwd);
		pwdagain = (EditText) findViewById(R.id.registeractivity_pwdagain);
		userpic = (ImageButton) findViewById(R.id.registeractivity_userpic);
		userpic.setOnClickListener(this);
		nicknameclear = (ImageButton) findViewById(R.id.registeractivity_nicknameclear);
		nicknameclear.setOnClickListener(this);
		phoneclear = (ImageButton) findViewById(R.id.registeractivity_phoneclear);
		phoneclear.setOnClickListener(this);
		pwdclear = (ImageButton) findViewById(R.id.registeractivity_pwdclear);
		pwdclear.setOnClickListener(this);
		pwdagainclear = (ImageButton) findViewById(R.id.registeractivity_pwdagainclear);
		pwdagainclear.setOnClickListener(this);
		pwdshow = (ImageButton) findViewById(R.id.registeractivity_pwdshow);
		pwdshow.setOnClickListener(this);
		pwdagainshow = (ImageButton) findViewById(R.id.registeractivity_pwdagainshow);
		pwdagainshow.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.includetitle1_backarrow:
			finish();
			break;
		case R.id.registeractivity_nicknameclear:
			nickname.setText("");
			break;
		case R.id.registeractivity_phoneclear:
			phone.setText("");
			break;
		case R.id.registeractivity_pwdclear:
			pwd.setText("");
			break;
		case R.id.registeractivity_pwdagainclear:
			pwdagain.setText("");
			break;
		case R.id.registeractivity_pwdshow:
			if(pwd.getInputType()==(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD)){
				pwd.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_NORMAL);
			}else{
				pwd.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
			}
			break;
		case R.id.registeractivity_pwdagainshow:
			if(pwd.getInputType()==(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD)){
				pwdagain.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_NORMAL);
			}else{
				pwdagain.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
			}
			break;
		case R.id.registeractivity_vercode:
			pTemp = phone.getText().toString();
			if(InputValidateUtil.isPhone(pTemp)){
				ToastUtil.show(this, "请正确输入手机号码");
				return;
			}
			new NetUtil(getPerfectParentsAPP(), registerHandler).urlGetData(NetUtil.appSendCode, pTemp);
			break;
		case R.id.registeractivity_submit:
			nnTemp = nickname.getText().toString();
			cTemp = code.getText().toString();
			pwTemmp = pwd.getText().toString();
			if(InputValidateUtil.isNickname(nnTemp)){
				ToastUtil.show(this, "用户名只能使用字母和数字(6-18位)");
			}else if(InputValidateUtil.isVercode(cTemp)){
				ToastUtil.show(this, "验证码为6为数字");
			}else if(InputValidateUtil.isPassword(pwTemmp)){
				ToastUtil.show(this, "用户名只能使用字母和数字(6-18位)");
			}else if(pwTemmp.equals(pwdagain.getText().toString())){
				ToastUtil.show(this, "两次输入密码不一致");
			};
			new NetUtil(getPerfectParentsAPP(), registerHandler).urlGetData(NetUtil.appCheckCode, cTemp);
			break;
		case R.id.registeractivity_userpic:
			new AlertDialog.Builder(this)
				.setTitle("设置头像")
				.setItems(new String[]{"选择本地图片"}, new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						switch (which) {
						case 0:
							Intent imgIntent = new Intent();
							imgIntent.setType("image/*");
							imgIntent.setAction(Intent.ACTION_GET_CONTENT);
							startActivityForResult(imgIntent,RESULT_USERIMG);
							break;
						default:
							break;
						}
					}
					
				}).setNegativeButton("取消", new DialogInterface.OnClickListener(){

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
					
				}).show();
			break;
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case RESULT_USERIMG:
			if (null == data){
				ToastUtil.show(this, "未选择图片");
			}else{
				Intent intent = new Intent("com.android.camera.action.CROP");
				intent.setDataAndType(data.getData(), "image/*");
				intent.putExtra("crop", "true");
				intent.putExtra("aspectX", 1);
				intent.putExtra("aspectY", 1);
				intent.putExtra("outputX", 320);
				intent.putExtra("outputY", 320);
				intent.putExtra("return-data", true);
				startActivityForResult(intent, RESULT_USERIMGCROP);
			}
			break;

		case RESULT_USERIMGCROP:
			if(data!=null){
				Bundle extras = data.getExtras();
				if(extras!=null){
					Bitmap photo = extras.getParcelable("data");
					if(photo!=null){
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						photo.compress(Bitmap.CompressFormat.PNG, 100, baos);
						byte[] buf = baos.toByteArray();
						File file = new File(Environment.getExternalStorageDirectory(), "headdisplay");
						upTemp = file.getAbsolutePath();
						BufferedOutputStream bos = null;
						FileOutputStream fos = null;
						try {
							fos = new FileOutputStream(file);
							bos = new BufferedOutputStream(fos);
							bos.write(buf);
							userpic.setImageBitmap(photo);
						} catch (Exception e) {
							ToastUtil.show(this, "获取图片失败");
						}finally{
							if(bos!=null){
								try {
									bos.close();
								} catch (IOException e) {
								}
							}
							if(fos!=null){
								try {
									fos.close();
								} catch (IOException e) {
								}
							}
						}
					}else{
						ToastUtil.show(this, "未选择图片");
					}
				}else{
					ToastUtil.show(this, "未选择图片");
				}
			}else{
				ToastUtil.show(this, "未选择图片");
			}
			break;
		}
	}
	
	private class VercodeTimer extends CountDownTimer {
		public VercodeTimer(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		@Override
		public void onTick(long millisUntilFinished) {
			vercode.setText((millisUntilFinished/1000)+"秒后重新获取");
		}

		@Override
		public void onFinish() {
			vercode.setText("重新获取验证码");
		}

	}
	
	private Handler registerHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case NetUtil.RESULTTRUE+NetUtil.appSendCode:
				ToastUtil.show(RegisterActivity.this, "验证码已发送至您的手机");
				break;
			case NetUtil.RESULTNULL+NetUtil.appSendCode:
				ToastUtil.show(RegisterActivity.this, "手机号格式不正确");
				break;
			case NetUtil.RESULTFALSE+NetUtil.appSendCode:
				ToastUtil.show(RegisterActivity.this, "该手机号已经注册过");
				break;
			case NetUtil.RESULTTRUE+NetUtil.appCheckCode:
				new NetUtil(getPerfectParentsAPP(), this).urlGetData(NetUtil.save, nnTemp,pTemp,pwTemmp,upTemp);
				break;
			case NetUtil.RESULTNULL+NetUtil.appCheckCode:
				ToastUtil.show(RegisterActivity.this, "验证码过期");
				break;
			case NetUtil.RESULTFALSE+NetUtil.appCheckCode:
				ToastUtil.show(RegisterActivity.this, "验证码输入错误");
				break;
			case NetUtil.RESULTFALSE+NetUtil.save:
				ToastUtil.show(RegisterActivity.this, "该用户已经注册过");
				break;
			case NetUtil.RESULTTRUE+NetUtil.save:
				ToastUtil.show(RegisterActivity.this, "注册成功");
				break;
			}
		};
	};
}
