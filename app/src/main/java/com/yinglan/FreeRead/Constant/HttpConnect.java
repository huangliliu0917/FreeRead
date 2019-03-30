package com.yinglan.FreeRead.Constant;

import android.content.Context;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;
import com.tsy.sdk.myokhttp.response.RawResponseHandler;
import com.yinglan.FreeRead.Utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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

        final Map<String, String> params = new HashMap<String, String>();
        params.put("email", eMail);
        params.put("password", password);
        params.put("phoneNumber", phoneNum1);

//        MyOkHttp.get().post(HttpConstant.register, params, new JsonResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, JSONObject response) {
//                LogUtils.d("注册成功：----->"+response.toString());
//                isSuccess = true;
//            }
//
//            @Override
//            public void onFailure(int statusCode, String error_msg) {
//                LogUtils.d("注册失败：----->"+error_msg);
//                isSuccess = false;
//            }
//        });

        new Thread() {
            @Override
            public void run() {

                postJson(params);
            }
        }.start();


        return isSuccess;

    }


    private static void postJson(Map<String, String> params) {
//        //申明给服务端传递一个json串
//        //创建一个OkHttpClient对象
//        OkHttpClient okHttpClient = new OkHttpClient();
//        //创建一个RequestBody(参数1：数据类型 参数2传递的json串)
//        //json为String类型的json数据
//        RequestBody requestBody = RequestBody.create(FormBody.create(MediaType.parse("application/json; charset=utf-8")
//                ,);
//        //创建一个请求对象
//        Request request = new Request.Builder()
//                .url(HttpConstant.register)
//                .post(requestBody)
//                .build();
//        //发送请求获取响应
//        try {
//            Response response=okHttpClient.newCall(request).execute();
//            //判断请求是否成功
//            if(response.isSuccessful()){
//                //打印服务端返回结果
//                LogUtils.d("注册返回结果：--------》"+response.body().toString());
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }






}
