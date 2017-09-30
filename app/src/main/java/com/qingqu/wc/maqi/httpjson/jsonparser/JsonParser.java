package com.qingqu.wc.maqi.httpjson.jsonparser;

import com.google.gson.Gson;
import com.qingqu.wc.maqi.httpjson.model.respose.JsonResponseModel;
import com.qingqu.wc.maqi.utlis.Utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


/**
 * 
 * Json解析类
 * 
 */
public class JsonParser {

	/**
	 * Json请求封装
	 * 
	 */
	public static String toJson(Object value) {
		Gson gson = new Gson();
		String str = gson.toJson(value);
		return str;
	}

	/**
	 * Json响应解析
	 * 
	 * @param
	 */

	@SuppressWarnings("rawtypes")
	public static JsonResponseModel fromJson(String json, Class clazz) {
		Gson gson = new Gson();
		Type objectType = type(JsonResponseModel.class, clazz);
		try {
			Utils.print("解析Json成功 (JsonParser.java)===" + gson.fromJson(json, objectType));
			return gson.fromJson(json, objectType);
		} catch (Exception e) {
			Utils.print("解析Json异常(JsonParser.java)==="+e);
			Utils.print(e);
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	static ParameterizedType type(final Class raw, final Type... args) {
		return new ParameterizedType() {
			public Type getRawType() {
				return raw;
			}

			public Type[] getActualTypeArguments() {
				return args;
			}

			public Type getOwnerType() {
				return null;
			}
		};
	}
}
