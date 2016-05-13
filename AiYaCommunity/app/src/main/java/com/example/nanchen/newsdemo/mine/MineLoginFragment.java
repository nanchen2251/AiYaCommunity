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
 * Created by nanchen on 2016/5/13.
 */
public class MineLoginFragment extends Fragment {
    private MainActivity mainActivity;

    public static MineLoginFragment newInstance(){
        return new MineLoginFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.is_login_my,null);
        Button btn_mine = (Button) view.findViewById(R.id.mine);
        Intent intent = mainActivity.getIntent();
        User user = intent.getParcelableExtra("USER");
        btn_mine.setText("爱吖用户" + user.getUserName());

        btn_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity,MineActivty.class));
            }
        });
        return view;
    }
}
