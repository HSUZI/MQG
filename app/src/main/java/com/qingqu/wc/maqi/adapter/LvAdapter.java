package com.qingqu.wc.maqi.adapter;

import android.widget.BaseAdapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qingqu.wc.maqi.R;


/**
 * Created by Administrator on 2017/8/24.
 */

public class LvAdapter extends BaseAdapter {
    private Context mContext;
    private int[] listImage ;
    private String[] listTitle;

    public LvAdapter(Context mContext, int[] listImage,String[] listTitle) {
        this.mContext = mContext;
        this.listImage = listImage;
        this.listTitle = listTitle;
    }

    @Override
    public int getCount() {
        return listTitle.length;
    }

    @Override
    public Object getItem(int i) {
        return getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            view = View.inflate(mContext,R.layout.shopping_draw_list,null);
            holder.ll_bj = (LinearLayout) view.findViewById(R.id.ll_bj);
            holder.tv_title = (TextView)view.findViewById(R.id.tv_title);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.ll_bj.setBackgroundResource(listImage[i]);
        holder.tv_title.setText(listTitle[i]);
        return view;}
    class ViewHolder {
        TextView tv_title;
        LinearLayout ll_bj;
    }
}