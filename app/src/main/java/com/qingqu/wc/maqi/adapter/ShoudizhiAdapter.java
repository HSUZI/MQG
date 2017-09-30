package com.qingqu.wc.maqi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qingqu.wc.maqi.R;
import com.qingqu.wc.maqi.bean.Shoudi;

import java.util.List;

/**
 * Created by wc_2 on 2017/8/31.
 */

public class ShoudizhiAdapter extends BaseAdapter {
    private List<Shoudi> list;
    private Context mContext;

    public ShoudizhiAdapter(Context mContext, List<Shoudi> list) {
        this.mContext = mContext;
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
        if (convertView == null){
            holder = new ViewHolder();
            convertView=View.inflate(mContext, R.layout.item_shoudizhi,null);
            holder.tv_dizhi= (TextView) convertView.findViewById(R.id.tv_dizhi);
            holder.tv_name= (TextView) convertView.findViewById(R.id.tv_name);
            holder.tv_dh= (TextView) convertView.findViewById(R.id.tv_dh);
            holder.tv_yb= (TextView) convertView.findViewById(R.id.tv_yb);
            holder.tv_dz= (TextView) convertView.findViewById(R.id.tv_dz);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        Shoudi shoudi=list.get(position);
        holder.tv_dizhi.setText(shoudi.getDizhi());
        holder.tv_name.setText(shoudi.getName());
        holder.tv_dh.setText(shoudi.getDh());
        holder.tv_yb.setText(shoudi.getYb());
        holder.tv_dz.setText(shoudi.getDz());
        return convertView;
    }
    class ViewHolder {
        TextView tv_dizhi;
        TextView tv_name;
        TextView tv_dh;
        TextView tv_yb;
        TextView tv_dz;

    }
}
