package com.toplong.perfectparents.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
	private static Toast mToast = null;

	public static void show(Context context, String text) {
		if (mToast == null) {
			mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
		} else {
			mToast.setText(text);
			mToast.setDuration(Toast.LENGTH_SHORT);
		}
		mToast.show();
	}
}
