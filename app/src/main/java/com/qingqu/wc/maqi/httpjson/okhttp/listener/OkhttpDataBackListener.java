package com.qingqu.wc.maqi.httpjson.okhttp.listener;

import java.io.IOException;

public interface OkhttpDataBackListener {
	
	public void onSuccess(String result);
	
	public void onFailure(IOException err);
	
}
