package com.qingqu.wc.maqi.httpjson.okhttp.request;

import com.qingqu.wc.maqi.utlis.Utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Request;

public class OkhttpRequest {
	
	
	/**
	 * post请求
	 * @param url
	 * @param params
	 * @return
	 */
	public static Request postRequst(String url, RequestParam params){
		FormBody.Builder form=new FormBody.Builder();
		if(params.urlParams!=null){
			for(Map.Entry<String,String> entry : params.urlParams.entrySet()){
				form.add(""+entry.getKey(), ""+entry.getValue());
			}
		}
		printParam(params,url);
		return new Request.Builder()
						.url(url)
						.post(form.build())
						.build();
	}
	/**
	 * get请求
	 * @param url
	 * @param params
	 * @return
	 */
	public static Request getRequst(String url, RequestParam params){
		StringBuffer sb=new StringBuffer();
		if(params.urlParams!=null){
			for(Map.Entry<String,String> entry : params.urlParams.entrySet()){
				if(sb.length()==0){
					sb.append("?"+entry.getKey()+"="+entry.getValue());
				}else{
					sb.append("&"+entry.getKey()+"="+entry.getValue());
				}
			}
		}
		printParam(params,url+sb.toString());
		return new Request.Builder()
		.url(url+sb.toString())
		.build();
	}
	/**
	 * 打印提交的参数信息
	 * @param params
	 * @param url
	 */
	private static void printParam(RequestParam params,String url){
		StringBuilder stringBuilder = new StringBuilder();
		Iterator<String> iterator = params.urlParams.keySet().iterator();

		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			String val = "";
			try {
				val = URLEncoder.encode(params.urlParams.get(key), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			stringBuilder.append("&" + key + "=" + val);
		}
		Utils.LogD("瑪奇購", "提交参数 "+ stringBuilder.toString()+"\nurl:"+url);
	}

}
