package com.qingqu.wc.maqi.httpjson.model.respose;
/**
 * 接口数据通用响应类
 */
public class JsonResponseModel<T> {

	/* 接口名称，对应API名称 */
//	public String api_name;
	/* 返回信息描述 */
	public String resp_msg;
	/* 返回码 */
	public String resp_code;
	/* 返回详情 */
	public T response_detail;

//	public String getApi_name() {
//		return api_name;
//	}
//
//	public void setApi_name(String api_name) {
//		this.api_name = api_name;
//	}

	public String getResp_msg() {
		return resp_msg;
	}

	public void setResp_msg(String resp_msg) {
		this.resp_msg = resp_msg;
	}

	public String getResp_code() {
		return resp_code;
	}

	public void setResp_code(String resp_code) {
		this.resp_code = resp_code;
	}

	public T getResponse_detail() {
		return response_detail;
	}

	public void setResponse_detail(T response_detail) {
		this.response_detail = response_detail;
	}
}

///** 版本号 */
//private String ver;
///** 登陆token */
//private String authToken;
///** 终端号 */
//private String terminalNo;
///** 设备类型 */
//private String deviceType;
///** 设备信息 */
//private String deviceInfo;
///** 客户号  */
//private String loginCustNo;
///** */
//private String timestamp;
///** */
//private String sign;




