package com.qingqu.wc.maqi.config;

/**
 * Created by SuZi on 2017/9/29.
 */

public class MaqiInfo {
    /**
     * 是否生产环境 true为真实环境 false为开发环境的
     */
    public static boolean isOnline = false;

    public static boolean isTest = false;

    public static String payUrlOnline = "http://adm.gxhi.space/api";  //生产环境

    public static String payUrlTest = "http://adm.gxhi.space/api";  //测试环境
}
