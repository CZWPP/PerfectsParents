package com.toplong.perfectparents.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.toplong.perfectparents.R;


public class UpdateInfoOneActivity extends BaseActivity implements OnClickListener{
	
	private TextView title;
	private EditText content;
	private Button finish;
	private ImageButton contentclear;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViews();
	}
	
	private void initViews(){
		setContentView(R.layout.updateinfoactivityone);
		title = (TextView) findViewById(R.id.includetitle2_title);
		finish = (Button) findViewById(R.id.includetitle2_operation);
		content = (EditText) findViewById(R.id.udpateinfoactivityone_content);
		contentclear = (ImageButton) findViewById(R.id.udpateinfoactivityone_contentclear);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.udpateinfoactivityone_contentclear:
			
			break;

		case R.id.includetitle2_operation:
			
			break;
		}
		
	}
	
	
}