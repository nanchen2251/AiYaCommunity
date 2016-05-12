package com.example.nanchen.newsdemo.msg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nanchen.newsdemo.R;

import java.util.List;

/**
 * Created by nanchen on 2016/5/12.
 */
public class PersonAdapter extends ArrayAdapter<Person> {

    private int resourceId;

    public PersonAdapter(Context context, int textViewResourceId, List<Person> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Person person = getItem(position);
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resourceId ,null);
            viewHolder = new ViewHolder();
            viewHolder.imageView_person = (ImageView) convertView.findViewById(R.id.imageView_person);
            viewHolder.textView_name = (TextView) convertView.findViewById(R.id.textView_name);
            convertView.setTag(viewHolder);
        }else{
            //            view = convertView;
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imageView_person.setImageResource(person.getImageId());
        viewHolder.textView_name.setText(person.getName());
        return convertView;
    }

    class ViewHolder{
        ImageView imageView_person;
        TextView textView_name;
    }
}

