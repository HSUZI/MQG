package com.qingqu.wc.maqi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.qingqu.wc.maqi.R;
import com.qingqu.wc.maqi.adapter.GvAdapter;
import com.qingqu.wc.maqi.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wc_2 on 2017/8/16.
 */

public class HoudActivity extends BaseFragment {
    Unbinder unbinder;
    @BindView(R.id.gv)
    GridView gv;
    @BindView(R.id.headTV)
    TextView headTV;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.activity_tou, null);
        unbinder = ButterKnife.bind(this, view);
        List<Integer> list = new ArrayList<>();
        list.add(R.mipmap.tou);
        list.add(R.mipmap.tou2);
        list.add(R.mipmap.tou3);
        list.add(R.mipmap.tou4);
        list.add(R.mipmap.tou5);
        list.add(R.mipmap.tou6);
        list.add(R.mipmap.tou7);
        list.add(R.mipmap.tou8);
        headTV.setText("活動列表");
        gv.setAdapter(new GvAdapter(getActivity(), list));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),HuoDongActivity.class);
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
