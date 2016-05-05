package com.example.nanchen.newsdemo.mine;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by nanchen on 2016/5/3.
 */
public class User implements Parcelable {
    private String userName;
    private String pwd;

    public User(){

    }

    public User(String pwd, String userName) {
        this.pwd = pwd;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(pwd);
    }

    //对象的创建器
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>(){

        @Override
        public User createFromParcel(Parcel source) {
            User user = new User();
            user.userName = source.readString();
            user.pwd = source.readString();
            return user;
        }

        @Override
        public User[] newArray(int size) {
            return new User[0];
        }
    };
}
