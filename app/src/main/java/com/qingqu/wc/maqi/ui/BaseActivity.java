package com.qingqu.wc.maqi.ui;

/**
 * Created by SuZi on 2017/9/29.
 */

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity  {
//    // 程序当前Activity。用于页面超时，避免每个Activity创建监听器
//    public static BaseActivity instance;
//
//    private Intent intent;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        instance = this;
//    }
//
//    @Override
//    protected void onResume() { // 当用户使程序恢复为前台显示时执行onResume()方法,在其中判断是否超时.
//        super.onResume();
//        instance = this;
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//    }
//
//    /*
//     * Activity跳转
//     */
//    protected void starttargetActivity(Class targetActivity, Bundle bundle) {
//        intent = new Intent();
//        intent.setClass(instance, targetActivity);
//
//        if (bundle != null) {
//            intent.putExtras(bundle);
//        }
//
//        startActivity(intent);
//    }
//
//    /**
//     * 弹出框信息
//     * @param info
//     */
//    public void showToastInfo(String info) {
//        Toast.makeText(BaseActivity.this, info, Toast.LENGTH_SHORT).show();
//    }
//
//    public void showToastLongInfo(String info) {
//        Toast.makeText(BaseActivity.this, info, Toast.LENGTH_LONG).show();
//    }
//
//    public void showToastInfo(String info, int duration) {
//        Toast.makeText(BaseActivity.this, info, duration).show();
//    }
//
//
//    protected void startActivity(Class<?> clazz) {
//        Intent intent = new Intent();
//        intent.setClass(this, clazz);
//        startActivity(intent);
//    }
//
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//    }

}
