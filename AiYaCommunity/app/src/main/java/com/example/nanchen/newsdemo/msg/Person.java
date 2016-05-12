package com.example.nanchen.newsdemo.msg;

/**
 * Created by nanchen on 2016/5/12.
 */
public class Person {
    private String name;
    private int imageId;

    public Person(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
