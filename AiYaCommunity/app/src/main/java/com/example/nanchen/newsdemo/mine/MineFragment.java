package com.example.nanchen.newsdemo.mine;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nanchen.newsdemo.MainActivity;
import com.example.nanchen.newsdemo.R;

/**
 *
 * Created by nanchen on 2016/5/3.
 */
public class MineFragment extends Fragment {
    private MainActivity mainActivity;

    public static MineFragment newInstance(){
        return new MineFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment,null);
        Button btn_login = (Button) view.findViewById(R.id.btn_login1);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity,LoginActivity.class));
            }
        });
        return view;
    }


}
