package com.qingqu.wc.maqi.httpjson.model.request;

import android.annotation.SuppressLint;

import com.qingqu.wc.maqi.config.MaqiInfo;
import com.qingqu.wc.maqi.utlis.Utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.HashMap;


@SuppressLint("SimpleDateFormat")
public class MiddleRequestModel{ //extends JsonRequestModel

    public HashMap<String, String> getMapParams(){
//        setSign(getParamSign());
        HashMap<String, String> params=new HashMap<String, String>();
        Field[] fs = getClass().getFields();
        for (Field f : fs) {
            try {
                if (f.getName().equals("$change") || f.getName().equals("serialVersionUID")) {
                    continue;
                }
                if ((String) f.get(this) != null && !((String) f.get(this)).equals("")) {
                    if(MaqiInfo.isOnline) {
                        params.put(""+f.getName()+"", URLEncoder.encode((String) f.get(this), "UTF-8"));
                    } else {
                        if(MaqiInfo.isTest) {
                            params.put(""+f.getName()+"", (String) f.get(this));
                        } else {
                            params.put(""+f.getName()+"", (String) f.get(this));
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                Utils.print(e);
            } catch (IllegalArgumentException e) {

                Utils.print(e);
            } catch (UnsupportedEncodingException e) {

                Utils.print(e);
            }
        }

        return params;
    }
}
