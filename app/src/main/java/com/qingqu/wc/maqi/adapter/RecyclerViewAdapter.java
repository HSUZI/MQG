package com.qingqu.wc.maqi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qingqu.wc.maqi.R;
import com.qingqu.wc.maqi.base.Sha;
import com.qingqu.wc.maqi.ui.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ImageView ivGoodsImg;
    ImageView jia;
    TextView tvGoodsName;
    TextView tv_jia;

    private Context mContext;
    private List<Sha> sha=new ArrayList<>();
    private int[] image = {R.mipmap.goods1, R.mipmap.goods2, R.mipmap.goods3, R.mipmap.goods4, R.mipmap.goods5, R.mipmap.goods6};
    private String[] name = {"酷夏冰爽", "健康西瓜汁", "綠色金桔", "紫色奶昔", "楊枝甘露", "咖啡伴侶"};

    public RecyclerViewAdapter(Context mContext, List<Sha> sha) {
        this.mContext = mContext;
        this.sha = sha;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_card_main, parent, false);
        return new ViewHolder(view);
    }
    int is=0;
    int mun=0;
    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, final int position) {
        final View view = holder.mView;
        ivGoodsImg = (ImageView) view.findViewById(R.id.iv_goodsImg);
        tvGoodsName = (TextView) view.findViewById(R.id.tv_goodsName);
        tv_jia= (TextView) view.findViewById(R.id.tv_jia);
        jia= (ImageView) view.findViewById(R.id.jia);
        ivGoodsImg.setBackgroundResource(image[position]);
        tvGoodsName.setText(name[position]);
        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              sha.get(position).setF(!sha.get(position).isF());
                String ss=tv_jia.getText().toString().trim();
                try {
                    mun = mun+Integer.parseInt(ss);
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }
//                mun+=Integer.parseInt(tv_jia.getText().toString());
//                is=true;
                if (sha.get(position).isF()) {
                    ++is;
                }else{
                    if(is>0) {
                        --is;
                    }
                }
                notifyDataSetChanged();
            }
        });

            if (sha.get(position).isF()) {
                jia.setImageResource(R.mipmap.shopcart_selected);
                MainActivity.rgMain.setVisibility(View.INVISIBLE);
                MainActivity.ll.setVisibility(View.VISIBLE);
                MainActivity.tv_xuan.setText("已選"+is+"件"+" NT"+ mun);
            } else {
                if (is==0){
                    MainActivity.rgMain.setVisibility(View.VISIBLE);
                    MainActivity.ll.setVisibility(View.INVISIBLE);
                }
                jia.setImageResource(R.mipmap.wxz);



        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
        }
    }
}
