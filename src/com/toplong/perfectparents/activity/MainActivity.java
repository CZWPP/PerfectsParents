package com.toplong.perfectparents.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.toplong.perfectparents.R;
import com.toplong.perfectparents.view.slidingmenulib.SlidingMenu;
import com.toplong.perfectparents.view.slidingmenulib.app.SlidingFragmentActivity;



public class MainActivity extends SlidingFragmentActivity implements OnClickListener{
	
	private SlidingMenu slidingMenu;
	private ImageButton userpic;
	private Button logout;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initViews();
	}
	
	private void initViews(){
		setContentView(R.layout.mainactivity_mainview);
		slidingMenu = getSlidingMenu();
		slidingMenu.setBehindOffsetRes(R.dimen.mainactivity_leftview);
		slidingMenu.setMode(SlidingMenu.LEFT);
		slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		setBehindContentView(R.layout.mainactivity_leftview);
		userpic = (ImageButton) findViewById(R.id.mainactivity_left_userpic);
		userpic.setOnClickListener(this);
		logout = (Button) findViewById(R.id.mainactivity_left_logout);
		logout.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mainactivity_left_userpic:
			Intent perinfoIntent = new Intent(this,PersonInfoActivity.class);
			startActivity(perinfoIntent);
			break;
		case R.id.mainactivity_left_logout:
			getPerfectParentsAPP().setCurrentUser(null);
			Intent loginIntent = new Intent(this,LoginActivity.class);
			startActivity(loginIntent);
			break;
		}
		
	}


}
