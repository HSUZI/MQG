package com.qingqu.wc.maqi.httpjson.okhttp.respose;

import com.google.gson.annotations.SerializedName;
import com.qingqu.wc.maqi.httpjson.model.respose.LoginModel;

import java.util.List;

/**
 * 登录响应类
 * Created by SuZi on 2017/9/29.
 */

public class LoginResponse {
    @SerializedName("code")
    public int code;
    @SerializedName("msg")
    public String msg;
    @SerializedName("data")
    public List<LoginModel> data;
    public int uid;
    public String access_token;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<LoginModel> getData() {
        return data;
    }

    public void setData(List<LoginModel> data) {
        this.data = data;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
