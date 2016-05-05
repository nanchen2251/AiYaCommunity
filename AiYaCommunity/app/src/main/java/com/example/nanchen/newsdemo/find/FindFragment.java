package com.example.nanchen.newsdemo.find;

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
 * 发现
 * Created by nanchen on 2016/5/3.
 */
public class FindFragment extends Fragment {

    private MainActivity mainActivity;
    private Button btn_fanyi;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    public static FindFragment newInstance(){
        return new FindFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_fragment,null);
        btn_fanyi = (Button) view.findViewById(R.id.btn_fanyi);
        btn_fanyi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity,TranslateActivity.class));
            }
        });
        return view;
    }
}
