package com.qingqu.wc.maqi.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ${liumengqiang} on 2017/7/18.
 */

public class HorseView extends View {
    private String textString;//跑马灯的内容
    private float measureWidth; //view的宽度
    private float measureHeight;//view的高度
    private  float textWidth ;//跑马灯内容的宽度
    private float baseLine;//textString的基线
    private Paint paint;//画笔
    private float textX = 0;//每次刷新view时 textString的X坐标
    private  ValueAnimator valueAnimator;//动画
    private int textColor = Color.BLACK;//字体颜色
    private int textSize = 40;//字体大小
    public HorseView(Context context) {
        super(context);
    }

    public HorseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HorseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureWidth = getMeasuredWidth();
        measureHeight = getMeasuredHeight();

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(textColor);
        paint.setAntiAlias(true);
        paint.setTextSize(textSize);
        textWidth = paint.measureText(textString);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        baseLine = measureHeight / (float)2 + (-fontMetrics.top + fontMetrics.bottom)/(float)2 - fontMetrics.bottom;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 判断是否为null   方式initView不设置时崩溃
         */
        if( null == textString || measureHeight == 0){
            return;
        }

        canvas.drawText(textString, textX,baseLine,paint);
    }


    /**
     * 需要传入参数
     * @param textString
     * @param duration  播放一次动画时长
     */
    public void initView(String textString,int duration){
        this.textString = textString;
        setAnimationFirst(duration);
    }

    private void setAnimationFirst(int duration){
        valueAnimator = ValueAnimator.ofFloat(0,textWidth + measureWidth);
        valueAnimator.setDuration(duration);
        valueAnimator.setRepeatCount(-1);//设置-1为无限循环
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                textX = measureWidth - animation.getCurrentPlayTime() * (textWidth + measureWidth)/valueAnimator.getDuration();
                postInvalidate();
            }
        });
        valueAnimator.start();
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }
}
