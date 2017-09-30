package com.qingqu.wc.maqi.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qingqu.wc.maqi.R;
import com.qingqu.wc.maqi.view.mw_UserButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wc_2 on 2017/8/31.
 */

public class LianxiActivity extends Activity {
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.headTV)
    TextView headTV;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.tv_right)
    LinearLayout tvRight;
    @BindView(R.id.ub_f)
    mw_UserButton ubF;
    @BindView(R.id.ub_f1)
    mw_UserButton ubF1;
    @BindView(R.id.ub_f2)
    mw_UserButton ubF2;
    @BindView(R.id.ub_f3)
    mw_UserButton ubF3;
    @BindView(R.id.ub_f4)
    mw_UserButton ubF4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lianxi);
        ButterKnife.bind(this);
        headTV.setText("聯繫我們");
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ubF.imgView.setImageResource(R.mipmap.lx_1);
        ubF.textView.setText("瑪奇購公司");
        ubF1.imgView.setImageResource(R.mipmap.lx_2);
        ubF1.textView.setText("桃園市八德區中華路269號3樓");
        ubF2.imgView.setImageResource(R.mipmap.lx_3);
        ubF2.textView.setText("03_25869360");
        ubF3.imgView.setImageResource(R.mipmap.lx_4);
        ubF3.textView.setText("03_25869360");
        ubF4.imgView.setImageResource(R.mipmap.lx_5);
        ubF4.textView.setText("Maqigou@yahoo.com");
    }
}
