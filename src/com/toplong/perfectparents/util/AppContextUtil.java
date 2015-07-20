package com.toplong.perfectparents.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;



public class AppContextUtil {
	
	public static String getDeviceId(Context context){
		TelephonyManager tm = (TelephonyManager) context.getSystemService( Context.TELEPHONY_SERVICE );
		return tm.getDeviceId();
	}
	
	public static String getAppName(Context context){
		try {
			PackageManager pm = context.getPackageManager();
			PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
			return context.getResources().getString(pi.applicationInfo.labelRes);
		} catch (NameNotFoundException e) {
			return null;
		}
	}
	
	public static String getVersionName(Context context){
		try {
			PackageManager pm = context.getPackageManager();
			return pm.getPackageInfo(context.getPackageName(), 0).versionName;
		} catch (NameNotFoundException e) {
			return null;
		}
	}
	
	public static int getVersionCode(Context context){
		try {
			PackageManager pm = context.getPackageManager();
			return pm.getPackageInfo(context.getPackageName(), 0).versionCode;
		} catch (NameNotFoundException e) {
			return 0;
		}
	}
	
	public static String getVersionName(int versionCode){
		String vaseName = "1.9.0";
		String v[] = vaseName.split("\\.");
		int v2 = versionCode%10;
		int v1 = versionCode/10-4+Integer.parseInt(v[1]);
		int v0 = v1/10+Integer.parseInt(v[0]);
		v1 = v1%10;
		return v0+"."+v1+"."+v2;
	}
}
