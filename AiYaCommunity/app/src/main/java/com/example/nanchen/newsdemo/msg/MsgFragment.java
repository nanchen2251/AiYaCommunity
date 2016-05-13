package com.example.nanchen.newsdemo.msg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nanchen.newsdemo.MainActivity;
import com.example.nanchen.newsdemo.R;
import com.example.nanchen.newsdemo.mine.User;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息
 * Created by nanchen on 2016/5/3.
 */
public class MsgFragment extends Fragment {
    private MainActivity mainActivity;
    private static final int DATA_UPDATE = 0x1;
    private List<Person> personList = new ArrayList<>();
    private PersonAdapter personAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    public static MsgFragment newInstance() {
        return new MsgFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.msg_fragment, null);

        TextView textView = (TextView) view.findViewById(R.id.user_login);

        Intent intent = mainActivity.getIntent();
        if (intent.getParcelableExtra("USER") != null) {
            User user = intent.getParcelableExtra("USER");
            textView.setText("当前登录：" + user.getUserName());
        }

        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            int visibleLastIndex;//用来可显示的最后一条数据的索引

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (personAdapter.getCount() == visibleLastIndex && scrollState == SCROLL_STATE_IDLE) {
                    new LoadDataThread().start();
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                visibleLastIndex = firstVisibleItem + visibleItemCount - 1;//减去最后一个加载中那条
            }
        });

        View footerView = mainActivity.getLayoutInflater().inflate(R.layout.loading_layout, null);
        listView.addFooterView(footerView);
        initData();

        personAdapter = new PersonAdapter(mainActivity, R.layout.person_item, personList);
        listView.setAdapter(personAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //                Toast.makeText(MainActivity.this,"你选择了"+personList.get(position).getName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mainActivity, ChatActivity.class);
                intent.putExtra("PERSON_NAME", personList.get(position).getName());
                startActivity(intent);
            }
        });
        return view;
    }


    /**
     * 线程间通信的机制
     */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case DATA_UPDATE:
                    personAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };

    /**
     * 模拟加载数据的线程
     */
    class LoadDataThread extends Thread {
        @Override
        public void run() {
            initData();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.sendEmptyMessage(DATA_UPDATE);//通过handler发送一个更新数据的标记
        }
    }


    /**
     * 初始化数据
     */
    private void initData() {
        Person person1 = new Person("刘世麟", R.mipmap.a_1);
        personList.add(person1);
        Person person2 = new Person("罗春燕", R.mipmap.a_2);
        personList.add(person2);
        Person person3 = new Person("王足英", R.mipmap.a_3);
        personList.add(person3);
        Person person4 = new Person("蔡何", R.mipmap.a_4);
        personList.add(person4);
        Person person5 = new Person("李兴", R.mipmap.a_5);
        personList.add(person5);
        Person person6 = new Person("李强", R.mipmap.a_6);
        personList.add(person6);
        Person person7 = new Person("李添顺", R.mipmap.a_7);
        personList.add(person7);
        Person person8 = new Person("晏贵秀", R.mipmap.a_8);
        personList.add(person8);
        Person person9 = new Person("周芳", R.mipmap.a_9);
        personList.add(person9);
        Person person10 = new Person("韩思明", R.mipmap.a_10);
        personList.add(person10);
        Person person11 = new Person("晏蜀杰", R.mipmap.a_11);
        personList.add(person11);
        Person person12 = new Person("马巍乃", R.mipmap.a_12);
        personList.add(person12);
    }

}
