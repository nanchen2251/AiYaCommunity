package com.example.nanchen.newsdemo.mine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nanchen.newsdemo.R;

public class UserManageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_user_manage);

        ImageButton back = (ImageButton) findViewById(R.id.imageButton_back);
        if (back != null) {
            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }

        TextView menu_text = (TextView) findViewById(R.id.menu_text);
        menu_text.setText("帐号设置");

        Button edit = (Button) findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserManageActivity.this, "退出登录成功...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UserManageActivity.this, MineActivty.class));
            }
        });

        Button pwd = (Button) findViewById(R.id.btn_pwd);
        pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserManageActivity.this,ChangePwdActivity.class));
            }
        });

        Button btn_youxiang = (Button) findViewById(R.id.btn_youxiang);
        btn_youxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserManageActivity.this, "绑定邮箱功能宝宝还在加班中...", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
