package com.yinglan.FreeRead.Base;

import java.io.Serializable;

/**
 * Created by Frank on 2019/4/9
 * Introduce : 趣头条收益情况
 */
public class QuBase implements Serializable {

    private int dayInput;//今日收益
    private int totalInput;//总收益
    private int readSeconds;//今日阅读时间

    public int getDayInput() {
        return dayInput;
    }

    public void setDayInput(int dayInput) {
        this.dayInput = dayInput;
    }

    public int getTotalInput() {
        return totalInput;
    }

    public void setTotalInput(int totalInput) {
        this.totalInput = totalInput;
    }

    public int getReadSeconds() {
        return readSeconds;
    }

    public void setReadSeconds(int readSeconds) {
        this.readSeconds = readSeconds;
    }
}
