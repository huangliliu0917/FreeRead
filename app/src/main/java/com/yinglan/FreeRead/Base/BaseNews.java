package com.yinglan.FreeRead.Base;

/**
 * Created by ${AUTHOR} on 2019/3/25 0025
 * Function: 消息数据集
 */
public class BaseNews {

    /*标题*/
    private String title;
    /*详细内容*/
    private String info;
    /*时间*/
    private String time;

    public BaseNews(String s, String s1, String fwe) {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
