package com.qingqu.wc.maqi.httpjson.Config;


import com.qingqu.wc.maqi.config.MaqiInfo;

public class Addresses {

    public static String getUrl() {
        String reqUrl = "";
        if (MaqiInfo.isOnline) {
            reqUrl = MaqiInfo.payUrlOnline;
        } else {
            reqUrl = MaqiInfo.payUrlOnline;
        }
        return reqUrl;
    }
}
