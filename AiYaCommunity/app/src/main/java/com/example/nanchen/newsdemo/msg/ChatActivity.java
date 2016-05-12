package com.example.nanchen.newsdemo.msg;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nanchen.newsdemo.R;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends Activity {
    private ListView listView_msg;
    private EditText editText_input;
    private Button button_send;
    private ImageButton btn_back;
    private MsgAdapter msgAdapter;
    private List<Msg> msgList = new ArrayList<>();
    private TextView textView_person_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_chat);

        initMsg();
        msgAdapter = new MsgAdapter(this,R.layout.msg_item,msgList);
        listView_msg = (ListView) findViewById(R.id.listView_msg);
        listView_msg.setAdapter(msgAdapter);

        editText_input = (EditText) findViewById(R.id.editText_send);
        editText_input.clearFocus();
        button_send = (Button) findViewById(R.id.button_send);
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editText_input.getText().toString();
                if(content.isEmpty()){//用户输入消息为空，则弹出一个警告框
                    final AlertDialog.Builder builder = new AlertDialog.Builder(ChatActivity.this);
                    builder.setTitle("警告");
                    builder.setMessage("输入的消息不能为空！");
                    builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                    builder.show();
                }else{
                    Msg msg = new Msg(content,Msg.TYPE_SENT);
                    msgList.add(msg);
                    msgAdapter.notifyDataSetChanged();//当有新消息时，刷新ListView中的显示
                    listView_msg.setSelection(msgList.size());//将ListView定位到最后一行
                    editText_input.setText("");//清空输入框中的内容

                }
            }
        });

        btn_back = (ImageButton) findViewById(R.id.imageButton_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textView_person_name = (TextView) findViewById(R.id.menu_text);
        Intent intent = getIntent();
        String person_name = intent.getStringExtra("PERSON_NAME");
        textView_person_name.setText(person_name);
    }

    private void initMsg() {
        Msg msg = new Msg("Hello!",Msg.TYPE_SENT);
        msgList.add(msg);
        Msg msg1 = new Msg("Hello!How are you?",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        Msg msg2 = new Msg("I am fine,and you?",Msg.TYPE_SENT);
        msgList.add(msg2);
        Msg msg3 = new Msg("I am ok!",Msg.TYPE_RECEIVED);
        msgList.add(msg3);
    }
}
