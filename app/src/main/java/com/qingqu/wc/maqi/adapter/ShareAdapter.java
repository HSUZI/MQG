package com.qingqu.wc.maqi.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qingqu.wc.maqi.R;

public class ShareAdapter extends BaseAdapter {
	
	private Context mContext;
	private int[] images = { R.mipmap.fb, };
	private String[] names = {"facebook" };
	
	public ShareAdapter(Context mContext) {
		this.mContext = mContext;
	}
	
	@Override
	public int getCount() {
		return images.length;
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
		Holder holder;
		if (convertView == null) {
			holder = new Holder();
			convertView = View.inflate(mContext, R.layout.grid_item, null);
			holder.textViewpopo = (TextView) convertView.findViewById(R.id.textViewpopo);
			holder.imageViewpopo = (ImageView) convertView.findViewById(R.id.imageViewpopo);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		holder.textViewpopo.setText(names[position]);
		holder.imageViewpopo.setImageResource(images[position]);

		return convertView;
	}
	
	class Holder {
		private TextView textViewpopo;
		private ImageView imageViewpopo;
	}
}
