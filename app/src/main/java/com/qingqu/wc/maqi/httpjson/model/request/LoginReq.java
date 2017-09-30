package com.qingqu.wc.maqi.httpjson.model.request;

import android.util.Log;

import com.qingqu.wc.maqi.utlis.Utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2017/9/29.
 */

public class LoginReq extends MiddleRequestModel{
    public String account;
    public String passwd;

    LoginReq() {}

    public LoginReq(String account, String passwd) {
        this.account = account;
        this.passwd = passwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getParams() {
        StringBuilder params = new StringBuilder();
        Field[] fs = getClass().getFields();
        try {
            for (Field f : fs) {

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
        Utils.print("请求参数：" + params.toString());
        return params.toString();
    }
}
