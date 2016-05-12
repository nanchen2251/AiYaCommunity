package com.example.nanchen.newsdemo.find;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nanchen.newsdemo.MainActivity;
import com.example.nanchen.newsdemo.R;

/**
 * Created by nanchen on 2016/5/12.
 */
public class VidioFragment extends Fragment {

    private MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    public static VidioFragment newInstance(){
        return new VidioFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vidio_fragment,null);
        return view;
    }
}
