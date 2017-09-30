package com.qingqu.wc.maqi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.qingqu.wc.maqi.R;
import com.qingqu.wc.maqi.adapter.LvAdapter;
import com.qingqu.wc.maqi.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wc_2 on 2017/8/24.
 */

public class ShoppingDraw extends BaseFragment {
    LvAdapter lvAdapter;
    @BindView(R.id.headTV)
    TextView headTV;
    Unbinder unbinder;
    @BindView(R.id.lv_shopping)
    ListView lvShopping;
    Unbinder unbinder1;
    @BindView(R.id.iv_back)
    LinearLayout ivBack;
    private String[] listTitle = {"三星家庭裝滾筒洗衣機","IPHOHE 7 手機一部","格蘭仕微波爐",
            "格力無氣變頻空調","方太 Fotile 抽油煙機"};
    private int[] listImage = {R.mipmap.img1,R.mipmap.img2,R.mipmap.img3,R.mipmap.img4,R.mipmap.img5};
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.shopping_draw, null);
        unbinder = ButterKnife.bind(this, view);
        headTV.setText("點數抽獎");
        lvAdapter = new LvAdapter(getActivity(),listImage,listTitle);
        lvShopping.setAdapter(lvAdapter);
        ivBack.setVisibility(View.VISIBLE);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        lvShopping.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle bundle = new Bundle();
                bundle.putInt("key",listImage[i]);
                bundle.putString("title",listTitle[i]);
                Intent intent=new Intent(getActivity(),ShoppingDrawEnter.class);
                intent.putExtras(bundle);
                getActivity().startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
