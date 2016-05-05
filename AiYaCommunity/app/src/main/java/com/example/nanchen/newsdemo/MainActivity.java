package com.example.nanchen.newsdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.example.nanchen.newsdemo.find.FindFragment;
import com.example.nanchen.newsdemo.home.HomeFragment;
import com.example.nanchen.newsdemo.mine.MineFragment;

public class MainActivity extends FragmentActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment, HomeFragment.newInstance());
        transaction.commit();


        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                transaction = manager.beginTransaction();
                switch (checkedId) {
                    case R.id.tab1:
                        transaction.replace(R.id.fragment, HomeFragment.newInstance());
                        break;
                    case R.id.tab2:
                        transaction.replace(R.id.fragment, FindFragment.newInstance());
                        break;
                    case R.id.tab3:
                        transaction.replace(R.id.fragment, MsgFragment.newInstance());
                        break;
                    case R.id.tab4:
                        transaction.replace(R.id.fragment, MineFragment.newInstance());
                        break;
                }
                transaction.commit();
            }
        });
    }
}
