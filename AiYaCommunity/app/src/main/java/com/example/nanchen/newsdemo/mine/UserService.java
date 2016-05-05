package com.example.nanchen.newsdemo.mine;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by nanchen on 2016/5/3.
 */
public class UserService {

    private MyDbHelper dbHelper;

    public UserService(Context context) {
        dbHelper = new MyDbHelper(context);
    }

    /**
     * 用于登录，登录成功则返回true
     * @param username
     * @param pwd
     * @return
     */
    public boolean login(String username,String pwd){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from user where username = ? and pwd = ?";
        Cursor cursor = db.rawQuery(sql,new String[]{username,pwd});
        if(cursor.moveToFirst()){
            cursor.close();
            return true;
        }
        return false;
    }

    public boolean register(User user){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "insert into user(username,pwd) values(?,?)";
        Object obj[] = {user.getUserName(),user.getPwd()};
        db.execSQL(sql,obj);
        return true;
    }
}
