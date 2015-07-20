package com.toplong.perfectparents.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.toplong.perfectparents.R;


public class AccountInfoActivity extends BaseActivity implements OnClickListener{
	
	private TextView title;
	private ImageButton backarrow;
	private LinearLayout perfectid,phoneaccount,customaccount,erweipic,socialaccount;
	private Button submit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViews();
	}
	
	private void initViews(){
		setContentView(R.layout.accountinfoactivity);
		backarrow = (ImageButton) findViewById(R.id.includetitle1_backarrow);
		backarrow.setOnClickListener(this);
		title = (TextView) findViewById(R.id.includetitle1_title);
		title.setText("’ ∫≈–≈œ¢");
		perfectid = (LinearLayout) findViewById(R.id.accountinfoactivity_perfectid);
		phoneaccount = (LinearLayout) findViewById(R.id.accountinfoactivity_phoneaccount);
		customaccount = (LinearLayout) findViewById(R.id.accountinfoactivity_customaccount);
		erweipic = (LinearLayout) findViewById(R.id.accountinfoactivity_erweipic);
		socialaccount = (LinearLayout) findViewById(R.id.accountinfoactivity_socialaccount);
		submit = (Button) findViewById(R.id.accountinfoactivity_submit);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.includetitle1_backarrow:
			finish();
			break;
		case R.id.accountinfoactivity_submit:
			finish();
			break;
		case R.id.accountinfoactivity_perfectid:
			finish();
			break;
		case R.id.accountinfoactivity_phoneaccount:
			finish();
			break;
		case R.id.accountinfoactivity_customaccount:
			finish();
			break;
		case R.id.accountinfoactivity_erweipic:
			finish();
			break;
		case R.id.accountinfoactivity_socialaccount:
			finish();
			break;
		}
		
	}
}