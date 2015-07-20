package com.toplong.perfectparents.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.http.Header;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.toplong.perfectparents.app.PerfectParents;
import com.toplong.perfectparents.entity.User;

public class NetUtil extends AsyncTask<Void, Void, Void>{
	
	public String httpurl = "http://192.168.1.240/PerfectBefriend/";
	public static final int RESULTNULL = -100;
	public static final int RESULTFALSE = -200;
	public static final int RESULTTRUE = 100;
	public static final int Login = 1;
	public static final int appSendCode = 2;
	public static final int appCheckCode = 3;
	public static final int save = 4;

	private Handler h;
	private PerfectParents ppCtx;
	private static AsyncHttpClient httpClient = new AsyncHttpClient();
	private String urlStr;
	private int inter;
	public NetUtil(PerfectParents ppContext,Handler handler) {
		ppCtx = ppContext;
		h = handler;
	}
	
	public void urlGetData(int inter,String... params){
		this.inter = inter;
		switch (inter) {
		case Login:
			urlStr = httpurl+"Login"+"?username="+params[0]+"&password="+params[1];
			execute();
			break;
		case appSendCode:
			urlStr = httpurl+"appSendCode";
			asyncHttpClient(params);
			break;
		case appCheckCode:
			urlStr = httpurl+"appCheckCode";
			asyncHttpClient(params);
			break;
		case save:
			urlStr = httpurl+"save";
			asyncHttpClient(params);
			break;
		}
	}
	
	@Override
	protected Void doInBackground(Void... params) {
		HttpURLConnection conn = null;
		InputStream is = null;
		try {
			URL url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(10000);
			conn.setReadTimeout(10000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
			StringBuffer result = new StringBuffer();
			String line = null;
			while((line=br.readLine())!=null){
				result.append(line);
			}
			handleUrlData(result.toString());
		} catch (Exception e) {
			Log.d("news", e+"");
		}finally{
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null){
				conn.disconnect();
			}
		}
		return null;
	}
	
	private void handleUrlData(String urlResult){
		switch (inter) {
		case Login:
			if("null".equals(urlResult)){
				h.sendEmptyMessage(RESULTNULL+inter);
			}else if("false".equals(urlResult)){
				h.sendEmptyMessage(RESULTFALSE+inter);
			}else{
				SharedUtil.newInstance(ppCtx).putUser(urlResult);
				User u = new Gson().fromJson(urlResult, User.class);
				ppCtx.setCurrentUser(u);
				h.sendEmptyMessage(RESULTTRUE+inter);
			}
			break;
		}
	}
	
	private void asyncHttpClient(String... params){
		RequestParams p = new RequestParams();
		try {
			switch (inter) {
			case appSendCode:
				p.put("phone", params[0]);
				break;
			case appCheckCode:
				p.put("code", params[0]);
				break;
			case save:
				p.put("nickname", params[0]);
				p.put("phone", params[1]);
				p.put("password", params[2]);
				p.put("file", new File(params[3]));
				break;
			}
		} catch (Exception e) {
		}
		httpClient.post(urlStr, p, new AsyncHttpResponseHandler(){
			@Override
			public void onSuccess(int statusCode, Header[] headers,byte[] responseBody){
				String urlResult = new String(responseBody);
				switch (inter) {
				case appSendCode:
					if("null".equals(urlResult)){
						h.sendEmptyMessage(RESULTNULL+inter);
					}else if("false".equals(urlResult)){
						h.sendEmptyMessage(RESULTFALSE+inter);
					}else if("true".equals(urlResult)){
						h.sendEmptyMessage(RESULTTRUE+inter);
					}
					break;
				case appCheckCode:
					if("null".equals(urlResult)){
						h.sendEmptyMessage(RESULTNULL+inter);
					}else if("false".equals(urlResult)){
						h.sendEmptyMessage(RESULTFALSE+inter);
					}else if("true".equals(urlResult)){
						h.sendEmptyMessage(RESULTTRUE+inter);
					}
					break;
				case save:
					if("false".equals(urlResult)){
						h.sendEmptyMessage(RESULTFALSE+inter);
					}else{
						SharedUtil.newInstance(ppCtx).putUser(urlResult);
						User u = new Gson().fromJson(urlResult, User.class);
						ppCtx.setCurrentUser(u);
						h.sendEmptyMessage(RESULTTRUE+inter);
					}
					break;

				default:
					break;
				}
			}

			@Override
			public void onFailure(int statusCode, Header[] headers,byte[] responseBody, Throwable error){
			}
		});
	}
	
} 
