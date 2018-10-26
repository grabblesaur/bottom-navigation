package com.example.bogdanov.bottom_navigation;

import java.io.Serializable;

public class Post implements Serializable {

    private String mTitle;
    private String mDesc;

    public Post(String title, String desc) {
        mTitle = title;
        mDesc = desc;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDesc() {
        return mDesc;
    }

    public void setDesc(String desc) {
        mDesc = desc;
    }

    @Override
    public String toString() {
        return "Post{" +
                "mTitle='" + mTitle + '\'' +
                ", mDesc='" + mDesc + '\'' +
                '}';
    }
}
