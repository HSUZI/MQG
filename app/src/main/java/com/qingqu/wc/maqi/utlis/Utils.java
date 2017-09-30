package com.qingqu.wc.maqi.utlis;

import com.qingqu.wc.maqi.config.MaqiApplication;

/**
 * 日志工具类
 * Created by SuZi on 2017/9/29.
 */

public class Utils {

    public final static void LogD(String tag, String msg) {
        if (MaqiApplication.Debug) {
            android.util.Log.d(tag, msg);
        }
    }

    public final static void printException(Exception e) {
        if (MaqiApplication.Debug) {
            e.printStackTrace();
        }
    }


    /**
     * @param obj
     */
    public final static void print(Object obj) {
        if (MaqiApplication.Debug) {
            if (null != obj) {
                if (obj instanceof String) {
                    print((String) obj);
                } else if (obj instanceof byte[]) {
                    print((byte[]) obj);
                } else {
                    System.out.println(obj);
                }
            }
        }
    }

    /**
     * @param s
     */
    public final static void print(String s) {
        if (MaqiApplication.Debug) {
            if (null != s) {
                int length = s.length();
                int offset = 3000;
                if (length > offset) {// 解决报文过长，打印不全的问题
                    int n = 0;
                    for (int i = 0; i < length; i += offset) {
                        n += offset;
                        if (n > length)
                            n = length;
                        System.err.println("Debug = " + s.substring(i, n));
                    }
                } else {
                    System.err.println("Debug = " + s);
                }
            }
        }
    }

    /**
     * @param byts
     */
    public final static void print(byte[] byts) {
        if (MaqiApplication.Debug) {
            if (byts == null) {
                return;
            }
            for (int i = 0; i < byts.length; i++) {
                System.out.print("[" + i + "]" + " : \t");
                System.out.println(byts[i]);
            }
        }
    }


}
