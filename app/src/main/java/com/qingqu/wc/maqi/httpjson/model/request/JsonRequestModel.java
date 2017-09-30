package com.qingqu.wc.maqi.httpjson.model.request;

import android.annotation.SuppressLint;

import com.qingqu.wc.maqi.utlis.Utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 接口数据通用请求类
 */
@SuppressLint("SimpleDateFormat")
public class JsonRequestModel {
	
	/** 授权token */
	public String authToken = "";
	/** 签名 */
	public String sign;
	
	protected void setSign(String sign) {
		this.sign = sign;
	}
    
//	public String getParamSign() {
//
//		StringBuilder params = new StringBuilder();
//		Field[] fs = getClass().getFields();
//		String[] fieldNames = new String[fs.length];
//		try {
//			for (int i = 0; i < fs.length; i++) {
//				fieldNames[i] = fs[i].getName();
//			}
//			Arrays.sort(fieldNames);
//			for (int i = 0; i < fs.length; i++) {
//
//				String s = "";
//				// Instant Run generated
//				if (fieldNames[i].equals("$change") || fieldNames[i].equals("serialVersionUID")) {
//					continue;
//				} else {
//					s = (String) getClass().getField(fieldNames[i]).get(this);
//				}
//
//				if (s != null && !s.equals("")) {
//					if (params.length() == 0)
//						params.append(fieldNames[i] + "=" + s);
//					else
//						params.append("&" + fieldNames[i] + "=" + s);
//				}
//			}
//		} catch (NoSuchFieldException e) {
//			Utils.print(e);
//		} catch (IllegalAccessException e) {
//			Utils.print(e);
//		} catch (IllegalArgumentException e) {
//			Utils.print(e);
//		}
//		Utils.print("sign = " + params.toString());
//		return SecurityUtils.encryptSign(params.toString());
//	}

	public String getParams() {
//		setSign(getParamSign());
		StringBuilder params = new StringBuilder();
		Field[] fs = getClass().getFields();
		try {
			for (Field f : fs) {

				// Instant Run generated
				if (f.getName().equals("$change") || f.getName().equals("serialVersionUID")) {
					continue;
				}

				if ((String) f.get(this) != null && !((String) f.get(this)).equals("")) {
					if (params.length() == 0 )
						params.append(f.getName() + "=" + URLEncoder.encode((String) f.get(this), "UTF-8"));
					else
						params.append("&" + f.getName() + "=" + URLEncoder.encode((String) f.get(this), "UTF-8"));
				}
			}
		} catch (IllegalAccessException e) {

			Utils.print(e);
		} catch (IllegalArgumentException e) {

			Utils.print(e);
		} catch (UnsupportedEncodingException e) {

			Utils.print(e);
		}
		return params.toString();
	}
}
