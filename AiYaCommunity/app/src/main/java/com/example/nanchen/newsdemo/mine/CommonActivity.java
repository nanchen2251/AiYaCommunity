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

public class CommonActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_common);
        ImageButton back = (ImageButton) findViewById(R.id.imageButton_back);
        assert back != null;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView menu_text = (TextView) findViewById(R.id.menu_text);
        menu_text.setText("通用设置");

        Button delete = (Button) findViewById(R.id.btn_delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CommonActivity.this,"啦啦啦，缓存什么的都没有啦~",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
