package com.qingqu.wc.maqi.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qingqu.wc.maqi.R;
import com.qingqu.wc.maqi.adapter.RecyclerViewAdapter;
import com.qingqu.wc.maqi.base.Sha;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private RecyclerView mRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRecyclerView =
                (RecyclerView) inflater.inflate(R.layout.list_fragment, container, false);
        return mRecyclerView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 实例化一个GridLayoutManager，列数为3
         GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);

        mRecyclerView.setLayoutManager(layoutManager);
        List<Sha> shas=new ArrayList<>();
        for (int i=0;i<6;i++){
            Sha sha=new Sha();
            sha.setF(false);
            shas.add(sha);
        }
        mRecyclerView.setAdapter(new RecyclerViewAdapter(getActivity(),shas));
    }
}
