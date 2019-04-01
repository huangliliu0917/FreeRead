package com.yinglan.FreeRead.Utils;

/**
 * Created by ${AUTHOR} on 2019/3/31 0031
 * Function: 访问网络返回的状态
 */
public class NetRequest {


    /**
     * code : 200
     * result : Success
     * msg : 注册成功
     */

    private int code;
    private String result;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
