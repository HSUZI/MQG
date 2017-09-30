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
 * Created by wc_2 on 2017/8/24.
 */

public class ShoppingDrawEnter extends Activity {

    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.headTV)
    TextView headTV;
    @BindView(R.id.ll_bj)
    LinearLayout llBj;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_draw_enter);
        ButterKnife.bind(this);
        headTV.setText("購物抽獎");
        ivBack.setVisibility(View.VISIBLE);
        Bundle bundle = this.getIntent().getExtras();

        int newSize = bundle.getInt("key");
        String title = bundle.getString("title");
        llBj.setBackgroundResource(newSize);
        tvTitle.setText(title);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
