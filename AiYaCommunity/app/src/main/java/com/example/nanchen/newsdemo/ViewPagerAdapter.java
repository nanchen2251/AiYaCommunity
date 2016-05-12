package com.example.nanchen.newsdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

/**
 * Created by nanchen on 2016/5/12.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private List<View> views;
    private Activity activity;


    public ViewPagerAdapter(List<View> views,Activity activity){
        this.views = views;
        this.activity = activity;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(views.get(position));
    }


    //获得当前界面数
    @Override
    public int getCount() {
        if (views != null){
            return views.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position));
        if (position == views.size() - 1){
            Button btn_start = (Button) container.findViewById(R.id.start);
            btn_start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setGuided();
                    goHome();
                }
            });
        }
        return views.get(position);
    }

    //设置已经引导过了，下次启动不用再次引导
    private void setGuided() {
        SharedPreferences preferences = activity.getSharedPreferences("FLAG", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isFirstIn", false);
        editor.apply();
    }

    private void goHome() {
        activity.startActivity(new Intent(activity,MainActivity.class));
        activity.finish();
    }
}

