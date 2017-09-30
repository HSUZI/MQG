package com.qingqu.wc.maqi.httpjson.okhttp.request;

import java.util.HashMap;
import java.util.Map;

public class RequestParam {
	public Map<String, String> urlParams=new HashMap<String, String>();
	public Map<String, Object> fileParams=new HashMap<String, Object>();
	
	public RequestParam() {
		
	}

	public RequestParam(Map<String, String> params){
		if(params!=null){
			for (Map.Entry<String, String> entry: params.entrySet()) {
				urlParams.put(""+entry.getKey(), ""+entry.getValue());
			}
		}
	}
	
	public void put(String key, String value){
		urlParams.put(key, value);
	}
	
	public void putFile(String key, Object value){
		fileParams.put(key, value);
	}
}
