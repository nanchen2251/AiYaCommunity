package com.example.nanchen.newsdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nanchen.newsdemo.mine.LoginActivity;
import com.example.nanchen.newsdemo.mine.RegistActivity;

/**
 * Created by nanchen on 2016/5/12.
 */
public class NotLoginFragment extends Fragment {
    private MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    public static NotLoginFragment newInstance(){
        return new NotLoginFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.not_login_fragment,null);
        Button btn_login = (Button) view.findViewById(R.id.button_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, LoginActivity.class));
            }
        });
        Button btn_reg = (Button) view.findViewById(R.id.button_reg);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, RegistActivity.class));
            }
        });
        return view;
    }
}
