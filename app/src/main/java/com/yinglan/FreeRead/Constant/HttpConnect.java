package com.yinglan.FreeRead.Constant;

import android.content.Context;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;
import com.yinglan.FreeRead.Utils.LogUtils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${AUTHOR} on 2019/3/30 0030
 * Function: 调用网络接口
 */
public class HttpConnect {

    private static boolean isSuccess;

    /**
     * 用户注册
     * @param eMail
     * @param password
     * @param phoneNum1
     * @return
     */
    public static boolean register(Context context,String eMail, String password, String phoneNum1){

        Map<String, String> params = new HashMap<String, String>();
        params.put("email", eMail);
        params.put("password", password);
        params.put("phoneNumber", phoneNum1);

        MyOkHttp.get().post(HttpConstant.register, params, new JsonResponseHandler() {
            @Override
            public void onSuccess(int statusCode, JSONObject response) {
                LogUtils.d("注册成功：----->"+response.toString());
                isSuccess = true;
            }

            @Override
            public void onFailure(int statusCode, String error_msg) {
                LogUtils.d("注册失败：----->"+error_msg);
                isSuccess = false;
            }
        });

        return isSuccess;

    }




}
