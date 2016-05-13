package com.example.nanchen.newsdemo.mine;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.nanchen.newsdemo.R;

public class RegistActivity extends Activity {

    private Button button_regist, btn_get_yanzhen;
    private ImageButton btn_back;
    private EditText editText_username, editText_pwd;
    private User user;
    private String userName, pwd, yanzhen;
    private UserService userService;


    private void initView() {
        button_regist = (Button) findViewById(R.id.btn_regist1);
        editText_username = (EditText) findViewById(R.id.username_text1);
        editText_pwd = (EditText) findViewById(R.id.pwd_text1);
        button_regist = (Button) findViewById(R.id.btn_regist1);
        btn_get_yanzhen = (Button) findViewById(R.id.btn_get_yanzhen);
        btn_back = (ImageButton) findViewById(R.id.imageButton_back);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_regist);
        initView();
        user = new User();
        userService = new UserService(this);
        final TimeCount timeCount = new TimeCount(60000,1000);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_get_yanzhen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(RegistActivity.this, "你点击了获取验证码按钮！", Toast.LENGTH_SHORT).show();
                timeCount.start();
            }
        });


        button_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText yanzheng = (EditText) findViewById(R.id.yanzhen_text);
                String yanzheng1 = yanzheng.getText().toString();
                if (TextUtils.isEmpty(yanzheng1)){
                    Toast.makeText(RegistActivity.this, "验证码不能为空！", Toast.LENGTH_SHORT).show();
                }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(RegistActivity.this);
                    builder.setTitle("注册");
                    builder.setMessage("确认注册吗？");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            userName = editText_username.getText().toString();
                            pwd = editText_pwd.getText().toString();
                            if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(pwd)) {
                                Toast.makeText(RegistActivity.this, "用户名或密码不能为空！", Toast.LENGTH_SHORT).show();
                            } else {
                                user.setUserName(userName);
                                user.setPwd(pwd);
                                if (userService.register(user)) {
                                    Toast.makeText(RegistActivity.this, "注册成功!", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(RegistActivity.this, LoginActivity.class));
                                } else {
                                    Toast.makeText(RegistActivity.this, "注册失败，请重试!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(RegistActivity.this, LoginActivity.class));
                        }
                    });
                    builder.show();
                }
            }
        });
    }


    class TimeCount extends CountDownTimer{

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);//参数依次为总时长和计时的时间间隔
        }

        @Override
        public void onTick(long millisUntilFinished) {//计时过程显示
            btn_get_yanzhen.setClickable(false);
            btn_get_yanzhen.setBackgroundColor(0xaea5a5);
            btn_get_yanzhen.setText(millisUntilFinished / 1000 + "秒后可重发");
        }

        @Override
        public void onFinish() {//计时完毕触发
            btn_get_yanzhen.setClickable(true);
            btn_get_yanzhen.setText("重新发送");
        }
    }
}
