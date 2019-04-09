package com.yinglan.FreeRead.Constant;

/**
 * Created by ${AUTHOR} on 2019/3/28 0028
 * Function: 统一管理接口地址
 */
public class HttpConstant {

    /*服务器地址*/
    public static final String URL_Service = "http://www.yybweb.com/NewsReader_WebApi/api/UserSystem/";
    /*本地地址*/
    public static final String URL_Local = "http://192.168.50.168/NewsReaderWebApi/api/UserSystem/";

    public static final String URL = URL_Service;
    /*接口测试*/
    public static final String test = URL+"GetUserInfoById";



    /*发送验证码（finish）*/
    public static final String sendNote = "https://sdk2.028lk.com/sdk2/BatchSend2.aspx";
    /*用户注册（finish）*/
    public static final String register = URL+"RegisterUser";
    /*密码登录（finish）*/
    public static final String login_with_password = URL+"LocalPasswordLogin";
    /*验证码登录（finish）*/
    public static final String login_with_SMS = URL+"TelephoneSmsLogin";
    /*忘记密码（finish）*/
    public static final String forgetPassword = URL+"ForgotPassword";
    /*用户签到（finish）*/
    public static final String signIn = URL+"UserSignIn";
    /*用户领取任务签到（finish）*/
    public static final String drawTask = URL+"DrawTask";
    /*正在执行的任务（finish）*/
    public static final String getTaskListOfStarting = URL+"GetTaskListOfStarting";
    /*新闻栏目（finish）*/
    public static final String allNewsCategory = URL+"GetAllNewsCategory";
    /*单个新闻栏目（finish）*/
    public static final String readNewsArticlePager = URL+"ReadNewsArticlePager";
    /*各平台收益（finish）*/
    public static final String getProfileIncomeOfMediaPlatform = URL+"GetProfileIncomeOfMediaPlatform";
    /*写入趣头条收益数据*/
    public static final String writeTolnComeRecord = URL+"WriteToIncomeRecord";






}
