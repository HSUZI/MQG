package com.qingqu.wc.maqi.config;

import android.app.Application;

import com.qingqu.wc.maqi.httpjson.Config.MaQiEnmType;
import com.qingqu.wc.maqi.utlis.Utils;

/**
 * Created by SuZi on 2017/9/29.
 */

public class MaqiApplication extends Application {
    // Utils.java日志打印开关
    public static final boolean Debug = true;
//	public static final boolean Debug = false;

    // 修改环境只要修改这里
//	private MaQiEnmType enmType = MaQiEnmType.DEPOENM;
	private MaQiEnmType enmType = MaQiEnmType.TESTENM;
//    private MaQiEnmType enmType = MaQiEnmType.PROENM;

    public static MaqiApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        // 设置环境
        initAllEnm();
    }

    /**
     * 初始化环境
     */
    private void initAllEnm() {
        // 设置原来接口的环境
        if (enmType == MaQiEnmType.TESTENM) {
            Utils.print("配置了测试环境");
            MaqiInfo.isOnline = false;
            MaqiInfo.isTest = true;
        } else if (enmType == MaQiEnmType.DEPOENM) {
            Utils.print("配置了开发环境");
            MaqiInfo.isOnline = false;
            MaqiInfo.isTest = false;
        } else if (enmType == MaQiEnmType.PROENM) {
            Utils.print("配置了生产环境");
            MaqiInfo.isOnline = true;
            MaqiInfo.isTest = false;
        } else {
            Utils.print("配置了生产环境");
            MaqiInfo.isOnline = true;
            MaqiInfo.isTest = false;
        }
    }

    public static MaqiApplication getInstance() {
        return instance;
    }
}
