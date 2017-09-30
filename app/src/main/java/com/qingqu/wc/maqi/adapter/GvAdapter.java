package com.qingqu.wc.maqi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qingqu.wc.maqi.R;

import java.util.List;

/**
 * Created by wc_2 on 2017/8/16.
 */

public class GvAdapter extends BaseAdapter {
    private Context mContet;
    List<Integer> list;

    public GvAdapter(Context mContet, List<Integer> list) {
        this.mContet = mContet;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder=new ViewHolder();
            convertView=View.inflate(mContet, R.layout.item_ll,null);
            holder.tv1= (TextView) convertView.findViewById(R.id.tv1);
            holder.tv2= (TextView) convertView.findViewById(R.id.tv3);
            holder.bt= (LinearLayout) convertView.findViewById(R.id.bt);
            holder.tou= (LinearLayout) convertView.findViewById(R.id.tou);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        int i=list.get(position);
        holder.tou.setBackgroundResource(i);
        if (position==3){
            holder.tv1.setVisibility(View.GONE);
            holder.tv2.setVisibility(View.GONE);
            holder.bt.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
    class ViewHolder{
        TextView tv1;
        TextView tv2;
        LinearLayout bt;
        LinearLayout tou;
    }
}
