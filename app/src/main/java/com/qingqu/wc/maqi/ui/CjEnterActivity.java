package com.qingqu.wc.maqi.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qingqu.wc.maqi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wc_2 on 2017/8/26.
 */

public class CjEnterActivity extends Activity {
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.headTV)
    TextView headTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cjenter);
        ButterKnife.bind(this);
        headTV.setText("抽獎記錄");
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
