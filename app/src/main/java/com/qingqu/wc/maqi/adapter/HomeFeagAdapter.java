package com.qingqu.wc.maqi.adapter;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.qingqu.wc.maqi.R;
import com.qingqu.wc.maqi.base.Banners;
import com.qingqu.wc.maqi.base.HomeBase;
import com.qingqu.wc.maqi.base.Sha;
import com.qingqu.wc.maqi.utlis.GlideImageLoader;
import com.qingqu.wc.maqi.view.HorseView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by wc_2 on 2017/8/1.
 */

public class HomeFeagAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private LayoutInflater inflater;
    private HomeBase base;
    public static Banner banner;
    private int currentType = BANNER;
    /**
     * 广告条幅类型
     */
    public static final int BANNER = 0;

    /**
     * 閃購
     */
    public static final int SHANGGOU = 1;
    /**
     * 消息
     */
    public static final int XIAOXI = 2;
    /**
     * 消息
     */
    public static final int SHANGPIN = 3;
    public HomeFeagAdapter(Context mContext, HomeBase homeBase) {
        this.mContext = mContext;
        this.base = homeBase;
        inflater=LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            return new BannerViewHolder(mContext, inflater.inflate(R.layout.banner_viewpager, null));
        }else  if (viewType == SHANGGOU) {
            return new ShanggouViewHolder(mContext, inflater.inflate(R.layout.activity_shangguo, null));
        }else  if (viewType == XIAOXI) {
            return new XiaoxiViewHolder(mContext, inflater.inflate(R.layout.activity_xiaoxin, null));
        }else  if (viewType == SHANGPIN) {
            return new ShanpinViewHolder(mContext, inflater.inflate(R.layout.list_fragment, null));
        }
        return null;
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == BANNER){
            BannerViewHolder bannerViewHolder = (BannerViewHolder)holder;
            bannerViewHolder.setData(base.getBanners());
        }else if(getItemViewType(position)==SHANGGOU){
            ShanggouViewHolder shanggouVIewHolder = (ShanggouViewHolder)holder;
            String[] ss = {"最新閃購","酷夏冰品","寶可夢補給站","特惠商品"};
            List<String> list = new ArrayList<>();
            for (int i = 0 ; i < 4 ;i++){
                list.add(ss[i]);
            }
            shanggouVIewHolder.setDate(list);
//            bannerViewHolder.setDate(base.getBanners());
        }else if(getItemViewType(position) == XIAOXI){
            XiaoxiViewHolder  xiaoxiViewHolder = (XiaoxiViewHolder)holder;
//            bannerViewHolder.setData(base.getBanners());
        }
    }
    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position){
            case BANNER:
                currentType=BANNER;
                break;
            case SHANGGOU:
                currentType=SHANGGOU;
                break;
            case XIAOXI:
                currentType=XIAOXI;
                break;
            case SHANGPIN:
                currentType=SHANGPIN;
                break;
        }
        return position;
    }
    private class BannerViewHolder extends RecyclerView.ViewHolder {
        private Context mcContext;

        public BannerViewHolder(Context ct,View itemView) {
            super(itemView);
            this.mcContext=ct;
            banner= (Banner) itemView.findViewById(R.id.banner);
        }

        public void setData(List<Banners> banner_info) {
            //设置banner数据
            //设置图片集合
            List<Integer> list = new ArrayList<>(); for(int i = 0;i < banner_info.size();i++){
                Log.e("ATG",banner_info.size()+"");
                list.add(banner_info.get(i).img);
            }
            banner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            banner.setImages(list);
            //banner设置方法全部调用完毕时最后调用
            banner.start();
            banner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int position) {
                    Toast.makeText(mContext,""+position,Toast.LENGTH_SHORT).show();
                }
            });
        }
    } private class ShanggouViewHolder extends RecyclerView.ViewHolder {
        private Context mContext;
        private RecyclerView rv;
        public ShanggouViewHolder(Context mContext, View inflate){
            super(inflate);
            this.mContext = mContext;
            rv = (RecyclerView) inflate.findViewById(R.id.rv_seckill);
        }
        public void setDate(List<String> list){
            rv.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL,false));
            ShangouAdapter adapter = new ShangouAdapter(list,mContext);
            rv.setAdapter(adapter);
        }
    }
    private class XiaoxiViewHolder extends RecyclerView.ViewHolder {
        private Context mContext;
        private HorseView horseView;
        public XiaoxiViewHolder(Context mContext, View inflate) {
            super(inflate);
            this.mContext=mContext;
            horseView = (HorseView) inflate.findViewById(R.id.hourview);
            horseView.initView("恭喜謝小秋獲得酷夏冰品一份",5000);
        }
    }

    private class ShanpinViewHolder extends RecyclerView.ViewHolder {
        RecyclerView mRecyclerView;
        Context mContext;
        public ShanpinViewHolder(Context mContext, View inflate) {
            super(inflate);
            this.mContext=mContext;
            mRecyclerView= (RecyclerView) inflate.findViewById(R.id.recycler_view);
            GridLayoutManager layoutManager = new GridLayoutManager(mContext, 2);

            mRecyclerView.setLayoutManager(layoutManager);
            List<Sha> shas=new ArrayList<>();
            for (int i=0;i<6;i++){
                Sha sha=new Sha();
                sha.setF(false);
                shas.add(sha);
            }
            mRecyclerView.setAdapter(new RecyclerViewAdapter(mContext,shas));
        }
    }
}