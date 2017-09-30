package com.qingqu.wc.maqi.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qingqu.wc.maqi.R;

import java.util.List;

/**
 * Created by wc_2 on 2017/8/2.
 */

public class ShangouAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {
    private List<String> listBean;
    private Context mContext;

    public ShangouAdapter(List<String> listBean, Context mContext) {
        this.listBean = listBean;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=View.inflate(mContext, R.layout.xiao_item,null);
        return new myViewHodler(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        myViewHodler viewHodler= (myViewHodler) holder;
        viewHodler.seData(position);
    }

    @Override
    public int getItemCount() {
        return listBean.size();
    }
    class myViewHodler extends RecyclerView.ViewHolder{
        private TextView shan;
        public myViewHodler(View itemView) {
            super(itemView);
            shan= (TextView) itemView.findViewById(R.id.shan);
        }
        public void seData( int position) {
            String ss=listBean.get(position);
            if(position==0){
                shan.setBackgroundResource(R.mipmap.shanggou);
            }else{
                shan.setBackgroundResource(R.mipmap.shanguo2);

                shan.setTextColor(Color.parseColor("#000000"));
            }
            shan.setText(ss);

        }
    }
}
