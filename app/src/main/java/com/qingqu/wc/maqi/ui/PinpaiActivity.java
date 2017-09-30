package com.qingqu.wc.maqi.ui;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qingqu.wc.maqi.R;
import com.qingqu.wc.maqi.view.mw_UserButton;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wc_2 on 2017/8/31.
 */

public class PinpaiActivity extends Activity {
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.headTV)
    TextView headTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinpai);
        ButterKnife.bind(this);
        headTV.setText("品牌故事");
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
