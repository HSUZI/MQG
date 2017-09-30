package com.qingqu.wc.maqi.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.qingqu.wc.maqi.R;
import com.qingqu.wc.maqi.adapter.ShoudizhiAdapter;
import com.qingqu.wc.maqi.bean.Shoudi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wc_2 on 2017/8/31.
 */

public class ShoudizhiActivity extends Activity {
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    @BindView(R.id.headTV)
    TextView headTV;
    @BindView(R.id.tv_right)
    LinearLayout tvRight;
    @BindView(R.id.lv)
    ListView lv;
    List<Shoudi> list = new ArrayList<>();
    @BindView(R.id.iv_right)
    ImageView ivRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoudizhi);
        ButterKnife.bind(this);
        headTV.setText("送貨地址");
        ivBack.setVisibility(View.VISIBLE);
        ivRight.setBackgroundResource(R.mipmap.shou_jia);
        ivRight.setPadding(1,1,1,1);
        tvRight.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Shoudi shoudi = new Shoudi();
        shoudi.setDizhi("購物中心地址");
        shoudi.setName("王向華");
        shoudi.setDh("032_0932121");
        shoudi.setYb("07_213432");
        shoudi.setDz("台北市大同區");
        list.add(shoudi);
        ShoudizhiAdapter adapter = new ShoudizhiAdapter(this, list);
        lv.setAdapter(adapter);
    }
}
