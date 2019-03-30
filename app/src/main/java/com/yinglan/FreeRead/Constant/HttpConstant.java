package com.yinglan.FreeRead.Constant;

/**
 * Created by ${AUTHOR} on 2019/3/28 0028
 * Function: 统一管理接口地址
 */
public class HttpConstant {

    /*服务器地址*/

    /*本地地址*/
    /*http://192.168.50.168/NewsReaderWebApi/api/UserSystem/*/

    public static final String URL = "http://192.168.50.168/NewsReaderWebApi/api/UserSystem/";

    /*发送验证码*/
    public static final String sendNote = "https://sdk2.028lk.com/sdk2/BatchSend2.aspx";
    /*用户注册*/
    public static final String register = URL+"RegisterUser";
    /*密码登录*/
    public static final String login_with_password = URL+"";
    /*验证码登录*/
    public static final String login_with_phoneNum = URL+"";
    /*忘记密码*/
    public static final String forgetPassword = URL+"";


}
