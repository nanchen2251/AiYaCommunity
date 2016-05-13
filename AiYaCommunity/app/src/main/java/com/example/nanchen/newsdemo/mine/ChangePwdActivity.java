package com.example.nanchen.newsdemo.mine;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nanchen.newsdemo.R;

public class ChangePwdActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_change_pwd);

        ImageButton back = (ImageButton) findViewById(R.id.imageButton_back);
        assert back != null;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView menu_text = (TextView) findViewById(R.id.menu_text);
        menu_text.setText("修改密码");

        Button btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //还未做密码修改
                Toast.makeText(ChangePwdActivity.this,"密码修改成功，宝宝记得下次要用新密码哦~",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}
