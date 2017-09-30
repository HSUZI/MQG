package com.qingqu.wc.maqi.httpjson.okhttp.respose;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.qingqu.wc.maqi.httpjson.okhttp.listener.RequestObjectCallback;
import com.qingqu.wc.maqi.httpjson.utils.ErrCodeUtils;
import com.qingqu.wc.maqi.utlis.Utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OkhttpResponseHandler<T> implements Callback {

    private Handler mHandler = null;
    private RequestObjectCallback<T> mOkhttpDataBackListener;

    public OkhttpResponseHandler(RequestObjectCallback<T> l) {
        mOkhttpDataBackListener = l;
        mHandler = new Handler(Looper.getMainLooper()) {//主线程handler
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 0) {
                    String result = (String) msg.obj;
                    parseReuslt(result);
                }

            }
        };
    }

    public void handleResult(String result) {
        Message message = new Message();
        message.what = 0;
        message.obj = result;
        mHandler.sendMessage(message);
    }

    /**
     * 拿到String 结果进行解析
     *
     * @param result
     */
    private void parseReuslt(String result) {
        //如果解析出错
        try {
            JsonParser parser = new JsonParser();

            JsonElement element = parser.parse(result);

            JsonObject rootObject = element.getAsJsonObject();

            JsonPrimitive primitiveCode = rootObject
                    .getAsJsonPrimitive("resp_code");
            String resp_code = primitiveCode.getAsString();
            JsonPrimitive primitiveMsg = rootObject
                    .getAsJsonPrimitive("resp_msg");
            String resp_msg = primitiveMsg.getAsString();

            Utils.LogD("瑪奇購", "onSuccess resp_code:" + resp_code);
            if ("0000".equals(resp_code)) {
                JsonObject detail = rootObject
                        .getAsJsonObject("response_detail");
                Utils.LogD("瑪奇購", "onSuccess detail:" + detail);
                if (mOkhttpDataBackListener != null) {
                    Gson gson = new Gson();
                    T t = (T) gson.fromJson(detail,
                            mOkhttpDataBackListener.getDataClass());
                    mOkhttpDataBackListener.onResponse(t);
                }
            } else {
                if (mOkhttpDataBackListener != null) {
                    mOkhttpDataBackListener.onError(resp_msg);
                }
            }
        } catch (Exception e) {
            if (mOkhttpDataBackListener != null) {
                mOkhttpDataBackListener.onDataRequestError(e);
            }
        }
    }

    @Override
    public void onFailure(final Call arg0, final IOException arg1) {
        Utils.LogD("瑪奇購", "onFailure " + arg1.getMessage());
        mHandler.post(new Runnable() {

            @Override
            public void run() {
                if (mOkhttpDataBackListener != null) {
                    mOkhttpDataBackListener.onDataRequestError(arg1);
                }

            }
        });
    }

    @Override
    public void onResponse(Call arg0, final Response response)
            throws IOException {
        final String result = response.body().string();
        Utils.LogD("瑪奇購", "onSuccess " + result);
        mHandler.post(new Runnable() {

            @Override
            public void run() {
                //真正解析拿到数据的地方
                parseReuslt(result);
                response.body().close();
            }
        });
    }

}
