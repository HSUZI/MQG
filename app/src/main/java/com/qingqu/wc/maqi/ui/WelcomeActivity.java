package com.qingqu.wc.maqi.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.qingqu.wc.maqi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wc_2 on 2017/8/2.
 */

public class WelcomeActivity extends Activity {
    @BindView(R.id.home)
    ImageView home;
    @BindView(R.id.iv_vip)
    ImageView iv_vip;
    @BindView(R.id.iv_lianxi)
    ImageView ivLianxi;
    @BindView(R.id.iv_pinpai)
    ImageView ivPinpai;
    @BindView(R.id.yingsi)
    ImageView yingsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        iv_vip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        ivLianxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, LianxiActivity.class);
                startActivity(intent);
            }
        });
        ivPinpai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, PinpaiActivity.class);
                startActivity(intent);
            }
        });
        yingsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }
}
