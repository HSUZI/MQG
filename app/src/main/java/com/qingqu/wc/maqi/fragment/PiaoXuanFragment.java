package com.qingqu.wc.maqi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.qingqu.wc.maqi.R;
import com.qingqu.wc.maqi.base.BaseFragment;
import com.qingqu.wc.maqi.ui.HuoDongActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wc_2 on 2017/8/9.
 */

public class PiaoXuanFragment extends BaseFragment {
    @BindView(R.id.bt_px)
    Button btPx;
    Unbinder unbinder;

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fragment_pianxuan, null);
        unbinder = ButterKnife.bind(this, view);
        btPx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), HuoDongActivity.class);
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
