package com.example.nanchen.newsdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener {

    private ViewPager vp;
    private ViewPagerAdapter vpAdapter;
    private List<View> views;

    //底部小点图片
    private ImageView[] dots;
    private int currentIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        // 初始化页面
        initView();

        //初始化底部小点
//        initDots();

    }

//    private void initDots() {
//        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
//        dots = new ImageView[views.size()];
//
//        for (int i = 0;i<views.size();i++){
//            dots[i] = (ImageView) ll.getChildAt(i);
//            dots[i].setEnabled(true);//都设为灰色
//        }
//
//        currentIndex = 0;
//        dots[currentIndex].setEnabled(false);//设置为白色，即选中状态
//    }
//
//    private void setCurrentDot(int position){
//        if (position<0 || position>views.size()-1 || currentIndex == position){
//            return;
//        }
//
//        dots[position].setEnabled(false);
//        dots[currentIndex].setEnabled(true);
//
//        currentIndex = position;
//    }

    private void initView() {
        LayoutInflater inflater = LayoutInflater.from(this);
        views = new ArrayList<>();

        views.add(inflater.inflate(R.layout.what_new_one,null));
        views.add(inflater.inflate(R.layout.what_new_two,null));
        views.add(inflater.inflate(R.layout.what_new_three,null));

        vpAdapter = new ViewPagerAdapter(views,this);
        vp = (ViewPager) findViewById(R.id.viewpager);
        vp.setAdapter(vpAdapter);

        vp.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
//        setCurrentDot(position);
    }

    //当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int state) {

    }


}
