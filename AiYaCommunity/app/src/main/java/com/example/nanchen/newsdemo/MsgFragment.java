package com.example.nanchen.newsdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 消息
 * Created by nanchen on 2016/5/3.
 */
public class MsgFragment extends Fragment {

    public static MsgFragment newInstance(){
        return new MsgFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.msg_fragment,null);
        //        ViewUtils.inject(this, view);
        return view;
    }
}
