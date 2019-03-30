package com.yinglan.FreeRead;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by ${AUTHOR} on 2019/3/29 0029
 * Function: ${Function}
 */
public class MyApplication extends Application {

    private Context context;

    /*微信*/
    public static IWXAPI mWXapi;
    public String WX_APP_ID = "5436423452345234";


    /*发送短信需要的字段*/
    public final static String CorpID = "XAJS008093";
    public final static String Pwd = "fo8093";
    public final static String sendContent = "您的验证码是";
    public final static String sendContent1 = "。请在页面中提交验证码完成验证。验证码有效期为1分钟。";

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();


        //向微信注册
        registerToWX();

    }

    private void registerToWX() {
        mWXapi = WXAPIFactory.createWXAPI(context, WX_APP_ID, false);
        mWXapi.registerApp(WX_APP_ID);
    }

    private void registerToQQ(){

    }


    public Context getContext() {
        return context;
    }
}
