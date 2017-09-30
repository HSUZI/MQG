package com.qingqu.wc.maqi;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.view.Window;
import android.view.WindowManager;

import com.qingqu.wc.maqi.ui.LoginActivity;
import com.qingqu.wc.maqi.ui.MainActivity;
import com.qingqu.wc.maqi.ui.WelcomeActivity;

/**
 * Created by wc_2 on 2017/8/1.iu
 */

public class StartActivity extends Activity{
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Window window = getWindow();
//        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//        //设置状态栏颜色
//        window.setStatusBarColor(Color.parseColor("#00A5A7"));
        setContentView(R.layout.activity_start);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(StartActivity.this,WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        },7000);
    }
}
