package com.qingqu.wc.maqi.httpjson.okhttp;

import com.qingqu.wc.maqi.config.MaqiApplication;
import com.qingqu.wc.maqi.httpjson.Config.Addresses;
import com.qingqu.wc.maqi.httpjson.Config.Urls;
import com.qingqu.wc.maqi.httpjson.okhttp.listener.RequestObjectCallback;
import com.qingqu.wc.maqi.httpjson.okhttp.respose.LoginResponse;

import java.util.HashMap;


public class HttpHelper {
	
	private static <T> void httpRequest (String url, final HashMap<String, String> params, final RequestObjectCallback<T> listener) {
		OkHttpManager.getInstance(MaqiApplication.getInstance()).doPost(url,params,listener);
	}
	
	private static <T> void httpGetRequest (String url, final HashMap<String, String> params, final RequestObjectCallback<T> listener) {
		OkHttpManager.getInstance(MaqiApplication.getInstance()).doGet(url,params,listener);
	}


	/**
	 *  用户登录
	 * @param listener
	 */
	public static void logined(HashMap<String, String> params, RequestObjectCallback<LoginResponse> listener){
		httpRequest(Addresses.getUrl()+ Urls.LOGINURL, params, listener);
	}


}
