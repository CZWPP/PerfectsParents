package com.toplong.perfectparents.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedUtil {
	
	private SharedPreferences sp;
	private static SharedUtil su;
	private SharedUtil(Context context){
		sp = context.getSharedPreferences("appconfig", Context.MODE_PRIVATE);
	}
	public static SharedUtil newInstance(Context context){
		if(su == null){
			su = new SharedUtil(context.getApplicationContext());
		}
		return su;
	}
	
	public boolean isFirst(){
		return sp.getBoolean("is_first", true);
	}
	
	public void putIsFirst(){
		sp.edit().putBoolean("is_first", false).commit();
	}
	
	public String getUser(){
		return sp.getString("user", "");
	}
	
	public void putUser(String userInfo){
		sp.edit().putString("user", userInfo).commit();
	}
}
