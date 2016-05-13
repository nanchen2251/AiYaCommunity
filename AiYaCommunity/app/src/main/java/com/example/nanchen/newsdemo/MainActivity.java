package com.example.nanchen.newsdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.example.nanchen.newsdemo.find.FindFragment;
import com.example.nanchen.newsdemo.home.HomeFragment;
import com.example.nanchen.newsdemo.mine.MineFragment;
import com.example.nanchen.newsdemo.mine.MineLoginFragment;
import com.example.nanchen.newsdemo.msg.MsgFragment;

public class MainActivity extends FragmentActivity {

    private FragmentManager manager;
    private FragmentTransaction transaction;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("LOGIN", Context.MODE_PRIVATE);

        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment, HomeFragment.newInstance());
        transaction.commit();


        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                transaction = manager.beginTransaction();
                Intent intent = getIntent();
                switch (checkedId) {
                    case R.id.tab1:
                        transaction.replace(R.id.fragment, HomeFragment.newInstance());
                        break;
                    case R.id.tab2:
                        transaction.replace(R.id.fragment, FindFragment.newInstance());
                        break;
                    case R.id.tab3:
                        if (intent.getParcelableExtra("USER") != null) {
                            //                        if (sp.getInt("isLogin", -1) == 1) {
                            transaction.replace(R.id.fragment, MsgFragment.newInstance());
                        } else {
                            transaction.replace(R.id.fragment, NotLoginFragment.newInstance());
                        }
                        break;
                    case R.id.tab4:
                        if (intent.getParcelableExtra("USER") != null) {
                            transaction.replace(R.id.fragment, MineLoginFragment.newInstance());
                        } else {
                            transaction.replace(R.id.fragment, MineFragment.newInstance());
                        }
                        break;
                }
                transaction.commit();
            }
        });
    }

}
