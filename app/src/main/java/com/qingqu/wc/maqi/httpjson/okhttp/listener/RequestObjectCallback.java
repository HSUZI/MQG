package com.qingqu.wc.maqi.httpjson.okhttp.listener;

import java.lang.reflect.ParameterizedType;

public abstract class RequestObjectCallback<T> {
	
	private Class<T> mClazz;
	
	@SuppressWarnings("unchecked")
	public RequestObjectCallback() {
		ParameterizedType type=(ParameterizedType) getClass().getGenericSuperclass();
		mClazz =(Class<T>) type.getActualTypeArguments()[0];
	}
	
	public Class<T> getDataClass(){
		return mClazz;
	}
	
	public abstract void onResponse(T response);
	/**
	 * 失败
	 * @param err 请求数据成功返回的错误
	 */
	public abstract void onError(String err);
	/**
	 * 失败
	 * @param err 请求数据失败抛出的异常
	 */
	public abstract void onDataRequestError(Throwable error);
}
