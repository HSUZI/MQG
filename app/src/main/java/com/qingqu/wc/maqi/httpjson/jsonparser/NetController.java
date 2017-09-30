package com.qingqu.wc.maqi.httpjson.jsonparser;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

import com.qingqu.wc.maqi.config.MaqiInfo;
import com.qingqu.wc.maqi.httpjson.Config.Addresses;
import com.qingqu.wc.maqi.utlis.Utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class NetController extends AbstractRequest {
    private Context context;
    private int timeout = 20000;
    private String result;
    private Thread thread;
    private String url;
    /**
     * 流量充值的请求地址的标志位
     */
    public final static int FLOWCHARGETYPE = 1;
    final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {

        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    public NetController(Context context) {
        this.context = context;
//		this.url = UrlType.ENMURL;
//        this.url = Addresses.getUrl();
    }

    /**
     * 同步请求数据
     *
     * @param param
     * @param isTips 能否关闭loading
     * @return
     */
    public String syncCallNetRequest(String param, boolean isTips) {
        // syncLoadingController(true, isTips);
        String result = callNetRequestPost(param);
        // syncLoadingController(false, isTips);
        return result;
    }

    /**
     * 同步 关闭网络
     *
     * @param t
     */
    public static void syncStopThread(Thread t) {
        t.interrupt();
    }


    /**
     * 不带请求地址的网络请求方法
     */
    public String asyncCallNetRequest(final String param, boolean isTips) {
        result = "";
        thread = new Thread(new Runnable() {

            @Override
            public void run() {
                result = callNetRequestPost(param);
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Utils.printException(e);
        }
        return result;

    }

    /**
     * 带请求地址的网络请求方法
     */
    public String asyncCallNetRequest(final String param, final String url, boolean isTips) {
        result = "";
        final String reqUrl;
        if (MaqiInfo.isOnline) {
            reqUrl = MaqiInfo.payUrlOnline + url;
        } else {
            reqUrl = MaqiInfo.payUrlTest + url;
        }

        thread = new Thread(new Runnable() {

            @Override
            public void run() {
                result = callNetRequestPost(param, reqUrl);
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            Utils.printException(e);
        }
        // context.stopLoading();
        return result;

    }

    public void asyncCallNetRequest(final String param, final Handler handler) {
        result = "";
//		context.showLoading();
        thread = new Thread(new Runnable() {

            @Override
            public void run() {
                result = callNetRequestPost(param);
                Bundle bundle = new Bundle();
                Message message = new Message();
                bundle.putString("result", result);
                message.setData(bundle);
                handler.sendMessage(message);

            }
        });
        thread.start();

    }

    public void syncStopThread() {
        thread.interrupt();
    }

    private static void trustAllHosts() {
        final String TAG = "trustAllHosts";
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {

            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[]{};
            }

            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                // Log.i(TAG, "checkClientTrusted");
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                // Log.i(TAG, "checkServerTrusted");
            }
        }};

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());

            if (24 <= Build.VERSION.SDK_INT) {
                // do nothing
            } else {
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            }
        } catch (Exception e) {
            Utils.print(e);
        }
    }

    /**
     * 不带请求地址的网络请求 Post方法
     */
    @Override
    public String callNetRequestPost(String param) {
        if (TextUtils.isEmpty(url))
            Utils.print("ERROR：未初始化环境");
        Utils.print("请求参数====" + param);
        Utils.print("请求url====" + url);
        String result = "";
        BufferedReader read = null;
        PrintWriter pw = null;
        HttpURLConnection conn = null;
        try {
            URL realurl = new URL(url);
            trustAllHosts();
            HttpsURLConnection https = null;//(HttpsURLConnection)realurl.openConnection();
            if (realurl.getProtocol().toLowerCase().equals("https")) {
                https = (HttpsURLConnection) realurl.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                conn = https;
            } else {
                conn = (HttpURLConnection) realurl.openConnection();
            }
//			HttpURLConnection conn = (HttpURLConnection) realurl
//					.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(600000);
            conn.setReadTimeout(600000);
            conn.connect();
            pw = new PrintWriter(conn.getOutputStream());
            pw.write(param);
            pw.flush();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                Utils.print(" Error===" + responseCode);
            } else {
                Utils.print("Post Success!");
            }
            read = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "utf-8"));
            String line;// 循环读取
            while ((line = read.readLine()) != null) {
                result += line;
            }
            Utils.print("返回数据====" + result);
        } catch (MalformedURLException e) {
            Utils.printException(e);

        } catch (IOException e) {
            Utils.printException(e);
        } finally {
            if (read != null) {// 关闭流
                try {
                    read.close();
                } catch (IOException e) {
                    Utils.printException(e);
                }
            }
            if (pw != null) {
                pw.close();
            }

        }
        return result;
    }

    /**
     * 带请求地址的网络请求 Post方法
     */
    public String callNetRequestPost(String param, String url) {
//		url = "http://172.20.16.126/recharge/mobileData.do";
        if (TextUtils.isEmpty(url))
            Utils.print("ERROR：未初始化环境");
        Utils.print("请求参数====" + param);
        Utils.print("请求url====" + url);
        String result = "";
        BufferedReader read = null;
        PrintWriter pw = null;
        HttpURLConnection conn = null;
        try {
            URL realurl = new URL(url);
            trustAllHosts();
            HttpsURLConnection https = null;//(HttpsURLConnection)realurl.openConnection();
            if (realurl.getProtocol().toLowerCase().equals("https")) {
                https = (HttpsURLConnection) realurl.openConnection();
                https.setHostnameVerifier(DO_NOT_VERIFY);
                conn = https;
            } else {
                conn = (HttpURLConnection) realurl.openConnection();
            }
//			HttpURLConnection conn = (HttpURLConnection) realurl
//					.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(30000);
            conn.setReadTimeout(600000);
            conn.connect();
            pw = new PrintWriter(conn.getOutputStream());
            pw.write(param);
            pw.flush();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                Utils.print(" Error===" + responseCode);
            } else {
                Utils.print("Post Success!");
            }
            read = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "utf-8"));
            String line;// 循环读取
            while ((line = read.readLine()) != null) {
                result += line;
            }
            Utils.print("返回数据====" + result);
        } catch (MalformedURLException e) {
            Utils.printException(e);

        } catch (IOException e) {
            Utils.printException(e);
        } finally {
            if (read != null) {// 关闭流
                try {
                    read.close();
                } catch (IOException e) {
                    Utils.printException(e);
                }
            }
            if (pw != null) {
                pw.close();
            }

        }
        return result;
    }

    @Override
    public String callNetRequestGet(String requestUrl) {
        return super.callNetRequestGet(requestUrl);
    }

    /**
     * 网络访问
     */
    public static String callNetRequestForPost(String url) {
        Utils.print("请求报文 ==》 " + url);
        HttpPost request = new HttpPost(url);
        DefaultHttpClient client = new DefaultHttpClient();
        client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 5000);
        client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 5000);

        String result = null;
        try {
            HttpResponse response = client.execute(request);
            //判断响应对象
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity());
                return result;
            }
        } catch (Exception e) {
            Utils.printException(e);
            result = "网络异常";
            return result;
        }

        return null;
    }
}
