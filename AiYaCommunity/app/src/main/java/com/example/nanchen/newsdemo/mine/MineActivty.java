package com.example.nanchen.newsdemo.mine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.nanchen.newsdemo.R;

public class MineActivty extends Activity implements View.OnClickListener{

    private ImageButton btn_back;
    private TextView menu_text;
    private Button btn_user,btn_tongyong,btn_aiya,btn_black;

    private void initView(){
        btn_back = (ImageButton) findViewById(R.id.imageButton_back);
        menu_text = (TextView) findViewById(R.id.menu_text);
        btn_user = (Button) findViewById(R.id.btn_manage);
        btn_tongyong = (Button) findViewById(R.id.btn_tongyong);
        btn_aiya = (Button) findViewById(R.id.btn_aiya);
        btn_black = (Button) findViewById(R.id.btn_black);

        menu_text.setText("我的");

        btn_back.setOnClickListener(this);
        btn_tongyong.setOnClickListener(this);
        btn_user.setOnClickListener(this);
        btn_aiya.setOnClickListener(this);
        btn_black.setOnClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mine_activty);

        initView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButton_back:
                finish();
                break;
            case R.id.btn_manage:
                startActivity(new Intent(this,UserManageActivity.class));
                break;
            case R.id.btn_tongyong:
                startActivity(new Intent(this,CommonActivity.class));
                break;
            case R.id.btn_aiya:
                startActivity(new Intent(this,AiYaActivity.class));
                break;
            case R.id.btn_black:
                startActivity(new Intent(this,BlackActivity.class));
                break;
        }
    }
}
