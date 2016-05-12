package com.example.nanchen.newsdemo.mine;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.nanchen.newsdemo.MainActivity;
import com.example.nanchen.newsdemo.R;

public class LoginActivity extends Activity {

    private EditText editText_userName,editText_pwd;
    private CheckBox checkBox_pwd,checkBox_autoLogin;
    private SharedPreferences sp;
    private ImageButton imageButton_back;
    private Button button_login;
    private String userName,pwd;
    private Button button_regist;
    private UserService userService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        userService = new UserService(this);

        //获得实例对象
        sp = this.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        editText_userName = (EditText) findViewById(R.id.username_text);
        editText_pwd = (EditText) findViewById(R.id.pwd_text);
        imageButton_back = (ImageButton) findViewById(R.id.imageButton_back);
        button_login = (Button) findViewById(R.id.btn_login);
        checkBox_autoLogin = (CheckBox) findViewById(R.id.check_aoto_login);
        checkBox_pwd = (CheckBox) findViewById(R.id.check_pwd);
        button_regist = (Button) findViewById(R.id.btn_regist);

        imageButton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //判断记住密码框状态
        if(sp.getBoolean("ISCHECK",false)){//false是默认值
            //设置默认是选择状态
            checkBox_pwd.setChecked(true);
            userName = sp.getString("USER_NAME","");
            pwd = sp.getString("PWD","");
            editText_userName.setText(userName);
            editText_pwd.setText(pwd);

            //判断自动登录复选框状态
            if(sp.getBoolean("AUTO_ISCHECK",false)){

                //设置自动登录框状态
                checkBox_autoLogin.setChecked(true);

                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        }


        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userName = editText_userName.getText().toString();
                pwd = editText_pwd.getText().toString();

                //                Toast.makeText(LoginActivity.this,userName+"---"+pwd,Toast.LENGTH_SHORT).show();

                if(TextUtils.isEmpty(userName) || TextUtils.isEmpty(pwd)){//如果用户名或者密码为空
                    Toast.makeText(LoginActivity.this, "用户名或密码不能为空！", Toast.LENGTH_SHORT).show();
                }else {
                    if(userService.login(userName,pwd)){
                        Toast.makeText(LoginActivity.this,"登录成功！正在获取用户信息...",Toast.LENGTH_SHORT).show();

                        //存入已经登录
                        SharedPreferences.Editor editor1 = sp.edit();
                        editor1.putBoolean("isLogin",true);
                        editor1.commit();

                        //如果用户选择记住密码，则把用户信息存在xml文件中
                        if(checkBox_pwd.isChecked()){
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("USER_NAME",userName);
                            editor.putString("PWD",pwd);
                            editor.commit();
                        }

                        //主界面的跳转
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);

                        //                        intent.putExtra("USER_NAME",userName);
                        //                        intent.putExtra("PWD",pwd);

                        User user = new User();
                        user.setUserName(userName);
                        user.setPwd(pwd);

                        intent.putExtra("USER",user);

                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this,"用户名或密码不正确，请重新输入！",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        //监听记住密码复选框的按钮事件
        checkBox_pwd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = sp.edit();
                if(checkBox_pwd.isChecked()){
                    editor.putBoolean("ISCHECK", true).commit();
                }else{
                    editor.putBoolean("ISCHECK",false).commit();
                }

            }
        });

        //监听自动登录按钮事件
        checkBox_autoLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkBox_autoLogin.isChecked()){
                    sp.edit().putBoolean("AUTO_ISCHECK",true).commit();
                }else {
                    sp.edit().putBoolean("AUTO_ISCHECK",false).commit();
                }
            }
        });

        //监听退出按钮事件
        imageButton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //                finish();
//                ActivityCollector.finishAll();//退出当前应用程序
                finish();
            }
        });

        button_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegistActivity.class));
            }
        });
    }
}
