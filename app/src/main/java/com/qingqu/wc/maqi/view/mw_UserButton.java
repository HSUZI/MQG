package com.qingqu.wc.maqi.view;




import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qingqu.wc.maqi.R;


//mw_HorizontalItem01�ؼ�
public class mw_UserButton extends RelativeLayout{
	
	public ImageView imgView;
	public TextView textView;
	
	public mw_UserButton(Context context, AttributeSet attrs){
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.mw_user_button, this);
		imgView = (ImageView)findViewById(R.id.mw_user_button_item01_img);
		textView = (TextView)findViewById(R.id.mw_user_button_item01_text);
	}
}