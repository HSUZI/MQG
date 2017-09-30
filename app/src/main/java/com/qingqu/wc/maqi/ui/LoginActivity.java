package com.qingqu.wc.maqi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qingqu.wc.maqi.R;
import com.qingqu.wc.maqi.httpjson.Config.Addresses;
import com.qingqu.wc.maqi.httpjson.Config.Urls;
import com.qingqu.wc.maqi.httpjson.jsonparser.NetController;
import com.qingqu.wc.maqi.httpjson.model.request.LoginReq;
import com.qingqu.wc.maqi.httpjson.okhttp.HttpHelper;
import com.qingqu.wc.maqi.httpjson.okhttp.listener.RequestObjectCallback;
import com.qingqu.wc.maqi.httpjson.okhttp.respose.LoginResponse;
import com.qingqu.wc.maqi.utlis.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends Activity {

    @BindView(R.id.bt_login)
    Button btLogin;

    @BindView(R.id.headTV)
    TextView headTV;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.zhao)
    TextView zhao;
    @BindView(R.id.xin)
    TextView xin;
    @BindView(R.id.et_account)
    EditText et_account;
    @BindView(R.id.et_passwd)
    EditText et_pawwd;

    private String account;
    private String passwd;

    private HandlerImpl handler;
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);
        handler = new HandlerImpl();
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        zhao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        xin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    /**
     * 登录
     */
    public void login() {
        account = et_account.getText().toString().trim();
        passwd = et_pawwd.getText().toString().trim();
        if(TextUtils.isEmpty(account) || TextUtils.isEmpty(passwd)) {
            Toast.makeText(this, "输入账号信息有误!", Toast.LENGTH_SHORT).show();
            return;
        }
        LoginReq loginReq = new LoginReq(account, passwd);
        HttpHelper.logined(loginReq.getMapParams(),new RequestObjectCallback<LoginResponse>() {

            @Override
            public void onResponse(LoginResponse response) {
                Utils.print("调用成功" );
                Utils.print("登录请求相应报文 ==》 " +  result);
                Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onError(String err) {
                Utils.print("调用成功 err => "  + err);
            }

            @Override
            public void onDataRequestError(Throwable error) {

            }
        });

//        loginHandler(account, passwd);
    }

    public void loginHandler(final String account, final String passwd) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                logined();
                Message msg = new Message();
                msg.what = 0;
                handler.sendMessage(msg);
            }
        }).start();
    }

    public void logined() {
//        String url = Addresses.getUrl() + Urls.LOGINURL; //登录url
        String url = "/user/login"; //登录url
        LoginReq loginReq = new LoginReq(account, passwd);
        NetController netController = new NetController(this);
//        String urlstr = url + "?" + loginReq.getParams();
//        result = NetController.callNetRequestForPost(urlstr);
        result = netController.asyncCallNetRequest(loginReq.getParams(), url, false);

    }

    public class HandlerImpl extends Handler {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0: //登录
                    Utils.print("登录请求相应报文 ==》 " +  result);
                    Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    }

}
