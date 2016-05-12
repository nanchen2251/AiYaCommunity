package com.example.nanchen.newsdemo.msg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nanchen.newsdemo.R;

import java.util.List;

/**
 * Created by nanchen on 2016/5/12.
 */
public class MsgAdapter extends ArrayAdapter<Msg> {
    private int resourceId;

    public MsgAdapter(Context context, int resource, List<Msg> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Msg msg = getItem(position);
        viewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resourceId,null);
            viewHolder = new viewHolder();
            viewHolder.leftLayout = (LinearLayout) convertView.findViewById(R.id.left_layout);
            viewHolder.rightLayout = (LinearLayout) convertView.findViewById(R.id.right_layout);
            viewHolder.leftMsg = (TextView) convertView.findViewById(R.id.left_msg);
            viewHolder.rightMsg = (TextView) convertView.findViewById(R.id.right_msg);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (MsgAdapter.viewHolder) convertView.getTag();
        }
        if (msg.getType() == Msg.TYPE_RECEIVED){//若是收到的消息，则隐藏右布局，显示左布局
            viewHolder.leftLayout.setVisibility(View.VISIBLE);
            viewHolder.rightLayout.setVisibility(View.GONE);
            viewHolder.leftMsg.setText(msg.getContent());
        }else if(msg.getType() == Msg.TYPE_SENT){
            viewHolder.leftLayout.setVisibility(View.GONE);
            viewHolder.rightLayout.setVisibility(View.VISIBLE);
            viewHolder.rightMsg.setText(msg.getContent());
        }
        return convertView;
    }
    class viewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
    }
}

