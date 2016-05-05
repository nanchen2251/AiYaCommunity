package com.example.nanchen.newsdemo.find;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nanchen.newsdemo.MainActivity;
import com.example.nanchen.newsdemo.R;

/**
 * 发现
 * Created by nanchen on 2016/5/3.
 */
public class FindFragment extends Fragment {

    private MainActivity mainActivity;

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
        return view;
    }
}
