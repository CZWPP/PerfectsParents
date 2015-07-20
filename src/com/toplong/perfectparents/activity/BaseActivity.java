package com.toplong.perfectparents.activity;

import com.toplong.perfectparents.app.PerfectParents;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


public class BaseActivity extends FragmentActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	public PerfectParents getPerfectParentsAPP(){
		return (PerfectParents) getApplicationContext();
	}
	
}
