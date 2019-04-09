package com.yinglan.FreeRead;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tauth.Tencent;
import com.yinglan.FreeRead.Utils.LogUtils;
import com.yinglan.FreeRead.Utils.MyActivityManager;
import com.yinglan.FreeRead.Utils.NetRequest;

/**
 * Created by ${AUTHOR} on 2019/3/29 0029
 * Function: ${Function}
 */
public class MyApplication extends Application {

    private Context context;
    public static SharedPreferences.Editor editor = null;
    public static SharedPreferences sharedPreferences = null;

    /*微信*/
    public static IWXAPI mWXapi;
    public String WX_APP_ID = "5436423452345234";
    /*QQ*/
    private Tencent mTencent;
    public String QQ_APP_ID = "101562333";//app-id
    public String QQ_APP_KEY = "de8e41e28d25402a4b49e3e044b63eea";//app-key
    public String QQ_APP_PACKAGE = "99bb1a60480d6b178b183cc2a1eb5b50";//应用签名

    /*发送短信需要的字段*/
    public final static String CorpID = "XAJS008093";
    public final static String Pwd = "fo8093";
    public final static String sendContent = "您的验证码是";
    public final static String sendContent1 = "。请在页面中提交验证码完成验证。验证码有效期为1分钟。";

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        //注册SharedPreference存储
        initSP();
        //向微信注册
        registerToWX();
        //注册QQ
        registerToQQ();
        //腾讯X5WebView集成
        initX5WebView();

    }

    public void initSP(){
        editor = context.getSharedPreferences("UserInfo",MODE_PRIVATE).edit();
        sharedPreferences = context.getSharedPreferences("UserInfo",MODE_PRIVATE);
    }

    private void registerToWX() {
        mWXapi = WXAPIFactory.createWXAPI(context, WX_APP_ID, false);
        mWXapi.registerApp(WX_APP_ID);
    }

    private void registerToQQ(){
        mTencent = Tencent.createInstance(QQ_APP_ID, this.getApplicationContext());
    }


    private void initX5WebView(){
        QbSdk.PreInitCallback pb = new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {

            }

            @Override
            public void onViewInitFinished(boolean b) {

            }
        };


        QbSdk.initX5Environment(context,pb);
    }

    public Context getContext() {
        return context;
    }
}
