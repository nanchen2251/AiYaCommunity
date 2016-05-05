package com.example.nanchen.newsdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.nanchen.newsdemo.home.MusicActivity;

/**
 * 主页
 * Created by nanchen on 2016/5/3.
 */
public class HomeFragment extends Fragment {
    private Button btn_music,btn_heart,btn_ksong,btn_song_words;
    private MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    public static HomeFragment newInstance(){
        return new HomeFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,null);
        btn_music = (Button) view.findViewById(R.id.btn_music);
        btn_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, MusicActivity.class));
            }
        });

        btn_heart = (Button) view.findViewById(R.id.btn_heart);
        btn_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainActivity,"程序员还在加班中,亲要耐心等待哦.....",Toast.LENGTH_SHORT).show();
            }
        });

        btn_ksong = (Button) view.findViewById(R.id.btn_ksong);
        btn_ksong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainActivity,"程序员还在加班中,亲要耐心等待哦.....",Toast.LENGTH_SHORT).show();
            }
        });

        btn_song_words = (Button) view.findViewById(R.id.btn_song_words);
        btn_song_words.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mainActivity,"程序员还在加班中,亲要耐心等待哦.....",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
