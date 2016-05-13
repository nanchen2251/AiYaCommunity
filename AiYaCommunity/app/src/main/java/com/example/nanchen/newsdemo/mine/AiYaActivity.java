package com.example.nanchen.newsdemo.mine;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.nanchen.newsdemo.R;

public class AiYaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_ai_ya);
        ImageButton back = (ImageButton) findViewById(R.id.imageButton_back);
        assert back != null;
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView menu_text = (TextView) findViewById(R.id.menu_text);
        menu_text.setText("关于爱吖社区");
    }
}
