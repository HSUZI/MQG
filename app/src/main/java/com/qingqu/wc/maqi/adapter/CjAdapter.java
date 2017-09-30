package com.qingqu.wc.maqi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qingqu.wc.maqi.R;

import static android.R.attr.id;

/**
 * Created by wc_2 on 2017/8/26.
 */

public class CjAdapter extends BaseAdapter {
    private Context mContext ;
    private int[] Image;
    private String[] name ;
    private int id;

    public CjAdapter(Context mContext, int[] image, String[] name,int id) {
        this.mContext = mContext;
        Image = image;
        this.name = name;
        this.id = id;
    }


    @Override
    public int getCount() {
        return Image.length;
    }

    @Override
    public Object getItem(int position) {
        return getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            if (id == 1){
                convertView = View.inflate(mContext, R.layout.mc_cj_list,null);
                holder.iv_image = (ImageView) convertView.findViewById(R.id.iv_image);
                holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
                holder.iv_image.setBackgroundResource(Image[position]);
                holder.tv_name.setText(name[position]);

            }else if(id == 2){
                convertView = View.inflate(mContext, R.layout.mc_dd_list,null);
                holder.ll_bt = (LinearLayout) convertView.findViewById(R.id.ll_bi);
                holder.iv_image = (ImageView) convertView.findViewById(R.id.iv_image);
                holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
                if (position == 0){
                    holder.ll_bt.setVisibility(View.VISIBLE);
                }
                holder.iv_image.setBackgroundResource(Image[position]);
                holder.tv_name.setText(name[position]);
            }else if(id==3){
                convertView = View.inflate(mContext, R.layout.mc_fx_list,null);
                holder.ll_bt = (LinearLayout) convertView.findViewById(R.id.ll_bt);
                if (position == 0){
                    holder.ll_bt.setVisibility(View.VISIBLE);
                }
            }else if(id==4){
                convertView = View.inflate(mContext, R.layout.mc_xh_list,null);
                holder.iv_image= (ImageView) convertView.findViewById(R.id.iv_cs);
                if(position==1){
                    holder.iv_image.setImageResource(R.mipmap.cz_sb);
                }

            }else if(id==5){
                convertView = View.inflate(mContext, R.layout.mc_yq_list,null);
            }


            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }
    class ViewHolder{
        ImageView iv_image;
        TextView tv_name;
        LinearLayout ll_bt;
        TextView tv1;
        TextView tv2;
    }
}
