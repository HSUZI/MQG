package com.qingqu.wc.maqi.httpjson.okhttp;

import android.annotation.SuppressLint;
import android.content.Context;

import com.qingqu.wc.maqi.config.MaqiInfo;
import com.qingqu.wc.maqi.httpjson.jsonparser.NetController;
import com.qingqu.wc.maqi.httpjson.okhttp.listener.RequestObjectCallback;
import com.qingqu.wc.maqi.httpjson.okhttp.request.OkhttpRequest;
import com.qingqu.wc.maqi.httpjson.okhttp.request.RequestParam;
import com.qingqu.wc.maqi.httpjson.okhttp.respose.OkhttpResponseHandler;
import com.qingqu.wc.maqi.utlis.Utils;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpManager {
	private static final long CONNECT_TIMEOUT = 10;
	private static final long READ_TIMEOUT = 10;
	private static final long WRITE_TIMEOUT = 10;
	
	private static OkHttpManager mOkHttpManager;
	private OkHttpClient mClient;
	private Context mContext;
	private NetController mNetController;
	private OkHttpManager(Context context) {
		mContext=context;
		mClient = new OkHttpClient.Builder()

					.connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
					.readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
					.writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
					.followRedirects(true)
					.build();
		mNetController = new NetController(mContext);


	}
	
	public static OkHttpManager getInstance(Context context){
		if(mOkHttpManager==null){
			synchronized (OkHttpManager.class) {
				if(mOkHttpManager==null){
					mOkHttpManager=new OkHttpManager(context.getApplicationContext());
				}
			}
		}
		return mOkHttpManager;
	}
	
	@SuppressLint("DefaultLocale")
	public  <T> void doPost(String url, Map<String,String> params, RequestObjectCallback<T> l){
		if(url.toLowerCase().startsWith("https")){
			String srtURl=url.replace(MaqiInfo.payUrlOnline, "");
			Utils.LogD("瑪奇購", "doPost request 参数:" +getParams(params)+"  \ndoPOST url:"+srtURl);
			new OkhttpResponseHandler<T>(l).handleResult(mNetController.asyncCallNetRequest(getParams(params), srtURl, false));
		}else{
			post(url, params, new OkhttpResponseHandler<T>(l));
		}
	}
	public  <T> void doGet(String url, Map<String,String> params, RequestObjectCallback<T> l){
		get(url, params, new OkhttpResponseHandler<T>(l));
	}
	
	
	
	private <T>void post(String url, Map<String,String> params, OkhttpResponseHandler<T> mHandler){
		Request request=OkhttpRequest.postRequst(url, new RequestParam(params));
		mClient.newCall(request).enqueue(mHandler);
	}
	
	private <T>void get(String url, Map<String,String> params, OkhttpResponseHandler<T> mHandler){
		
		Request request= OkhttpRequest.getRequst(url, new RequestParam(params));
		mClient.newCall(request).enqueue(mHandler);
	}
	/**
	 * 将参数转成String
	 * @param maps
	 * @return
	 */
	private String getParams(Map<String,String> maps) {
		if(maps==null){
			return "";
		}
		StringBuilder params = new StringBuilder();
		for (Map.Entry<String,String> entry : maps.entrySet()) {
			if (params.length() == 0 ){
				params.append(entry.getKey() + "=" + entry.getValue());
			}else{
				params.append("&" + entry.getKey() + "=" + entry.getValue());
			}
			
		}
		return params.toString();
	}
	
	

}
