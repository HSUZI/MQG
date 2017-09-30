package com.qingqu.wc.maqi.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qingqu.wc.maqi.R;

/**
 * Created by wc_2 on 2017/8/26.
 */

public class Menu_adapter  extends BaseAdapter{
    private Context  context;
    private int[]img={
        R.mipmap.menu_1,R.mipmap.menu_2,R.mipmap.menu_3,R.mipmap.menu_4,R.mipmap.menu_5,R.mipmap.menu_6};
    private String[] y={"Product","Vote","Hot News","Privacy Right","Contact Us","Sign In/Out"};
    private String [] z={"商品總覽","熱門票選","品牌故事","隱私權政策","聯繫我們","會員登錄/註冊"};
    public Menu_adapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return img.length;
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
        if(convertView == null) {
            convertView=View.inflate(context,R.layout.menu_item,null);
            holder = new ViewHolder();
            holder.iv_image= (ImageView) convertView.findViewById(R.id.iv);
            holder.tv_y= (TextView) convertView.findViewById(R.id.tv_y);
            holder.tv_z= (TextView) convertView.findViewById(R.id.tv_z);
            holder.iv= (ImageView) convertView.findViewById(R.id.iv2);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        if (position==0||position==1){
            holder.iv.setVisibility(View.VISIBLE);
        }
        holder.iv_image.setImageResource(img[position]);
        holder.tv_y.setText(y[position]);
        holder.tv_z.setText(z[position]);

        return convertView;
    }
    class ViewHolder{
        ImageView iv_image;
        TextView tv_y;
        TextView tv_z;
        ImageView iv;
    }
}
